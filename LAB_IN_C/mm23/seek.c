#include "seek.h"

int main(int argc, char* argv[])
{
  int num = atoi(argv[1]), i;
  if(argc< 3) /* we want more then one */
  {
    fprintf(stderr, "ERORR, argument not valid");
    return 1;
  }
  
  if(num <= 0)
  {
    fprintf(stderr, "ERORR,invalid number");
    return 1;
  }
  
  for(i = 2; i < argc; i++)
  { 
    FILE* file;
    char* file_name;
    char c;
    file_name = (char *)malloc(strlen(argv[i]) +  1);
    if(file_name == NULL)
    {
      fprintf(stderr,"ERORR, no memory for allocation\n");
      return 1;
    }
    strcpy(file_name, argv[i]);
    file = fopen(file_name, "r");
    
    if(file == NULL)
    {
      fprintf(stderr, "ERORR, cant open file name:%s\n", argv[i]);
      free(file_name);
      continue;
    }
    if(num_of_chars(file) < num)
    {
      fprintf(stderr, "ERORR, not enogth chars in file:%s\n", argv[i]);
      free(file_name);
      continue;
    }
    if(fseek(file, num-1,SEEK_SET) == 0)
    {
      c = fgetc(file);
    }
    print(c);
    free(file_name);
    fclose(file);
  }
  return 0;
} 

int print(char c)
{
  printf("the  asci code for the char in the required position is: %d\n",c); 
  return 0;
}

int num_of_chars(FILE * file)
{
  long int count = 0;
  fseek(file, 0, SEEK_END);
  count = ftell(file);
  rewind(file);
  return count;
}
