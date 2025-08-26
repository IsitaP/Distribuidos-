# Define el compilador a usar en este caso es gcc
GCC = gcc 
# opciones de compilación. Aquí se especifica enlazar la librería matemática (-lm)
CFLAGS = -lm 
#banderas para habilitar OpenMP y optimizar con nivel -O3.
FOPENMP = -fopenmp -O3 
#enlaza la librería de hilos POSIX (pthreads).
POSIX = -lpthread 

# hace una referencfia a un archivo fuente 
modulo = inter.c  

#Aquí se define el nombre del ejecutable que se quiere generar.
PROGRAMAS = mmClasicaOpenMP 
# Cuando ejecutas make, se va a construir lo que está en la variable PROGRAMAS (es decir, mmClasicaOpenMP).
ALL: $(PROGRAMAS)


# regla para compilar mmClasicaOpenMP.c
mmClasicaOpenMP:
	$(GCC) $(CLFAGS) $@.c -o $@ $(FOPENMP)
#Regla para limpiar ejecutables 
clean:
	$(RM) $(PROGRAMAS) 
