package services.employee;


import entities.employee.DockPay;

/**
 * 险金服务类
 * Created by cmj on 2015/4/6.
 */
public interface IDockPayService {

    /**
     * 根据员工号获得缺勤扣薪记录
     * @param employeeId
     * @return
     */
    public DockPay findDockPayById(Integer employeeId, Integer year, Integer month);

    /**
     * 添加缺勤扣薪记录
     * @param dockPay
     */
    public void addDockPay(DockPay dockPay);

    /**
     * 更新缺勤扣薪记录
     * @param dockPay
     */
    public void updateDockPay(DockPay dockPay);
}
