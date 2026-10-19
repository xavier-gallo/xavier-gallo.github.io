#include "maximizacion.h"
int main()
{
    //Criatura = 0, Hechizo = 1, Artefacto = 2, tierra = 3
    //Poderes: 10, 15, 8, 1 en el mismo orden
    int mazo[10] = {0};
    int mejorsol[10] = {0};
    int poderes[4] = {10, 15, 8, 1};
    int nivel = 0;
    int nodos = 0;
    printf("Se van a empezar a calcular las soluciones: \n");
    //Llamamos a la funcion
    maximizacion(mazo, nivel, &nodos, poderes, mejorsol);
    printf("Se han calculado todas las soluciones\n");
    printf("La mejor solucion es: ");
    //Imprimimos la mejor solucion
    for(int i = 0;i < 10; i++){
        printf("%d", mejorsol[i]);
    }
    printf("\n");
    printf("Total de nodos explorados: %d", nodos);
    return 0;
}
