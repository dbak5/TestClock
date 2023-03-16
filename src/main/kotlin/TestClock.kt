import kotlin.system.exitProcess

/*
Name: DaHye Baker
ID: 30063368
Assessment 1: Activity 2
*/

fun main() {

    // Instantiate timer
    var timer = Clock()

    // Create a function for the menu, taking in a user input
    fun menuOptions() {
        println("\nThe current time ==> ${timer.hour} : ${timer.minute} : ${timer.second}\n")
        println("Enter 's' to set the time.\nEnter 'a' to advance one second.\nEnter 'r' to reset the clock.\nEnter 'q' to quit.\n")

        // Take user input and update timer accordingly
        // (s == set time, a == advance time, r == reset time or q == quit program)
        when (readln()) {
            "s" -> {
                timer = Clock().setTime()
                menuOptions()
            }
            "a" -> {
                timer = Clock().advance(timer.hour, timer.minute, timer.second)
                menuOptions()
            }
            "r" -> {
                timer = Clock().reset()
                menuOptions()
            }
            "q" -> exitProcess(0)
            else -> {
                println("\nInvalid input, please try again")
                menuOptions()
            }
        }
    }

    menuOptions()
}
