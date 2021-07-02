#include <stdio.h>
#include <time.h>

#define DIM 50
#define ANNO_MAX 2014
#define ANNO_MIN 1900

struct Date
{
    int giorno;
    int mese;
    int anno;
};

struct Date produci_date();
int is_bisestile(struct Date date);
int is_older();

int is_bisestile(struct Date date)
{
    return
        (date.anno % 4 == 0 && date.anno % 100 != 0 || date.anno % 400 == 0) ? 1 : 0;
}

struct Date produci_date()
{
    struct Date date;
    date.anno = rand() % (ANNO_MAX - ANNO_MIN + 1) + ANNO_MIN;
    date.mese = rand() % 12 + 1;

    if(date.mese == 2 && is_bisestile(date))
    {
        date.giorno = (rand() % 29) + 1;
    }
    else if(date.mese == 2 && !is_bisestile(date))
    {
        date.giorno = (rand() % 28) + 1;
    }
    else
    {
        switch(date.mese)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                date.giorno = (rand() % 31) + 1;
                break;
            default:
                date.giorno = (rand() % 30) + 1;
        }
    }
    return date;
}

int is_older(struct Date date_1, struct Date date_2)
{
    if(date_1.anno < date_2.anno)
    {
        return 1;
    }
    else if(date_1.anno > date_2.anno)
    {
        return 0;
    }
    else if(date_1.mese < date_2.mese)
    {
        return 1;
    }
    else if(date_1.mese > date_2.mese)
    {
        return 0;
    }
    else if(date_1.giorno < date_2.giorno)
    {
        return 1;
    }
    else if(date_1.giorno > date_2.giorno)
    {
        return 0;
    }
}

int main(void)
{
    struct Date dates[DIM], oldest;;
    srand(time(NULL));

    oldest.giorno = 9999;
    oldest.mese = 9999;
    oldest.anno = 9999;

    for(int i = 0; i < DIM; i++)
    {
        dates[i] = produci_date();
        printf(i <= 8 ? "Data 0%d: " : "Data %d: ", i + 1);
        printf(dates[i].giorno <= 9 ? "0%d/" : "%d/", dates[i].giorno);
        printf(dates[i].mese <= 9 ? "0%d/" : "%d/", dates[i].mese);
        printf("%d", dates[i].anno);

        printf(is_bisestile(dates[i]) == 1 ? " - Anno Bisestile\n" : "\n");
    }

    for(int i = 0; i < DIM; i++)
    {
        if(dates[i].giorno == 1 && dates[i].mese == 1 && dates[i].anno == ANNO_MIN)
        {
            oldest.giorno = 1;
            oldest.mese = 1;
            oldest.anno = ANNO_MIN;
            break;
        }

        if(is_older(dates[i], oldest))
        {
            oldest.giorno = dates[i].giorno;
            oldest.mese = dates[i].mese;
            oldest.anno = dates[i].anno;
        }
    }

    printf("\nData piu' remota: %d/%d/%d", oldest.giorno, oldest.mese, oldest.anno);
}
