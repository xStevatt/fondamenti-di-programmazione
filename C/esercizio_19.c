#include <stdio.h>
#include <stdbool.h>
#define SIZE 3

void showCoordinates()
{
    printf("Schema delle coordinate: \n");
    printf("       |       |     \n");
    printf("  0,0  |  0,1  |  0,2 \n");

    printf("_______|_______|_____\n");
    printf("       |       |     \n");

    printf("  1,0  |  1,1  |  1,2 \n");

    printf("_______|_______|_____\n");
    printf("       |       |     \n");

    printf("  2,0  |  2,1  |  2,2 \n");

    printf("       |       |     \n\n");
}

void board(char mat[SIZE][SIZE])
{
    system("cls");

    printf("Giocatore 1 (X)  -  Giocatore 2 (O)\n\n\n");


    printf("     |     |     \n");
    printf("  %c  |  %c  |  %c \n", mat[0][0], mat[0][1], mat[0][2]);

    printf("_____|_____|_____\n");
    printf("     |     |     \n");

    printf("  %c  |  %c  |  %c \n", mat[1][0], mat[1][1], mat[1][2]);

    printf("_____|_____|_____\n");
    printf("     |     |     \n");

    printf("  %c  |  %c  |  %c \n", mat[2][0], mat[2][1], mat[2][2]);

    printf("     |     |     \n\n");
}

char checkWinner(char mat[SIZE][SIZE])
{
    for(int i = 0; i < SIZE; i++)
        if(mat[i][0] == mat[i][1] && mat[i][0] == mat[i][2] && mat[i][0] != ' ' && mat[i][1] != ' ' && mat[i][2] != ' ')
        {
            //printf("Sono qui. 1 \n");
            return mat[i][0];
        }

    for(int i = 0; i < SIZE; i++)
        if(mat[0][i] == mat[1][i] && mat[0][i] == mat[2][i] && mat[0][i] != ' ' && mat[1][i] != ' ' && mat[2][i] != ' ')
        {
            //printf("Sono qui. 2 \n");
            return mat[0][i];
        }

    if(mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2] && mat[0][0] != ' ' && mat[1][1] != ' ' && mat[2][2] != ' ')
        {
            //printf("Sono qui. 3 \n");
            return mat[0][0];
        }

    if(mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0] && mat[0][2] != ' ' && mat[1][1] != ' ' && mat[2][0] != ' ')
        {
            //printf("Sono qui. 4 \n");
            return mat[0][2];
        }

    return ' ';
}

// Controlla se la partita è terminata o meno
int checkState(char mat[SIZE][SIZE])
{
    int flag = 0;

    for(int i = 0; i < SIZE; i++)
    {
        for(int j = 0; j < SIZE; j++)
        {
            if(mat[i][j] == ' ')
                flag = 1;
        }
    }

    if(flag == 1)
        return 1;
    if(flag == 0)
        return 0;
}

int main(void)
{
    char mat[SIZE][SIZE], winner;
    int turn = 1, c1, c2;

    printf("Benvenuti nel TRIS di Stefano Valloncini. Have fun!\n");
    printf("Giocatore 1 - X \n");
    printf("Giocatore 2 - O \n");

    printf("\n");
    system("pause");
    printf("\n");


    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
            mat[i][j] = ' ';
    }

    do
    {
        c1 = -1, c2 = -1;

        if(turn == 1)
        {
            do
            {
                do
                {
                    showCoordinates();
                    printf("Giocatore 1 (X) inserire la prima coordinata: ");
                    scanf("%d", &c1);

                    if(c1 > 2 || c1 < 0)
                        printf("Inserire un numero valido!\n");
                }
                while(c1 > 2 || c1 < 0);

                do
                {
                    printf("Giocatore 1 (X) inserire la seconda coordinata: ");
                    scanf("%d", &c2);

                    if(c2 > 2 || c2 < 0)
                        printf("Inserire un numero valido!\n");
                }
                while(c2 > 2 || c2 < 0);

                if(mat[c1][c2] != ' ')
                {
                    system("cls");
                    printf("Le coordinate non sono valide in quanto già occupate.\n");
                }

            }while(mat[c1][c2] != ' ');

            mat[c1][c2] = 'X';
            board(mat);
            turn++;

            if(checkWinner(mat) != ' ')
            {
                if(checkWinner(mat) == 'X')
                    printf("IL VINCITORE E' IL GIOCATORE 1 X!");
                if(checkWinner(mat) == 'O')
                    printf("IL VINCITORE E' IL GIOCATORE 2 O!");

                break;
            }
            else
            {
                if(checkState(mat) == 0)
                {
                    printf("PARTITA TERMINATA IN PAREGGIO");
                    break;
                }
            }
        }

        if(turn == 2)
        {
            do
            {
                do
                {
                    showCoordinates();
                    printf("Giocatore 2 (O) inserire la prima coordinata: ");
                    scanf("%d", &c1);

                    if(c1 > 2 || c1 < 0)
                        printf("Inserire un numero valido!\n");
                }
                while(c1 > 2 || c1 < 0);

                do
                {
                    printf("Giocatore 2 (O)  inserire la seconda coordinata: ");
                    scanf("%d", &c2);

                    if(c2 > 2 || c2 < 0)
                        printf("Inserire un numero valido!\n");
                }
                while(c2 > 2 || c2 < 0);

                if(mat[c1][c2] != ' ')
                {
                    system("cls");
                    printf("Le coordinate non sono valide in quanto già occupate.\n");
                }

            }while(mat[c1][c2] != ' ');

            mat[c1][c2] = 'O';
            board(mat);
            turn--;

            if(checkWinner(mat) != ' ')
            {
                if(checkWinner(mat) == 'X')
                    printf("IL VINCITORE E' IL GIOCATORE 1 X!");
                if(checkWinner(mat) == 'O')
                    printf("IL VINCITORE E' IL GIOCATORE 2 O!");

                break;
            }
            else
            {
                if(checkState(mat) == 0)
                {
                    printf("PARTITA TERMINATA IN PAREGGIO");
                    break;
                }
            }
        }
    }
    while(1);

    printf("\n");
    printf("Grazie per aver giocato!");
    system("pause");
    printf("\n");

    return 0;
}



