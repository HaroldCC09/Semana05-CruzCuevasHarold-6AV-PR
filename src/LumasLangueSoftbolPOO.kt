/**
 * CETis 108
 * Semestre: Febrero-Julio 2022
 * Grupo: 6AV-PR
 * Asignatura: Desarrollo de aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): Cruz Cuevas Harold
 *
 * Fecha: 04/03/2022
 */
fun main() {
    val liga = Liga("Liga del alumno")
    liga.inicializarTemporada()
    liga.simularTemporadaRegular()
    liga.imprimirTablaDeResultados()
}

class Liga {
    var nombre: String = ""
    var equipos = ArrayList<Equipo>()

    constructor(nombre: String){
        this.nombre = nombre
    }
    fun inicializarTemporada() {
        val numeroDeEquipos = pedirEnteroPorTeclado("¿Cuantos equipos")
        for(equipo in 1..numeroDeEquipos){
            val mensaje = "¿Cual es el nombre del equipo $equipo"
            this.equipos.add(
                Equipo(pedirCadenaPorTeclado(mensaje))
            )
        }
    }
    fun simularTemporadaRegular() {
        for (c in 0..this.equipos.size-1) {
            for (v in c + 1.. this.equipos.size-1) {
                //Ambos equipos registran un juego mas
                this.equipos[c].juegosJugados++
                this.equipos[v].juegosJugados++

                //Imprime el titular del juego
                print("${equipos[c].nombre} vs ${equipos[v].nombre}")

                //Definir ganador y perdedor
                if ((1..2).random() == 1) {
                    println("Ganador: ${equipos[c].nombre}")
                    equipos[c].juegosGanados++
                    equipos[v].juegosPerdidos++
                } else {
                    println("Ganador: ${equipos[v].nombre}")
                    equipos[v].juegosGanados++
                    equipos[c].juegosPerdidos++
                }
            }
        }
    }
    fun imprimirTablaDeResultados() {
        equipos.sortByDescending { r -> r.calcularAvg() }
        for (equipo in equipos){
            println("${equipo.nombre} " +
                    "JJ: ${equipo.juegosJugados} " +
                    "JG: ${equipo.juegosGanados} " +
                    "JP: ${equipo.juegosPerdidos}" +
                    "AVG: %.3f".format(equipo.calcularAvg()))
        }
    }
}
class Equipo {
    var nombre = ""
    var juegosJugados = 0
    var juegosGanados = 0
    var juegosPerdidos = 0

    constructor(nombre: String) {
        this.nombre = nombre
    }
    fun calcularAvg(): Float {
        return juegosGanados.toFloat()/juegosJugados.toFloat()
    }

}

