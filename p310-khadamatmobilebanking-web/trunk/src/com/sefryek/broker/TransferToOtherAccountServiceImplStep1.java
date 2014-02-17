package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.model.MessageBody;
import com.sefryek.broker.utils.MyConnection;
import com.sefryek.broker.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String servicType = bundle.getString("tn1");
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

        String params[]=request.split(" ");
            String accountCode=params[2];
            String accountTypeLetter = accountCode.substring(0,1);
            String accCode = accountCode.substring(1,2);
        String destAccount = params[3];
        String amount = params[4];
        String Field1=accountTypeLetter+PackNumeric.packNumeric2(accCode+destAccount+amount);
        String Field2=Constant.destinationAccHolderName;

        return "tn10tn1.a"+"|"+Field1+"|"+Field2+"|" ;
        } else return "tn11acc.incorrect|";
        }

    public String tr_2() {
        return "2";
    }

    public String tr_3() {
        return "3";
    }
}
