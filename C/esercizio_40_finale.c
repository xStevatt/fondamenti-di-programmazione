/*
    Esercizio di fine corso: TURTLE GRAPHICS
    Author: Stefano Valloncini
*/

#include <stdio.h>

#define NORD 1
#define EST 2
#define SUD 3
#define OVEST 4

#define ALZA_LA_PENNA 1
#define ABBASSA_PENNA 2
#define MUOVI_DESTRA 3
#define MUOVI_SINISTRA 4
#define AGGIUNGI_POSTI 5
#define EXIT 0

typedef struct
{
    int x, y;

} Coordinate;

typedef struct
{
    Coordinate position;
    int is_penna_alzata;
    int direzione;
} Turtle;

int main(void)
{
    run();
}

void matrix_printer(int rows, int columns, char matrix[rows][columns])
{
    printf(" ");
    for(int i = 0; i < columns; i++)
    {
        printf("-");
    }

    printf("\n");

    for(int i = 0; i < rows; i++)
    {
        printf("|");
        for(int j = 0; j < columns; j++)
        {
            printf("%c", matrix[i][j]);
        }
        printf("|");
        printf("\n");
    }

    printf(" ");
    for(int i = 0; i < columns; i++)
    {
        printf("-");
    }

    printf("\n\n");
}

void matrix_initilizer(int rows, int columns, char matrix[rows][columns])
{
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < columns; j++)
        {
            matrix[i][j] = ' ';
        }
    }
}

void get_window_size(int* rows, int* columns)
{
    int scelta = 0;

    printf("Benvenuto bel programma di Turtle Graphics di Stefano Valloncini.\n");
    printf("Da questa schermata puoi cambiare la dimensione della finestra interessata dalla tartaruga.\n\n");

    printf("La dimensione di default ha un'altezza di 25 e una larghezza di 100.\n");
    printf("Per motivi pratici la dimensione minima del campo deve essere 3 x 3.\n");
    printf("\n");
    printf("Dimensione impostata: [DEFAULT: %d x %d]. Premere 1 per cambiarla, 0 per lasciarla invariata.\n", *rows, *columns);
    printf("Scelta: ");
    do
    {
        scanf("%d", &scelta);
        if(scelta < 0 || scelta > 1)
            printf("Scelta non valida, inserire una scelta valida [0 o 1]: ");
    }
    while(scelta < 0 || scelta > 1);

    if(scelta == 0)
    {
        system("CLS");
        return 0;
    }

    do
    {
        printf("Inserire l'altezza desiderata: ");
        scanf("%d", rows);

        if(*rows < 3 || *rows > 25)
            printf("Inserire un numero valido [MAX: 25 - MIN: 3]\n");
    }
    while(*rows < 3 || *rows > 25);

    do
    {
        printf("Inserire la lunghezza desiderata: ");
        scanf("%d", columns);

        if(*columns < 3 || *columns > 100)
            printf("Inserire un numero valido [MAX: 100 - MIN: 3]\n");
    }
    while(*columns < 3 || *columns > 100);

    system("CLS");
}

void muovi_destra(Turtle* turtle)
{
    switch((*turtle).direzione)
    {
        case OVEST:
            (*turtle).direzione = NORD;
            break;
        default:
            (*turtle).direzione += 1;
    }
}

void muovi_sinistra(Turtle* turtle)
{
    switch((*turtle).direzione)
    {
        case NORD:
            (*turtle).direzione = OVEST;
            break;
        default:
            (*turtle).direzione -= 1;
    }
}

