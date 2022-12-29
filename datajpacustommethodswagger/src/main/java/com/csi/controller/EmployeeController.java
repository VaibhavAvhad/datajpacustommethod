package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee>saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return  ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getdatabyname/{empName}")
    public  ResponseEntity<List<Employee>>getDataByName(@PathVariable String empName){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabycontactno/empContactNo")
    public  ResponseEntity<Employee>getDataByContactNo(@PathVariable long empContactNo){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByContactNo(empContactNo));
    }

    @GetMapping("/getdatabyaddress/{}empAddress")
    public  ResponseEntity<List<Employee>>getDataByAddress(@PathVariable String empAddress){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByAddress(empAddress));
    }

    @GetMapping("/getalldata")
    public  ResponseEntity<List<Employee>>getAllData(){
        return  ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")
    public  ResponseEntity<Employee>updateData(@PathVariable int empId, @RequestBody Employee employee){
       Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee not Found"));
       employee1.setEmpName(employee.getEmpName());
       employee1.setEmpAddress(employee.getEmpAddress());
       employee1.setEmpDob(employee.getEmpDob());
       employee1.setEmpSallary(employee.getEmpSallary());
       employee1.setEmpContactNo(employee.getEmpContactNo());
       return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public  ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data deleted by ID successfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("Data deleted successfully");
    }


}
