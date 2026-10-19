#ifndef MAXIMIZACION_H_INCLUDED
#define MAXIMIZACION_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//Inicializamos las funciones
int maximizacion(int solucion[], int nivel, int *nodos, int poderes[], int *mejorsol);
int alcanzable(int solucion[], int nivel);
void procesarSolucion(int solucion[], int nivel, int poderes[], int *mejorsol);
#endif // MAXIMIZACION_H_INCLUDED
