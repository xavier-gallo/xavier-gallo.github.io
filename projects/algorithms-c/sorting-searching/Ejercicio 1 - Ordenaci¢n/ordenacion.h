#ifndef ORDENACION_H_INCLUDED
#define ORDENACION_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
//Inicializamos todas las funciones
int menu();
void leerFichero(int a[], int tam, char nombreArchivo[]);
void crearFichero(int a[], int tam, char nombreArchivo[]);
void seleccionDirectaNormal(int *a, int tam);
void seleccionDirectaMejorada(int *a, int tam);
void shellSort(int array[], int size);
int calcular_tamano_incremento(int size);
int calcular_siguiente_incremento(int size, int intervalo);
void QuickSortMediana(int a[], int ini, int fin);
void QuickSortAleatorio(int a[], int ini, int fin);
void QuickSortMedio(int a[], int ini, int fin);
int mediana(int a[],int i, int j, int k);
#endif // ORDENACION_H_INCLUDED
