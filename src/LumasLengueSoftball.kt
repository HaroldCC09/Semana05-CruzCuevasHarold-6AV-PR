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
var nombresDeEquipos = ArrayList<String>()
var resultados = ArrayList<Array<Int>>()
var numeroDeEquipos = 0

fun main() {
 /**
  * simular los resultado de temporada regular de una liga de sotbool
  * regional donde participan,7 equipos y la temporada costa de 2 vueltas
  */
 numeroDeEquipos = pedirEnteroPorTeclado("¿Cuantos equipos")
 for(equipo in 1..numeroDeEquipos){
  val mensaje = "¿Cual es el nombre del equipo $equipo"
  nombresDeEquipos.add(pedirCadenaPorTeclado(mensaje))
  resultados.add(arrayOf(0, 0, 0, equipo-1))
 }
 jugarVueltaDelRoLRegular()
 jugarVueltaDelRoLRegular()
 imprimirTablaDeResultados()
}

fun imprimirTablaDeResultados() {
 val ordenados = resultados.sortedBy { r -> r[1] }
 for (resultado in ordenados){
  val avg = resultado[1].toFloat()/resultado[0].toFloat()
  println("${nombresDeEquipos[resultado[3]]} " +
          "JJ: ${resultado[0]} " +
          "JG: ${resultado[1]} " +
          "JP: ${resultado[2]}" +
          "AVG: %.3f".format(avg))
 }
}

fun jugarVueltaDelRoLRegular() {
 for (eq1 in 1 until numeroDeEquipos) {
  for (eq2 in eq1 + 1..numeroDeEquipos) {
   //Ambos equipos registran un juego mas
   resultados[eq1 - 1][0]++
   resultados[eq2 - 1][0]++

   //Imprime el titular del juego
   print("${nombresDeEquipos[eq1 - 1]} vs ${nombresDeEquipos[eq2 - 1]} ")

   //Definir ganador y perdedor
   if ((1..2).random() == 1) {
    println("Ganador: ${nombresDeEquipos[eq1 - 1]}")
    resultados[eq1 - 1][1]++
    resultados[eq2 - 1][2]++
   } else {
    println("Ganador: ${nombresDeEquipos[eq2 - 1]}")
    resultados[eq2 - 1][1]++
    resultados[eq1 - 1][2]++
   }
  }
 }
}
