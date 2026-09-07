#include "defenition.h"

int main()
{
  int num1 =0, num2= 0, i =0;
  printf("enter 2 numbers each time for quit enter ctrl+d\n");
  while(scanf("%d %d", &num1, &num2) == 2)
  {
    printf("the numbers %d and %d are the current input\n", num1, num2);
    saveArray(num1, num2);
     printf("for the macro ABS the output id %d\n", ABS(num1,num2));
     printf("for the macro SUM the output id %d\n", SUM(num1,num2));
       findDifferenceAndSum(num1,num2,&num1,&num2);
    printf("for the function findDifferenceAndSum the output is dif: %d sum: %d\n",num2, num1 );
    }
    for(i=0; i < current_size; i+= 2)
    {
      printf("first couple: %d,%d\n",*(ptr + i),*(ptr + i+1));
      }
  free(ptr);
  return 0;
}


