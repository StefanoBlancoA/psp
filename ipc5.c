#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>

// Función que calcula la letra del dni
char letra(int dni)
{
	char letra[] = "TRWAGMYFPDXBNJZSQVHLCKE";
	dni %= 23;
	
	return letra[dni];
}


void main(){

     int fd[2]; 
     int fd2[2];
     char buffer[30];
     char buffer2[30];
     pid_t pid;
    
     // Creamos el pipe
     pipe(fd); 
     pipe(fd2);
     
     //Se crea un proceso hijo
     pid = fork();
     
     //Variable del dni
     //char * dni;
     
     int dni;

     if (pid==0)
     
     {
                close(fd[0]); // Cierra el descriptor de lectura del pipe 1
                close(fd2[1]); // Cierra el descriptor de escritura del pipe 2. Con este lee
                
                printf("Escriba el dni: \n");
                scanf("%d", &dni);
                
                printf("El dni es: %d", dni);
                
                write(fd[1], &dni, sizeof(dni));
                
                read(fd2[0], buffer2, sizeof(buffer2)); //El proceso hijo espera para leer mientras no haya datos en el pipe 2. Una vez hay datos, se reanuda
                printf("La letra del dni es: %s", buffer2);
     }
     
     else
     
     {
                close(fd[1]); // Cierra el descriptor de escritura del pipe 1. Con este lee
                close(fd2[0]); // Cierra el descriptor de lectura del pipe 2. Con este escribe
                printf("hola1");
                read(fd[0], buffer, sizeof(buffer)); //El read se queda bloqueado hasta que haya datos en el pipe 1 (fd). Cuando hay datos continúa el código
                printf("hola2");
                int numdni;
                numdni = atoi(buffer); //Cast de string a int
                char l;
                l = letra(numdni); //Calcula la letra del dni
                printf("%d",l);
                //write(fd2[1], l, sizeof(l));
                
                wait(NULL); //Espera a que el proceso hijo termine
     }
     
        
}
