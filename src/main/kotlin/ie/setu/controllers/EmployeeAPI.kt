/*
Author Peter Woods
Date 12/02/23
Description: Employee API
 */

package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++


}


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
            Employee Name: ${employees[e].firstname} ${employees[e].surname}
            Employee Id: ${employees[e].employeeId}
            > -------------------------
            
        """.trimIndent()

            )
            e++
        }
    }

    //just name and paye so doesn't show unneeded info
    fun PAYE() {
        var e = 0
        while (e < employees.size) {
            print(
                """
            Employee Name: ${employees[e].firstname} ${employees[e].surname} of ID:${employees[e].employeeId}
            PAYE: ${employees[e].PAYE}
            > -------------------------
            
        """.trimIndent()

            )
            e++

        }
        println("Enter -1 to exit")
    }


    fun PRSI() {
        var e = 0
        while (e < employees.size) {
            print(
                """
            Employee Name: ${employees[e].firstname} ${employees[e].surname} of ID:${employees[e].employeeId}
            PAYE: ${employees[e].PRSI}
            > -------------------------
            
        """.trimIndent()

            )
            e++

        }
        println("Enter -1 to exit")
    }

    fun salaryRanges(minSal: Double,maxSal: Double){
        var e = 0
        while (e < employees.size) {
            if(employees[e].grossSal in minSal..maxSal){//range checker
                print("""
                    ${employees[e]}
            
                """.trimIndent())
            }
            e++
        }

    }


}



