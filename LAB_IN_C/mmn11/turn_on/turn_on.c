#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

/*for a given long number return it with the 17th place turn on*/
long turn_on(long);

/*translate the number from base 10 to binary */
void translate(long);

int main()
{
  long num, change_num;
  
  printf("please enter a number\n");
  if (scanf("%ld", &num) != 1) /*exeption endeler*/
    printf("it is not a number\n");
    
  change_num = turn_on(num);
  printf("\nthe original number:\n");
  translate(num); 
  printf("in 10 base the number is %ld\n", num);
  
  if( change_num != num)
  {
    printf("\nafter turning on the 17th bit: perform a transfer\n");
    translate(change_num);
    printf("in base 10 the number is %ld\n", change_num);
  }
  else
    printf("the 17th bit is already turn on\n that way there is no change\n");
 return 0;
}

long turn_on(long num)
{
  long mask = ((long)1) << 16; /* to make the change at the 17 position*/
  num = num | mask; /* the actual turning on*/
  return num;
}

void translate(long number)
{
  unsigned long num = (unsigned long)number; /* for a negtive number*/
  int bits = sizeof(long) * 8;
  long i, mask;
  
  for(i = bits - 1; i >= 0 ; i--)
  {
    mask = ((long)1) << i;
    if(num & mask) /*turn on*/ 
      printf("1");
    else
       printf("0");           
  }
  printf("\n");  
}


