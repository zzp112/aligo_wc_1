package services.impl;

import AuthorityException.DataException;
import dao.PaymentDetailDao;
import entities.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.IPaymentDetailService;

import javax.xml.soap.DetailEntry;
import java.util.List;

/**
 * Created by 张超红 on 2015-04-01.小站收支服务层
 */
@Service
@Transactional
public class PaymentDetailService implements IPaymentDetailService {
    @Autowired
    private PaymentDetailDao paymentDetailMapper;

    //添加
    public void CreatePaymentDetail(PaymentDetail paymentDetail) {
        try {
            paymentDetailMapper.CreatePaymentDetail(paymentDetail);
        } catch (Exception ex) {
            throw new DataException(ex.getMessage());
        }
    }

    //删除
    public void DeletePaymentDetail(Integer detail_id) {
        paymentDetailMapper.DeletePaymentDetail(detail_id);
    }


    //查询所有
    public List<PaymentDetail> findAllPaymentDetails() {
        return paymentDetailMapper.loadAllPaymentDetails();
    }


    //更新
    @Override
    public boolean UpdatePaymentDetail(PaymentDetail paymentDetail) {
        try {
            paymentDetailMapper.UpdatePayment(paymentDetail);
            return true;
        } catch (Exception exception) {
            //捕获并抛出异常
            throw new DataException(exception.getMessage());
        }
    }

    @Override
    public PaymentDetail findPaymentDetailById(Integer detail_id) {
        try {
            return paymentDetailMapper.findPaymentDetailById(detail_id);
        } catch (Exception ex) {
            throw new DataException(ex.getMessage());
        }
    }

    /**
     * 三个不同参数的查询
     */
    public List<PaymentDetail> search(String balance) {
        return paymentDetailMapper.search(balance);
    }

    public List<PaymentDetail> searchByTime(String begin_time, String end_time) {
        return paymentDetailMapper.searchByTime(begin_time, end_time);
    }

    public List<PaymentDetail> searchByAll(String balance, String begin_time, String end_time) {
        return paymentDetailMapper.searchByAll(balance, begin_time, end_time);
    }

}
