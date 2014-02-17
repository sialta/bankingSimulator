package com.sefryek.broker;

import com.sefryek.broker.AddAccountService;
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
public class CardBalanceServiceImpl implements CardBalanceService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getBalance(String serviceName, String request) {
        String servicType = bundle.getString("getCardBalance");
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
            String params[]=request.split(" ");
            String Field1= params[1].substring(0,4)+Constant.date+Constant.time+Constant.bankPin;
            String Field2= Constant.availableBalSign+ PackNumeric.packNumeric2(Constant.effectiveBalance);
            String Field3= Constant.availableBalSign+ PackNumeric.packNumeric2(Constant.availableBal);

            return "blc0a" + "|" +PackNumeric.packNumeric2(Field1)+"|"+Field2+"|"+Field3+"|";
    } else return "blc1acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
