package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++


}

class Employee(
    var firstName: String,var surname: String,var gender: CharArray,
    var employeeID: Int,var grossSalary: Double,
    var payePercentage: Double,var prsiPercentage: Double,
    var annualBonus: Double,var cycleToWorkMonthlyDeduction: Double)

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeId == id }
    }

    fun create(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }


    fun remove(employee: Employee) {

        employee.employeeId = getId()
        employees.remove(employee)
    }

    fun setPAYE(employeeID: Int,PAYE: Double){
        for(Employee in employees){
            if(Employee.employeeId == employeeID){
                Employee.PAYE = PAYE
            }
        }
    }

    fun displayNames() {
        var e =0
       while(e < employees.size) {
           print(
               """
            > -------------------------
            Employee Name: ${employees.get(e).firstname} ${employees.get(e).surname}
            Employee Id: ${employees.get(e).employeeId}
            > -------------------------
            
        """.trimIndent()

           )
           e++;
       }
}


    fun PAYE(){
        var e =0
        while(e < employees.size) {
            print(
                """
            Employee Name: ${employees.get(e).firstname} ${employees.get(e).surname} of ID:${employees.get(e).employeeId}
            PAYE: ${employees.get(e).PAYE}
            > -------------------------
            
        """.trimIndent()

            )
            e++;

        }
        println("Enter -1 to exit")
    }


    fun PRSI(){
        var e =0
        while(e < employees.size) {
            print(
                """
            > -------------------------
            Employee Name: ${employees.get(e).firstname} ${employees.get(e).surname} of ID:${employees.get(e).employeeId}
            PRSI: ${employees.get(e).PRSI}
            > -------------------------
            
        """.trimIndent()

            )
            e++;
        }

    }


}
