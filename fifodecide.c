#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <ctype.h>

int main(void)
{
  int  fp;
  int  p,  bytesleidos;
  char buffer[10];

   p=mkfifo("FIFODAM2",  S_IFIFO|0666);//permiso  de  lecture y escritura
	
  while (1)
  {
	fp = open("FIFODAM2", 0); //Abre fichero
	bytesleidos=read(fp,buffer,1) ; //Lee fichero fp y lo escribe en buffer, leyendo de 1en1
	printf("OBTENIENDO  Informacion...");
	if(isdigit(buffer[0])){
		printf("El caracter %c es un número",buffer[0]);
	}else{
		printf("El caracter %c es una letra",buffer[0]);
	}
	close(fp); 
  }  
return(0); 
}
