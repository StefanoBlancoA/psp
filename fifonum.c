#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>

int  main()
{
   int  fp;
   char  numeros[]= "1";
	
    fp = open("FIFODAM2",1);

    printf("Mandando  informacion  al  FIFO...\n"); 
    write(fp,numeros,sizeof(numeros));
    close(fp);
   return 0;
}


