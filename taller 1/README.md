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



