// Información de cabecera del código
/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Esteban Zambrano 22119
 * Lab 2
 */

// Importación del paquete que contiene la función para generar números aleatorios
import kotlin.random.Random

// Función que calcula el promedio de una lista de números enteros
fun calcularPromedio(numbers: List<Int>): Double {
    // Se suman todos los números y se dividen por la cantidad de números para obtener el promedio
    return numbers.reduce { acc, num -> acc + num }.toDouble() / numbers.size
}

// Función que determina si una cadena es un palíndromo
fun isPalindrome(input: String): Boolean {
    // Compara la cadena con su versión invertida para determinar si es palíndromo
    return input == input.reversed()
}

// Función que realiza una operación específica entre dos números enteros
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Definición de una clase que representa a una persona
data class Person(val name: String, val age: Int, val gender: String)
// Definición de una clase que representa a un estudiante (con un ID de estudiante)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

// Función que convierte un objeto Person en un objeto Student generando un ID de estudiante aleatorio
fun mapPersonToStudent(person: Person): Student {
    val studentId = Random.nextInt(1, 200).toString()
    return Student(person.name, person.age, person.gender, studentId)
}

// Función que imprime la información de un estudiante en la consola
fun imprimirEstudiante(student: Student) {
    println("El Estudiante ${student.name} tiene ${student.age} años con id de ${student.studentId}")
}

// Función principal del programa
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // Calcula y muestra el promedio de la lista de números
    val promedio = calcularPromedio(numbers)
    println(promedio)

    // Filtra y muestra los números impares de la lista
    val oddNumbers = numbers.filter { it % 2 != 0 }
    println("Números impares: $oddNumbers")

    // Comprueba y muestra si las palabras son palíndromos
    val palabra = "racecar"
    val palabra2 = "huevo"
    println("$palabra es una palabra palindrome: ${isPalindrome(palabra)}")
    println("$palabra2 es una palabra palindrome: ${isPalindrome(palabra2)}")

    // Saluda a cada nombre en la lista usando map
    val names = listOf("JUANPABLO", "KOU", "EL UWU")
    val greetings = names.map { "¡Hola, $it!" }
    println("Saludos: $greetings")

    // Realiza y muestra la suma de dos números utilizando la función performOperation
    val sum = performOperation(5, 3) { a, b -> a + b }
    println("Suma: $sum")

    // Convierte y muestra una lista de personas en una lista de estudiantes
    val persons = listOf(
            Person("JuanPablo", 20, "M"),
            Person("Josue", 22, "M")
    )
    val students = persons.map(::mapPersonToStudent)
    students.forEach(::imprimirEstudiante)
}

