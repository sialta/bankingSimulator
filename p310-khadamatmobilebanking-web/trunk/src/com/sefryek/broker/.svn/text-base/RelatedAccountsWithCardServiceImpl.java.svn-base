package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class RelatedAccountsWithCardServiceImpl implements RelatedAccountsWithCardService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getAccounts(String serviceName, String request) {
        String servicType = bundle.getString("getRelatedAccounts");
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
        String reqParams[]=request.split(" ");
            String cardNumber4digs = reqParams[1].substring(12,16);




        return "cal0a" + "|"+cardNumber4digs+"|"+PackNumeric.packNumeric2(Constant.relatedAcc1)+"|"
                +PackNumeric.packNumeric2(Constant.relatedAcc2)+"|"+PackNumeric.packNumeric2(Constant.relatedAcc3)+"|";
    } else return "cal1card.invalid|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
