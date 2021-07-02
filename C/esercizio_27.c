#include <stdio.h>
#include <time.h>

#define ROWS 10
#define COLUMNS 5
#define MAX_NUM 9
#define MIN_NUM 1

void visualizza_vettore(int vect[], int n)
{
    for(int i = 0; i < n; i++)
    {
        printf("%d ", vect[i]);
    }
}

int calcola_somma(int vect[], int n)
{
    int somma = 0;

    for(int i = 0; i < n; i++)
    {
        if(vect[i] % 2 == 0)
            somma += vect[i];
    }

    return somma;
}

void rimepi_vettore(int mat[ROWS][COLUMNS], int x, int y)
{
    srand(time(NULL));
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            mat[i][j] = rand() % (x - y + 1) + y;
        }
    }
}

int main(void)
{
    int mat[ROWS][COLUMNS];
    int vect[ROWS] = {0};

    rimepi_vettore(mat, MAX_NUM, MIN_NUM);
    for(int i = 0; i < ROWS; i++)
    {
        visualizza_vettore(mat[i], COLUMNS);
        printf("\n");
    }

    for(int i = 0; i < ROWS; i++)
    {
        vect[i] = calcola_somma(mat[i], COLUMNS);
    }

    printf("Il vettore contenente la somma contiene i seguenti elementi: ");
    visualizza_vettore(vect, ROWS);

    return 0;
}
