#include <stdio.h>
#include <string.h>

#define NUM_P 50
#define LEN_P 20


int main(void)
{
    char parole[NUM_P][LEN_P], ris[LEN_P * NUM_P] = "";
    int i, n = 0, c = 0;

    do
    {
        printf("Inserire una parola: ");
        scanf("%s", parole[n]);
        n++;
    }
    while(strcmp(parole[n - 1], "fine") != 0 && n < NUM_P);

    for(int i = 0; i < n; i++)
    {
        if(strcmp(parole[i], parole[0]) > 0)
        {
            // printf("%s\n", parole[i]);
            strcat(strcat(ris, parole[i]), " ");
            c++;
        }
    }

    printf("%d\n", c);
    printf("%s", ris);

    return 0;
}
