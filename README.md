# 🧑‍🎓 Alumnos

- **Coria, Agustín Ariel** – [soyagustincoria@gmail.com](mailto:soyagustincoria@gmail.com)  
- **Saffarano, Tomás** – [tomassaffarano1@gmail.com](mailto:tomassaffarano1@gmail.com)


# 🏭 Trabajo Práctico: Optimización de Producción en una Fábrica de Autopartes

## 📘 Descripción general

En una fábrica de autopartes se dispone de un conjunto de máquinas, cada una capaz de producir una cantidad fija de piezas por puesta en funcionamiento. Una vez iniciada, **una máquina no puede detenerse hasta completar su producción**.

Por razones de ahorro energético, **solo una máquina puede funcionar a la vez**, pero **no existen restricciones respecto a reutilizar una misma máquina varias veces**.

---

## 🎯 Objetivo

Desarrollar una aplicación que permita, a partir de un conjunto de máquinas y una cantidad objetivo de piezas a producir, **determinar una secuencia de puestas en funcionamiento que minimice la cantidad total de activaciones**.

---

## 🧩 Ejemplo

Dadas las siguientes máquinas:

M1 → 7 piezas
M2 → 3 piezas
M3 → 4 piezas
M4 → 1 pieza

Y una necesidad de producir **12 piezas**, algunas soluciones posibles son:

- `[M1, M3, M4]`  
- `[M3, M3, M3]`  

Ambas producen exactamente 12 piezas, pero la primera opción requiere menos puestas en funcionamiento.

---

## 🧾 Formato del archivo de entrada

El archivo de entrada debe respetar el siguiente formato:

<ObjetivoTotalDePiezas> <NombreMaquina1>,<CantidadPiezas1> <NombreMaquina2>,<CantidadPiezas2> ... <NombreMaquinaN>,<CantidadPiezasN>

12
M1,7
M2,3
M3,4
M4,1

🛠 Técnicas de resolución
La aplicación debe implementar dos estrategias de resolución:

🔍 Backtracking
Explora todas las posibles combinaciones de máquinas para alcanzar exactamente la cantidad requerida.

Tiene en cuenta podas y condiciones de corte para mejorar eficiencia.

⚡ Greedy (voraz)
Selecciona en cada paso la máquina que produce la mayor cantidad de piezas sin exceder el total restante.

No garantiza la solución óptima, pero es más eficiente computacionalmente.

📊 Formato de resultados
La salida del programa debe mostrar, para cada estrategia:

Backtracking
✅ Secuencia de máquinas obtenida.

⚙️ Total de piezas producidas.

🔁 Cantidad de puestas en funcionamiento.

📈 Costo de ejecución (estados generados).

Greedy
✅ Secuencia de máquinas obtenida.

⚙️ Total de piezas producidas.

🔁 Cantidad de puestas en funcionamiento.

📈 Costo de ejecución (candidatos cons


## 🧠 Explicación de las estrategias

### 🔍 Backtracking

El objetivo es encontrar la **secuencia más corta** de máquinas cuya producción total sea exactamente igual a la cantidad de piezas requeridas.

- En cada llamada recursiva se genera un nuevo estado agregando una máquina a la secuencia actual.
- Se exploran todas las combinaciones posibles.
- Una secuencia es considerada **solución válida** si la suma de sus producciones es exactamente igual al objetivo.
- Se guarda únicamente la **secuencia válida más corta** encontrada.
- Se aplican **podas** para mejorar la eficiencia:
  - Si la secuencia actual ya supera en longitud a la mejor solución conocida, se descarta.
  - Si la suma de piezas supera la cantidad requerida, también se descarta.
- Se contabiliza la **cantidad de estados generados** mediante una variable `cantEstadosGenerados`.

---

### ⚡ Greedy

El objetivo es también encontrar una secuencia de máquinas que produzca exactamente la cantidad de piezas necesarias, pero usando una estrategia más directa y eficiente.

- Primero, se ordena la lista de máquinas de **mayor a menor** según la cantidad de piezas que producen.
- En cada paso se elige la máquina **más grande posible que no exceda la cantidad restante a producir**.
- Si una máquina excede la cantidad restante, se descarta.
- El proceso se repite hasta alcanzar exactamente el total de piezas requeridas o hasta que no queden más opciones válidas.
- Si no se logra completar exactamente la cantidad requerida con las máquinas disponibles, se concluye que **no existe solución posible**.
- Se registra la **cantidad de candidatos considerados** en `cantCandidatosConsiderados`.
 


