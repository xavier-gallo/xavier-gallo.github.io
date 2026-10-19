#include "maximizacion.h"
//Utilizamos el esquema de backtracking
int maximizacion(int solucion[], int nivel, int *nodos, int poderes[], int *mejorsol){
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
                procesarSolucion(solucion, nivel, poderes, mejorsol);
            }
            else{
                maximizacion(solucion, nivel+1, nodos, poderes, mejorsol);
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
void procesarSolucion(int solucion[], int nivel, int poderes[], int *mejorsol){
    //Creamos las variables para calcular el poder total
    int poderessol = 0;
    int poderesmejorsol = 0;
    for(int i = 0;i < 10; i++){
        //Calculamos el poder total
        poderessol = poderessol + poderes[solucion[i]];
        poderesmejorsol = poderesmejorsol + poderes[mejorsol[i]];
    }
    //Si el poder de la sol actual es mayor que la de la mejor sol, entonces mejorsol = sol
    if(poderessol > poderesmejorsol || poderesmejorsol == 0){
        for(int i = 0;i < 10; i++){
            mejorsol[i] = solucion[i];
        }
    }
}
