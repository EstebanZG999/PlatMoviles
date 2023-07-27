/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Esteban Zambrano 22119
 * Lab 2
 */


import kotlin.random.Random

fun calcularPromedio(numbers: List<Int>): Double {
    return numbers.reduce { acc, num -> acc + num }.toDouble() / numbers.size
}

fun isPalindrome(input: String): Boolean {
    return input == input.reversed()
}

fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

fun mapPersonToStudent(person: Person): Student {
    val studentId = Random.nextInt(1, 200).toString()
    return Student(person.name, person.age, person.gender, studentId)
}

fun imprimirEstudiante(student: Student) {
    println("El Estudiante ${student.name} tiene ${student.age} años con id de ${student.studentId}")
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val promedio = calcularPromedio(numbers)
    println(promedio)

    val oddNumbers = numbers.filter { it % 2 != 0 }
    println("Números impares: $oddNumbers")

    val palabra = "racecar"
    val palabra2 = "huevo"

    println("$palabra es una palabra palindrome: ${isPalindrome(palabra)}")
    println("$palabra2 es una palabra palindrome: ${isPalindrome(palabra2)}")

    val names = listOf("JUANPABLO", "KOU", "EL UWU")
    val greetings = names.map { "¡Hola, $it!" }
    println("Saludos: $greetings")

    val sum = performOperation(5, 3) { a, b -> a + b }
    println("Suma: $sum")

    val persons = listOf(
        Person("JuanPablo", 20, "M"),
        Person("Josue", 22, "M")
    )

    val students = persons.map(::mapPersonToStudent)
    students.forEach(::imprimirEstudiante)
}
