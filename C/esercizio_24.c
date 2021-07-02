#include <stdio.h>
#define DIM 10
/*
    Esercizio 25
    Author: Stefano Valloncini
*/

int checkPrimo(int n)
{
    int i;
    int primo = 1;

    for (i = 2; i <= (n / 2); ++i)
    {
        if (n % i == 0)
        {
            primo = 0;
            break;
        }
    }
    return primo;
}

void trovaIntero(int n)
{
    int i = 0, flag = 0;

    for (i = 2; i <= n / 2; ++i)
    {
        if (checkPrimo(i) == 1)
        {
            if (checkPrimo(n - i) == 1)
            {
                printf("Il numero %d si puo' esprimere come somma di  %d + %d\n", n, i, n - i);
                flag = 1;
            }
        }
    }

    if (flag == 0)
    {
        printf("%d - Non e' possibile esprimere il numero come somma di due primi.", n);
    }
}

int main()
{
    int n[DIM];

    for(int i = 0; i < DIM; i++)
    {
        printf("->");
        scanf("%d", &n[i]);
        if(n[i] > 2)
            trovaIntero(n[i]);
        printf("\n");
    }

    return 0;
}

