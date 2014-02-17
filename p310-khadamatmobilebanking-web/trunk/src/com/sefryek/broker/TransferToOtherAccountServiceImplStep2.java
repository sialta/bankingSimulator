package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
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
public class TransferToOtherAccountServiceImplStep2 implements TransferToOtherAccountServiceStep2 {
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
            String accountType = "";
            if (accountTypeLetter.equals("j")) {
                accountType = "01";
            } else if (accountTypeLetter.equals("k")) {
                accountType = "02";
            } else if (accountTypeLetter.equals("p")) {
                accountType = "03";
            }
            String accCode = accountCode.substring(1,2);




            MyConnection myConnection = new MyConnection();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM mobile_banking.tbl_account where code=? and acctype=?";
            String accNumber = "";
            try {
                connection = myConnection.createConnection();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            try {
                //make account number and date for Field1
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,accCode);
                preparedStatement.setString(2,accountType);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    accNumber = rs.getString("accnumber");
                }
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }




        String destAccount = params[3];
        String amount = params[4];
        String date = Constant.date;
        String trace = Constant.trace;
        String Field1=PackNumeric.packNumeric2(accNumber+destAccount+date+trace+amount);
        String Field2=Constant.availableBalSign+PackNumeric.packNumeric2(Constant.availableBal);

        return "tn20a"+"|"+Field1+"|"+Field2+"|" ;
        } else return "tn21acc.incorrect|";
        }

    public String tr_2() {
        return "2";
    }

    public String tr_3() {
        return "3";
    }
}
