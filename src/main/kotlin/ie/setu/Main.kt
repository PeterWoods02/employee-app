import ie.setu.models.Employee

import ie.setu.controllers.EmployeeAPI
import mu.KotlinLogging

var employees = EmployeeAPI()

val logger = KotlinLogging.logger{}//importing logger
fun main(args: Array<String>) {
    logger.info { "Launching Employee App" }

    start()

}


//main menu
fun menu(): Int {
    print("""
      > ----------------------------------
      > | Employee Menu                  |
      > ----------------------------------
      > |  1. Add Employee               |
      > |  2. List All Employees         |
      > |  3. Search Employees           |
      > |  4. Print Payslip for Employee |
      > |  5. Delete an Employee         |
      > |  6. Update Taxes               |
      > |  7. Display in range (Salary)  |
      > ----------------------------------
      > | -1. Exit                       |
      > ----------------------------------
      > | Enter Option : 
      
      """.trimMargin())
    return readLine()!!.toInt()



}
//command for menu
fun start() {
    var input: Int

    do{
        input = menu()
        when(input){
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> delete()
            6 -> taxRates()
            7 -> salRange()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()

    }
    while(input != -1)
}

//list all employee details
fun list(){
    logger.info { "Listing All Employees Details" }
    employees.findAll()
        .forEach({ println(it)})

}

//search by ID
fun search() {
    logger.info { "Searching Through Employee App" }
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}

//input for search to get employee details
internal fun getEmployeeById(): Employee? {
    println("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

//generates payslip
fun paySlip(){
    logger.info { "Generating Payslip" }
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPaySlip())
}


//fake data to use to test with
fun dummyData() {
    logger.info { "Grabbing Dummy Data" }
    employees.create(Employee("Joe", "Soap", 'm', 1, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 2, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 3, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}

//round off
fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()

//add employee to arraylist
fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

//creates new employee
    employees.create(
        Employee(firstName,surname,gender,employeeID,grossSalary,
        payePercentage,prsiPercentage,annualBonus,cycleToWorkMonthlyDeduction)
    )
}

//deletes employee
fun delete(){
    // logger.info { "Select Employee ID" }
    println("Select Employee Id you wish to Delete")
    println("")
    employees.displayNames()//displays names and ids only
val employee = getEmployeeDelById()
    if (employee != null) {
        employees.remove(employee)
        println("${employee.firstname} ${employee.surname} of ID:${employee.employeeId} has been deleted")
    }
}

//gets employee by id for delete
internal fun getEmployeeDelById(): Employee? {
        val employeeID = readLine()!!.toInt()
        return employees.findOne(employeeID)
}


//menu for taxrates
internal fun taxRates(){
    print(""" 
        Would you like to Update PAYE or PRSI
        1. PAYE
        2. PRSI
        
    """.trimMargin())
    var PAYORPRS =0
    PAYORPRS = readLine()!!.toInt()


        do {
            when (PAYORPRS) {
                1 -> employees.PAYE()
                2 -> employees.PRSI()
                -1 -> start()
                else -> println("Invalid Option")
            }
            println()

            if (PAYORPRS == 1) {
                print(
                    """
                Updating PAYE
                ------------------------------
                Select Id of who you want to change their PAYE:
                
            """.trimIndent()
                )
                val employeeID = readLine()!!.toInt()
                //to exit
               if(employeeID == -1){
    start()
}
// >= so you can exit with -1
                if (employeeID >= 0) {
                    println("${employees.findOne(employeeID)} ")//gets info for one employee only
                    println("")
                    println("Enter Value of New PAYE %:")
                    val payePercentage = readLine()!!.toDouble()
                    employees.setPAYE(employeeID, payePercentage)//method created to set PAYE

                }
            }

            else if (PAYORPRS == 2) {
                print(
                    """
                Updating PRSI
                ------------------------------
                Select Id of who you want to change their PRSI:
                
            """.trimIndent()
                )
                val employeeID = readLine()!!.toInt()
                if(employeeID == -1){
                    start()
                }

                if (employeeID >= 0) {
                    println("${employees.findOne(employeeID)} ")
                    println("")
                    println("Enter Value of New PRSI %:")
                    val prsiPercentage = readLine()!!.toDouble()
                    employees.setPRSI(employeeID, prsiPercentage)

                }
            }
            else if(PAYORPRS == -1) {
               start()
            }
            else{
                println("Invalid Option")
                start()//run start when invalid so dosent spam invalid over
            }


        }
        while (PAYORPRS != -1)

    }

fun salRange(){
    // logger.info { "Select Employee ID" }
    println("Please enter the two values to search between")
    val salMin = readLine()!!.toDouble()
    val salMax = readLine()!!.toDouble()

    employees.salaryRanges(salMin,salMax)


        }
