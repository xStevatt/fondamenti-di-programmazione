#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera 5 volte due numeri naturali.
    Si considerino i naturali acquisiti come il
    dividendo ed il divisore di una divisione. Dopo
    ciascuna acquisizione visualizzare il quoziente
    intero ed il resto.

    AUTHOR: Stefano Valloncini
*/

int main(void)
{
    int dividendo, divisore, c = 1;

    for(int i = 0; i < 5; i++)
    {
        printf("Inserire il %d dividendo: ", c);
        do
        {
            scanf("%d", &dividendo);

            if(dividendo < 0)
                printf("Il numero inserito non e' un naturale.\nInserire un naturale: ");
        }
        while(dividendo < 0);

        printf("Inserire il %d divisore: ", c);
        do
        {
            scanf("%d", &divisore);

            if(divisore <= 0)
                printf(divisore == 0 ? "Non puoi dividere per zero!\nInserisci un numero naturale diverso da zero: " :
                       "Il numero inserito non e' un naturale.\nInserire un naturale: ");
        }
        while(divisore <= 0);

        printf("Quoziente intero: %d\n", dividendo / divisore);
        printf("Resto: %d\n", dividendo % divisore);
        c++;
    }

    return 0;
}
