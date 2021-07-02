#include <stdio.h>
#include <time.h>
#define ROWS 10
#define COLUMNS 10
#define MAX_N 99
#define MIN_N 10

void conta_pari_dispari(int arr[], int size_arr, int* somma_pari, int* somma_dispari)
{
    *somma_pari = 0, *somma_dispari = 0;

    for(int i = 0; i < size_arr; i++)
    {
        if(arr[i] % 2 == 0)
            *somma_pari = *somma_pari + arr[i];
        else
            *somma_dispari = *somma_dispari + arr[i];
    }
}

int main(void)
{
    int mat[ROWS][COLUMNS];
    int somma_dispari[ROWS], somma_pari[ROWS];
    int _somma_pari, _somma_dispari;
    srand(time(NULL));

    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            mat[i][j] = rand() % (MAX_N - MIN_N + 1) + MIN_N;
            printf("%d \t", mat[i][j]);
        }
        printf("\n");
    }

    for(int i = 0; i < ROWS; i++)
    {
        conta_pari_dispari(mat[i], COLUMNS, &_somma_pari, &_somma_dispari);
        somma_dispari[i] = _somma_dispari;
        somma_pari[i] = _somma_pari;
    }

    printf("\n");

    for(int i = 0; i < ROWS; i++)
    {
        printf("Riga %d - Somma pari: %d - Somma dispari: %d\n", i + 1, somma_pari[i], somma_dispari[i]);
    }

    return 0;
}
