#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera due numeri naturali.
    Si consideri i naturali acquisiti come il dividendo
    ed il divisore di una divisione. Visualizzare il
    quoziente intero ed il resto se il divisore è diverso da zero.

	AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int dividendo, divisore, quoziente_intero, resto;

    do
    {
        printf("Dividendo: ");
        scanf("%d", &dividendo);

        if(dividendo < 0)
            printf("Il numero inserito non è un naturale!\n");
    }
    while(dividendo < 0);

    do
    {
        printf("Divisore: ");
        scanf("%d", &divisore);

        if(divisore <= 0)
            printf(divisore == 0 ? "Il numero inserito e' zero!\n" :
                   "Il numero inserito non e' un naturale\n");
    }
    while(divisore < 0);

    if(divisore != 0)
    {
        printf("Quoziente intero: %d \n", dividendo / divisore);
        printf("Resto: %d \n", dividendo % divisore);
    }

    return 0;
}
