#include <stdio.h>

#define MAX 5

/*
    Acquisire da tastiera 5 volte due numeri naturali.
    Si considerino i naturali acquisiti come il dividendo ed il divisore di una divisione.
    Dopo avere acquisito tutti i naturali e calcolato tutti i quozienti interi e resti,
    visualizzare il quoziente intero di ciascuna divisione con resto zero.

    Author: Stefano Valloncini
*/

int main(void)
{
    int divisore[MAX], dividendo[MAX], quoziente[MAX], c = 0, resto = 0;

    for(int i = 0; i < MAX; i++)
    {
        printf("Inserire il dividendo: ");
        scanf("%d", &dividendo[i]);
        printf("Inserire il divisore: ");
        scanf("%d", &divisore[i]);
    }

    for(int i = 0; i < MAX; i++)
    {
        resto = dividendo[i] % divisore[i];
        if(resto == 0)
        {
            quoziente[c] = dividendo[i] / divisore[i];
            c++;
        }
    }

    for(int i = 0; i < c; i++)
    {
        printf("Quoziente: %d\n", quoziente[i]);
    }

    return 0;
}
