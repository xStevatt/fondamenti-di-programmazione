#include <stdio.h>
#include <time.h>
#define ROWS 4
#define COLUMNS 5

/*
    Inizializza una matrice di 4 righe e 5 colonne con dei numeri casuali tra 0 - 9. 
    Creare un vettore composto da 5 elementi. Effetturare la moltiplicazione tra 
    matrice e vettore. Mostrare a schermo il vettore risultante
    
    AUTHOR: STEFANO VALLONCINI
*/

int main(void)
{
    int mat[ROWS][COLUMNS], vect[COLUMNS], res[ROWS] = {0};
    srand(time(NULL));

    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            mat[i][j] = (rand() % 9) + 1;
            printf("%d \t", mat[i][j]);
        }
        printf("\n\n");
    }

    for(int i = 0; i < COLUMNS; i++)
    {
        printf("Inserire il %d elemento del vettore: ", i);
        scanf("%d", &vect[i]);
    }

    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            res[i] += mat[i][j] * vect[j];
        }
    }

    printf("Vettore risultante: [ ");
    for(int i = 0; i < ROWS; i++)
    {
        printf("%d ", res[i]);
    }
    printf("]");
    return 0;
}
