#ifndef MYCOMP_H
#define MYCOMP_H
#include <ctype.h>
#include <string.h>
#include "complex.h"
#define MAX_LINE 256

#define CHECK_COMMAS(actual, expected)\
  if ((actual) > (expected))\
  {\
    printf("Multiple consecutive commas\n\n");\
    continue;\
  }\
  if ((actual) < (expected))\
  {\
    printf("Missing comma\n\n");\
    continue;\
  }

#define EXTRANEOUS_TEXT(token)\
  if ((token) != NULL)\
  {\
    printf("Extraneous text after end of command\n\n");\
    continue;\
  } 

#define MISSING_PARAMETERS(condition)\
  if (condition)\
  { \
    printf("Missing parameter\n\n");\
    continue;\
  } 
  
#define CHECK_NUM(str, var)\
  if (!valid_num((str), &(var)))\
  {\
    printf("Invalid parameter - not a number\n\n");\
    continue;\
  }
  
#define CHECK_COMP(comp) \
  if ((comp) == NULL)\
  { \
    printf("Undefined complex variable\n"); \
    continue; \
  }
  
  
/* convers the given string to a double if the string is not represent a valid num return 0*/
int valid_num(char *str, double *value);

/*count num of commas in the given string */
int count_comma(char* str);

/*cheks the complex varabile*/
complexnum* find_comp(char *ptr, complexnum* comps[]) ;
    
cmd commands[] = {
    {"read_comp", read_comp},
    {"print_comp", print_comp},
    {"add_comp", add_comp},
    {"sub_comp", sub_comp},
    {"mult_comp_real", mult_comp_real},
    {"mult_comp_img", mult_comp_img},
    {"mult_comp_comp", mult_comp_comp},
    {"abs_comp", abs_comp},
    {"stop", stop},
    {"not_valid", NULL}
};

#endif
