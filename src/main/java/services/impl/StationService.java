package services.impl;

import entities.Station;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IStationService;

import java.util.List;

/**
 * Created by Administrator on 2015/4/2 0002.
 */
@Service
@Transactional
public class StationService implements IStationService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<Station> findAllStation() {return sqlSession.selectList("station.findAllStation");}

    public Station findStationById(String id){ return sqlSession.selectOne("station.findStationById", id);}

    public boolean delStationById(String id){
        if(id == null)
            return false;

        Station station = this.findStationById(id);
        if(station == null)
            return false;

        sqlSession.delete("station.delStationById", id);
        return true;
    }

    public boolean updateStationTotalById(String id, String total){
        if(id == null || total == null )
            return false;

        Station result = this.findStationById(id);

        if(result == null)
            return false;

        Integer totalAccount = Integer.parseInt(total);
        float ratio = result.getAccountRatio();
        int actual = (int)(totalAccount * ratio);

        String actualStringValue = total+"*"+(int)(ratio*100)+"%="+actual;

        result.setTotalAmount(totalAccount);
        result.setActualAmountString(actualStringValue);
        result.setActualAmount(actual);

        sqlSession.update("station.updateStationTotalById", result);
        return true;
    }


    public boolean updateStationById(String id,String address,String managerId,String accountRatio,String totalAmount){
        if(id == null)
            return false;
        if(address == null)
            return false;
        if(managerId == null)
            return false;
        if(accountRatio == null)
            return false;
        if(totalAmount == null)
            return false;

        Station result = this.findStationById(id);
        if(result == null)
            return false;

        Integer totalAccount = Integer.parseInt(totalAmount);
        float ratio = Float.parseFloat(accountRatio);
        int actual = (int)(totalAccount * ratio);
        String actualStringValue = totalAmount+"*"+(int)(ratio*100)+"%="+actual;

        result.setManagerId(Integer.parseInt(managerId));
        result.setAddress(address);
        result.setTotalAmount(totalAccount);
        result.setActualAmount(actual);
        result.setActualAmountString(actualStringValue);
        result.setAccountRatio(ratio);

        sqlSession.update("station.updateStationTotalById", result);

        return true;
    }

    public boolean addStation(String address,String managerId,String accountRatio){
        if(address == null || managerId == null || accountRatio == null)
            return false;

        Station station = new Station();

        Float ratio = Float.parseFloat(accountRatio);

        station.setAddress(address);
        station.setManagerId(Integer.parseInt(managerId));
        station.setAccountRatio(ratio);
        station.setActualAmount(0);
        station.setTotalAmount(0);
        station.setActualAmountString("0*"+(int)(ratio*100)+"%=0");

        sqlSession.insert("station.addStation", station);

        return true;
    }
}
