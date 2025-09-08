package com.emsbackend.ems_backend.service;

import org.springframework.stereotype.Service;

import com.emsbackend.ems_backend.dto.EmployeeDto;
import com.emsbackend.ems_backend.entity.Employee;
import com.emsbackend.ems_backend.exception.ResourceNotFoundException;
import com.emsbackend.ems_backend.mapper.EmployeeMapper;
import com.emsbackend.ems_backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class  EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    // public List<EmployeeDto> getAllEmployees(){
    //     List<Employee> employees = employeeRepository.findAll();
    //     return employees.stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    // }

    public  EmployeeDto getEmployeeById(Long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
       return EmployeeMapper.toEmployeeDto(employee);
    }

    public void removeEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }


    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return EmployeeMapper.toEmployeeDto(employee);

    }
}
