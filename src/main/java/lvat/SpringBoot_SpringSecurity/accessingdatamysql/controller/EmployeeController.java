package lvat.SpringBoot_SpringSecurity.accessingdatamysql.controller;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.projection.employee.EmployeeFullProjection;
import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.projection.employee.EmployeeProjection;
import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.projection.employee.EmployeeProjection01;
import lvat.SpringBoot_SpringSecurity.accessingdatamysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final static int SIZE = 20;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/by-employee-number", method = RequestMethod.GET)
    public EmployeeProjection getCustomersById(@RequestParam(value = "employee-number", defaultValue = "1002") Long employeeNumber, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return employeeService.findByEmployeeNumber(employeeNumber, EmployeeProjection01.class);
    }

    @RequestMapping(path = "/fn_ln", method = RequestMethod.GET)
    public List<EmployeeFullProjection> getByFirstNameContainingAndLastNameContaining(@RequestParam(value = "first-name", defaultValue = "ma") String firstName,
                                                                                      @RequestParam(value = "last-name", defaultValue = "pat") String lastName,
                                                                                      @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return employeeService.findByFirstNameContainingOrLastNameContaining(firstName, lastName, EmployeeFullProjection.class, page);
    }
}
