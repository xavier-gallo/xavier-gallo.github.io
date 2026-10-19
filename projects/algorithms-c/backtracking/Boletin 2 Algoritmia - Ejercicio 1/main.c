#include "backtracking.h"
int main()
{
    //Criatura = 0, Hechizo = 1, Artefacto = 2, tierra = 3
    int mazo[10];
    int nivel = 0;
    int nodos = 0;
    backtracking(mazo, nivel, &nodos);
    printf("Total de nodos explorados: %d", nodos);
}
