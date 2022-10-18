#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

/* gestión de señales en proceso padre       */
void manejador( int numsenal )
{
 printf("Hijo recibe señal número..%d\n", numsenal);
 
}

void manejador2( int numsenal )
{
 printf("Padre recibe señal número..%d\n", numsenal);
 
}

int main()
{
  int pid_hijo;  
  pid_hijo = fork(); //creamos hijo   
  
  switch(pid_hijo)
  {
     case -1:
          printf( "Error al crear el proceso hijo...\n");
          exit( -1 );        
     case 0:   //HIJO     	         
          signal(SIGUSR1, manejador); //Función manejadora de la señal. Especifico qué hace SIGUSR1 en el proceso hijo.
          pause(); //Espera a recibir una señal para ejecutarse el proceso.
          printf("Soy el proceso %d hijo \n",getpid());
          sleep(1);
          printf("Mandando señal a mi padre %d \n",getppid());
          kill(getppid(),SIGUSR1); //Envia señal al padre
          sleep(1);
          break;    
     default: //PADRE envia 2 señales
          signal(SIGUSR1, manejador2); //Función manejadora de la señal. Especifico qué hace SIGUSR1 en el proceso padre.
          printf("Soy el proceso %d padre \n",getpid());
          sleep(1);
          printf("Voy a enviar una señal al proceso hijo %d \n",pid_hijo);
          kill(pid_hijo, SIGUSR1);//ENVIA SEÑAL AL HIJO 
          pause(); //Espera a recibir una señal para terminar de ejecutarse.
          sleep(1);
          printf("Fin proceso padre \n");
          break;
  } 
  return 0;
}
