#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera una successione di naturali che termina
    con 0 e al termine delle acquisizione visualizzare la
    quantità di numeri primi acquisiti

	AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int num, n_div = 0, primi = 0;

    do
    {
        n_div = 0;

        do
        {
            printf("Inserire un numero (natuale): ");
            scanf("%d", &num);

            if(num < 0)
                printf("Numero inserito NON naturale. Inserire un numero naturale.\n");

            if(num == 0)
                break;
        }
        while(num < 0); // I numeri inseriti devono essere naturali.

        for(int i = 1; i <= num; i++)
        {
            if(num % i == 0)
                n_div++;
            if(n_div > 2)
                break;
        }

        if(n_div == 2)
            primi++;
    }
    while(num != 0);

    printf(primi > 0 ? "Numeri primi %d" : "Nessun numero primo inserito", primi);
}
