#include "ordenacion.h"
int menu(){
    //Menu de navegacion
    int opc;
    printf("    /Menu de ordenacion/\n");
    printf("1) Seleccion directa\n");
    printf("2) ShellSort\n");
    printf("3) QuickSort\n");
    printf("Elige una opcion: ");
    scanf("%d", &opc);
    return opc;
}
void seleccionDirectaNormal(int *a, int tam){
    //Utilizamos el codigo proporcionado en los apuntes
    int pos, interc;
    for(int i = 0; i < tam-1; i++){
        pos = i;
        for(int j = i+1; j < tam; j++){
            if(a[j] < a[pos]){
                pos = j;
            }
        }
        interc = a[pos];
        a[pos] = a[i];
        a[i] = interc;
    }
}
void seleccionDirectaMejorada(int *a, int tam){
    //Utilizamos el codigo proporcionado en los apuntes
    int pos, interc;
    for(int i = 0; i < tam-1; i++){
        pos = i;
        for(int j = i+1; j < tam; j++){
            if(a[j] < a[pos]){
                pos = j;
            }
        }
        //Si el pivote es igual que i, no se intercambian los elementos
        if(pos != i){
            interc = a[pos];
            a[pos] = a[i];
            a[i] = interc;
        }
    }
}
void shellSort(int array[], int size) {
    //Utilizamos el codigo proporcionado en los apuntes
    int i, j, intervalo, temp;
    intervalo = calcular_tamano_incremento(size);
    while (intervalo > 0) {
        for (i=intervalo; i < size; i++) {
            j = i;
            temp = array[i];
            while ((j >= intervalo) && (array[j - intervalo] > temp)){
                array[j] = array[j - intervalo];
                j = j - intervalo;
            }
            array[j] = temp;
        }
        intervalo = calcular_siguiente_incremento(size, intervalo);
    }
}
int calcular_tamano_incremento(int size){
    //Calculamos el maximo del intervalo de Knuth
    int tam = 1;
    while(tam *3 + 1 < size){
        tam = tam * 3 + 1;
    }
    return tam;
}
int calcular_siguiente_incremento(int size, int intervalo){
    //Calculamos el numero anterior del intervalo
    return((intervalo - 1)/3);
}
void QuickSortMedio(int a[], int ini, int fin){
    int pivote;
    int i,j;
    // Caso vector con 1 solo n�mero --> No hacer nada
    if(ini >= fin)
        return;
    // Caso vector con 2 n�meros --> Comprobar si es necesario ordenarlos
    if(ini+1 == fin){
        if(a[ini] > a[fin]) // No est�n ordenados los dos n�meros, intercambiar
            intercambio(a, ini, fin);
        return;
    }
    // Resto de casos --> vector con 3 n�meros o m�s
    // Pivote --> La posici�n de mitad del vector
    int medio = (ini+fin)/2;
    intercambio(a, medio, fin); // Intercambiar pivote por el �ltimo elemento
    pivote=a[fin];
    // empezamos la partici�n
    for(i=ini, j=fin-1;;){
        while((i <= fin-1) && (a[i]<=pivote)) i++;
        while((j >= ini) && (pivote <=a[j])) j--;
        if(i<j){ // Todav�a no se han intercambiado los �ndices, intercambiar n�meros
            intercambio(a, i, j);
            i++; j--;
        }
        else // Se han intercambiando los �ndices, fin de la particion
            break;
        }
    //colocaci�n del pivote en su sitio
        intercambio (a, i, fin);
    //termina particion; //llamadas recursivas
        QuickSortMedio(a, ini, i-1); // Vector de la izquierda del pivote
        QuickSortMedio(a, i+1, fin); // Vector de la derecha del pivote
}
void QuickSortAleatorio(int a[], int ini, int fin){
    int pivote;
    int i,j;
    // Caso vector con 1 solo n�mero --> No hacer nada
    if(ini >= fin)
        return;
    // Caso vector con 2 n�meros --> Comprobar si es necesario ordenarlos
    if(ini+1 == fin){
        if(a[ini] > a[fin]) // No est�n ordenados los dos n�meros, intercambiar
            intercambio(a, ini, fin);
        return;
    }
    // Resto de casos --> vector con 3 n�meros o m�s
    // Pivote --> Aleatorio
    srand(time(NULL));
    int aleatorio = rand()%(fin - ini + 1) + ini;
    intercambio(a, aleatorio, fin); // Intercambiar pivote por el �ltimo elemento
    pivote=a[fin];
    // empezamos la partici�n
    for(i=ini, j=fin-1;;){
        while((i <= fin-1) && (a[i]<=pivote)) i++;
        while((j >= ini) && (pivote <=a[j])) j--;
        if(i<j){ // Todav�a no se han intercambiado los �ndices, intercambiar n�meros
            intercambio(a, i, j);
            i++; j--;
        }
        else // Se han intercambiando los �ndices, fin de la particion
            break;
        }
    //colocaci�n del pivote en su sitio
        intercambio (a, i, fin);
    //termina particion; //llamadas recursivas
        QuickSortAleatorio(a, ini, i-1); // Vector de la izquierda del pivote
        QuickSortAleatorio(a, i+1, fin); // Vector de la derecha del pivote
}
void QuickSortMediana(int a[], int ini, int fin){
    int pivote;
    int i,j;
    // Caso vector con 1 solo n�mero --> No hacer nada
    if(ini >= fin)
        return;
    // Caso vector con 2 n�meros --> Comprobar si es necesario ordenarlos
    if(ini+1 == fin){
        if(a[ini] > a[fin]) // No est�n ordenados los dos n�meros, intercambiar
            intercambio(a, ini, fin);
        return;
    }
    // Resto de casos --> vector con 3 n�meros o m�s
    // Pivote --> La mediana entre el inicio, el final y el valor medio
    int m;
    m = mediana(a, ini, (ini + fin)/2, fin);
    intercambio(a, m, fin); // Intercambiar pivote por el �ltimo elemento
    pivote=a[fin];
    // empezamos la partici�n
    for(i=ini, j=fin-1;;){
        while((i <= fin-1) && (a[i]<=pivote)) i++;
        while((j >= ini) && (pivote <=a[j])) j--;
        if(i<j){ // Todav�a no se han intercambiado los �ndices, intercambiar n�meros
            intercambio(a, i, j);
            i++; j--;
        }
        else // Se han intercambiando los �ndices, fin de la particion
            break;
        }
    //colocaci�n del pivote en su sitio
        intercambio (a, i, fin);
    //termina particion; //llamadas recursivas
        QuickSortMediana(a, ini, i-1); // Vector de la izquierda del pivote
        QuickSortMediana(a, i+1, fin); // Vector de la derecha del pivote
}
void intercambio(int a[], int i, int j){
    //Creamos una variable auxiliar para almacenar a[i] y cambiamos los valores que nos pide (El pivote con el ultimo elemento)
    int aux;
    aux = a[i];
    a[i] = a[j];
    a[j] = aux;
}
int mediana(int a[], int i, int j, int k){
    //Comparamos i con j y con k, si detecta que i es un valor intermedio lo devuelve
    if((a[i] >= a[j] && a[i] <= a[k]) || (a[i] <= a[j] && a[i] >= a[k])){
        return i;
    }
    //Comparamos j con i y con k, si detecta que j es un valor intermedio lo devuelve
    else if((a[j] >= a[i] && a[j] <= a[k]) || (a[j] <= a[i] && a[j] >= a[k])){
        return j;
    }
    //Comparamos los demas casos
    else{
        return k;
    }
}
