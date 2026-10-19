#ifndef HASHING_H_INCLUDED
#define HASHING_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <windows.h>
int menu();
int menu2();
int *insertarLineal(int *tabla, int *elementos);
int *insertarCuadratica(int *tabla, int *elementos);
int *insertarDependiente(int *tabla, int *elementos);
void consultarTabla(int *tabla, int elementos);
float factorCarga(int *tabla, int elementos);
void firmaVerificacion(char *fichero, int elementos);
int k(char *palabra);
int h(int k, int elementos);
int maximo(int a, int b);
int siguientePrimo(int num);
#endif // HASHING_H_INCLUDED
