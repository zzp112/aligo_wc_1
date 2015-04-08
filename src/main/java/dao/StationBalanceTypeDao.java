package dao;

import entities.StationBalanceDetailType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 张超红 on 2015-04-03.
 * 小站收支明细类型dao
 */
@Repository
public interface StationBalanceTypeDao {
    //增加一条收支明细类型
    static String CreateType="insert into stationPaymentDetailType(type_name)values(#{paymentTypeName})";
    //删除一条收支明细类型
    static String DeleteType="delete stationPaymentDetailType from stationPaymentDetailType where type_id=#{paymentTypeId}";
    //更新一条收支明细类型
    static String UpdateType="update stationPaymentDetailType set type_name=#{paymentTypeName} from stationPaymentDetailType where type_id=#{paymentTypeId}";
    //根据id返回收支明细类型的对象
    static String findTypeById="select type_id as paymentTypeId,type_name as paymentTypeName from stationPaymentDetailType where type_id=#{typeId}";
    //加载所有的收支明细类型
    static String listAllType="select type_id as paymentTypeId,type_name as paymentTypeName from stationPaymentDetailType";
    //根据name返回指定的收支明细类型的list集合
    static String findTypeByName="select type_id as paymentTypeId,type_name as paymentTypeName from stationPaymentDetailType where type_name=#{typeName}";
    @Insert(CreateType)
    public boolean CreateStationBalanceType(StationBalanceDetailType stationBalanceDetailType);


    @Delete(DeleteType)
    public boolean RemoveStationBalanceType(Integer typeId);


    @Update(UpdateType)
    public boolean UpdateStationBalanceType(StationBalanceDetailType stationBalanceDetailType);


    @Select(listAllType)
    public List<StationBalanceDetailType> listAllStationBalanceType();


    @Select(findTypeById)
    public StationBalanceDetailType findStationTypeById(Integer typeId);

    @Select(findTypeByName)
    public List<StationBalanceDetailType> listStationBalanceType(String typeName);
}
