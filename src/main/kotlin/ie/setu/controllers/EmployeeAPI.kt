package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++


}

//so i can access individualy like gender
class Employee(
    var firstName: String,var surname: String,var gender: CharArray,
    var employeeID: Int,var grossSalary: Double,
    var payePercentage: Double,var prsiPercentage: Double,
    var annualBonus: Double,var cycleToWorkMonthlyDeduction: Double)

class EmployeeAPI {
    //creates arraylist
    private val employees = ArrayList<Employee>()

    //list all
    fun findAll(): List<Employee> {
        return employees
    }

    //use employee id passed in main to get single employee
    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeId == id }
    }

    //creating
    fun create(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }

    //gets id and removes employee object
    fun remove(employee: Employee) {

        employee.employeeId = getId()
        employees.remove(employee)
    }

    //returns size of array
    fun size(): Int {
        return employees.size.toInt()
    }

    //takes in ID and paye and for that id sets new PAYE (USER INPUT)
    fun setPAYE(employeeID: Int, PAYE: Double) {
        for (Employee in employees) {
            if (Employee.employeeId == employeeID) {
                Employee.PAYE = PAYE
            }
        }
    }

    fun setPRSI(employeeID: Int, PRSI: Double) {
        for (Employee in employees) {
            if (Employee.employeeId == employeeID) {
                Employee.PRSI = PRSI
            }
        }
    }

    //for deleting so dont see all info
    fun displayNames() {
        var e = 0
        while (e < employees.size) {
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

    //just name and paye so dosent show unneeded info
    fun PAYE() {
        var e = 0
        while (e < employees.size) {
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


    fun PRSI() {
        var e = 0
        while (e < employees.size) {
            print(
                """
            Employee Name: ${employees.get(e).firstname} ${employees.get(e).surname} of ID:${employees.get(e).employeeId}
            PAYE: ${employees.get(e).PRSI}
            > -------------------------
            
        """.trimIndent()

            )
            e++;

        }
        println("Enter -1 to exit")
    }

    fun salaryRanges(minSal: Double,maxSal: Double){
        var e = 0
        while (e < employees.size) {
            if(employees.get(e).grossSal >= minSal && employees.get(e).grossSal <= maxSal){
                print("""
                    ${employees.get(e)}
            
                """.trimIndent())
            }
            e++
        }

    }


}



