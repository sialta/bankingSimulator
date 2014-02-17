package com.sefryek.mbanking;

import com.sefryek.mbanking.model.Constant;
import com.sefryek.mbanking.model.MessageBody;
import com.sefryek.mbanking.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransferToOtherAccountServiceImplStep1 implements TransferToOtherAccountServiceStep1 {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);
    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String transfer(String serviceName,String request) {
        String servicType = bundle.getString("transferToOtherSt1");
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
        String accountType = "";
        if (accountTypeLetter.equals("j")) {
            accountType = "01";
        } else if (accountTypeLetter.equals("k")) {
            accountType = "02";
        } else if (accountTypeLetter.equals("p")) {
            accountType = "03";
        }
        String accCode = request.substring(10, 11);
        String params[] = request.toString().split(" ");
        String destAcc = params[3];
        String amount = params[4];
           String Field1=accountTypeLetter+accCode+PackNumeric.packNumeric2(destAcc+amount);
           String Field2=Constant.destinationAccHolderName;
        return "tn10"+ MessageBody.transferOtherAccSt1+"|"+Field1+"|"+Field2+"|";
        } else return "tn11acc.incorrect|";
        }

    public String tr_2() {
        return "2";
    }

    public String tr_3() {
        return "3";
    }
}
