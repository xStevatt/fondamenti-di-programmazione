#include <stdio.h>
#include <time.h>

#define MAX_NUM 50
#define MIN_NUM -50
#define ROWS 10
#define COLUMNS 12

int calcola_somma_pos(int vect[], int n)
{
    int somma, i;

    for(i = 0, somma = 0; i < n; somma += vect[i], i++);

    return somma;
}

int calcola_somma_neg(int vect[], int n)
{
    int somma, i;

    for(i = 0, somma = 0; i < n; somma += vect[i], i++);

    return somma;
}

int main(void)
{
    srand(time(NULL));
    int mat[ROWS][COLUMNS];

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
        int neg[COLUMNS], c_pos = 0;
        int pos[COLUMNS], c_neg = 0;
        for(int j = 0; j < COLUMNS; j++)
        {
            if(mat[i][j] < 0)
            {
                neg[c_neg] = mat[i][j];
                c_neg++;
            }
            else
            {
                pos[c_pos] = mat[i][j];
                c_pos++;
            }
        }
        printf("Riga %d: ", i);
        printf(c_neg > 0 ? "Neg: %d" : "Nessun negativo", calcola_somma_neg(neg, c_neg));
        printf(c_pos > 0 ? " - Pos: %d" : "Nessun negativo", calcola_somma_pos(pos, c_pos));
        printf("\n");
    }

    return 0;
}
