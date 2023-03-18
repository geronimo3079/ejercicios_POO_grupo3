nombre = input("Ingrese el nombre del trabajador: ")
horas_trabajadas = int(input("Ingrese las horas trabajadas en la semana: "))
valor_hora = float(input("Ingrese el valor recibido por una hora normal de trabajo: "))

if horas_trabajadas <= 40:
    salario = horas_trabajadas * valor_hora
else:
    horas_normales = 40 * valor_hora
    horas_extras = (horas_trabajadas - 40) * valor_hora * 2
    if horas_trabajadas > 48:
        horas_extras_triples = (horas_trabajadas - 48) * valor_hora * 3
        salario = horas_normales + horas_extras + horas_extras_triples
    else:
        salario = horas_normales + horas_extras

print("El salario semanal de", nombre, "es:", salario)
