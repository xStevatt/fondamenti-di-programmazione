#include <stdio.h>
#define MAX 50
#define LENGTH 50

int compara_string(char string1[], char string2[])
{
    int length_1, length_2;

    for(length_1 = 0; string1[length_1] != '\0'; length_1++);
    for(length_2 = 0; string2[length_2] != '\0'; length_2++);

    if(length_1 == length_2)
    {
        for(int i = 0; i < length_1; i++)
        {
            if(string1[i] == string2[i])
                continue;
            else
                return 0;
        }
        return 1;
    }
    else
        return 0;
}

int is_vocale(char c)
{
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return 1;
    else
        return 0;
}

int is_lettera(char c)
{
    if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
        return 1;
    else
        return 0;
}

void contatore(char string[], int* n_vocali, int* n_consonanti)
{
    *n_vocali = 0, *n_consonanti = 0;

    for(int i = 0; string[i] != '\0'; i++)
    {
        if(is_lettera(string[i]) == 1 && is_vocale(string[i]) == 1)
        {
            (*n_vocali)++;
        }
        if(is_lettera(string[i]) == 1 && is_vocale(string[i]) == 0)
        {
            (*n_consonanti)++;
        }
    }
}

int main(void)
{
    char parole[MAX][LENGTH];
    int n_vocali, n_consonanti;
    int max_vocali = 0, max_consonanti = 0;
    int index_max_v = -1, index_max_c = -1;

    for(int i = 0; i < MAX; i++)
    {
        printf("Inserire una parola: ");
        scanf("%49s", parole[i]);

        if(compara_string(parole[i], "0") != 1)
        {
            contatore(parole[i], &n_vocali, &n_consonanti);

            if(n_vocali > max_vocali)
            {
                max_vocali = n_vocali;
                index_max_v = i;
            }
            if(n_consonanti > max_consonanti)
            {
                max_consonanti = n_consonanti;
                index_max_c = i;
            }
        }
        else
            break;
    }

    printf("Stringa %s con %d vocali \n", parole[index_max_v], max_vocali);
    printf("Stringa %s con %d consonanti \n", parole[index_max_c], max_consonanti);
    return 0;
}
