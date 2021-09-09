#include <stdio.h>
#include <stdlib.h>

/*
    Acquire da tastiera due coppie di interi.
    Ciascuna coppia indica il numeratore ed il denominatore di una frazione.
    Visualizzare la somma delle frazioni acquisite ridotta ai minimi termini.

    Author: STEFANO VALLONCINI
*/

int MCD(int a, int b);
void somma (int n1, int d1, int n2, int d2, int *num_r, int *den_r);

int main()
{
    int num_r, den_r;
    int num_1, num_2, den_1, den_2;

    printf("Inserire il primo numeratore: ");
    scanf("%d", &num_1);
    printf("Inserire il primo denominatore: ");

    do
    {
        scanf("%d", &den_1);
        if(den_1 == 0)
            printf("Hai inserito un numero uguale a 0.\nInserire un numero diverso da 0: ");
    }
    while(den_1 == 0);


    printf("Inserire il secondo numeratore: ");
    scanf("%d", &num_2);
    printf("Inserire il secondo denominatore: ");
    do
    {
    scanf("%d", &den_2);
        if(den_2 == 0)
            printf("Hai inserito un numero uguale a 0.\nInserire un numero diverso da 0: ");
    }
    while(den_2 == 0);

    somma(num_1, den_1, num_2, den_2, &num_r, &den_r);
    printf("La somma vale: %d/%d\n", num_r, den_r);

    return 0;
}

int MCD(int a, int b)
{
    int divisore = a < b ? a : b;

    for (int i = divisore; i >= 1; i--)
    {
        if (a % i == 0 && b % i == 0)
            return i;
    }
}

void somma(int n1, int d1, int n2, int d2, int *num_r, int *den_r)
{
    *num_r = n1 * d2 + n2 * d1;
    *den_r = d1 * d2;
    int temp = MCD (*num_r, *den_r);
    *num_r = *num_r / temp;
    *den_r = *den_r / temp;
}
