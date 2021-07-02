#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera una successione di due interi che termina con due interi positivi.
    Si consideri gli interi acquisiti come il dividendo ed il divisore di una divisione.
    Visualizzare il quoziente intero calcolato utilizzando esclusivamente operazioni di somma e sottrazione.

	AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int dividendo, divisore, quoziente_intero, i;

    do
    {
        printf("Dividendo: ");
        scanf("%d", &dividendo);

        if(dividendo <= 0)
            printf("Il numero inserito non è positivo \n");
    }
    while(dividendo <= 0);

    do
    {
        printf("Divisore: ");
        scanf("%d", &divisore);

        if(divisore <= 0)
            printf(divisore == 0 ? "Il numero inserito e' zero!\n" :
                   "Il numero inserito non e' un positivo\n");
    }
    while(divisore <= 0);

    for(i = divisore, quoziente_intero = 0; i <= dividendo; i += divisore, quoziente_intero++);

    printf("Quoziente intero: %d", quoziente_intero);

    return 0;
}
