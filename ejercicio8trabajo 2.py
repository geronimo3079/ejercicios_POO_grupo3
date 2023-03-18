valor_compra = float(input("Ingrese el valor total de la compra: "))

color_bolita = input("Ingrese el color de la bolita que sacó (blanca, verde, amarilla, azul o roja): ")

if color_bolita == "verde":
    descuento = 0.1
elif color_bolita == "amarilla":
    descuento = 0.25
elif color_bolita == "azul":
    descuento = 0.5
elif color_bolita == "roja":
    descuento = 1.0
else:
    descuento = 0

valor_final = valor_compra * (1 - descuento)

print("El valor final de la compra es: $" + str(valor_final))
