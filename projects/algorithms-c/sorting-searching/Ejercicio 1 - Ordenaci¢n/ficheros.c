#include "ordenacion.h"
//Aqui estan todas las funciones relacionadas con ficheros
void leerFichero(int a[], int tam, char nombreArchivo[]){
    //Creamos y abrimos el fichero
    FILE *archivo;
    archivo = fopen(nombreArchivo, "r");
    if(archivo == NULL){
        printf("Error al abrir el archivo");
        return -1;
    }
    int i = 0;
    //Comparamos el contador i con el tama�o del array, e insertamos en a[], si se ha guardado el numero correctamente se devolvera un 1
    while(i < tam && fscanf(archivo, "%d", &a[i]) == 1){
        i++;
    }
    //Cerramos el fichero
    fclose(archivo);
}

void crearFichero(int a[], int tam, char nombreArchivo[]){
    //Creamos y abrimos el fichero
    FILE *archivo;
    archivo = fopen(nombreArchivo, "w");
    if(archivo == NULL){
        printf("Error al abrir el archivo");
        return -1;
    }
    //Guardamos todos los numeros en el archivo, todos con un salto de linea
    for(int i = 0;i < tam; i++){
        fprintf(archivo, "%d\n", a[i]);
    }
    //Cerramos el fichero
    fclose(archivo);
}

