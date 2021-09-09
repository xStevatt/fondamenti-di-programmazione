#include <stdio.h>
#define LENGTH 20

/*
    Invertire una stringa inserita in input. Mostrare a schermo la stringa invertita.
    Fare questo con e senza l'utilizzo di un secondo vettore. 

    Author: STEFANO VALLONCINI
*/

int main(void)
{
    char string[LENGTH], inversa[LENGTH];
    int j = 0;
    fgets(string, LENGTH, stdin);

    for(; string[j] != '\0' && string[j] != '\n' && j < LENGTH; j++);

    // Senza Vettore
    for(int i = j - 1; i >= 0; i--)
        printf("%c", string[i]);

    printf("\n");

    // Con l'uso del secondo vettore
    for(int i = 0, c = j - 1; i < j; i++, c--)
        inversa[i] = string[c];
    for(int i = 0; i < j; i++)
        printf("%c", inversa[i]);

    return 0;
}
