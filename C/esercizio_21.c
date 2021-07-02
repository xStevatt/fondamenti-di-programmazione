#include <stdio.h>
#include <time.h>
#define DIM 10

int numero_divisori(int n)
{
    int n_divisori = 0;

    for(int i = 1; i <= n; i++)
    {
        if(n % i == 0)
            n_divisori++;
    }

    return n_divisori;
}

int main(void)
{
    int seq[DIM], max_div = -1, max_num = -1;
    srand(time(NULL));

    printf("Sequenza generata: ");
    for(int i = 0; i < DIM; i++)
    {
        seq[i] = rand() % 100 + 1;
        printf(i != (DIM - 1) ? "%d, " : "%d", seq[i]);

        if(numero_divisori(seq[i]) >= max_div)
        {
            max_num = seq[i];
            max_div = numero_divisori(seq[i]);
        }
    }

    printf("\n\nIl numero con il massimo numero di divisori: %d con %d divisori.", max_num, max_div);

    return 0;
}
