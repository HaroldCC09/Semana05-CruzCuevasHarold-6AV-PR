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
    println("Arrays en kotlin")
    //declarar un array o motriz de tipo String con 3 elementos
    //para almacenar nombres propios
    var nombres = Array<String>(3){ "" }
    //inicializar la matriz on valores tipo String
    nombres [0] = "nombre1"
    nombres [1] = "nombre2"
    nombres [2] = "nombre3"
    // nombres [3] = "nombre4" ArrayIndexOutOfBoundsException

    //acceder a un elemento en particular
    println("El primer elemento de la matriz de nombres es ${nombres[0]}")

    //reorer todos los elementos de la matriz
    for (nombre in nombres){
        println(nombre)
    }
}