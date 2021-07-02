#include <stdio.h>
#include <time.h>

#define DIM_INT 10
#define DIM_FLOAT 20

#define MIN_NUM_INT 500
#define MAX_NUM_INT 2000

#define MM 0
#define M 1

typedef struct
{
    int tipo;

    union
    {
        int millimetri;
        float metri;
    }
    mis;
}
Misura;

int aggrega(int int_vect[], int size_v1, float float_vect[], int size_v2, Misura mis_vect[])
{
    int i, j;

    for(j = 0, i = 0; i < size_v1; j++, i++)
    {
        mis_vect[j].mis.millimetri = int_vect[i];
        mis_vect[j].tipo = MM;
    }

    for(i = 0; i < size_v2; j++, i++)
    {
        mis_vect[j].mis.metri= float_vect[i];
        mis_vect[j].tipo = M;
    }

    return j;
}

void visualizza(Misura misura)
{
    if(misura.tipo == 0)
    {
        printf("%d\n", misura.mis.millimetri);
    }
    else
    {
        printf("%.2f\n", misura.mis.metri);
    }
}

int minore(Misura m1, Misura m2)
{
    if(m1.tipo == M && m2.tipo == M && m1.mis.metri < m2.mis.metri)
    {
        return 1;
    }
    if(m1.tipo == M && m2.tipo == MM && m1.mis.metri * 1000 < m2.mis.millimetri)
    {
        return 1;
    }
    if(m1.tipo == MM && m2.tipo == MM && m1.mis.millimetri < m2.mis.millimetri)
    {
        return 1;
    }
    if(m1.tipo == MM && m2.tipo == M && m1.mis.millimetri < m2.mis.millimetri * 1000)
    {
        return 1;
    }
    return 0;
}

void ordina_sequenza(Misura misure[], int size_arr)
{
    for(int i = 0; i < size_arr - 1; i++)
    {
        for(int j = size_arr - 1; j > i; j--)
        {
            if(minore(misure[j], misure[j - 1]) == 1)
            {
                Misura temp = misure[j];
                misure[j] = misure[j - 1];
                misure[j - 1] = misure[j];
            }
        }
    }
}

Misura minimo(Misura v[], int n)
{
    Misura min = v[0];

    for(int i = 0; i < n; i++)
    {
        if(minore(v[i], min) == 1)
            min = v[i];
    }

    return min;
}

int main(void)
{
    int arr_int[DIM_INT];
    float arr_float[DIM_FLOAT];
    Misura misure[DIM_INT + DIM_FLOAT];
    srand(time(NULL));

    for(int i = 0; i < DIM_INT; i++)
    {
        arr_int[i] = rand() % (MAX_NUM_INT - MIN_NUM_INT + 1) + MIN_NUM_INT;
    }

    for(int i = 0; i < DIM_FLOAT; i++)
    {
        arr_float[i] = (rand() % 151 + 50) / 100.0;
    }

    int n = aggrega(arr_int, DIM_INT, arr_float, DIM_FLOAT, misure);
    //ordina_sequenza(misure, n);

    for(int i = 0; i < n; i++)
    {
        visualizza(misure[i]);
    }

    printf("\nMinimo: ");
    visualizza(minimo(misure, n));

    return 0;
}
