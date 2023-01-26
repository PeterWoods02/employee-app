
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
    payslip()
}


fun payslip(){

    println(
        """
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
    |     Salary: ${"%.2f".format(grossSal/12)}                   PAYE: ${"%.2f".format(monthlySal()*(PAYE/100))}                      |
    |     Bonus:  ${"%.2f".format(bonus/12)}                    PRSI: ${"%.2f".format(monthlySal() * (PRSI / 100))}                       |
    |                                       Cycle To Work: ${"%.2f".format(cycleWork)}               |
    |--------------------------------------------------------------------------|
    |     Gross: ${("%.2f".format((grossSal/12)+(bonus/12)))}                    Total Deductions: ${"%.2f".format(deductions())}          |
    |--------------------------------------------------------------------------|
    |                         NET PAY: ${"%.2f".format(netPay())}                                 |
    ----------------------------------------------------------------------------
    """)



}

fun monthlySal()= grossSal/12
fun netPay() = ((grossSal/12)+(bonus/12)) - ((monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork))
fun deductions() = (monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork)

