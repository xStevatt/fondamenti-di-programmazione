#include <stdio.h>
#include <time.h>

#define DIM 11
#define GIORNO_MIN 1
#define GIORNO_MAX 31
#define MESE_MIN 1
#define MESE_MAX 12
#define ANNO_MIN 0
#define ANNO_MAX 99

struct Date
{
    int giorno;
    int mese;
    int anno;
};

void visualizza_date(struct Date dates[], int size_array)
{
    for(int i = 0; i < size_array; i++)
    {
        printf(dates[i].giorno <= 9 ? "0%d/" : "%d/", dates[i].giorno);
        printf(dates[i].mese <= 9 ? "0%d/" : "%d/", dates[i].mese);
        printf(dates[i].anno <= 9 ? "0%d\n" : "%d\n", dates[i].anno);
    }
}

int is_bisestile(struct Date date)
{
    return
        (date.anno % 4 == 0 && date.anno % 100 != 0 || date.anno % 400 == 0) ? 1 : 0;
}

int is_valid(struct Date data)
{
    if(data.anno < 0 || data.anno > 99 || data.giorno <= 0 || data.giorno > 31 || data.mese < 1 || data.mese > 12)
        return 0;

    if(data.mese == 2 && data.giorno > 29)
        return 0;
    if(data.mese == 2 && !is_bisestile(data) && data.giorno > 28)
        return 0;
    if(data.mese == 2 && is_bisestile(data) && data.giorno == 29)
        return 1;

    int month_31 = (data.mese == 1 || data.mese == 3 || data.mese == 5 || data.mese == 7 || data.mese == 8 || data.mese == 10 || data.mese == 12) ? 1 : 0;

    if(month_31 && data.giorno <= 31)
        return 1;
    else if(!month_31 && data.giorno <= 30)
        return 1;
    else
        return 0;
}

struct Date genera_data()
{
    int rand_giorni = rand() % (GIORNO_MAX - GIORNO_MIN + 1) + GIORNO_MIN;
    int rand_mese = rand() % (MESE_MAX - MESE_MIN + 1) + MESE_MIN;
    int rand_anno = rand() % (ANNO_MAX - ANNO_MIN + 1) + ANNO_MIN;

    struct Date data = { .giorno = rand_giorni, .mese = rand_mese, .anno = rand_anno};

    return data;
}

int is_older(struct Date date_1, struct Date date_2)
{
    if(date_1.anno < date_2.anno)
    {
        return 1;
    }
    if(date_1.anno > date_2.anno)
    {
        return 0;
    }
    if(date_1.mese < date_2.mese)
    {
        return 1;
    }
    if(date_1.mese > date_2.mese)
    {
        return 0;
    }
    if(date_1.giorno < date_2.giorno)
    {
        return 1;
    }
    if(date_1.giorno > date_2.giorno)
    {
        return 0;
    }
}

void ordina_date(struct Date dates[], int size_arr)
{
    int i, j;

    for(i = 0; i < size_arr - 1; i++)
    {
        for(j = size_arr - 1; j > i; j--)
        {
            if(is_older(dates[j - 1], dates[j]) == 0)
            {
                struct Date temp = dates[j - 1];
                dates[j - 1] = dates[j];
                dates[j] = temp;
            }
        }
    }
}

void inserisci_elemento(struct Date dates[], int size_arr, struct Date da_inserire, int* index)
{
    ordina_date(dates, size_arr);
    int i, j;

    for(i = 0; i < size_arr && is_older(dates[i], da_inserire) == 1; i++);
    for(j = size_arr; j > i; j--)
        dates[j] = dates[j - 1];

    dates[i] = da_inserire;
    *index = i;
}

int main(void)
{
    srand(time(NULL));
    struct Date dates[DIM];
    int i = 0;

    do
    {
        struct Date data_temp = genera_data();
        if(is_valid(data_temp))
            dates[i++] = data_temp;
    }
    while(i < DIM - 1);

    visualizza_date(dates, DIM - 1);
    printf("\n");

    printf("La sequenza ordinata: \n");
    ordina_date(dates, DIM - 1);
    visualizza_date(dates, DIM - 1);
    printf("\n");

    struct Date data_ins;

    do
    {
        printf("Inserire il giorno: ");
        scanf("%d", &data_ins.giorno);
        printf("Inserire il mese: ");
        scanf("%d", &data_ins.mese);
        printf("Inserire l'anno: ");
        scanf("%d", &data_ins.anno);

        if(!is_valid(data_ins))
            printf("Data valida non inserita!\n");
    }
    while(!is_valid(data_ins));
    int index = -1;

    printf("\n\nNuova sequenza ordinata: \n");
    inserisci_elemento(dates, DIM, data_ins, &index);
    visualizza_date(dates, DIM);

    printf("\n");
    printf("Date che precedono: \n");
    visualizza_date(dates, index);

    return 0;
}
