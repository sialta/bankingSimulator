package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.utils.PackNumeric;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ChargesInPeriodServiceImpl implements ChargesInPeriodService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getCharges(String serviceName, String request) {
        String servicType = bundle.getString("chargeInPeriod");
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
        if (Constant.OUTPUT.equals("SUCCESS")) {
            String first[] = Constant.chargePurchased1.split(" ");
            String firstChargeType=first[0];
            String firstAmount=first[1];
            String firstDate=first[2];
            String firstTrace=first[3];
            String firstChargeSerial=first[4];
            String firstChargePin=first[5];
            String Field1=firstChargeType+firstAmount+PackNumeric.packNumeric(firstDate+firstTrace)+
                    PackNumeric.packNumeric2(firstChargeType+firstChargePin);

            String second[] = Constant.chargePurchased2.split(" ");
            String secondChargeType=first[0];
            String secondAmount=first[1];
            String secondDate=first[2];
            String secondTrace=first[3];
            String secondChargeSerial=first[4];
            String secondChargePin=first[5];
            String Field2=secondChargeType+secondAmount+PackNumeric.packNumeric(secondDate+secondTrace)+
                    PackNumeric.packNumeric2(secondChargeType+secondChargePin);

            String third[] = Constant.chargePurchased3.split(" ");
            String thirdChargeType=first[0];
            String thirdAmount=first[1];
            String thirdDate=first[2];
            String thirdTrace=first[3];
            String thirdChargeSerial=first[4];
            String thirdChargePin=first[5];
            String Field3=thirdChargeType+thirdAmount+PackNumeric.packNumeric(thirdDate+thirdTrace)+
                    PackNumeric.packNumeric2(thirdChargeType+thirdChargePin);


            return "scd0a" + "|"+Field1+"|"+Field2+"|"+Field3+"|";
        } else return "scd1acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
