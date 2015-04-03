package services.impl;

import AuthorityException.DataException;
import dao.PaymentDetailDao;
import entities.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import services.IPaymentDetailService;

import java.util.List;

/**
 * Created by 张超红 on 2015-04-01.小站收支服务层
 */
@Repository
public class PaymentDetailService implements IPaymentDetailService{
    @Autowired
    private PaymentDetailDao paymentDetailMapper;

    public List<PaymentDetail> findAllPaymentDetails(){
        return paymentDetailMapper.loadAllPaymentDetails();
    }

    public void CreatePaymentDetail(PaymentDetail paymentDetail){
        try{
            paymentDetailMapper.CreatePaymentDetail(paymentDetail);
        }
        catch (Exception ex){
            throw new DataException(ex.getMessage());
        }
    }

    public void DeletePaymentDetail(Integer detail_id){
        paymentDetailMapper.DeletePaymentDetail(detail_id);
    }
}
