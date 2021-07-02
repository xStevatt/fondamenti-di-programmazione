#include <stdio.h>
#include <string.h>

#define DIM 50
#define STR_MAX_LENGTH 50

int inserisci_stringa(char strings[][STR_MAX_LENGTH], int size_arr, char parola_vietata[])
{
    char temp_str[STR_MAX_LENGTH];

    printf("Inserire la %d stringa: ", size_arr + 1);
    scanf("%49s", temp_str);

    if(strcmp(temp_str, parola_vietata) != 0)
    {
        strcpy(strings[size_arr], temp_str);
        return ++size_arr;
    }
    else
    {
        return size_arr;
    }
}

int cerca_elemento(char strings[][STR_MAX_LENGTH], int size_arr, char parola[])
{
    for(int i = 0; i < size_arr; i++)
    {
        if(strcmp(strings[i], parola) == 0)
            return i;
    }
    return -1;
}

int cancella_elemento(char string[][STR_MAX_LENGTH], int size_arr, char parola[])
{
    int i, j;
    i = cerca_elemento(string, size_arr, parola);

    if(i < 0)
        return size_arr;

    for(int j = i; j < size_arr - 1; j++)
        strcpy(string[j], string[j + 1]);

    return size_arr - 1;
}

void visualizza_stringa(char strings[][STR_MAX_LENGTH], int size_arr)
{
    for(int i = 0; i < size_arr; i++)
    {
        printf("%s\n", strings[i]);
    }
}

int main(void)
{
    char mat[DIM][STR_MAX_LENGTH];
    int flag = 1;

    int size_old = 0;
    int size = 0;

    do
    {
        size_old = size;
        size = inserisci_stringa(mat, size, "fine");
    }
    while(size < 50 && size_old != size);

    printf("\n");

    printf("Cognomi inseriti: \n");
    visualizza_stringa(mat, size);
    printf("\n");

    // Eliminazione stringa:

    char stringa_eliminare[STR_MAX_LENGTH];
    int new_size = 0;

    printf("Inserire una stringa da eliminare: ");
    scanf("%49s", stringa_eliminare);
    new_size = cancella_elemento(mat, size, stringa_eliminare);
    visualizza_stringa(mat, new_size);

    return 0;
}
