/**
 * CETis 108
 * Semestre: Febrero-Julio 2022
 * Grupo: 6AV-PR
 * Asignatura: Desarrollo de aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): Cruz Cuevas Harold
 *
 * Fecha: 24/02/2022
 */
fun pedirCadenaPorTeclado(mensaje: String): String{
 while (true)
 {
  println(mensaje)
  val cadena = readLine()
  if (cadena != "") {
   return cadena!!
  }
 }
}

fun pedirEnteroPorTeclado(mensaje: String): Int{
 while (true){
  try{
   println(mensaje)
   return readLine()!!.toInt()
  }catch (ex: NumberFormatException){
   println("Error el valor debe ser número entero")
  }
 }
}

fun pedirFloatPorTeclado(mensaje: String): Float{
 while (true){
  try{
   println(mensaje)
   return readLine()!!.toFloat()
  }catch (ex: NumberFormatException){
   println("Error el valor debe ser número float")
  }
 }
}
fun imprimirTitulo(titulo: String){
 println("-".repeat(60))
 val margenIzquierdo = (60- titulo.length) / 2
 println("-".repeat(margenIzquierdo) + titulo.uppercase())
 println("-".repeat(60))

}


