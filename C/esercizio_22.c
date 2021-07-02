#include <stdio.h>
#include <time.h>
#define DIM 10

void calc_divisione(int dividendo, int divisore, int *quoziente_intero, int *resto)
{
    int sum = 0;
    *quoziente_intero = 0;

    while(sum + divisore <= dividendo)
    {
        sum += divisore;
        *quoziente_intero = *quoziente_intero + 1;
    }

    *resto = dividendo - sum;
}

void calc_divisione_semplice(int dividendo, int divisore, int *quoziente_intero, int *resto)
{
    *quoziente_intero = dividendo / divisore;
    *resto = dividendo % divisore;
}

int main(void)
{
    int seq[DIM], n;
    int quoziente_intero, resto;
    srand(time(NULL));

    printf("Sequenza generata: ");
    for(int i = 0; i < DIM; i++)
    {
        seq[i] = rand() % 41 + 10;
        printf(i != (DIM - 1) ? "%d, " : "%d", seq[i]);
    }

    printf("\n");
    printf("Inserire un numero naturale: ");
    do
    {
        scanf("%d", &n);
        if(n <= 0)
            printf("Non hai inserito un numero naturale. Inserire un naturale: ");
    }
    while(n <= 0);

    printf("\n");

    for(int i = 0; i < DIM; i++)
    {
        printf("Operazione: %d / %d \n", seq[i], n);


        calc_divisione(seq[i], n, &quoziente_intero, &resto);
        printf("Quoziente intero: %d \n", quoziente_intero);
        printf("Resto: %d \n", resto);

        printf("--- Altra funzione --- \n");

        calc_divisione_semplice(seq[i], n, &quoziente_intero, &resto);
        printf("Quoziente intero: %d \n", quoziente_intero);
        printf("Resto: %d \n", resto);
        printf("\n");
    }

    return 0;
}
