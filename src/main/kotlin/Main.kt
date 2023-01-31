import java.lang.Math.round

val firstname = "Joe"
val surname = "Soap"
val Gender = "m"
val employeeId = 6143
val grossSal = 67543.21
val PAYE = 38.5
val PRSI = 5.2
val bonus = 1450.50
val cycleWork = 54.33



fun main(args: Array<String>) {

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary ${roundTwoDecimals(monthlySal())}")
            2 -> println("Monthly PRSI: ${roundTwoDecimals(monthlyPRSI())}")
            3 -> println("Monthly PAYE: ${roundTwoDecimals(monthlyPAYE())}")
            4 -> println("Monthly Gross Pay: ${roundTwoDecimals(monthlyGross())}")
            5 -> println("Monthly Total Deductions: ${roundTwoDecimals(deductions())}")
            6 -> println("Monthly Net Pay: ${roundTwoDecimals(netPay())}")
            7 -> println(getPaySlip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}



fun menu(): Int {
    print("""
        Employee Menu for $(getFullName()}
          1. Monthly Salary
          2. Monthly PRSI
          3. Monthly PAYE
          4. Monthly Gross Pay
          5. Monthly Total Deductions
          6. Monthly Net Pay
          7. Full Payslip
          -1. Exit Menu
          Enter option :  """)
    return readLine()!!.toInt()
}

fun getPaySlip(): String {

      return  """
          ${getFullName()}
    ----------------------------------------------------------------------------
    |                          Monthly Payslip                                 |
    |--------------------------------------------------------------------------|
    |                                                                          |
    |    Employee Name:  ${firstname.uppercase()} ${surname.uppercase()} (${Gender.uppercase()})        Employee ID:  $employeeId                |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |                                                                          |
    |     PAYMENT DETAILS                   DEDUCTION DETAILS                  |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |     Salary: ${"%.2f".format(monthlySal())}                   PAYE: ${"%.2f".format(monthlyPAYE())}                      |
    |     Bonus:  ${"%.2f".format(bonus/12)}                    PRSI: ${"%.2f".format(monthlyPRSI())}                       |
    |                                       Cycle To Work: ${"%.2f".format(cycleWork)}               |
    |--------------------------------------------------------------------------|
    |     Gross: ${("%.2f".format(monthlyGross()))}                    Total Deductions: ${"%.2f".format(deductions())}          |
    |--------------------------------------------------------------------------|
    |                         NET PAY: ${"%.2f".format(netPay())}                                 |
    ----------------------------------------------------------------------------
    """

}

fun monthlySal()= grossSal/12
fun monthlyPRSI() = monthlySal() * (PRSI / 100)
fun monthlyPAYE() = monthlySal()*(PAYE/100)
fun monthlyGross() = monthlySal()+(bonus/12)
fun deductions() = (monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork)
fun netPay() = ((grossSal/12)+(bonus/12)) - ((monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork))




fun getFullName() = when(Gender){
        "m" -> "Mr. $firstname $surname"
        "f" -> "Mrs. $firstname $surname"
        else -> "$firstname $surname"}


fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()