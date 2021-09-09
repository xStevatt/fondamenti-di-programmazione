#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera due numeri naturali. Si
    consideri gli interi acquisiti come il
    dividendo ed il divisore di una divisione.
    Visualizzare il quoziente intero, il resto ed il
    quoziente reale della divisione.

    AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int divisore, dividendo, quozienteIntero, resto;
    float quozienteReale;

    do
    {
        printf("Inserire il dividendo: ");
        scanf("%d", &dividendo);

        if(dividendo < 0)
            printf("Inserire un numero naturale valido \n");
    }
    while(dividendo < 0);


    do
    {
        printf("Inserire il divisore: ");
        scanf("%d", &divisore);

        if(divisore <= 0)
            printf("Inserire un numero naturale valido, maggiore di zero \n");
    }
    while(divisore <= 0);

    quozienteIntero = (dividendo / divisore);
    quozienteReale = ((float)dividendo / (float)divisore);
    resto = (dividendo % divisore);


    printf("\nIl quoziente intero vale %d\n", quozienteIntero);
    printf("Il resto della divisione %d\n", resto);
    printf("Il quoziente reale vale: %.2f\n", quozienteReale);

    return 0;
}
