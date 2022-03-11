/**
 * CETis 108
 * Semestre: Febrero-Julio 2022
 * Grupo: 6AV-PR
 * Asignatura: Desarrollo de aplicaciones móviles
 * Profesor: Bidkar Aragón Cárdenas
 * Alumno(a): Cruz Cuevas Harold
 *
 * Fecha: 07/03/2022
 */
fun main() {
    /**
     * Boleta de calificaciones del 6AV-PR
     * Realiza un programa que registre las califiaciones y
     * asistencias parciales de n alumnos del grupo ?
     * Imprimir boleta de resultados de los 3 parciales
     * con el promedio de las califaciones, y el porcentaje
     * de asistencia con respecto al máximo de asistencia grupal,
     * incluyendo cada materia que cursó en el periodo.
     */
    imprimirTitulo("Boleta de calificaciones")
    // Crear el grupo
    val sextoVespertinoDeProgramacion =
        Grupo("6AV-PR", 'V', 6, "Programación")
    // Crear alumnos
    val angela = Alumno(
        "Angela Y.",
        "Espinoza Cota",
        "19325061080143",
        sextoVespertinoDeProgramacion
    )

    val paulina = Alumno(
        "Ana P.",
        "Graciano Wong",
        "19345778554144",
        sextoVespertinoDeProgramacion
    )

    val hector = Alumno(
        "Hector J.",
        "Moroyoqui Quiñonez",
        "195825425456552255",
        sextoVespertinoDeProgramacion
    )

    // Agregar alumnos al grupo
    sextoVespertinoDeProgramacion.alumnos.add(angela)
    sextoVespertinoDeProgramacion.alumnos.add(paulina)
    sextoVespertinoDeProgramacion.alumnos.add(hector)

    // Craer materias
    val android = Materia("Desarrolla aplicaciones Android", 96)
    val iOS = Materia("Desarrolla aplicaciones iOS", 96)

    // Crear calificaciones
    var cal1 = Calificacion(angela, android)
    var cal2 = Calificacion(angela, iOS)
    var cal3 = Calificacion(paulina, android)
    var cal4 = Calificacion(paulina, iOS)
    var cal5 = Calificacion(hector, android)
    var cal6 = Calificacion(hector, iOS)

    // Crear boletas
    val boletaAngela = Boleta(
        sextoVespertinoDeProgramacion,
        angela,
        "2022-03-07"
    )
    val boletaPaulina = Boleta(
        sextoVespertinoDeProgramacion,
        paulina,
        "2022-03-07"
    )

    val boletaHector = Boleta(
        sextoVespertinoDeProgramacion,
        hector,
        "2022-03-07"
    )

    // Agregar las calificaciones a cada alumno a su boleta
    boletaAngela.calificaciones.add(cal1)
    boletaAngela.calificaciones.add(cal2)
    boletaPaulina.calificaciones.add(cal3)
    boletaPaulina.calificaciones.add(cal4)
    boletaHector.calificaciones.add(cal5)
    boletaHector.calificaciones.add(cal6)

    // Registrar calificaciones y asistencias
    for(calificacion in boletaAngela.calificaciones){
        calificacion.simularCalificacionesYAsistencias()
    }
    for(calificacion in boletaPaulina.calificaciones){
        calificacion.simularCalificacionesYAsistencias()
    }
    for(calificacion in boletaHector.calificaciones){
        calificacion.simularCalificacionesYAsistencias()
    }

    boletaAngela.imprimir()
    boletaPaulina.imprimir()
    boletaHector.imprimir()
}

class Alumno(
    var nombre: String,
    var apellidos: String,
    var numeroDeControl: String,
    var grupo: Grupo){}

class Grupo(
    var nombre: String,
    var turno: Char,
    var semestre: Int,
    var carrera: String
) {
    var alumnos = ArrayList<Alumno>()
}

class Materia(
    var nombre: String,
    var horas: Int
){ }

class Boleta(
    var  grupo: Grupo,
    var  alumno: Alumno,
    var fecha: String,
) {
    var calificaciones= ArrayList<Calificacion>()

    fun imprimir(){
        imprimirTitulo("Boleta de ${alumno.nombre}")
        for (cal in calificaciones){
            println("Materia: ${cal.materia.nombre}")
            println("P1: ${cal.parcial1}  P2: ${cal.parcial2}  P3: ${cal.parcial3}")
            println("A1: ${cal.asistencias1}  A2: ${cal.asistencias2}  A3: ${cal.asistencias3}")
            println("-".repeat(60))

        }
    }
}

class Calificacion(
    var alumno: Alumno,
    var materia: Materia
) {
    var parcial1:Float? = null
    var parcial2:Float? = null
    var parcial3:Float? = null
    var asistencias1: Int? = null
    var asistencias2: Int? = null
    var asistencias3: Int? = null

    fun calcularPromedio(): Float{
        return (parcial1!! + parcial2!! + parcial3!!) / 3
    }

    fun simularCalificacionesYAsistencias(){
        parcial1 = (50..100).random().toFloat() / 10
        parcial2 = (50..100).random().toFloat() / 10
        parcial3 = (50..100).random().toFloat() / 10
        asistencias1 = (20..32).random()
        asistencias2 = (20..32).random()
        asistencias3 = (20..32).random()
    }
}

