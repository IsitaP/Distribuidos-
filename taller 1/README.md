# **Multiplicación de Matrices con OpenMP**

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
` ``` `
---




