package controller

import com.example.springbootemployeeservice.controller.EmployeeController
import com.example.springbootemployeeservice.domain.Employee
import com.example.springbootemployeeservice.repository.EmployeeRepository
import spock.lang.Specification

class EmployeeControllerTest extends Specification{

    EmployeeRepository repo = Mock()
    EmployeeController controller = new EmployeeController(repo)

    def "validate getAllEmployee method"() {
        given: "set data"
            def employeeList = Arrays.asList(new Employee(1, "something", "something", "something"));
            repo.findAll() >> employeeList
        when: "test method"
            def result = controller.getAllEmployee()
        then:"result"
            noExceptionThrown()
    }

    def "validate getEmployee method"() {
        given: "set data"
            def employee = new Employee(1, "something", "something", "something");
            Optional<Employee> optionalEmployee = Optional.of(employee)
            repo.findById(1) >> optionalEmployee
        when: "test method"
            def result = controller.getEmployee(1)
        then:"result"
            noExceptionThrown()
    }

    def "validate addEmployee method"() {
        given: "set data"
            def employee = new Employee(1, "something", "something", "something");
            repo.save(employee) >> _
        when: "test method"
            def result = controller.addEmployee(employee)
        then:"result"
            noExceptionThrown()
    }

    def "validate editEmployee method"() {
        given: "set data"
            def employee = new Employee(1, "something", "something", "something");
            repo.save(employee) >> _
        when: "test method"
            def result = controller.editEmployee(employee)
        then:"result"
            noExceptionThrown()
    }


    def "validate deleteEmployee method"() {
        given: "set data"
            def employee = new Employee(1, "something", "something", "something");
            repo.deleteById(1) >> _
        when: "test method"
            def result = controller.deleteEmployee(1)
        then:"result"
            noExceptionThrown()
    }
}
