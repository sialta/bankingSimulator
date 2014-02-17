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
public class TransferFromAccToCardServiceImplStep1 implements TransferFromAccToCardServiceStep1 {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);
    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String transfer(String serviceName,String request) {
        String servicType = bundle.getString("trnAccCardst1");
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
        String accountTypeLetter = request.substring(4, 5);
        String accCode = request.substring(5, 6);

        String query = "SELECT * FROM test.tbl_account where code=? and acctype=?";
        String reqParams[] = request.split(" ");
        String destCardNum = reqParams[3];
        String Field1=accountTypeLetter+PackNumeric.packNumeric2(accCode)+PackNumeric.packNumeric2(Constant.destAccountNumber)+
                PackNumeric.packNumeric2(destCardNum)+PackNumeric.packNumeric2(Constant.date)+PackNumeric.packNumeric2(reqParams[4]);
        String Field2= "Sina Alizadeh";
            return "ct10tn1.a"+"|"+ Field1+"|"+Field2+"|";
        } else return "ct11acc.incorrect|";
        }

    public String tr_2() {
        return "2";
    }

    public String tr_3() {
        return "3";
    }
}
