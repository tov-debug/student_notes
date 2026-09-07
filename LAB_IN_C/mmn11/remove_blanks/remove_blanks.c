#include <string.h>
#include <stdio.h>
#include <ctype.h> 
/* the function for a given string remove the blanks inside */
void remove_blanks(char str[]);

int main()
{
  int i = 0;
  char str[1000];
  int c;/* as an intger in order to get EOF */
  printf("Please enter a valid string, at the end press cntr + d\n");
  c = getchar();
  while(c != EOF)
  {
    str[i++] = c;
    c = getchar();
  }
  str[i] = '\0'; /* end of string, for edge case cuts the input at 999 place*/
  printf("\nThe input string:\n");
  printf("%s\n", str);
  remove_blanks(str);
  return 0;
}

void remove_blanks(char str[])
{
  int i = 0;
  int j = 0;
  
  printf("The string as received by the function:\n");
  printf("%s\n", str); 
  while(i < strlen(str)) /*end of string*/
  {
    if (!isspace(str[i])) /*the value at i need to get transfer back*/
    { 
      str[j] = str[i];
      j++;
    }
    i++;
  }
  str[j] = '\0'; /* end of string*/
  printf("The string at the end of the function:\n");
  printf("%s\n", str); 
}


