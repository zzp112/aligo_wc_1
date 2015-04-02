package filter;

import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by yiyong_sy on 2015/3/12.
 */
public class AutoSetUserAdapterFilter implements Filter{

    @Override
    public void destroy() {

    }


    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
                    throws IOException,ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //_const_cas_assertion_是CAS中存放登录用户名的session标志
        Object object = httpRequest.getSession().getAttribute("_const_cas_assertion");
        if(object!=null){
            Assertion assertion = (Assertion) object;
            String loginName= assertion.getPrincipal().getName();
            System.out.println("登录名为："+loginName);
            //接下来在本业务系统中根据用户名获取用户对象，判断session中是否存在，
            //如果不存在，则获取用户对象保存到session中，否则直接获取用户对象。
        }
        chain.doFilter(request,response);

        }

    public void init(FilterConfig filterConfig)throws ServletException{

    }



}
