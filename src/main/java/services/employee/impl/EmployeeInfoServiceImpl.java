package services.employee.impl;

import dao.employee.EmployeeInfoDao;
import entities.employee.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.employee.IEmployeeInfoService;

import java.util.List;

/**
 * Created by cmj on 2015/4/6.
 */
@Service
@Transactional
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {

    @Autowired
    private EmployeeInfoDao employeeInfoDao;

    @Override
    public List<EmployeeInfo> findAllEmployeeInfo() {

        return employeeInfoDao.findAllEmployeeInfo();

    }

    @Override
    public EmployeeInfo findEmployeeInfoById(Integer employeeId) {

        return employeeInfoDao.findEmployeeInfoById(employeeId);

    }

    @Override
    public void addEmployeeInfo(EmployeeInfo employeeInfo) {

        employeeInfoDao.addEmployeeInfo(employeeInfo);

    }

    @Override
    public void updateEmployeeInfo(EmployeeInfo employeeInfo) {

        employeeInfoDao.updateEmployeeInfo(employeeInfo);

    }

    @Override
    public List<Integer> finEmployeeId() {
        return employeeInfoDao.finEmployeeId();
    }
}
