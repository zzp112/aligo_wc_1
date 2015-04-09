package services.impl;

import AuthorityException.DataException;
import dao.PaymentDetailDao;
import entities.PaymentDetail;
import entities.PaymentDetailHelper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
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
    private SqlSessionTemplate sqlSession;


    //添加
    public void CreatePaymentDetail(PaymentDetail paymentDetail) {
        try {
            sqlSession.insert("paymentDetail.CreatePaymentDetail",paymentDetail);
        } catch (Exception ex) {
            throw new DataException(ex.getMessage());
        }
    }

    //删除
    public void DeletePaymentDetail(Integer detail_id) {
        try{
            sqlSession.delete("paymentDetail.DeletePaymentDetail",detail_id);
        }catch (Exception ex){
            throw new DataException(ex.getMessage());
        }
    }


    //查询所有
    public List<PaymentDetail> findAllPaymentDetails() {
        return sqlSession.selectList("paymentDetail.findAllPaymentDetails");
    }


    //更新
    @Override
    public boolean UpdatePaymentDetail(PaymentDetail paymentDetail) {
        try {
            sqlSession.update("paymentDetail.UpdatePaymentDetail",paymentDetail);
            return true;
        } catch (Exception exception) {
            //捕获并抛出异常
            throw new DataException(exception.getMessage());
        }
    }

    //按照id查询
    @Override
    public PaymentDetail findPaymentDetailById(Integer detail_id) {
        try {
            return sqlSession.selectOne("paymentDetail.findPaymentDetailById", detail_id);
        } catch (Exception ex) {
            throw new DataException(ex.getMessage());
        }
    }



    //多条件查询
    @Override
    public List<PaymentDetail> findPaymentDetailBySql(PaymentDetailHelper paymentDetailHelper) {
        try {
            return sqlSession.selectList("paymentDetail.findPaymentDetailBySql", paymentDetailHelper);
        } catch (Exception ex) {
            throw new DataException(ex.getMessage());
        }
    }

}
