#include <stdio.h>
#include <time.h>
#define DIM 10

int cerca(float arr[], int size_arr, float num);
int aggiungi_elemento(float arr[], int size_arr, float num);
int cancella_elemento(float arr[], int size_arr, float num);
void visualizza_array(float arr[], int size_arr);

int main(void)
{
    float seq[DIM];
    int size_array = 0;
    float reale;
    srand(time(NULL));

    for(int i = 0; i < DIM; i++)
    {
        float num_gen = (rand() % 101) / 100.0;
        int temp = aggiungi_elemento(seq, size_array, num_gen);

        if(size_array == temp)
        {
            i--;
        }
        else
        {
            size_array = temp;
        }
    }

    visualizza_array(seq, size_array);

    printf("\nInserire un numero reale: ");
    scanf("%f", &reale);
    size_array = cancella_elemento(seq, size_array, reale);
    visualizza_array(seq, size_array);

    return 0;
}

int cancella_elemento(float arr[], int size_arr, float num)
{
    int i, j;
    i = cerca(arr, size_arr, num);
    if(i < 0)
        return size_arr;

    for(int j = i; j < size_arr - 1; j++)
        arr[j] = arr[j + 1];

    return size_arr - 1;
}

int aggiungi_elemento(float arr[], int size_arr, float num)
{
    int i = 0;

    if(cerca(arr, size_arr, num) != -1)
    {
        return size_arr;
    }

    for(i = size_arr - 1; i >= 0 && arr[i] > num; i--)
    {
        arr[i + 1] = arr[i];
    }
    arr[i + 1] = num;

    return size_arr + 1;
}

int cerca(float arr[], int size_arr, float num)
{
    for(int i = 0; i < size_arr; i++)
    {
        if(arr[i] == num)
            return i;
    }
    return -1;
}

void visualizza_array(float arr[], int size_arr)
{
    printf("\n\nSequenza:");
    for(int i = 0; i < size_arr; i++)
    {
        printf(i == size_arr - 1 ? "%.2f" : "%.2f, ", arr[i]);
    }
}
