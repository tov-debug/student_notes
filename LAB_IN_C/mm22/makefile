mycomp: complex.o mycomp.o
	gcc -ansi -pedantic -Wall  complex.o mycomp.o -o mycomp -lm
complex.o: complex.c complex.h
	gcc -c -ansi -pedantic -Wall complex.c -o complex.o
mycomp.o: mycomp.c mycomp.h
	gcc -c -ansi -pedantic -Wall mycomp.c -o  mycomp.o
