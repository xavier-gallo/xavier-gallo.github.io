#ifndef BUSQUEDA_H_INCLUDED
#define BUSQUEDA_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
// Declaraciones de funciones previamente proporcionadas
int menu();
void cargarTextoDesdeArchivo(char *texto);
void busquedaDirecta(char *texto, char *patron, int *resultados, int *contador, int *saltos);
void KMPSearch(char *s, char *p, int *posiciones, int *contador, int *saltos);
void boyermoore_search(char *s, char *p, int posiciones[], int *contador, int *saltos);
void mostrar_tabla(int *s, int size, char *nombre_tabla);
void mostrar_tablab(int *s, int size, char *nombre_tabla);
void mostrarResultados(int *resultados, int contador, int saltos);
void cargarTextoDesdeArchivo(char *texto);

#endif // BUSQUEDA_H_INCLUDED
