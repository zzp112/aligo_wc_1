package services.impl;

import AuthorityException.DataException;
import dao.StationBalanceTypeDao;
import entities.StationBalanceDetailType;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import services.IStationBalanceTypeService;

import javax.xml.crypto.Data;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
@Repository
/**
 * Created by 张超红 on 2015-04-04.
 */
public class StationBalanceTypeService implements IStationBalanceTypeService{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public boolean CreateStationBalanceType(StationBalanceDetailType stationBalanceDetailType) {
        if(stationBalanceDetailType.getPaymentTypeName().equals("")){
            throw new DataException("小站收支明细类型名不能为空...");
        }
        try{
            sqlSessionTemplate.insert("stationBalanceType.CreateStationBalanceType",stationBalanceDetailType);
            return true;
        }catch (Exception ex){
            throw new DataException(ex.getMessage());
        }
    }

    @Override
    public boolean RemoveStationBalanceType(Integer type_id) {
        try{
            if(type_id.equals("")){
                throw  new DataException("类型id为空...报错...");
            }
            //删除成功
            sqlSessionTemplate.delete("stationBalanceType.RemoveStationBalanceType",type_id);
            return true;
        }catch (Exception ex){
            throw new DataException(ex.getMessage()+"删除失败!");
        }
    }

    @Override
    public boolean UpdateStationBalanceType(StationBalanceDetailType stationBalanceDetailType) {
        try{
            if(stationBalanceDetailType!=null){
                sqlSessionTemplate.update("stationBalanceType.UpdateStationBalanceType",stationBalanceDetailType);
                return true;
            }
            else{
                return false;
            }
        }catch (Exception ex){
            throw new DataException(ex.getMessage()+"修改失败!");
        }
    }

    @Override
    public List<StationBalanceDetailType> listAllStationBalanceType() {
        try{
            return sqlSessionTemplate.selectList("stationBalanceType.listAllStationBalanceType");
        }catch (Exception ex)
        {
            throw new DataException(ex.getMessage()+"加载失败!");
        }
    }

    @Override
    public StationBalanceDetailType findAllStationBalanceTypeById(Integer type_id) {
        try{
             return sqlSessionTemplate.selectOne("stationBalanceType.findAllStationBalanceTypeById",type_id);
        }catch (Exception ex){
             throw new DataException(ex.getMessage()+"加载数据失败!");
        }
    }

    @Override
    public List<StationBalanceDetailType> findAllStationBalanceTypeByName(String type_name) {
        try{
             return sqlSessionTemplate.selectList("stationBalanceType.findAllStationBalanceTypeByName",type_name);
        }catch (Exception ex){
            throw new DataException(ex.getMessage()+"查找数据失败!");
        }
    }
}
