#include "busqueda.h"
#define TRUE 1
#define FALSE 0
#define ALPHABET_SIZE 25
void cargarTextoDesdeArchivo(char texto[]) {
    FILE *archivo;
    archivo = fopen("textobusq.txt", "r");
    if (archivo == NULL) {
        printf("Error al abrir el archivo");
        return -1;
    }
    fgets(texto, 33000, archivo);
    fclose(archivo);
}
int menu() {
    int opc;
    printf("    /Menu/\n");
    printf("1) Busqueda Directa \n");
    printf("2) KMP \n");
    printf("3) BM \n");
    printf("4) Salir\n");
    printf("Seleccionar una opcion: ");
    scanf("%d", &opc);
    return opc;
}
// Función de busqueda directa
void busquedaDirecta(char *texto, char *patron, int *resultados, int *contador, int *saltos) {
    int n = strlen(texto);
    int m = strlen(patron);
    *contador = 0;
    *saltos = 0;

    for (int i = 0; i <= n - m; i++) {
        int j = 0;
        while (j < m && texto[i + j] == patron[j]) {
            j++;
            (*saltos)++;
        }
        (*saltos)++;
        if (j == m) {
            resultados[*contador] = i;
            (*contador)++;
        }

    }
}
//  KMP
// Funcion para mostrar la tabla siguiente
 void mostrar_tabla(int *t, int size, char *nombre_tabla) {
    printf("Tabla %s: ",nombre_tabla);
    //Recorremos la tabla y la imprimimos
    for(int i = 0; i < size; i++) {
        printf("%i ", t[i]);
    }
    printf("\n");
}

//calcula la tabla siguiente
 void preKMP(char *p, int size, int *tablaNext){
        int i,j;
        i = 0;
        j = tablaNext[0] = -1;
        while (i < size-1) {
            while (j > -1 && p[i] != p[j]) {
                j = tablaNext[j];
                }
            i++;
            j++;
                if (p[i] == p[j])
                    tablaNext[i] = tablaNext[j];
                else
                    tablaNext[i] = j;
        }
}

//funcion KMP
 void KMPSearch(char *s, char *p, int *posiciones, int *contador, int *saltos) {
        int i,j,k;
        int s_len, p_len;
        p_len = strlen(p);
        s_len = strlen(s);
        int tablaNext[p_len];
        preKMP(p, p_len, tablaNext);
        mostrar_tabla(tablaNext, p_len, "Sgte");
        i = j = k = 0;
        *contador = 0;
        *saltos = 0;

        while (i < s_len) {
            while (j > -1 && s[i] != p[j]) {
                j = tablaNext[j];
            }
                i++;
                j++;
                (*saltos)++;
                    if (j >= p_len) {
                        posiciones[k] = i -j;
                        k++;
                        (*contador)++;
                        j = 0;
                    }
        }
}

// Funcion para calcular la tabla D1 (regla del mal caracter).
// p es el patron, size es el tamaño del patron y D1 es la tabla que se debe rellenar
// en la funcion
static void prepare_badcharacter_heuristic(const char *p, int size, int D1[ALPHABET_SIZE]) {

 int i;

 for (i = 0; i < ALPHABET_SIZE; i++)
     D1[i] = -1;

 for (i = 0; i < size; i++) {
     int t = (size_t)p[i] - 97;
     D1[t] = i;
 }

}

// Funcion auxiliar necesaria para calcular la tabla D2.
static void compute_prefix(const char* str, int size, int result[]) {
 int q;
 int k;
 result[0] = 0;

 k = 0;
 for (q = 1; q < size; q++) {
     while (k > 0 && str[k] != str[q])
         k = result[k-1];

     if (str[k] == str[q])
         k++;
     result[q] = k;
 }
}

// Funcion para calcular la tabla D2 (regla del buen sufijo).
// p es el patron, size es el tamaño del patron y D2 es la tabla que se debe rellenar
// en la funcion
void prepare_goodsuffix_heuristic(const char *p, int size, int D2[]) {

 char *left = (char *) p;
 char *right = left + size;
 char reversed[size+1];
 char *tmp = reversed + size;
 int i;

 *tmp = 0;
 while (left < right)
     *(--tmp) = *(left++);

 int prefix_normal[size];
 int prefix_reversed[size];

 compute_prefix(p, size, prefix_normal);
 compute_prefix(reversed, size, prefix_reversed);

 for (i = 0; i <= size; i++) {
     D2[i] = size - prefix_normal[size-1];
 }

 for (i = 0; i < size; i++) {
     const int j = size - prefix_reversed[i];
     const int k = i - prefix_reversed[i]+1;

     if (D2[j] > k)
         D2[j] = k;
 }
}


// Funcion para mostrar las tablas D1 o D2
void mostrar_tablab(int *s, int size, char *nombre_tabla) {
     printf("Tabla %s: ",nombre_tabla);
     //Recorremos la tabla y la imprimimos
     for(int i = 0; i < size; i++) {
             printf("%i ", s[i]);
     }
     printf("\n");
}



/*
 * Algoritmo de busqueda Boyer-Moore
 * s es la cadena madre, p es el patr�n, y posiciones es un array de enteros
 * que contendr� las posiciones iniciales del patr�n p detectado en la cadena s cuando acabe el algoritmo
 */
void boyermoore_search(char *s, char *p, int posiciones[], int *contador, int *saltos) {
 /*
 * Calcula el tamaño de las cadenas
 */
 int  s_len, p_len;
 p_len = strlen(p);
 s_len = strlen(s);

 /*
 * Comprobaciones simples
 */
 if(s_len == 0)
     return;
 if(p_len == 0)
     return;
 if(p_len > s_len)
     return;


 //Obtener tablas D1 y D2

 int D1[ALPHABET_SIZE];  // D1 = mal caracter
 int D2[p_len+1]; // D2 = buen sufijo


 prepare_badcharacter_heuristic(p, p_len, D1);
 prepare_goodsuffix_heuristic(p, p_len, D2);

 mostrar_tabla(D1, ALPHABET_SIZE, "D1");
 mostrar_tabla(D2,p_len, "D2");

 // Busqueda Boyer-Moore

 int i = 0; // indice de la cadena s
 int k = 0; // indice del vector resultado "posiciones"
  *contador = 0;
  *saltos = 0;

 while(i <= (s_len - p_len))
 {
     int j = p_len;  // indice del patron p (desde el ultimo caracter)
     while(j > 0 && p[j-1] == s[i+j-1]){
        j--;
        (*saltos)++;
     }
     (*saltos)++;
     if(j > 0)
     {
         int z = D1[((size_t) s[i+j-1])-97];
         int m;
         if(z < j && (m = j-z-1) > D2[j])
             i+= m;
         else
             i+= D2[j];
     }
     else{
         posiciones[k] = i;
         k++;
         (*contador)++;
         i++;
        }
    }
}
void mostrarResultados(int *resultados, int contador, int saltos) {
    //Si el contador sube es que se ha detectado el patron, como contador es 0, entonces no esta el patron
    if (contador == 0){
        printf("No hay ese patron.\n");
    }
    //Se imprime el numero de veces que se ha encontrado el patron
    else{
        printf("Se encontraron %d coincidencias en:\n", contador);
        for (int i = 0; i < contador; i++){
            printf("%d ", resultados[i]);
        }
        printf("\n");
    }
    //Numero de saltos dados por el algoritmo de busqueda
    printf("Numero total de saltos realizados durante la busqueda: %d\n", saltos);
}

