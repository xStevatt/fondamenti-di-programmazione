#include <stdio.h>

/*
    Dati due numeri interi n e m, calcolare il massimo comun divisore. 
    
    AUTHOR: STEFANO VALLONCINI
*/

int mcd(int num1, int num2)
{
    int temp;

    while (num2 != 0)
    {
        temp = num2;
        num2 = num1 % num2;
        num1 = temp;
    }

    return num1;
}

int main()
{
    int n, m;

    printf("Inserire il primo numero: ");
    scanf("%d", &n);
    printf("Inserire il secondo numero: ");
    scanf("%d", &m);

    printf ("%d", mcd(n, m));

    return 0;
}
