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
public class CellphoneChargeWithBankAccountServiceImpl implements CellphoneChargeWithBankAccountService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);


    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String charge(String serviceName, String request) {
        String servicType = bundle.getString("chargeWithAcc");
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
            String simType=reqParams[2];
            String chargeAmount=reqParams[3];
            String chargeCode="";
            if(chargeAmount.equals("100000"))
                chargeCode="0";
            else if (chargeAmount.equals("200000"))
                chargeCode="1";
            else if (chargeAmount.equals("400000"))
                chargeCode="2";
            else if (chargeAmount.equals("20000"))
                chargeCode="3";
            else if (chargeAmount.equals("50000"))
                chargeCode="4";
            else if (chargeAmount.equals("10000"))
                chargeCode="5";
            else if (chargeAmount.equals("500000"))
                chargeCode="6";



        return "sca0scc.a" + "|"+simType+chargeCode+
                PackNumeric.packNumeric(Constant.date+Constant.trace)+PackNumeric.packNumeric2(Constant.chargeSerialNo+Constant.chargePin)+"|";
    } else return "sca1acc.incorrect|";
    }

    public String addService_2() {
        return "2";
    }

    public String addService_3() {
        return "3";
    }


}
