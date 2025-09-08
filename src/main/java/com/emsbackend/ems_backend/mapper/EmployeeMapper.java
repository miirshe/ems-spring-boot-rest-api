package com.emsbackend.ems_backend.mapper;
import com.emsbackend.ems_backend.dto.EmployeeDto;
import com.emsbackend.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
    }
    
}