void movimento_nord(int rows, int columns, char matrix[rows][columns], Turtle* turtle, int incremento)
{
    int flag = 0;

    for(int i = 0; i < incremento - 1; i++)
    {
        if(((*turtle).position.x < 1))
        {
            printf("LIMITE RAGGIUNTO A NORD\n");
            system("PAUSE");
            flag = 1;
            break;
        }
        if((*turtle).is_penna_alzata)
        {
            (*turtle).position.x--;
        }
        if(!(*turtle).is_penna_alzata)
        {
            (*turtle).position.x--;
            matrix[(*turtle).position.x][(*turtle).position.y] = '*';
        }
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 1)
    {
        matrix[0][(*turtle).position.y] = 'O';
        (*turtle).position.x = 0;
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 0)
    {
        matrix[0][(*turtle).position.y] = 'I';
        (*turtle).position.x = 0;
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.x -= 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.x -= 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
}

void movimento_est(int rows, int columns, char matrix[rows][columns], Turtle* turtle, int incremento)
{
    int flag = 0;

    for(int i = 0; i < incremento - 1; i++)
    {
        if(((*turtle).position.y > columns - 2))
        {
            printf("LIMITE RAGGIUNTO A EST\n");
            system("PAUSE");
            flag = 1;
            break;
        }
        if((*turtle).is_penna_alzata)
        {
            (*turtle).position.y++;
        }
        if(!(*turtle).is_penna_alzata)
        {
            (*turtle).position.y++;
            matrix[(*turtle).position.x][(*turtle).position.y] = '*';
        }
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.y = columns - 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.y = columns - 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.y += 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.y += 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
}

void movimento_sud(int rows, int columns, char matrix[rows][columns], Turtle* turtle, int incremento)
{
    int flag = 0;

    for(int i = 0; i < incremento - 1; i++)
    {
        if(((*turtle).position.x > rows - 2))
        {
            printf("LIMITE RAGGIUNTO A SUD\n");
            system("PAUSE");
            flag = 1;
            break;
        }
        if((*turtle).is_penna_alzata)
        {
            (*turtle).position.x++;
        }
        if(!(*turtle).is_penna_alzata)
        {
            (*turtle).position.x++;
            matrix[(*turtle).position.x][(*turtle).position.y] = '*';
        }
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 1)
    {
        matrix[rows - 1][(*turtle).position.y] = 'O';
        (*turtle).position.x = rows - 1;
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 0)
    {
        matrix[rows - 1][(*turtle).position.y] = 'I';
        (*turtle).position.x = rows - 1;
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.x += 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.x += 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
}

void movimento_ovest(int rows, int columns, char matrix[rows][columns], Turtle* turtle, int incremento)
{
    int flag = 0;

    for(int i = 0; i < incremento - 1; i++)
    {
        if(((*turtle).position.y < 1))
        {
            printf("LIMITE RAGGIUNTO A OVEST\n");
            system("PAUSE");
            flag = 1;
            break;
        }
        if((*turtle).is_penna_alzata)
        {
            (*turtle).position.y--;
        }
        if(!(*turtle).is_penna_alzata)
        {
            (*turtle).position.y--;
            matrix[(*turtle).position.x][(*turtle).position.y] = '*';
        }
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.y = 0;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 1 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.y = 0;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 1)
    {
        (*turtle).position.y -= 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
    }
    if(flag == 0 && (*turtle).is_penna_alzata == 0)
    {
        (*turtle).position.y -= 1;
        matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
    }
}

void aggiungi_caselle(int rows, int columns, char matrix[rows][columns], Turtle* turtle, int incremento)
{
    if((*turtle).is_penna_alzata)
    {
        matrix[(*turtle).position.x][(*turtle).position.y] = ' ';
    }
    else
    {
        matrix[(*turtle).position.x][(*turtle).position.y] = '*';
    }

    switch((*turtle).direzione)
    {
        case NORD:
            movimento_nord(rows, columns, matrix, turtle, incremento);
            break;
        case EST:
            movimento_est(rows, columns, matrix, turtle, incremento);
            break;
        case SUD:
            movimento_sud(rows, columns, matrix, turtle, incremento);
            break;
        case OVEST:
            movimento_ovest(rows, columns, matrix, turtle, incremento);
            break;
    }
}

int get_next_move(int rows, int columns, char matrix[rows][columns], Turtle* turtle)
{
    printf("Stato penna: ");
    printf((*turtle).is_penna_alzata == 1 ? "ALZATA" : "ABBASSATA");

    printf("\t - \tPosizione corrente: ");
    if((*turtle).direzione == NORD)
        printf("NORD");
    if((*turtle).direzione == EST)
        printf("EST");
    if((*turtle).direzione == SUD)
        printf("SUD");
    if((*turtle).direzione == OVEST)
        printf("OVEST");
    printf("\n");

    printf("1. ALZA LA PENNA - 2. ABBASSA LA PENNA - 3. MUOVI A DESTRA - 4. MUOVI A SINISTRA - 5. AGGIUNGI - 0. ESCI \n");

    printf("Inserire la prossima azione: ");

    int scelta, incremento;

    do
    {
        scanf("%d", &scelta);

        if(scelta < 0 || scelta > AGGIUNGI_POSTI)
            printf("Inserimento non consentito. Inserire un input valido: ");
    }
    while(scelta < 0 || scelta > AGGIUNGI_POSTI);


    switch(scelta)
    {
        case ALZA_LA_PENNA:
            (*turtle).is_penna_alzata = 1;
            matrix[(*turtle).position.x][(*turtle).position.y] = 'O';
            break;
        case ABBASSA_PENNA:
            (*turtle).is_penna_alzata = 0;
            matrix[(*turtle).position.x][(*turtle).position.y] = 'I';
            break;
        case MUOVI_DESTRA:
            muovi_destra(turtle);
            break;
        case MUOVI_SINISTRA:
            muovi_sinistra(turtle);
            break;
        case AGGIUNGI_POSTI:
            printf("Inserire lo spostamento [Maggiore di zero]: ");

            do
            {
                scanf("%d", &incremento);
                if(incremento <= 0)
                    printf("L'incremento inserito e' minore o uguale di zero.\nInserire un input corretto: ");
            }
            while(incremento <= 0);

            aggiungi_caselle(rows, columns, matrix,  turtle, incremento);
            break;
        default:
            return 0;
    }

    return 1;
}

void game(int rows, int columns, char matrix[rows][columns])
{
    Turtle turtle = { .position.x = rows / 2, .position.y = columns / 2, .is_penna_alzata = 1, .direzione = 1 };
    matrix[turtle.position.x][turtle.position.y] = 'O';
    matrix_printer(rows, columns, matrix);

    while(get_next_move(rows, columns, matrix, &turtle))
    {
        system("CLS");
        matrix_printer(rows, columns, matrix);
    }
}

void run()
{
    int rows = 25, columns = 100;

    get_window_size(&rows, &columns);
    char matrix[rows][columns];

    printf("Matrice generata, di dimensione [%d x %d]: \n\n", rows, columns);
    matrix_initilizer(rows, columns, matrix);
    matrix_printer(rows, columns, matrix);
    system("PAUSE");
    system("CLS");

    game(rows, columns, matrix);
}


