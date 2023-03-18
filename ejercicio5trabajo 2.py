num_inscripcion = input("Ingrese el número de inscripción del estudiante: ")
nombres = input("Ingrese los nombres del estudiante: ")
patrimonio = float(input("Ingrese el patrimonio del estudiante en pesos: "))
estrato_social = int(input("Ingrese el estrato social del estudiante: "))

valor_matricula = 50000  # valor constante de la matrícula

if patrimonio > 2000000 and estrato_social > 3:
    valor_matricula += patrimonio * 0.03

print("Número de inscripción:", num_inscripcion)
print("Nombres:", nombres)
print("Valor de la matrícula: $", valor_matricula)
