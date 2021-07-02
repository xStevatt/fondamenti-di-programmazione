#include <stdio.h>
#include <time.h>

#define DIM 10

struct Time
{
    int ora;
    int minuti;
};

struct Time generate_time()
{
    struct Time time;

    time.minuti = rand() % 60;
    time.ora = rand() % 24;

    return time;
}

void print_correct_data(struct Time time)
{
    if(time.ora <= 9)
    {
        printf("0%d:", time.ora);
    }
    else
    {
        printf("%d:", time.ora);
    }
    if(time.minuti <= 9)
    {
        printf("0%d", time.minuti);
    }
    else
    {
        printf("%d", time.minuti);
    }
}

int seconds_passed(struct Time time)
{
    int time_passed_seconds = 0;

    time_passed_seconds += (time.ora * 3600) + (time.minuti * 60);

    return time_passed_seconds;
}

int determina_prossimo(struct Time time_1, struct Time time_2)
{
    if(seconds_passed(time_1) >= seconds_passed(time_2))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void trova_valori(struct Time orari[], int size_arr, struct Time* max_orario, struct Time* min_orario)
{
    for(int i = 0; i < size_arr; i++)
    {
        struct Time temp_min = *min_orario;
        struct Time temp_max = *max_orario;

        if(determina_prossimo(orari[i], temp_min) == 0)
        {
            *min_orario = orari[i];
            continue;
        }
        if(determina_prossimo(orari[i], temp_max) == 1)
        {
            *max_orario = orari[i];
        }
    }
}

int main(void)
{
    struct Time orari[DIM];
    srand(time(NULL));

    printf("Orari generati: \n");
    for(int i = 0; i < DIM; i++)
    {
        orari[i] = generate_time();
        print_correct_data(orari[i]);
        printf("\n");
    }

    struct Time max_orario = { .ora = 0, .minuti = 0};
    struct Time min_orario = { .ora = 24, .minuti = 0};

    trova_valori(orari, DIM, &max_orario, &min_orario);

    printf("Primo orario della giornata: ");
    print_correct_data(min_orario);
    printf("\n") ;
    printf("Ultimo orario della giornata: ");
    print_correct_data(max_orario);

    return 0;
}
