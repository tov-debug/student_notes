#ifndef COMPLEX_H
#define COMPLEX_H
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define POW(a) ((a) * (a))

typedef struct 
{
  double real;
  double imaginary;
} complexnum;

/*   */
int read_comp(complexnum*,complexnum*, double, double);
/*   */
int print_comp(complexnum*,complexnum*, double, double);
/*   */
int add_comp(complexnum*,complexnum*, double, double);
/*   */
int sub_comp(complexnum*,complexnum*, double, double);
/*   */
int mult_comp_real(complexnum*,complexnum*, double, double);
/*   */
int mult_comp_img(complexnum*,complexnum*, double, double);
/*   */
int mult_comp_comp(complexnum*,complexnum*, double, double);
/*   */
int abs_comp(complexnum*,complexnum*, double, double);
/*   */
int stop(complexnum*,complexnum*, double, double);

typedef struct{
  char * name;
  int (*func)(complexnum*,complexnum*, double, double);
  } cmd;
#endif
