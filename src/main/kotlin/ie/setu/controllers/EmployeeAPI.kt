package ie.setu.controllers

import ie.setu.models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

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

    fun displayNames() {
        employees.forEach() ->
    print("""
            Employee Name: ${employees.get(e).firstname} ${employees.get(e).surname}
            Employee Id: ${employees.get(e).employeeId
            }
        """.trimIndent())

}


}
