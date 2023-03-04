horas_semanales=48
razon_hora=5000
porcentaje_retencion=0.125
salario_bruto=razon_hora*horas_semanales*4
retencion_fuente=int(razon_hora*horas_semanales*4*0.125)
salario_neto=salario_bruto-retencion_fuente
print("El salario bruto de un mes es:", salario_bruto)
print("La retencion de fuente es:", retencion_fuente)
print("El salario neto es:", salario_neto)