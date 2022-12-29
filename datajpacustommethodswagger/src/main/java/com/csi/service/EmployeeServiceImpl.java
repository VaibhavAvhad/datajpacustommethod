package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDao;

    public Employee saveData(Employee employee){
        return  employeeDao.saveData(employee);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDao.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName){
        return employeeDao.getDataByName(empName);
    }

    public Employee getDataByContactNo(long empContactNo){
        return employeeDao.getDataByContactNo(empContactNo);
    }

    public List<Employee>getDataByAddress(String empAddress){
        return employeeDao.getDataByAddress(empAddress);
    }

    public  List<Employee>getAllData(){
        return employeeDao.getAllData();
    }

    public Employee updateData(Employee employee){
        return employeeDao.updateData(employee);
    }

    public void deleteDataById(int empId){
        employeeDao.deleteDataById(empId);
    }

    public void  deleteAllData(){
        employeeDao.deleteAllData();
    }
}
