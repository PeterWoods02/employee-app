/*
Author Peter Woods
Date 12/02/23
Description: Employee storing info on attributes and payslip
 */


package ie.setu.models


class Employee (var firstname: String, var surname: String, var Gender : Char, var employeeId : Int,
                var grossSal: Double, var PAYE: Double, var PRSI: Double,
                var bonus: Double, var cycleWork: Double){



    fun getFullName() = when(Gender) {
        'm','M' -> "Mr. $firstname  $surname"
        'f','F' -> "Mrs. $firstname  $surname"
        else -> "$firstname  $surname"
    }
    fun monthlySal()= grossSal/12
    fun monthlyPRSI() = monthlySal() * (PRSI / 100)
    fun monthlyPAYE() = monthlySal()*(PAYE/100)
    fun monthlyGross() = monthlySal()+(bonus/12)
    fun deductions() = (monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork)
    fun netPay() = ((grossSal/12)+(bonus/12)) - ((monthlySal()*(PAYE/100))+(monthlySal() * (PRSI / 100))+(cycleWork))





    fun getPaySlip(): String {

        return  """
          ${getFullName()}
    ----------------------------------------------------------------------------
    |                          Monthly Payslip                                 |
    |--------------------------------------------------------------------------|
    |                                                                          |
    |    Employee Name:  ${getFullName()}        Employee ID:  ${employeeId}               |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |                                                                          |
    |     PAYMENT DETAILS                   DEDUCTION DETAILS                  |
    |                                                                          |
    |--------------------------------------------------------------------------|
    |     Salary: ${"%.2f".format(monthlySal())}                   PAYE: ${"%.2f".format(monthlyPAYE())}                      |
    |     Bonus:  ${"%.2f".format(bonus/12)}                    PRSI: ${"%.2f".format(monthlyPRSI())}                       |
    |                                       Cycle To Work: ${"%.2f".format(cycleWork)}                |
    |--------------------------------------------------------------------------|
    |     Gross: ${("%.2f".format(monthlyGross()))}                    Total Deductions: ${"%.2f".format(deductions())}          |
    |--------------------------------------------------------------------------|
    |                         NET PAY: ${"%.2f".format(netPay())}                                 |
    ----------------------------------------------------------------------------
    """

    }

    override fun toString(): String {
        return "Employee(firstname='$firstname', surname='$surname', Gender=$Gender, employeeId=$employeeId, grossSal=$grossSal, PAYE=$PAYE, PRSI=$PRSI, bonus=$bonus, cycleWork=$cycleWork)"
    }

}





