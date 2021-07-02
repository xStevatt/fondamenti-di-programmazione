#include <stdio.h>
#define MAX 100

/*
    Acquisire da tastiera una successioni di interi che termina
    con il primo numero positivo e minore di 1024 immesso.
    Successivamente visualizzare la conversione in base 2
    dell’ultimo intero acquisito.

    Author: Stefano Valloncini
*/

int main(void)
{
    int num, bin[MAX], n, i = 0;

    do
    {
        printf("Inserire un numero maggiore di 0 e minore di 1024: ");
        scanf("%d", &num);

        if(num < 0 || num > 1024)
            printf("Inserire un numero valido!\n");
    }
    while(num < 0 || num > 1024);

    do
    {
        if(num % 2 == 0)
            bin[i] = 0;
        else
            bin[i] = 1;
        num /= 2;
        i++;
    }
    while(num != 0);

    printf("\nIl numero in binario vale: ");
    for(int j = i - 1; j >= 0; j--)
    {
        printf("%d", bin[j]);
    }

    return 0;
}
