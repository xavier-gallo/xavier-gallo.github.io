#include "hashing.h"
int menu(){
    int opc;
    printf("    ***Menu de hashing***\n");
    printf("1) Prueba lineal\n");
    printf("2) Prueba cuadratica\n");
    printf("3) Prueba dependiente de clave\n");
    printf("Elige una opcion: ");
    scanf("%d",&opc);
    return opc;
}
int menu2(){
    int opc;
    printf("    Selecciona una opcion: \n");
    printf("1) Ingresar todas las palabras\n");
    printf("2) Consultar tabla\n");
    printf("3) Consultar factor de carga\n");
    printf("4) Consultar firma de verificacion\n");
    printf("5) Salir\n");
    scanf("%d",&opc);
    return opc;
}
int main()
{
    FILETIME inicio, fin;
    ULARGE_INTEGER inicio_ns, fin_ns;
    int opcion, opcion2, ingresados;
    float factor;
    int *tabla;
    int elem, utilizado = 0;
    //El fichero se carga al activar alguna opcion de prueba
    opcion = menu();
    switch(opcion){
    //Prueba lineal
    case 1:
        //Empezamos con 150 elementos
        elem = 150;
        tabla = malloc(sizeof(int)*elem);
        memset(tabla, 0, sizeof(int)*elem);
        while(opcion2 != 5){
            opcion2 = menu2();
            switch(opcion2){
            case 1:
                if(utilizado != 0){
                    printf("No hay mas palabras para insertar\n");
                    break;
                }
                //El programa al utilizar la funcion de insertar accede automaticamente al fichero
                GetSystemTimePreciseAsFileTime(&inicio);
                tabla = insertarLineal(tabla, &elem);
                GetSystemTimePreciseAsFileTime(&fin);
                inicio_ns.LowPart = inicio.dwLowDateTime;
                inicio_ns.HighPart = inicio.dwHighDateTime;
                fin_ns.LowPart = fin.dwLowDateTime;
                fin_ns.HighPart = fin.dwHighDateTime;
                double tiempo_ejecucion = (double)(fin_ns.QuadPart - inicio_ns.QuadPart) * 100;
                printf("El tiempo de insercion total es: %f nanosegundos\n", tiempo_ejecucion);
                utilizado++;
                printf("\n");
                break;
            case 2:
                consultarTabla(tabla, elem);
                printf("\n");
                break;
            case 3:
                //El factor de carga va a ser el mismo en la cuadratica y lineal
                factor = factorCarga(tabla, elem);
                printf("El factor de carga de la tabla es: %f por ciento\n", factor);
                printf("\n");
                break;
            case 4:
                firmaVerificacion("texto.txt", elem);
                printf("\n");
                break;
            case 5:
                free(tabla);
                printf("\n");
                break;
            default:
                printf("Esa opcion no esta disponible\n");
                printf("\n");
                break;
            }
        }
        break;
    //Prueba cuadratico
    case 2:
        //Empezamos con 150 elementos
        elem = 150;
        tabla = malloc(sizeof(int)*elem);
        memset(tabla, 0, sizeof(int)*elem);
        while(opcion2 != 5){
            opcion2 = menu2();
            switch(opcion2){
            case 1:
                if(utilizado != 0){
                    printf("No hay mas palabras para insertar\n");
                    break;
                }
                //El programa al utilizar la funcion de insertar accede automaticamente al fichero
                GetSystemTimePreciseAsFileTime(&inicio);
                tabla = insertarCuadratica(tabla, &elem);
                GetSystemTimePreciseAsFileTime(&fin);
                inicio_ns.LowPart = inicio.dwLowDateTime;
                inicio_ns.HighPart = inicio.dwHighDateTime;
                fin_ns.LowPart = fin.dwLowDateTime;
                fin_ns.HighPart = fin.dwHighDateTime;
                double tiempo_ejecucion = (double)(fin_ns.QuadPart - inicio_ns.QuadPart) * 100;
                printf("El tiempo de insercion total es: %f nanosegundos\n", tiempo_ejecucion);
                utilizado++;
                printf("\n");
                break;
            case 2:
                consultarTabla(tabla, elem);
                printf("\n");
                break;
            case 3:
                //El factor de carga va a ser el mismo en la cuadratica y lineal
                factor = factorCarga(tabla, elem);
                printf("El factor de carga de la tabla es: %f por ciento\n", factor);
                printf("\n");
                break;
            case 4:
                firmaVerificacion("texto.txt", elem);
                printf("\n");
                break;
            case 5:
                free(tabla);
                printf("\n");
                break;
            default:
                printf("Esa opcion no esta disponible\n");
                printf("\n");
                break;
            }
        }
        break;
    //Prueba dependiente de clave
    case 3:
        //Para recorrer toda la tabla el numero de elementos debe de ser primo y d no debe ser multiplo del numero de elementos
        elem = 151;
        tabla = malloc(sizeof(int)*elem);
        memset(tabla, 0, sizeof(int)*elem);
        while(opcion2 != 5){
            opcion2 = menu2();
            switch(opcion2){
            case 1:
                if(utilizado != 0){
                    printf("No hay mas palabras para insertar\n");
                    break;
                }
                //El programa al utilizar la funcion de insertar accede automaticamente al fichero
                GetSystemTimePreciseAsFileTime(&inicio);
                tabla = insertarDependiente(tabla, &elem);
                GetSystemTimePreciseAsFileTime(&fin);
                inicio_ns.LowPart = inicio.dwLowDateTime;
                inicio_ns.HighPart = inicio.dwHighDateTime;
                fin_ns.LowPart = fin.dwLowDateTime;
                fin_ns.HighPart = fin.dwHighDateTime;
                double tiempo_ejecucion = (double)(fin_ns.QuadPart - inicio_ns.QuadPart) * 100;
                printf("El tiempo de insercion total es: %f nanosegundos\n", tiempo_ejecucion);
                utilizado++;
                printf("\n");
                break;
            case 2:
                consultarTabla(tabla, elem);
                printf("\n");
                break;
            case 3:
                factor = factorCarga(tabla, elem);
                printf("El factor de carga de la tabla es: %f por ciento\n", factor);
                printf("\n");
                break;
            case 4:
                firmaVerificacion("texto.txt", elem);
                printf("\n");
                break;
            case 5:
                free(tabla);
                printf("\n");
                break;
            default:
                printf("Esa opcion no esta disponible\n");
                printf("\n");
                break;
            }
        }
    }
    return 0;
}
