import java.lang.Math.round

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)


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
    |    Employee Name:  ${getFullName()}        Employee ID:  ${employee.employeeId}               |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |                                                                          |
    |     PAYMENT DETAILS                   DEDUCTION DETAILS                  |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |     Salary: ${"%.2f".format(monthlySal())}                   PAYE: ${"%.2f".format(monthlyPAYE())}                      |
    |     Bonus:  ${"%.2f".format(employee.bonus/12)}                    PRSI: ${"%.2f".format(monthlyPRSI())}                       |
    |                                       Cycle To Work: ${"%.2f".format(employee.cycleWork)}               |
    |--------------------------------------------------------------------------|
    |     Gross: ${("%.2f".format(monthlyGross()))}                    Total Deductions: ${"%.2f".format(deductions())}          |
    |--------------------------------------------------------------------------|
    |                         NET PAY: ${"%.2f".format(netPay())}                                 |
    ----------------------------------------------------------------------------
    """

}

fun monthlySal()= employee.grossSal/12
fun monthlyPRSI() = monthlySal() * (employee.PRSI / 100)
fun monthlyPAYE() = monthlySal()*(employee.PAYE/100)
fun monthlyGross() = monthlySal()+(employee.bonus/12)
fun deductions() = (monthlySal()*(employee.PAYE/100))+(monthlySal() * (employee.PRSI / 100))+(employee.cycleWork)
fun netPay() = ((employee.grossSal/12)+(employee.bonus/12)) - ((monthlySal()*(employee.PAYE/100))+(monthlySal() * (employee.PRSI / 100))+(employee.cycleWork))




fun getFullName() = when(employee.Gender) {
    'm','M' -> "Mr. ${employee.firstname}  ${employee.surname}"
    'f','F' -> "Mrs. ${employee.firstname}  ${employee.surname}"
    else -> "${employee.firstname}  ${employee.surname}"
}


fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()


