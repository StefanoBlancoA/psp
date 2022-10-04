#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
void main(){
	pid_t pid, pid_hijo;
	
	pid=fork();
	
	if(pid==0){
		
		/*estamos en el proceso hijo*/
		printf("Nombre: Stefano Blanco \n");
		printf("Soy el padre y mi pid es: %d \n",getppid());
		printf("Mi hijo es el proceso: %d \n",getpid());
	}else{
		/*estamos en el proceso padre*/
		wait(NULL);
	}
	exit(0);
}
