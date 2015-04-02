package services;

import dao.StationDao;
import entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/4/2 0002.
 */
@Service
@Transactional
public class StationService {
    @Autowired
    private StationDao stationDao;
    public List<Station> findAllStation() {
        return stationDao.findAllStation();
    }
}
