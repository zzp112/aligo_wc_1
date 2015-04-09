package services.employee;


import entities.employee.Premium;

/**
 * Created by cmj on 2015/4/6.
 */
public interface IPremiumService {

    /**
     * 根据员工号查找险金记录
     * @param employeeId
     * @return
     */
    public Premium findPremiumDaoById(Integer employeeId, Integer year, Integer month);

    /**
     * 添加险金记录
     * @param premium
     */
    public void addPremium(Premium premium);

    /**
     * 更新险金记录
     * @param premium
     */
    public void updatePremium(Premium premium);
}
