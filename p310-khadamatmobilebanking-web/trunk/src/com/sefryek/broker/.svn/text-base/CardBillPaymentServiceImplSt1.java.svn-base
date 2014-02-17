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
public class CardBillPaymentServiceImplSt1 implements CardBillPaymentServiceSt1 {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String payBill(String serviceName, String request) {
        String servicType = bundle.getString("payBillWithCard");
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
            String Field1= "b"+Constant.billType;
            String Field2= Constant.billAmount;
            String Field3= params[1];
            String Field4= params[2];
            String Field5= params[3].split("\\|")[0];


            return "pg10bill.i" + "~" +Field1+"~"+Field2+"~|"+PackNumeric.packNumeric2(Field3)+ "|" +PackNumeric.packNumeric2(Field4)+ "|" +PackNumeric.packNumeric2(Field5)+"|";
    } else return "pg11acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
