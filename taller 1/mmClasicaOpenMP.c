/*#######################################################################################
 #* Fecha:15-08-2025
 #* Autor:Isabella Palacio Fajardo 
 #* Tema: 
 #* 	- Programa Multiplicación de Matrices algoritmo clásico
 #* 	- Paralelismo con OpenMP
######################################################################################*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>
#include <omp.h>

// Variables globales para medir tiempo
struct timeval inicio, fin; 

// Función para marcar el inicio de la medición de tiempo
void InicioMuestra(){
	gettimeofday(&inicio, (void *)0);
}
// Función para marcar el final de la medición de tiempo y calcular el tiempo transcurrido
void FinMuestra(){
	gettimeofday(&fin, (void *)0);
	fin.tv_usec -= inicio.tv_usec;
	fin.tv_sec  -= inicio.tv_sec;
	double tiempo = (double) (fin.tv_sec*1000000 + fin.tv_usec); 
	printf("%9.0f \n", tiempo);
}

// Imprime una matriz cuadrada de dimensión D (solo si D < 9 para que sea legible)
void impMatrix(double *matrix, int D){
	printf("\n");
	if(D < 9){
		for(int i=0; i<D*D; i++){
			if(i%D==0) printf("\n");
			printf("%f ", matrix[i]);
		}
		printf("\n**-----------------------------**\n");
	}
}


// Inicializa dos matrices con valores aleatorios entre 0 y 99
void iniMatrix(double *m1, double *m2, int D){
	for(int i=0; i<D*D; i++, m1++, m2++){
		*m1 =   rand()%100;	
		*m2 =   rand()%100;	
	}
}

// Multiplicación de matrices clásicas con paralelismo OpenMP
// mA * mB = mC
void multiMatrix(double *mA, double *mB, double *mC, int D){
	double Suma, *pA, *pB;
	#pragma omp parallel  // define región paralela
	{
	#pragma omp for
	for(int i=0; i<D; i++){
		for(int j=0; j<D; j++){
			pA = mA+i*D;	 // apunta al inicio de la fila i de A
			pB = mB+j; //pB = mB+(j*D);	 // apunta al inicio de la fila i de A
			Suma = 0.0;
			// recorre toda la fila i de A y la columna j de B
			for(int k=0; k<D; k++, pA++, pB+=D){
				Suma += *pA * *pB; // multiplicación elemento a elemento y acumulación
			}
			mC[i*D+j] = Suma; // resultado en la posición (i,j
		}
	}
	}
}

int main(int argc, char *argv[]){
	if(argc < 3){
	// Uso correcto: ./ejecutable tamaño_matriz numero_hilos
		printf("\n Use: $./clasicaOpenMP SIZE Hilos \n\n");
		exit(0);
	}

	// Se obtienen parámetros de entrada
	int N = atoi(argv[1]); // dimensión de la matriz
	int TH = atoi(argv[2]);// número de hilos a usar
	// Reservamos memoria para las matrices (N x N)
	double *matrixA  = (double *)calloc(N*N, sizeof(double));
	double *matrixB  = (double *)calloc(N*N, sizeof(double));
	double *matrixC  = (double *)calloc(N*N, sizeof(double));
	srand(time(NULL)); // semilla para números aleatorios

	// Fijamos el número de hilos para OpenMP
	omp_set_num_threads(TH); 

	
	// Inicializamos matrices A y B con valores aleatorios
	iniMatrix(matrixA, matrixB, N);

	// Mostramos A y B (solo si N < 9)
	impMatrix(matrixA, N);
	impMatrix(matrixB, N);

	// Medimos el tiempo de la multiplicación
	InicioMuestra();
	multiMatrix(matrixA, matrixB, matrixC, N);
	FinMuestra();
	// Mostramos la matriz resultante
	impMatrix(matrixC, N);

	/*Liberación de Memoria*/
	free(matrixA);
	free(matrixB);
	free(matrixC);
	
	return 0;
}
