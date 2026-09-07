#include "mycomp.h"
int main()
{
  complexnum A,B,C,D,E,F;
  complexnum* comps[6];
  complexnum *first_comp = NULL, *second_comp = NULL;
  double real = 0.0, imag = 0.0;
  char *args , *cmd_name, line[256], *t1 = NULL;
  int i;
  comps[0] = &A;
  comps[1] = &B;
  comps[2] = &C;
  comps[3] = &D;
  comps[4] = &E;
  comps[5] = &F;
  for(i = 0; i < 6; i++) /* restart the number to 0+0i */  
  {
    read_comp(comps[i], second_comp, real, imag);
  } 
  printf("Please enter a command\n"); 
  while(fgets(line, sizeof(line), stdin) != NULL)
  {
    int comma = count_comma(line);
    printf("the command:%s\n", line);
    cmd_name = strtok(line, " \t\n\r"); /* the command*/
    if (cmd_name == NULL)
    {
      printf("\n>");
      continue;
    }
    if (cmd_name[strlen(cmd_name) - 1] == ',') 
    {
      printf("Illegal comma\n\n");
      continue;
    }
    args = strtok(NULL, "\n");/* the argument*/
    for (i = 0; commands[i].func != NULL; i++) 
    {
      if (strcmp(cmd_name, commands[i].name) == 0) /* the same command*/ 
      {
        break; 
      }
    }
    if (commands[i].func == NULL)/* not a command*/
    {
      printf("Undefined command name\n\n");
      continue;
    }/*else- an actual command name: */
    if (strcmp(cmd_name, commands[8].name) == 0 ) /* stop*/
    {
      CHECK_COMMAS(comma,0)
      t1 = (args == NULL) ? NULL : strtok(args, ", \t\n\r");
      EXTRANEOUS_TEXT(t1)
    }  
    else if (strcmp(cmd_name, commands[0].name) == 0) /* read_comp*/
    {
      char *t2, *t3, *t4;
      t1 = (args == NULL) ? NULL : strtok(args, ", \t\n\r");
      t2 = strtok(NULL, ", \t\n\r"); 
      t3 = strtok(NULL, ", \t\n\r"); 
      t4 = strtok(NULL, ", \t\n\r"); 
      MISSING_PARAMETERS(t2 == NULL || t3 == NULL)
      CHECK_COMMAS(comma,2)
      EXTRANEOUS_TEXT(t4)
      CHECK_NUM(t2, real);
      CHECK_NUM(t3, imag);
      first_comp = find_comp(t1, comps);
      CHECK_COMP(first_comp)
    }
    else if (strcmp(cmd_name, commands[1].name) == 0 || strcmp(cmd_name, commands[7].name) == 0) /* print_comp or abs_comp*/ 
    {
      char *t2;
      t1 = (args == NULL) ? NULL : strtok(args, ", \t\n\r");
      t2 = strtok(NULL, ", \t\n\r"); 
      MISSING_PARAMETERS(!t1) 
      CHECK_COMMAS(comma,0)
      EXTRANEOUS_TEXT(t2)
      first_comp = find_comp(t1, comps);
      CHECK_COMP(first_comp)
    }
    else /*  mult_comp_real or mult_comp_img*/
    /* add_comp or sub_comp or nult_comp_cmp*/
    {
      char *t2, *t3;
      t1 = (args == NULL) ? NULL : strtok(args, ", \t\n\r");
      t2 = strtok(NULL, ", \t\n\r"); 
      t3 = strtok(NULL, ", \t\n\r"); 
      MISSING_PARAMETERS(!t1 || !t2)
      CHECK_COMMAS(comma,1)
      EXTRANEOUS_TEXT(t3)
      first_comp = find_comp(t1, comps);
      CHECK_COMP(first_comp)
      if(strcmp(cmd_name, commands[4].name) == 0) /* mult_comp_real */
      {
        CHECK_NUM(t2, real)
      }
      else if(strcmp(cmd_name, commands[5].name) == 0) /* mult_comp_img */
      {
        CHECK_NUM(t2, imag)
      }
      else/* add_comp or sub_comp or nult_comp_cmp*/
      {
        second_comp = find_comp(t2, comps);
        CHECK_COMP(second_comp)
      }
    }
    commands[i].func(first_comp, second_comp, real, imag);
    printf("\n"); 
  }
  printf("didnt put quit\n\n");
  return 0;
}
 
int count_comma(char* str)
{
  int i = 0, count = 0;
  while(str[i] != '\0')
  {
    if(str[i++] == ',')
    {
      count++;
    }
  }
  return count;
}

int valid_num(char *str, double *ptr) 
{
  char *endptr;
  double value;

  if (str == NULL || *str == '\0')/*edge case*/
  {
    return 0;
  }

  value = strtod(str, &endptr);

  if (endptr == str)/* didnt mange to get to the end*/
  {
    return 0;
  }

  while (*endptr != '\0') /* ceck the rest of the string*/ 
  {
    if (!isspace((unsigned char)*endptr)) 
    {
      return 0;
    }
    endptr++;
  }

  if (ptr != NULL)
  {
    *ptr = value;
  }
  return 1;
}

complexnum* find_comp(char *ptr, complexnum* comps[]) 
{
  if (ptr == NULL || strlen(ptr) != 1) 
  {
    return NULL;
  }
  if (ptr[0] >= 'A' && ptr[0] <= 'F') 
  {
    return comps[ptr[0] - 'A']; 
  }
    return NULL;
}
 

  

