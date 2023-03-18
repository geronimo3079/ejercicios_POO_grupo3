import math

lado = float(input("Ingrese el valor del lado del triángulo equilátero: "))

perimetro = 3 * lado

altura = math.sqrt(3) * lado / 2

area = (math.sqrt(3) / 4) * lado ** 2
 
print("El perímetro del triángulo es:", perimetro)
print("La altura del triángulo es:", altura)
print("El área del triángulo es:", area)
