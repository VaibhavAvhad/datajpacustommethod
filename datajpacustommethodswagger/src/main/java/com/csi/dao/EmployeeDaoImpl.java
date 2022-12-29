package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee saveData(Employee employee){
        return  employeeRepo.save(employee);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeRepo.findById(empId);
    }

    public List<Employee>getDataByName(String empName){
        return employeeRepo.findByEmpName(empName);
    }

    public Employee getDataByContactNo(long empContactNo){
        return employeeRepo.findByEmpContactNo(empContactNo);
    }

    public List<Employee>getDataByAddress(String empAddress){
        return  employeeRepo.findByEmpAddress(empAddress);
    }

    public  List<Employee>getAllData(){
        return employeeRepo.findAll();
    }

    public Employee updateData(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteDataById(int empId){
        employeeRepo.deleteById(empId);
    }

    public void  deleteAllData(){
        employeeRepo.deleteAll();
    }

}
