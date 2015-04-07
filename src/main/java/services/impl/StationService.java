package services.impl;

import dao.StationDao;
import entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IStationService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/2 0002.
 */
@Service
@Transactional
public class StationService implements IStationService{
    @Autowired
    private StationDao stationDao;

    public List<Station> findAllStation() {
        return stationDao.findAllStation();
    }

    public Station findStationById(String id){
        return stationDao.findStationById(id);
    }

    public boolean delStationById(String id){
        if(id == null)
            return false;

        Station station = stationDao.findStationById(id);
        if(station == null)
            return false;
        stationDao.delStationById(id);
        return true;
    }

    public boolean updateStationTotalById(String id, String total){
        if(id == null || total == null )
            return false;

        Station result = stationDao.findStationById(id);

        if(result == null)
            return false;

        Integer totalAccount = Integer.parseInt(total);
        float ratio = result.getAccountRatio();
        int actual = (int)(totalAccount * ratio);

        String actualStringValue = total+"*"+(int)(ratio*100)+"%="+actual;

        result.setTotalAmount(totalAccount);
        result.setActualAmountString(actualStringValue);
        result.setActualAmount(actual);

        stationDao.updateStation(result);
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

        Station result = stationDao.findStationById(id);
        if(result == null)
            return false;

        Integer totalAccount = Integer.parseInt(totalAmount);
        float ratio = Float.parseFloat(accountRatio);
        int actual = (int)(totalAccount * ratio);
        String actualStringValue = totalAmount+"*"+(int)(ratio*100)+"%="+actual;

        Station station = new Station();
        station.setId(Integer.parseInt(id));
        station.setManagerId(Integer.parseInt(managerId));
        station.setAddress(address);
        station.setTotalAmount(totalAccount);
        station.setActualAmount(actual);
        station.setActualAmountString(actualStringValue);
        station.setAccountRatio(ratio);

        stationDao.updateStation(station);

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

        stationDao.addStation(station);

        return true;
    }
}
