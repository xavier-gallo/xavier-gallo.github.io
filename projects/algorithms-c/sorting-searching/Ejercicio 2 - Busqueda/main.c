#include "busqueda.h"
int main() {
    //Creamos las variables
    char texto[33000];
    int resultados[33000];
    int contador = 0;
    int saltos = 0;
    int opcion;
    //Creamos las variables de tiempo
    struct timespec inicio, fin;
    double tiempo;
    //Creamos el patron que vamos a buscar
    char *patron = "porompomrom";
    //Cargamos el texto entero en la variable texto
    cargarTextoDesdeArchivo(texto);

    //Menu
    while (opcion!=4) {
        opcion = menu();
        switch (opcion) {
            case 1:
                printf("Se va a empezar a buscar el patron\n");
                clock_gettime(CLOCK_MONOTONIC, &inicio);
                //Utilizamos la busqueda directa e imprimimos resultados
                busquedaDirecta(texto, patron, resultados, &contador, &saltos);
                mostrarResultados(resultados, contador, saltos);
                clock_gettime(CLOCK_MONOTONIC, &fin);
                tiempo = (fin.tv_sec - inicio.tv_sec) + (fin.tv_nsec - inicio.tv_nsec) / 1e9;
                printf("La busqueda tomo %.9f segundos.\n", tiempo);
                break;
            case 2:
                printf("Se va a empezar a buscar el patron\n");
                clock_gettime(CLOCK_MONOTONIC, &inicio);
                //Utilizamos el algoritmo de KMP e imprimimos resultados
                KMPSearch(texto, patron, resultados, &contador, &saltos);
                mostrarResultados(resultados, contador, saltos);
                clock_gettime(CLOCK_MONOTONIC, &fin);
                tiempo = (fin.tv_sec - inicio.tv_sec) + (fin.tv_nsec - inicio.tv_nsec) / 1e9;
                printf("La busqueda tomo %.9f segundos.\n", tiempo);
                break;
            case 3:
                printf("Se va a empezar a buscar el patron\n");
                clock_gettime(CLOCK_MONOTONIC, &inicio);
                //Utilizamos el algoritmo de BM e imprimimos resultados
                boyermoore_search(texto, patron, resultados, &contador, &saltos);
                mostrarResultados(resultados, contador, saltos);
                clock_gettime(CLOCK_MONOTONIC, &fin);
                tiempo = (fin.tv_sec - inicio.tv_sec) + (fin.tv_nsec - inicio.tv_nsec) / 1e9;
                printf("La busqueda tomo %.9f segundos.\n", tiempo);
                break;
            case 4:
                break;
            default:
                printf("No existe esa opcion \n");
                break;
        }
    }

    return 0;
}
