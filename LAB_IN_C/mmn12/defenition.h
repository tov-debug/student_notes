#ifndef DEF_H
#define DEF_H
#include <stdio.h>
#include <stdlib.h>
#define ABS(a,b) (a) > (b) ? (a) - (b): (b) - (a)
#define SUM(a,b) ((a)+(b))
extern int *ptr;
extern int current_size;
/* put the sum and abs of two numbers at their memory  */
void findDifferenceAndSum(int num1,int num2, int* point1, int* point2);
/*  save the numbers in array */
void saveArray(int num1, int num2);
#endif
