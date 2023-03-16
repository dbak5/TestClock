class Clock() {

    //region Min/max variables
    private var minTimer = 0
    private var maxTimerHour = 23
    private var maxTimerMinSec = 59

    //endregion

    //region Set default parameters and initialise
    var hour = 0
    var minute = 0
    var second = 0

    init{
        hour
        minute
        second
    }
    //endregion

    // Secondary constructor
    constructor(hour: Int, minute: Int, second: Int) : this() {
        this.hour = hour
        this.minute = minute
        this.second = second
    }

    //region Functions
    // Reset the timer, returns zero for all values
    fun reset(): Clock {
        return Clock(0,0,0)
    }

    // Advance the timer by one second, returns new hour, minute and second values
    fun advance(hour: Int, minute: Int, second: Int): Clock {
        // If second == 59, increment minute by 1, set second to zero
        if (second == maxTimerMinSec) {
            this.minute = minute + 1
            this.second = minTimer
            // If minute == 59, increment hour by 1, set minute to zero
            if (minute == maxTimerMinSec){
                this.hour = hour + 1
                this.minute = minTimer
                // If hour == 23, set hour to zero
                if (hour == maxTimerHour){
                    this.hour = minTimer
                }
            }
        }
        // Else increment second by 1
        else {
            this.hour = hour
            this.minute = minute
            this.second = second + 1
        }
        return Clock(this.hour, this.minute, this.second)
    }

    // Set the hour, minute and second on the timer
    fun setTime(): Clock {
        println("Now you can set the clock")

        // Set hour taking user input
        // Error trapping to catch if value is not within range 0-23
        fun setHour() {
            println("Enter hour ($minTimer ~ $maxTimerHour)")
            this.hour = readln().toInt()
            while (this.hour < minTimer || this.hour > maxTimerHour){
                println("Error, must be an integer between $minTimer and $maxTimerHour")
                setHour()
            }
        }

        // Set minute taking user input
        // Error trapping to catch if value is not within range 0-59
        fun setMinute() {
            println("Enter minute ($minTimer ~ $maxTimerMinSec)")
            this.minute = readln().toInt()
            while (this.minute < minTimer || this.minute > maxTimerMinSec){
                println("Error, must be an integer between $minTimer and $maxTimerMinSec")
                setMinute()
            }
        }

        // Set minute taking user input
        // Error trapping to catch if value is not within range 0-59
        fun setSecond() {
            println("Enter second ($minTimer ~ $maxTimerMinSec)")
            this.second = readln().toInt()
            while (this.second < minTimer || this.second > maxTimerMinSec){
                println("Error, must be an integer between $minTimer and $maxTimerMinSec")
                setSecond()
            }
        }

        setHour()
        setMinute()
        setSecond()

        return Clock(this.hour, this.minute, this.second)
    }
    //endregion
}