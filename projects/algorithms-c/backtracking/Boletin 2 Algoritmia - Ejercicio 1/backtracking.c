#include "backtracking.h"
//Utilizamos el esquema de backtracking
int backtracking(int solucion[], int nivel, int *nodos){
    //Criatura = 0, Hechizo = 1, Artefacto = 2, tierra = 3
    if(nivel > 9){
        return 0;
    }
    int nuevo_valor = 0;
    do{
        solucion[nivel] = nuevo_valor;
        (*nodos)++;
        if(alcanzable(solucion, nivel) == 1){
            if(nivel == 9){
                procesarSolucion(solucion);
            }
            else{
                backtracking(solucion, nivel+1, nodos);
            }
        }
        nuevo_valor++;
    } while(nuevo_valor < 4);
}
int alcanzable(int solucion[], int nivel){
    int contador0 = 0, contador1 = 0, contador2 = 0;
    for(int i = 0;i <= nivel; i++){
        //Contador de soluciones
        if(solucion[i] == 0)
            contador0++;
        else if(solucion[i] == 1)
            contador1++;
        else if(solucion[i] == 2)
            contador2++;
        //Si alguno es mayor que seis
        if(contador0 > 6 || contador1 > 6 || contador2 > 6){
            return 0;
        }
        //Verificar cuatro valores consecutivos iguales
        if (i >= 3 && solucion[i] == solucion[i - 1] && solucion[i - 1] == solucion[i - 2] && solucion[i - 2] == solucion[i - 3]){
            if(solucion[i] != 3){
                return 0;
            }
        }
    }
    return 1;
}
void procesarSolucion(int solucion[]){
    //Imprimimos las soluciones
    for(int i = 0; i < 10;i++){
        printf("%d", solucion[i]);
    }
    printf("\n");
}
