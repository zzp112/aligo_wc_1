package services.employee.impl;


import dao.employee.EmployeeBaseInfoDao;
import entities.employee.EmployeeBaseInfo;
import entities.employee.EmployeeSalaryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IEmployeeBaseInfoService;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class EmployeeBaseInfoServiceImpl implements IEmployeeBaseInfoService {

    @Autowired
    private EmployeeBaseInfoDao employeeBaseInfoDao;

    @Override
    public List<EmployeeBaseInfo> findAllEmployeeBaseInfo() {

        return employeeBaseInfoDao.findAllEmployeeBaseInfo();

    }

    @Override
    public EmployeeBaseInfo findEmployeeBaseInfoById(Integer employeeId) {

        return employeeBaseInfoDao.findEmployeeBaseInfoById(employeeId);

    }

    @Override
    public void addEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo) {

        employeeBaseInfoDao.addEmployeeBaseInfo(employeeBaseInfo);

    }

    @Override
    public void updateEmployeeBaseInfo(EmployeeBaseInfo employeeBaseInfo) {

        employeeBaseInfoDao.updateEmployeeBaseInfo(employeeBaseInfo);

    }

    @Override
    public List<EmployeeSalaryStructure> findemployeesalary() {
        return employeeBaseInfoDao.findemployeesalary();
    }

    @Override
    public List<EmployeeSalaryStructure> findemployeesalaryById(Integer employeeId) {
        return employeeBaseInfoDao.findemployeesalaryById(employeeId);
    }
}
