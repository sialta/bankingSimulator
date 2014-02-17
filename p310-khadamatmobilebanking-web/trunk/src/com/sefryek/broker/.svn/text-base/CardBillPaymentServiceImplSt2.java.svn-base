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
public class CardBillPaymentServiceImplSt2 implements CardBillPaymentServiceSt2 {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String payBill(String serviceName, String request) {
        String servicType = bundle.getString("payBillWithCardSt2");
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
            String Field3= Constant.date+Constant.trace;
            String Field4= params[2];
            String Field5= params[3];
            String last4DigitsOfCard= params[1].substring((params[1].length()-4),params[1].length());
            String Field6= PackNumeric.packNumeric2(last4DigitsOfCard)+PackNumeric.packNumeric2(Constant.lastFourOfAccount);


            return "pg20a" + "|" +Field1+"|"+PackNumeric.packNumeric2(Field2)+"|"+PackNumeric.packNumeric2(Field3)+ "|" +
                    PackNumeric.packNumeric2(Field4)+ "|" +PackNumeric.packNumeric2(Field5)+"|"+Field6+"|";
    } else return "pg21acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
