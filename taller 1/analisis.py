import numpy as np
import glob
import re
import csv

# Buscar todos los archivos .dat en la carpeta actual
archivos = glob.glob("*.dat")

resultados = []

for archivo in archivos:
    with open(archivo) as f:
        datos = [int(line.strip()) for line in f if line.strip()]

    # Calcular estadísticos
    promedio = np.mean(datos)
    desviacion = np.std(datos)

    # Extraer tamaño y hilos del nombre del archivo con regex
    match = re.search(r'(\d+)-Hilos-(\d+)', archivo)
    if match:
        size = int(match.group(1))
        hilos = int(match.group(2))
    else:
        size, hilos = None, None

    resultados.append([archivo, size, hilos, promedio, desviacion])

# Guardar resultados en CSV
with open("resultados.csv", "w", newline="") as f:
    writer = csv.writer(f, delimiter=';')
    writer.writerow(["Archivo", "Matriz", "Hilos", "Promedio (µs)", "Desviación Estándar (µs)"])
    writer.writerows(resultados)

print("Análisis completado. Resultados guardados en 'resultados.csv'")
