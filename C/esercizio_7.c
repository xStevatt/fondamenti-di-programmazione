#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera una successione di interi
    che termina con il primo 0 immesso e visualizzare
    la media degli interi positivi acquisiti.
	AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int i = 0, c = 1, sum = 0, num;

    do
    {
        printf("Inserire il %d numero: ", c);
        scanf("%d", &num);

        if(num > 0)
        {
            sum += num;
            i++;
        }
        c++;
    }
    while(num != 0);


    printf(i > 0 ? "La media vale: %-.2f" : "Nessun numero valido inserito", (float)sum / (float)i);
}
