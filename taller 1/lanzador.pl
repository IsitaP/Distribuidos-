#!/usr/bin/perl
#**************************************************************
#         		Pontificia Universidad Javeriana
#     Autor: Isabella Palacio Fajardo
#     Fecha: 15 agosto 2025
#     Materia: distribuidos 
#     Tema: Taller de Evaluación de Rendimiento
#     Fichero: script automatización ejecución por lotes 
#****************************************************************/

$Path = `pwd`; # Obtiene la ruta absoluta del directorio actual ejecutando `pwd` en la shell
chomp($Path);  # quita el salto de línea final que deja `pwd`

# Esta línea define el nombre del ejecutable a invoca
$Nombre_Ejecutable = "mmClasicaOpenMP"; // en este se pone el nombre del ejecutable el cual se cambio por mmClasicaOpenMP
@Size_Matriz = ("340","320","400","8000","9600","12000","4000","7200");# Lista de tamaños de matriz (N). Cada N ejecutará N×N.
@Num_Hilos = (1,2,4,8,16,20); # Lista de números de hilos a usar con OpenMP en cada corrida.
$Repeticiones = 30;## Cantidad de repeticiones por combinación (tamaño, hilos) para obtener estadística.

# Doble bucle: recorre cada tamaño y cada #hilos
foreach $size (@Size_Matriz){
	foreach $hilo (@Num_Hilos) {

 		# Nombre del archivo de salida donde se acumulan (append) los tiempos,
        # un archivo por combinación N/hilos. Ej: mmClasicaOpenMP-340-Hilos-2.dat
		$file = "$Path/$Nombre_Ejecutable-".$size."-Hilos-".$hilo.".dat";

 # Ejecuta el programa $Repeticiones veces y agrega (>>) la salida al archivo.	
  for ($i=0; $i<$Repeticiones; $i++) {

  			 # Llama: /ruta/mmClasicaOpenMP <size> <hilos> >> archivo.dat
            # La salida del programa (tiempo en µs) se anexa al .dat
			system("$Path/$Nombre_Ejecutable $size $hilo  >> $file");
			printf("$Path/$Nombre_Ejecutable $size $hilo \n");
		}
  
        # Muestra en pantalla qué comando se ejecutó (progreso).
		close($file);
	$p=$p+1;
	}
}
