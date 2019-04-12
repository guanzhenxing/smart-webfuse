package cn.webfuse.cloud.uaa.resources.api.controller;

import cn.webfuse.cloud.uaa.resources.api.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/employee")
    public Optional<Employee> getEmployee(@RequestParam String email) {
        return employees.stream().filter(x -> x.getEmail().equals(email)).findAny();
    }

    @PostMapping(value = "/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMessage(@RequestBody Employee employee) {
        employees.add(employee);
    }
}
