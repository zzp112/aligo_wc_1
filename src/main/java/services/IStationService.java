package services;

import entities.Station;

import java.util.List;

/**
 * Created by Administrator on 2015/4/3 0003.
 */
public interface IStationService {
    /**
     * 查找所有小站
     * @return 小站列表
     */
    public List<Station> findAllStation();

    /**
     * 通过id查找小站
     * @param id 小站id
     * @return 小站
     */
    public Station findStationById(String id) ;

    /**
     * 删除小站
     * @param id 小站id
     * @return 小站
     */
    public boolean delStationById(String id) ;

    /**
     * 更新小站收入
     * @param id 小站id, total 小站收入
     * @return 是否成功
     */
    public boolean updateStationTotalById(String id, String total);

    /**
     * 更新小站所有信息
     * @param id 小站id
     * @param address 小站地址
     * @param managerId 负责人Id
     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
     * @param totalAmount 总收入
     * @return 是否成功
     */
    public boolean updateStationById(String id, String address, String managerId, String accountRatio, String totalAmount);

    /**
     * 添加小站
     * @param address 小站地址
     * @param managerId 负责人Id
     * @param accountRatio 拆账比例，格式：(0.x) 或 (0.xx)
     * @return 是否成功
     */
    public boolean addStation(String address, String managerId, String accountRatio);
}
