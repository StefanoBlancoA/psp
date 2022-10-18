#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
void main(){
	pid_t pid, pid_hijo;
	
	pid=fork();
	
	if(pid==0){
		
		/*estamos en el proceso hijo. pid en el proceso hijo es 0*/
		printf("Nombre: Stefano Blanco \n");
	}else{
		/*estamos en el proceso padre. pid en el proceso padre es el PID del proceso hijo*/
		wait(NULL);
		printf("Soy el padre y mi pid es: %d \n",getpid());
		printf("Mi hijo es el proceso: %d \n",pid);
	}
	exit(0);
}
