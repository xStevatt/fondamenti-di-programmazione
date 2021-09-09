#include <stdio.h>
#include <time.h>
#define ROWS 4
#define COLUMNS 3

/*
    Inizializza un matrice con numeri causali compresi tra 0 - 9. 
    Mostrare a schermo la somma di ciascuna riga e di ciascuna colonna della matrice. 

    Author: Stefano Valloncini
*/

int main(void)
{
    int mat[ROWS][COLUMNS], sum;
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

    for(int i = 0; i < ROWS; i++)
    {
        sum = 0;
        for(int j = 0; j < COLUMNS; j++)
        {
            sum += mat[i][j];
        }
        printf("La somma della %d riga vale: %d\n", i, sum);
    }

    printf("\n");

    for(int i = 0; i < COLUMNS; i++)
    {
        sum = 0;
        for(int j = 0; j < ROWS; j++)
        {
            sum += mat[j][i];
        }
        printf("La somma della %d colonna vale: %d\n", i, sum);
    }
}
