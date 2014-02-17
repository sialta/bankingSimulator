package com.sefryek.mbanking;

import com.sefryek.mbanking.model.Constant;
import com.sefryek.mbanking.utils.PackNumeric;
import com.sun.net.httpserver.HttpExchange;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddOnewayServiceImpl implements AddOnewayService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String addService(String serviceName, String request) {
        String servicType = bundle.getString("addService");
        if (servicType.equals("1")) {
            return addService_1(serviceName, request);
        } else if (servicType.equals("2")) {
            return addService_2();
        } else if (servicType.equals("3")) {
            return addService_3();
        }
        return "";
    }



    public String addService_1(String serviceName, String request) {

        if(Constant.OUTPUT.equals("SUCCESS")){
        String params[] = request.toString().split(" ");
        String srvType = params[1];
        String acc = params[2];
        String Field1="";

        if(srvType.equals("trn")){
            Field1="st.trn";
        }   else  if(srvType.equals("spl")){
            Field1="st.spl";
        } else  if(srvType.equals("max")){
            Field1="st.max";
        }
        String Filed3= "1392/01/01";
        String Field4 = PackNumeric.packNumeric("12345678912341");
        return "srv0srv.as" + "~"+Field1+"~"+acc+"~"+Filed3+"~|"+Field4+"|";
    }else return "srv1acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
