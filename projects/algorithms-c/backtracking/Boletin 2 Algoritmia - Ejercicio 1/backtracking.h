#ifndef BACKTRACKING_H_INCLUDED
#define BACKTRACKING_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//Inicializamos las funciones
int backtracking(int solucion[], int nivel, int *nodos);
int alcanzable(int solucion[], int nivel);
void procesarSolucion(int solucion[]);
#endif // BACKTRACKING_H_INCLUDED
