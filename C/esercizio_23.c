#include <stdio.h>
#include <time.h>
#define ROWS 10
#define COLUMNS 2
#define MAX_NUM 100
#define MIN_NUM 10

int MCD(int a, int b)
{
    int divisore;
    if (a < b)
        divisore = a;
    else
        divisore = b;
    for (int i = divisore; i >= 1; i--)
        if (a % i == 0 && b % i == 0)
            return i;
}


int main(void)
{
    int seq[ROWS][COLUMNS];
    int nr, dr;

    srand(time(NULL));

    for(int i = 0; i < ROWS; i++)
    {
        seq[i][0] = (rand() % (MAX_NUM - MIN_NUM + 1) + MIN_NUM);
        seq[i][1] = (rand() % (MAX_NUM - seq[i][0] + 1) + seq[i][0]);
    }

    printf("Matrice generata: \n");
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLUMNS; j++)
        {
            printf("%d \t", seq[i][j]);
        }
        printf("\n");
    }

    for(int i = 0; i < ROWS; i++)
    {
        int d = MCD(seq[i][0], seq[i][1]);
        nr = (seq[i][0] / d);
        dr = (seq[i][1] / d);

        printf("Numero ridotto ai minimi termini: %d / %d \n", nr, dr);
    }

    return 0;
}
