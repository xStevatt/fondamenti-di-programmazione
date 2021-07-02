#include <stdio.h>
#define ROWS 5
#define COLUMNS 12

/*
    Si visualizzi la tabella e successivamente,
    per ciascuna colonna della tabella, si visualizzi
    la media degli interi positivi presenti sulla colonna.

    Author: Stefano Valloncini
*/

int main(void)
{
    int mat[ROWS][COLUMNS], sum, c;

    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            mat[i][j] = rand() % 101 - 20;
            printf("%d \t", mat[i][j]);
        }
        printf("\n");
    }

    for(int i = 0; i < COLUMNS; i++)
    {
        sum = 0, c = 0;
        for(int j = 0; j < ROWS; j++)
        {
            if(mat[j][i] > 0)
            {
                sum += mat[j][i];
                c++;
            }
        }
        if(c > 0)
            printf("La somma della colonna %d vale: %.2f\n", i, (float) sum / (float) c);
        else
            printf("Nessun termine positivo");
    }

    return 0;
}
