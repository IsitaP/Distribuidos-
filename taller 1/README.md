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

# *** Dentro el script se puede modificar***

Con `Ejecutable a probar`:
```perl
$Nombre_Ejecutable = "mmClasicaOpenMP";
```

