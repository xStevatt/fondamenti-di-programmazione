#include <stdio.h>
#include <math.h>
#include <time.h>

#define DIM 10
#define MAX 1000
#define MIN -1000

struct Punto
{
    float x;
    float y;
    float dis;
};

struct Punto origine = { .x = 0.0, .y = 0.0};

float distanza_due_punti(struct Punto punto_1, struct Punto punto_2)
{
    return sqrtf(powf(punto_1.x - punto_2.x, 2) + powf(punto_1.y - punto_2.y, 2));
}

void riempi_array(struct Punto punti[], int size_arr)
{
    for(int i = 0; i < size_arr; i++)
    {
        punti[i].x = (rand() % (MAX - MIN + 1) + MIN) / 1.0;
        punti[i].y = (rand() % (MAX - MIN + 1) + MIN) / 1.0;
        punti[i].dis = distanza_due_punti(punti[i], origine);
    }
}

void ordina_punti(struct Punto punti[], int size_arr)
{
    for(int i = 0; i < size_arr - 1; i++)
    {
        for(int j = size_arr - 1; j > i; j--)
        {
            if(punti[j - 1].dis > punti[j].dis)
            {
                struct Punto temp = punti[j - 1];
                punti[j - 1] = punti[j];
                punti[j] = temp;
            }
        }
    }
}

void visualizza_punto(struct Punto punto)
{
    printf("(X: %.2f ", punto.x);
    printf("Y: %.2f)", punto.y);
    printf(" - Distanza origine: %.2f", punto.dis);
    printf("\n");
}

void visualizza_sequenza(struct Punto punti[], int size_arr)
{
    for(int i = 0; i < size_arr; i++)
    {
        visualizza_punto(punti[i]);
    }
}

struct Punto trova_punto(struct Punto punti[], int size_arr, struct Punto punto_inserito)
{
    struct Punto punto_vicino;

    punto_vicino = punti[0];

    for(int i = 1; i < size_arr; i++)
    {
        if(abs(distanza_due_punti(punto_inserito, punti[i])) <= abs(distanza_due_punti(punto_inserito, punto_vicino)))
            punto_vicino = punti[i];
    }
    return punto_vicino;
}

int main(void)
{
    srand(time(NULL));
    struct Punto punti[DIM], inserito;

    printf("Sequenza generata: \n");
    riempi_array(punti, DIM);
    visualizza_sequenza(punti, DIM);

    printf("\n");

    printf("Sequenza ordinata: \n");
    ordina_punti(punti, DIM);
    visualizza_sequenza(punti, DIM);

    printf("\n");

    printf("Inserire la coordinata X del punto: ");
    scanf("%f", &inserito.x);
    printf("Inserire la coordinata Y del punto: ");
    scanf("%f", &inserito.y);

    inserito.dis = distanza_due_punti(inserito, origine);

    printf("\n");

    printf("Punto inserito: ");
    visualizza_punto(inserito);
    printf("Punto vicino: ");
    visualizza_punto(trova_punto(punti, DIM, inserito));

    return 0;
}
