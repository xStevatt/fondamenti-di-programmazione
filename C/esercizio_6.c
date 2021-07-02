#include <stdio.h>
#include <stdlib.h>

/*
    Acquisire da tastiera una successione di interi che termina con il primo 0
    immesso e visualizzare dopo aver acquisito ciascun intero un messaggio
     che indica se l’intero acquisto è pari oppure dispari.

	AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int num;

    do
    {
        printf("Inserire un numero intero: ");
        scanf("%d", &num);

        if(num != 0)
            printf(num % 2 == 0 ? "%d - Pari\n" : "%d - Dispari\n", num);
    }
    while(num != 0);
}
