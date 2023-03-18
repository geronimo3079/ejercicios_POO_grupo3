ventas1 = float(input("Ingrese las ventas del departamento 1: "))
salario1 = float(input("Ingrese el salario de los vendedores del departamento 1: "))
ventas2 = float(input("Ingrese las ventas del departamento 2: "))
salario2 = float(input("Ingrese el salario de los vendedores del departamento 2: "))
ventas3 = float(input("Ingrese las ventas del departamento 3: "))
salario3 = float(input("Ingrese el salario de los vendedores del departamento 3: "))

venta_total = ventas1 + ventas2 + ventas3

venta_33 = venta_total * 0.33

if ventas1 > venta_33:
    salario1 *= 1.2
if ventas2 > venta_33:
    salario2 *= 1.2
if ventas3 > venta_33:
    salario3 *= 1.2

print("El salario final de los vendedores del departamento 1 es:", salario1)
print("El salario final de los vendedores del departamento 2 es:", salario2)
print("El salario final de los vendedores del departamento 3 es:", salario3)
