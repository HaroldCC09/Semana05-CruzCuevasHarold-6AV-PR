/**
 * CETis 108
 * Semestre: Febrero-Julio 2022
 * Grupo: 6AV-PR
 * Asignatura: Desarrollo de aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): Cruz Cuevas Harold
 *
 * Fecha: 28/02/2022
 */
fun main() {
 /**
  * Definir un arreglo de n componentes de tipo float que representan
  * las alturas de 5 personas. Obtener el promedio de las mismas.
  * contar cuantas personas son mas altas que el promedio ycuantas mas bajas.
  */
 println("Altura de personas")
 var alturas = Array<Float>(5){ 0.0f }
 var promedioDeAltura = 0.0f
 var sumaDeAlturas = 0.0f
 var mayoresAlPromedio = 0
 var menoresAlPromedio = 0
 for (persona in 0..4){
  val msg = "¿Cual es la altura de la persona ${persona+1}?"
  alturas[persona] = pedirFloatPorTeclado(msg)
  sumaDeAlturas += alturas[persona]
 }
 promedioDeAltura = sumaDeAlturas/5


 for (altura in alturas){
  if (altura > promedioDeAltura)
   mayoresAlPromedio++
  else if (altura < promedioDeAltura)
   menoresAlPromedio++
 }
 println("El promedio de altura de las personas es $promedioDeAltura")
 println("$mayoresAlPromedio son mayores que el promedio de altura")
 println("$menoresAlPromedio son mayores que el promedio de altura")
}

