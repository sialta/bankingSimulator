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
public class TransferFromAccToCardServiceImplStep2 implements TransferFromAccToCardServiceStep2 {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);
    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String transfer(String serviceName,String request) {
        String servicType = bundle.getString("trnAccCardst2");
        if(servicType.equals("1")){
            return tr_1(serviceName,request);
        }else if(servicType.equals("2")){
            return tr_2();
        }else if(servicType.equals("3")){
            return tr_3();
        }
        return "";
    }

    public String tr_1(String serviceName,String request) {

        if(Constant.OUTPUT.equals("SUCCESS"))  {
        String accountTypeLetter = request.substring(9, 10);
        String accCode = request.substring(10, 11);

        String reqParams[] = request.split(" ");
            String destAccNum = PackNumeric.packNumeric2(reqParams[3]);
            String destCardNum =PackNumeric.packNumeric2( reqParams[4]);
            String amount = PackNumeric.packNumeric2(reqParams[5]);
            String date = PackNumeric.packNumeric2(Constant.date);
            String trace= PackNumeric.packNumeric2(Constant.trace);

        String Field1= destAccNum+destCardNum+date+trace+amount;
        String Field2= Constant.TxnSign+PackNumeric.packNumeric2(Constant.availableBal);
            return "ct20a"+"|"+ Field1+"|"+Field2+"|";
        } else return "ct21acc.incorrect|";
        }

    public String tr_2() {
        return "2";
    }

    public String tr_3() {
        return "3";
    }
}
