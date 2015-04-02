package services;

import AuthorityException.DataException;
import dao.PaymentDetailDao;
import entities.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 张超红 on 2015-04-01.小站收支服务层
 */
@Repository
public class PaymentDetailService {
    @Autowired
    private PaymentDetailDao paymentDetailMapper;

    /**
     * 加载所有的小站收支明细
     * @return
     */
    public List<PaymentDetail> findAllPaymentDetails(){
        return paymentDetailMapper.loadAllPaymentDetails();
    }

    /**
     * 添加一条小站收支明细
     * @param paymentDetail
     * @return
     */
    public Boolean CreatePaymentDetail(PaymentDetail paymentDetail){
        try{
            paymentDetailMapper.CreatePaymentDetail(paymentDetail);
        }
        catch (Exception ex){
            throw new DataException(ex.getMessage());
        }
        return true;
    }

    /**
     * 删除一条数据
     * @param detail_id
     */
    public void DeletePaymentDetail(Integer detail_id){
        paymentDetailMapper.DeletePaymentDetail(detail_id);
    }
}
