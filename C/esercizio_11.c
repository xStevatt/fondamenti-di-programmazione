#include <stdio.h>

#define MAX 5

/*
    Acquisire da tastiera 5 volte due numeri naturali.
    Si considerino i naturali acquisiti come il dividendo ed il divisore di una divisione.
    Dopo avere acquisito tutti i naturali e calcolato tutti i quozienti interi e resti,
    visualizzare il quoziente intero di ciascuna divisione con resto zero.

    Author: STEFANO VALLONCINI
*/

int main(void)
{
    int divisore[MAX], dividendo[MAX];

    for(int i = 0; i < MAX; i++)
    {
        printf("Inserire il dividendo: ");
        scanf("%d", &dividendo[i]);
        printf("Inserire il divisore: ");
        scanf("%d", &divisore[i]);
    }

    for(int i = 0; i < MAX; i++)
    {
        printf("Quoziente e resto %d/%d: %d %d\n", dividendo[i], divisore[i], dividendo[i] / divisore[i], dividendo[i] % divisore[i]);
    }

    return 0;
}
