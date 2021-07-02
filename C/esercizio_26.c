#include <stdio.h>
#include <time.h>

#define MAX_NUM 50
#define MIN_NUM -50
#define ROWS 10
#define COLUMNS 12

void calcola_somma(int* somma_positivi, int* somma_negativi, int vect[], int n)
{
    *somma_negativi = 0, *somma_positivi = 0;

    for(int i = 0; i < n; i++)
    {
        if(vect[i] > 0)
            *somma_positivi = *somma_positivi + vect[i];
        else
            *somma_negativi = *somma_negativi + vect[i];
    }
}

int main(void)
{
    srand(time(NULL));
    int mat[ROWS][COLUMNS];
    int somma_positivi = 0, somma_negativi = 0;

    printf("Matrice Generata: \n");
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            mat[i][j] = rand() % (MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            printf("%d \t", mat[i][j]);
        }
        printf("\n");
    }

    printf("\n");

    for(int i = 0; i < ROWS; i++)
    {
        int temp[COLUMNS];
        for(int j = 0; j < COLUMNS; j++)
        {
            temp[j] = mat[i][j];
        }
        calcola_somma(&somma_positivi, &somma_negativi, temp, COLUMNS);
        printf("Riga %d, Somma Pos: %d, Somma Neg %d \n", i, somma_positivi, somma_negativi);
    }

    return 0;
}
