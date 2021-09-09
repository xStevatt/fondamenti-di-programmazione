#include <stdio.h>

/*
    Dati due numeri interi n e m, calcolare il massimo comun divisore. 
    
    AUTHOR: STEFANO VALLONCINI
*/

int main()
{
    int n, m;

    int mcd, min, c;

    printf("Inserire il primo numero: ");
    scanf ("%u", &n);
    printf("Inserire il secondo numero: ");
    scanf ("%u", &m);

    min = n <= m ? n : m;

    c = 1;

    while (c <= min)
    {
        if (n % c == 0 && m % c == 0)
        {
            mcd = c;
        }
        c = c + 1;
    }
    printf ("%d", mcd);

    return 0;
}
