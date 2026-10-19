#include "ordenacion.h"
int main()
{
    //Variables para los menus
    int opcion, opcion2, opcion3;
    //Variables para el tiempo de ejecucion
    clock_t inicio, fin;
    double tiempo;
    //Inicializamos los arrays en los que almacenaremos los numeros de los ficheros
    int *array1 = (int *)malloc(sizeof(int)*50000);
    int *array2 = (int *)malloc(sizeof(int)*100000);
    int *array3 = (int *)malloc(sizeof(int)*200000);
    int *array1ordenado = (int *)malloc(sizeof(int)*50000);
    int *array2ordenado = (int *)malloc(sizeof(int)*100000);
    int *array3ordenado = (int *)malloc(sizeof(int)*200000);
    //Leemos los ficheros y almacenamos los numeros en los arrays
    leerFichero(array1, 50000, "numeros50000.txt");
    leerFichero(array2, 100000, "numeros100000.txt");
    leerFichero(array3, 200000, "numeros200000.txt");

    opcion = menu();
    switch(opcion){
        //Seleccion directa
        case 1:
            printf("    Elige:\n");
            printf("1) Seleccion directa normal\n");
            printf("2) Seleccion directa mejorada\n");
            printf("Elige una opcion: ");
            scanf("%d", &opcion2);
            switch(opcion2){
            case 1:
                printf("    Que archivo quieres ordenar:\n");
                printf("1) 50000 palabras\n");
                printf("2) 100000 palabras\n");
                printf("3) 200000 palabras\n");
                printf("4) Fichero ordenado de 50k\n");
                printf("5) Fichero ordenado de 100k\n");
                printf("6) Fichero ordenado de 200k\n");
                printf("Elige una opcion: ");
                scanf("%d", &opcion3);
                if(opcion3 == 1){
                    inicio = clock();
                    seleccionDirectaNormal(array1, 50000);
                    crearFichero(array1, 50000, "50kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 2){
                    inicio = clock();
                    seleccionDirectaNormal(array2, 100000);
                    crearFichero(array2, 100000, "100kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 3){
                    inicio = clock();
                    seleccionDirectaNormal(array3, 200000);
                    crearFichero(array3, 200000, "200kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 4){
                    leerFichero(array1ordenado, 50000, "50kordenado.txt");
                    inicio = clock();
                    seleccionDirectaNormal(array1ordenado, 50000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 5){
                    leerFichero(array2ordenado, 100000, "100kordenado.txt");
                    inicio = clock();
                    seleccionDirectaNormal(array2ordenado, 100000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 6){
                    leerFichero(array3ordenado, 200000, "200kordenado.txt");
                    inicio = clock();
                    seleccionDirectaNormal(array3ordenado, 200000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                else{
                    printf("Elige una opcion valida\n");
                    break;
                }
            case 2:
                printf("    Que archivo quieres ordenar:\n");
                printf("1) 50000 palabras\n");
                printf("2) 100000 palabras\n");
                printf("3) 200000 palabras\n");
                printf("4) Fichero ordenado de 50k\n");
                printf("5) Fichero ordenado de 100k\n");
                printf("6) Fichero ordenado de 200k\n");
                printf("Elige una opcion: ");
                scanf("%d", &opcion3);
                if(opcion3 == 1){
                    inicio = clock();
                    seleccionDirectaMejorada(array1, 50000);
                    crearFichero(array1, 50000, "50kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 2){
                    inicio = clock();
                    seleccionDirectaMejorada(array2, 100000);
                    crearFichero(array2, 100000, "100kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 3){
                    inicio = clock();
                    seleccionDirectaMejorada(array3, 200000);
                    crearFichero(array3, 200000, "200kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 4){
                    leerFichero(array1ordenado, 50000, "50kordenado.txt");
                    inicio = clock();
                    seleccionDirectaMejorada(array1ordenado, 50000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 5){
                    leerFichero(array2ordenado, 100000, "100kordenado.txt");
                    inicio = clock();
                    seleccionDirectaMejorada(array2ordenado, 100000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 6){
                    leerFichero(array3ordenado, 200000, "200kordenado.txt");
                    inicio = clock();
                    seleccionDirectaMejorada(array3ordenado, 200000);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                else{
                    printf("Elige una opcion valida\n");
                    break;
                }
                break;
            }
            break;

        //Shellsort
        case 2:
            printf("    Que archivo quieres ordenar:\n");
            printf("1) 50000 palabras\n");
            printf("2) 100000 palabras\n");
            printf("3) 200000 palabras\n");
            printf("4) Fichero ordenado de 50k\n");
            printf("5) Fichero ordenado de 100k\n");
            printf("6) Fichero ordenado de 200k\n");
            printf("Elige una opcion: ");
            scanf("%d", &opcion3);
            if(opcion3 == 1){
                inicio = clock();
                shellSort(array1, 50000);
                crearFichero(array1, 50000, "50kordenado.txt");
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            if(opcion3 == 2){
                inicio = clock();
                shellSort(array2, 100000);
                crearFichero(array2, 100000, "100kordenado.txt");
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            if(opcion3 == 3){
                inicio = clock();
                shellSort(array3, 200000);
                crearFichero(array3, 200000, "200kordenado.txt");
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            if(opcion3 == 4){
                leerFichero(array1ordenado, 50000, "50kordenado.txt");
                inicio = clock();
                shellSort(array1ordenado, 50000);
                //No se crea fichero porque se ordena un fichero ya ordenado
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            if(opcion3 == 5){
                leerFichero(array2ordenado, 100000, "100kordenado.txt");
                inicio = clock();
                shellSort(array2ordenado, 100000);
                //No se crea fichero porque se ordena un fichero ya ordenado
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            if(opcion3 == 6){
                leerFichero(array3ordenado, 200000, "200kordenado.txt");
                inicio = clock();
                shellSort(array3ordenado, 200000);
                //No se crea fichero porque se ordena un fichero ya ordenado
                fin = clock();
                tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                break;
            }
            else{
                printf("Elige una opcion valida\n");
                break;
            }
            break;

        //Quicksort
        case 3:
            printf("    Elige:\n");
            printf("1) QuickSort pivote en el medio\n");
            printf("2) QuickSort pivote aleatorio\n");
            printf("3) QuickSort pivote sacado de la mediana\n");
            printf("Elige una opcion: ");
            scanf("%d", &opcion2);
            switch(opcion2){
            case 1:
                printf("    Que archivo quieres ordenar:\n");
                printf("1) 50000 palabras\n");
                printf("2) 100000 palabras\n");
                printf("3) 200000 palabras\n");
                printf("4) Fichero ordenado de 50k\n");
                printf("5) Fichero ordenado de 100k\n");
                printf("6) Fichero ordenado de 200k\n");
                printf("Elige una opcion: ");
                scanf("%d", &opcion3);
                if(opcion3 == 1){
                    inicio = clock();
                    QuickSortMedio(array1, 0, 49999);
                    crearFichero(array1, 50000, "50kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 2){
                    inicio = clock();
                    QuickSortMedio(array2, 0, 99999);
                    crearFichero(array2, 100000, "100kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 3){
                    inicio = clock();
                    QuickSortMedio(array3, 0, 199999);
                    crearFichero(array3, 200000, "200kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 4){
                    leerFichero(array1ordenado, 50000, "50kordenado.txt");
                    inicio = clock();
                    QuickSortMedio(array1ordenado, 0, 49999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 5){
                    leerFichero(array2ordenado, 100000, "100kordenado.txt");
                    inicio = clock();
                    QuickSortMedio(array2ordenado, 0, 99999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 6){
                    leerFichero(array3ordenado, 200000, "200kordenado.txt");
                    inicio = clock();
                    QuickSortMedio(array3ordenado, 0, 199999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                else{
                    printf("Elige una opcion valida\n");
                    break;
                }
            case 2:
                printf("    Que archivo quieres ordenar:\n");
                printf("1) 50000 palabras\n");
                printf("2) 100000 palabras\n");
                printf("3) 200000 palabras\n");
                printf("4) Fichero ordenado de 50k\n");
                printf("5) Fichero ordenado de 100k\n");
                printf("6) Fichero ordenado de 200k\n");
                printf("Elige una opcion: ");
                scanf("%d", &opcion3);
                if(opcion3 == 1){
                    inicio = clock();
                    QuickSortAleatorio(array1, 0, 49999);
                    crearFichero(array1, 50000, "50kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 2){
                    inicio = clock();
                    QuickSortAleatorio(array2, 0, 99999);
                    crearFichero(array2, 100000, "100kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 3){
                    inicio = clock();
                    QuickSortAleatorio(array3, 0, 199999);
                    crearFichero(array3, 200000, "200kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 4){
                    leerFichero(array1ordenado, 50000, "50kordenado.txt");
                    inicio = clock();
                    QuickSortAleatorio(array1ordenado, 0, 49999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 5){
                    leerFichero(array2ordenado, 100000, "100kordenado.txt");
                    inicio = clock();
                    QuickSortAleatorio(array2ordenado, 0, 99999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 6){
                    leerFichero(array3ordenado, 200000, "200kordenado.txt");
                    inicio = clock();
                    QuickSortAleatorio(array3ordenado, 0, 199999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                else{
                    printf("Elige una opcion valida\n");
                    break;
                }

            case 3:
                printf("    Que archivo quieres ordenar:\n");
                printf("1) 50000 palabras\n");
                printf("2) 100000 palabras\n");
                printf("3) 200000 palabras\n");
                printf("4) Fichero ordenado de 50k\n");
                printf("5) Fichero ordenado de 100k\n");
                printf("6) Fichero ordenado de 200k\n");
                printf("Elige una opcion: ");
                scanf("%d", &opcion3);
                if(opcion3 == 1){
                    inicio = clock();
                    QuickSortMediana(array1, 0, 49999);
                    crearFichero(array1, 50000, "50kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 2){
                    inicio = clock();
                    QuickSortMediana(array2, 0, 99999);
                    crearFichero(array2, 100000, "100kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 3){
                    inicio = clock();
                    QuickSortMediana(array3, 0, 199999);
                    crearFichero(array3, 200000, "200kordenado.txt");
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 4){
                    leerFichero(array1ordenado, 50000, "50kordenado.txt");
                    inicio = clock();
                    QuickSortMediana(array1ordenado, 0, 49999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 5){
                    leerFichero(array2ordenado, 100000, "100kordenado.txt");
                    inicio = clock();
                    QuickSortMediana(array2ordenado, 0, 99999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                if(opcion3 == 6){
                    leerFichero(array3ordenado, 200000, "200kordenado.txt");
                    inicio = clock();
                    QuickSortMediana(array3ordenado, 0, 199999);
                    //No se crea fichero porque se ordena un fichero ya ordenado
                    fin = clock();
                    tiempo = (double)(fin - inicio) / CLOCKS_PER_SEC;
                    printf("La ordenacion tomo %.5f segundos.\n", tiempo);
                    break;
                }
                else{
                    printf("Elige una opcion valida\n");
                    break;
                }
                break;
            }
            break;

        default:
            printf("No existe esa opcion\n");
            return 0;
        }
    //Cuando termina la ordenacion, el programa imprime que ha terminado
    printf("Se han ordenado los numeros, se ha guardado un fichero con los mismos en la carpeta del proyecto\n");
    printf("Si has ordenado un archivo ya ordenado, no cambiara ningun fichero");
    free(array1);
    free(array2);
    free(array3);
    free(array1ordenado);
    free(array2ordenado);
    free(array3ordenado);
    return 0;
}
