#include <stdio.h>
#define DIM 5

struct Numero_Complesso
{
    float re;
    float im;
};

struct Numero_Complesso somma(struct Numero_Complesso z1, struct Numero_Complesso z2)
{
    struct Numero_Complesso z = { .re = z1.re + z2.re, .im = z1.im + z2.im};
    return z;
}

void coniuga_complesso(struct Numero_Complesso* z)
{
    (*z).im = (-1) * (*z).im;
}

void visualizza_complesso(struct Numero_Complesso z_complesso)
{
    if(z_complesso.im > 0)
        printf("z = %.2f + %.2f\n", z_complesso.re, z_complesso.im);
    else if(z_complesso.im < 0)
        printf("z = %.2f + (%.2f)\n", z_complesso.re, z_complesso.im);
    else
        printf("z = %.2f\n", z_complesso.re);
}

void visualizza_sequenza_complessi(struct Numero_Complesso complessi[], int size_arr)
{
    for(int i = 0; i < size_arr; i++)
    {
        visualizza_complesso(complessi[i]);
    }
}

int main(void)
{
    struct Numero_Complesso complessi[DIM];

    for(int i = 0; i < DIM; i++)
    {
        printf("Inserire la parte reale del %d numero: ", i + 1);
        scanf("%f", &complessi[i].re);
        printf("Inserire la parte immaginaria del %d numero: ", i + 1);
        scanf("%f", &complessi[i].im);

        printf("Numero complesso inserito: ");
        visualizza_complesso(complessi[i]);
        printf("\n");

        coniuga_complesso(&complessi[i]);
    }
    printf("Numeri complessi coniugati: \n");
    visualizza_sequenza_complessi(complessi, DIM);

    printf("\n");
    struct Numero_Complesso risultato = { .re = 0, .im = 0};
    struct Numero_Complesso temp;

    for(int i = 0; i < DIM; i++)
    {
        temp = somma(risultato, complessi[i]);
        risultato = temp;
    }

    printf("Il complesso risultante vale: ");
    visualizza_complesso(temp);

    return 0;
}
