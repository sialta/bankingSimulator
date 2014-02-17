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
public class BillPaymentWithAccountSt1ServiceImpl implements BillPaymentWithAccountSt1Service {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);
    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String payBillWithAccount(String serviceName,String request) {
        String servicType = bundle.getString("billPayAccF1");
        if(servicType.equals("1")){
            return pay_1(serviceName, request);
        }else if(servicType.equals("2")){
            return pay_2();
        }else if(servicType.equals("3")){
            return pay_3();
        }
        return "";
    }

    public String pay_1(String serviceName,String request) {
        if(Constant.OUTPUT.equals("SUCCESS")){
        String accountTypeLetter = request.substring(4, 5);
        String accountType = "";
        if (accountTypeLetter.equals("j")) {
            accountType = "01";
        } else if (accountTypeLetter.equals("k")) {
            accountType = "02";
        } else if (accountTypeLetter.equals("p")) {
            accountType = "03";
        }
        String accCode = request.substring(5, 6);
        String billANDpayID[]=request.substring(7,request.lastIndexOf("|")).split(" ");
        String billID=billANDpayID[0];
        String payID=billANDpayID[1];
        String account = "";
//        String pass = stringBuilder.substring(18,22);
        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM mobile_banking.tbl_account where code=? and acctype=?";

//        int numberOfAccounts = 0 ;
//        String acc= "";
        String Field1="billType";
        String Field2="billAmount";

        try {
            connection = myConnection.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        int location=0;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,accCode);
            preparedStatement.setString(2,accountType);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account = rs.getString("accnumber");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


//        String packed = PackNumeric.packNumeric(acc);

        return "pg10"+ MessageBody.billPaymentAcc+"~"+Field1+"~"+Field2+"~|"+PackNumeric.packNumeric2(account)+"|"+PackNumeric.packNumeric2(billID)+"|"+PackNumeric.packNumeric2(payID)+"|";

    } else return "pg101acc.incorrect|";

}

    public String pay_2() {
        return "2";
    }

    public String pay_3() {
        return "3";
    }
}
