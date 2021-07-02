#include <stdio.h>
#define DIM 100

/*
    Riempire una sequenza con 100 interi pseudo-casuali compresi
    tra -50 e +50 (estremi inclusi). Successivamente visualizzare
    il secondo intero più piccolo tra gli interi presenti nella sequenza.

    Author: Stefano Valloncini
*/

int main(void)
{
    int arr[DIM], min, not_min;

    for(int i = 0; i < DIM; i++)
    {
        arr[i] = rand() % 101 - 50;
    }

    int c = 0;

    if(arr[c] > arr[c + 1])
    {
        not_min = arr[c];
        min = arr[c + 1];
    }
    else
    {
        not_min = arr[c + 1];
        min = arr[c];
    }

    for(int i = 0; i < DIM; i++)
    {
        if(arr[i] > min && arr[i] < not_min)
        {
            not_min = arr[i];
        }
        if(arr[i] < min)
        {
            min = arr[i];
        }
    }

    printf("Il secondo numero minimo: %d", not_min);
    return 0;
}
