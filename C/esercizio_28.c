#include <stdio.h>
#include <time.h>

#define LENGTH 50

char return_char(char c, int n)
{
    if(c >= 'a' && c <= 'z')
    {
        if(c + n > 'z')
        {
            return
                (c + n) - ('z' - 'a' + 1);
        }
        if(c + n < 'a')
        {
            return
                (c + n) + ('z' - 'a' + 1);
        }
        else
        {
            return
                c + n;
        }
    }
    else
    {
        return c;
    }
}

int main(void)
{
    char frase[LENGTH];
    int n;

    printf("Inseririre una frase: ");
    fgets(frase, LENGTH, stdin);
    printf("Inserire un numero (modulo <= 10): ");
    scanf("%d", &n);

    printf("Nuova frase: ");
    for(int i = 0; i < LENGTH && frase[i] != '\0'; i++)
    {
        printf("%c", return_char(frase[i], n));
    }
}
