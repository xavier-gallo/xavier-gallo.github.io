#include "hashing.h"
int *insertarLineal(int *tabla, int *elementos){
//Insertar con metodo de colisiones lineal
    char linea[4500];
    int colisiones = 0;
    char *palabra;
    int ingresados = 0;
    FILE *archivo = fopen("texto.txt", "r");
    if(archivo == NULL){
            printf("Error de lectura del archivo\n");
            return NULL;
    }
    if(fgets(linea,4500,archivo)!= NULL){
        palabra = strtok(linea," ");
        while(palabra != NULL){
            if(ingresados == *elementos/2){
                //Aumentamos el numero de elementos de la tabla cuando tiene ocupada la mitad de esta
                int elemAntiguo = *elementos;
                *elementos = *elementos * 2;
                tabla = realloc(tabla, sizeof(int)* (*elementos));
                for(int i = elemAntiguo; i < *elementos; i++){
                    tabla[i] = 0;
                }
            }
            //Cogemos la clave hash y la posicion en la que deberia estar sin una colision
            //IMPORTANTE, la posicion donde va la clave hash es igual a: h(k)
            int num = k(palabra);
            int pos = h(num, *elementos);
            while(tabla[pos] != 0){
                if(tabla[pos] != 0){
                    pos = (pos + 1)% *elementos;
                    colisiones++;
                }
            }
            tabla[pos] = num;
            ingresados++;
            palabra = strtok(NULL, " ");
        }
    }
    fclose(archivo);
    printf("Colisiones al ingresar los codigos de las palabras: %d\n", colisiones);
    return tabla;
}
int *insertarCuadratica(int *tabla, int *elementos){
//Insertar con metodo de colisiones cuadratica
    char linea[4500];
    int colisiones = 0;
    int cuadrado;
    char *palabra;
    int ingresados = 0;
    FILE *archivo = fopen("texto.txt", "r");
    if(archivo == NULL){
            printf("Error de lectura del archivo\n");
            return NULL;
    }
    if(fgets(linea,4500,archivo)!= NULL){
        palabra = strtok(linea," ");
        while(palabra != NULL){
            if(ingresados >= *elementos/2){
                //Aumentamos el numero de elementos de la tabla cuando tiene ocupada la mitad de esta
                int elemAntiguo = *elementos;
                *elementos = *elementos * 2;
                tabla = realloc(tabla, sizeof(int)* (*elementos));
                for(int i = elemAntiguo; i < *elementos; i++){
                    tabla[i] = 0;
                }
            }
            //Cogemos la clave hash y la posicion en la que deberia estar sin una colision
            //IMPORTANTE, la posicion donde va la clave hash es igual a: h(k)
            int num = k(palabra);
            int pos = h(num, *elementos);
            cuadrado = 1;
            while(tabla[pos] != 0){
                if(tabla[pos] != 0){
                    pos = (pos + (cuadrado * cuadrado)) % (*elementos);
                    //Hago % *elementos para que no supere el numero de elementos actual de la tabla
                    cuadrado++;
                    colisiones++;
                }
            }
            tabla[pos] = num;
            ingresados++;
            palabra = strtok(NULL, " ");
        }
    }
    fclose(archivo);
    printf("Colisiones al ingresar los codigos de las palabras: %d\n", colisiones);
    return tabla;
}
int *insertarDependiente(int *tabla, int *elementos){
//Insertar con metodo de colisiones dependiente de clave
    char linea[4500];
    int colisiones = 0;
    char *palabra;
    int ingresados = 0;
    FILE *archivo = fopen("texto.txt", "r");
    if(archivo == NULL){
            printf("Error de lectura del archivo\n");
            return NULL;
    }
    if(fgets(linea,4500,archivo)!= NULL){
        palabra = strtok(linea," ");
        while(palabra != NULL){
            if(ingresados >= *elementos/2){
                int elemAntiguo = *elementos;
                *elementos = siguientePrimo(*elementos);
                //Hay que aumentar la tabla al siguiente primo de elementos * 2
                tabla = realloc(tabla, sizeof(int)* (*elementos));
                for(int i = elemAntiguo; i < *elementos; i++){
                    tabla[i] = 0;
                }
            }
            //Cogemos la clave hash y la posicion en la que deberia estar sin una colision, ademas de coger la clave y calcular la k
            int clave = k(palabra);
            //IMPORTANTE, la posicion donde va la clave hash es igual a: h(k)
            int num = k(palabra);
            int pos = h(num, *elementos);
            int dk = maximo(1, clave / (*elementos));
            //Si valorFinal es multiplo de elementos, se le suma 1. (Esto es por la prueba dependiente de clave para recorrer toda la tabla hash)
            if(dk % *elementos == 0){
                dk++;
            }
            int i = 1;
            while(tabla[pos] != 0){
                if(tabla[pos] != 0){
                    pos = (pos + (i*dk)) % (*elementos);
                    //Hago % *elementos para que no supere el numero de elementos actual de la tabla
                    i++;
                    colisiones++;
                }
            }
            tabla[pos] = num;
            ingresados++;
            palabra = strtok(NULL, " ");
        }
    }
    fclose(archivo);
    printf("Colisiones al ingresar los codigos de las palabras: %d\n", colisiones);
    return tabla;
}
int k(char *palabra){
    int valorFinal;
    valorFinal = strlen(palabra);
    valorFinal = pow(valorFinal, 3);
    valorFinal = (valorFinal * 123) + 310;
    return valorFinal;
}
int h(int k, int elementos){
    k = (k * 19 + 14);
    k = k % elementos;
    return k;
}
void consultarTabla(int *tabla, int elementos){
    for(int i = 0;i < elementos;i++){
        printf("Posicion %d: %d\n", i, tabla[i]);
    }
}
float factorCarga(int *tabla, int elementos){
    float factor = 0;
    for(int i = 0;i < elementos;i++){
        if(tabla[i] != 0){
            factor++;
        }
    }
    factor = (factor/elementos) * 100;
    return factor;
}
void firmaVerificacion(char *fichero,int elementos){
    char linea[500];
    char *palabra;
    int firma;
    FILE *archivo = fopen(fichero, "r");
    if(archivo == NULL){
            printf("Error de lectura del archivo");
    }
    while(fgets(linea,500,archivo)!=NULL){
        palabra = strtok(linea," ");
        while (palabra != NULL){
            firma = k(palabra) % elementos;
            printf("%d",firma);
            palabra = strtok(NULL, " ");
        }
    }
    printf("\n");
    fclose(archivo);
}
int maximo(int a, int b){
    if(b < a){
        return a;
    }
    if(a < b){
        return b;
    }
}
int siguientePrimo(int num){
    //Multiplicamos el numero por 2
    num = num * 2;
    //Si el numero tiene algun divisor le sumamos 1
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
             num++;
        }
    }
    return num;
}
