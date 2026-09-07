#include "complex.h"


int read_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
 if( c1 == NULL )/*edge case*/
    return 1;
  c1-> real = realN;
  c1-> imaginary = imaN;
  return 0;
}

int print_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  printf("%.2f + (%.2f )i \n", c1->real, c1->imaginary);
  return 0;
}

int add_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = c1->real + c2->real;
  temp.imaginary = c1->imaginary + c2->imaginary;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int sub_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = c1->real - c2->real;
  temp.imaginary = c1->imaginary - c2->imaginary;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int mult_comp_real(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = (c1->real) * realN;
  temp.imaginary = (c1->imaginary) * realN;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int mult_comp_img(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = -(c1->imaginary) * imaN;
  temp.imaginary = (c1->real) * imaN;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int mult_comp_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = c1->real * c2->real -(c1->imaginary * c2-> imaginary);
  temp.imaginary = c1->real * c2-> imaginary + c2->real * c1-> imaginary;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int abs_comp(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  complexnum temp;
  temp.real = sqrt(POW(c1->real) + POW(c1->imaginary)) ;
  temp.imaginary = 0;
  print_comp(&temp, NULL,0,0);
  return 0;
}

int stop(complexnum* c1,complexnum* c2, double realN, double imaN)
{
  exit(0);
  return 0;
}

