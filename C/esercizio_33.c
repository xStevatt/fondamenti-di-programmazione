#include <stdio.h>
#include <math.h>

#define DIM 3

typedef struct
{
    float x;
    float y;
}
Punto;

float distanza_due_punti(Punto punto_1, Punto punto_2)
{
    return sqrtf(powf(punto_1.x - punto_2.x, 2) +
                 powf(punto_1.y - punto_2.y, 2));
}

int main(void)
{
    Punto punti[DIM];
    float perimetro = 0;

    for(int i = 0; i < DIM; i++)
    {
        printf("Inserimento %d punto. Inserire coordinata X: ", i + 1);
        scanf("%f", &punti[i].x);
        printf("Inserimento %d punto. Inserire coordinata X: ", i + 1);
        scanf("%f", &punti[i].y);
    }

    perimetro = distanza_due_punti(punti[0], punti[1]) + distanza_due_punti(punti[1], punti[2]) + distanza_due_punti(punti[0], punti[2]);
    printf("Perimetoro del triangolo: %.2f", perimetro);
}
