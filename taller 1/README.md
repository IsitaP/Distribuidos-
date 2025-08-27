# **Explicacion del codigo mmClasicaOpenMP**
---
# ***Multiplicación de Matrices con OpenMP***

Proyecto en **C** que implementa la multiplicación clásica de matrices y la paraleliza usando **OpenMP** para aprovechar múltiples núcleos de procesamiento.

---

## **📌 Descripción**
El programa:
- Genera dos matrices `A` y `B` con números aleatorios.
- Calcula `C = A × B` con el algoritmo clásico.
- Paraleliza la multiplicación usando `OpenMP`.
- Mide el tiempo de ejecución en microsegundos.
- Imprime resultados (solo si la matriz es pequeña).

---

## **⚙️ Funciones principales**
- **`iniMatrix`** → Inicializa matrices con números aleatorios.  
- **`impMatrix`** → Imprime matrices pequeñas (N < 9).  
- **`multiMatrix`** → Realiza la multiplicación paralelizada.  
- **`InicioMuestra / FinMuestra`** → Cronómetro en microsegundos.  
- **`main`** → Controla todo el flujo del programa.  

---

## **🚀 Compilación **
Con `Makefile`:
```bash
make
```
## **🚀 ejecución **
Formato:
```bash
./clasicaOpenMP SIZE HILOS
```
Ejemplo:
```bash
./clasicaOpenMP 500 4
```
multiplica 2 matrices 500 *500 usando 4 hilos

## 🧪**Ejemplo de salida**

<img width="597" height="103" alt="image" src="https://github.com/user-attachments/assets/f442be80-b36f-49f4-a25b-3a7f12d0f164" />

representa el tiempo de ejecución en microsegundos para multiplicar dos matrices de 340 × 340 con 2 hilos.

# 📊 Script de Automatización de Ejecuciones (`lanzador.pl`)

Este script en **Perl** automatiza la ejecución del programa `mmClasicaOpenMP` en **múltiples tamaños de matrices** y con diferentes números de hilos.  
El objetivo es recolectar datos de rendimiento para analizarlos posteriormente (tiempos de ejecución).

---

## 📌 Descripción

- Recorre una lista de **tamaños de matriz** (ej: 340, 400, 4000…).  
- Para cada tamaño, prueba diferentes cantidades de **hilos OpenMP** (ej: 1, 2, 4, 8, 16, 20).  
- Cada combinación `(tamaño, hilos)` se repite **30 veces** (configurable).  
- La salida (tiempo de ejecución en microsegundos) se guarda en un archivo `.dat` separado.  
- Cada archivo tiene el formato:

<img width="654" height="21" alt="image" src="https://github.com/user-attachments/assets/1c480c53-da0d-4697-889d-b0e9c956a8d4" />

donde 640 es el tamaño y el 4 es la cantidad de hilos

# * Dentro el script se puede modificar*

Con `Ejecutable a probar`:
```perl
$Nombre_Ejecutable = "mmClasicaOpenMP";
```
Con `tamaño de matrices`:
```perl
@Size_Matriz = ("340","320","400","8000","9600","12000","4000","7200");
```
Con `numero de hilos`:
```perl
@Num_Hilos = (1,2,4,8,16,20);
```
Con `numero de repeticiones`:
```perl
$Repeticiones = 30;

```

## **🚀 ejecución **
1. `Compilacion `:
 ```bash
gcc -O2 -fopenmp mmClasicaOpenMP.c -o mmClasicaOpenMP

```
2. `dar permisos`:
 ```bash
chmod +x lanzador.pl

```
3. `ejecución del programa`:
 ```bash
./lanzador.pl

```

## **🚀 Archivos generados **
dependiendo la cantidad de hilos y el tamaño se crea un ejemplo unarchivo.`dat`.
1. `ejemplo`:
<img width="640" height="537" alt="image" src="https://github.com/user-attachments/assets/adf2b2c1-2187-4942-8c86-c310451dcefa" />

En estos archivos se encuentra 30 lineas una por cada repeticion, con el tiempo de ejecución en microsegunndos

## **Ejemplo generado en consola **
<img width="487" height="264" alt="image" src="https://github.com/user-attachments/assets/8ea0327f-bc20-4c6b-9a33-92df9a2fca46" />

# 📊 Análisis de Resultados con Python

Este módulo (`analisis.py`) permite procesar los archivos `.dat` generados por el **lanzador en Perl** (`lanzador.pl`).  
El objetivo es calcular el **promedio** y la **desviación estándar** de los tiempos de ejecución para cada combinación `(matriz, hilos)` y generar un archivo `.csv` que pueda abrirse en **Excel o Google Sheets**.

---

## 📌 Descripción del script

El script realiza los siguientes pasos:

1. **Busca** todos los archivos `.dat` en la carpeta de trabajo.  
2. **Lee** las 30 repeticiones de tiempo (en microsegundos) contenidas en cada archivo.  
3. **Calcula** el promedio y la desviación estándar usando `numpy`.  
4. **Extrae** del nombre del archivo el tamaño de la matriz y la cantidad de hilos (ejemplo: `mmClasicaOpenMP-340-Hilos-2.dat`).  
5. **Guarda** los resultados en un archivo `resultados.csv`, listo para abrir en Excel.  

---

## 🛠️ Dependencias

El script usa librerías estándar de Python más **numpy**:

```bash
pip install numpy
```
##  resultado
Se crea un archivo.csv donde estan todos los datos con su respectivo tamño de la matriz,hilos, promedio y desviacion estandar, como se ve a continuació
<img width="779" height="483" alt="image" src="https://github.com/user-attachments/assets/4bef79d8-40c0-4c6d-93e7-40f9d1e7d6e9" />
<img width="796" height="420" alt="image" src="https://github.com/user-attachments/assets/4d088ee1-c6da-4891-8199-444321b85031" />

Con los resultados obtenidos se puede analizar la **escalabilidad del algoritmo de multiplicación de matrices con OpenMP**, observando que para **matrices pequeñas** el uso de más hilos no aporta mejoras significativas e incluso puede generar sobrecarga, mientras que en **matrices grandes** el paralelismo reduce considerablemente el tiempo de ejecución, mostrando un crecimiento cúbico del costo computacional conforme aumenta el tamaño de la matriz. Además, el cálculo del **promedio y la desviación estándar** permite evaluar tanto el rendimiento típico como la estabilidad de las ejecuciones, evidenciando que el **speedup y la eficiencia** se incrementan con el número de hilos hasta cierto punto, a partir del cual la ganancia se estanca por limitaciones de memoria y sincronización.

