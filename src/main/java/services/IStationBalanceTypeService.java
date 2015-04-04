package services;

import entities.StationBalanceDetailType;

import java.util.List;

/**
 * Created by 张超红 on 2015-04-03.
 * 小站收支明细类型服务层
 */
public interface IStationBalanceTypeService {
    /**
     * 添加一条小站收支明细类型
     * @return
     */
    public boolean CreateStationBalanceType(StationBalanceDetailType stationBalanceDetailType);

    /**
     * 删除一条小站收支明细类型
     * @return
     */
    public boolean RemoveStationBalanceType(Integer type_id);

    /**
     * 修改选中的小站收支明细类型
     * @return
     */
    public boolean UpdateStationBalanceType(StationBalanceDetailType stationBalanceDetailType);

    /**
     * 加载所有的小站收支明细类型
     * @return
     */
    public List<StationBalanceDetailType> listAllStationBalanceType();

    /**
     * 根据id查找到指定的小站收支明细类型
     * @return
     */
    public StationBalanceDetailType findAllStationBalanceTypeById(Integer type_id);

    /**
     *根据名字查找到系列的小站收支明细类型
     */
    public List<StationBalanceDetailType> findAllStationBalanceTypeByName(String type_name);

}
