peso_a = float(input("Ingrese el peso de la esfera A: "))
peso_b = float(input("Ingrese el peso de la esfera B: "))
peso_c = float(input("Ingrese el peso de la esfera C: "))
peso_d = float(input("Ingrese el peso de la esfera D: "))

if peso_a == peso_b == peso_c != peso_d:
    esfera_diferente = "d"
elif peso_a == peso_b == peso_d != peso_c:
    esfera_diferente = "c"
elif peso_a == peso_c == peso_d != peso_b:
    esfera_diferente = "b"
elif peso_b == peso_c == peso_d != peso_a:
    esfera_diferente = "a"
else:
    print("Error: los pesos ingresados no cumplen con las condiciones del problema.")
    exit()

peso_promedio = (peso_a + peso_b + peso_c + peso_d - eval("peso_" + esfera_diferente)) / 3
if eval("peso_" + esfera_diferente) > peso_promedio:
    print(f"La esfera {esfera_diferente} es de mayor peso.")
else:
    print(f"La esfera {esfera_diferente} es de menor peso.")
