#include "defenition.h"
int *ptr = NULL;
int current_size = 0;
/* put the sum and abs of two numbers at their memory  */
void findDifferenceAndSum(int num1,int num2, int* point1, int* point2)
{
  int sum = num1+num2;
  int sub = abs(num1-num2);
  *point1 = sum;
  *point2 = sub;
}
/*  save the numbers in array */
void saveArray(int num1, int num2)
{
  int* temp = (int*) realloc(ptr,(current_size+ 2)*sizeof(int));
  if(temp == NULL)
    exit(1);
  ptr = temp;
  *(ptr + current_size + 1) = num1;
  *(ptr + current_size ) = num2;
  current_size +=2;
}
  
