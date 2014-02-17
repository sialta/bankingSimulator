package com.sefryek.broker;

import com.sefryek.broker.mobileHandler.MIDletConstant;
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
public class AccountInvoiceServiceImpl implements AccountInvoiceService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getAccountInvoice(String serviceName, String request) {
        String servicType = bundle.getString("getInvoice");
        if (servicType.equals("1")) {
            return get_1(serviceName, request);
        } else if (servicType.equals("2")) {
            return get_2();
        } else if (servicType.equals("3")) {
            return get_3();
        }
        return "";
    }

    public String get_1(String serviceName, String request) {

        String accountTypeLetter = request.substring(9, 10);
        String code = request.substring(10, 11);
        String accountType="";
        if (accountTypeLetter.equals("j")) {
            accountType = "01";
        } else if (accountTypeLetter.equals("k")) {
            accountType = "02";
        } else if (accountTypeLetter.equals("p")) {
            accountType = "03";
        }

        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM mobile_banking.tbl_account where code=? and acctype=?";
        String accountNumber = "";
        try {
            connection = myConnection.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            //make account number and date for Field1
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,code);
            preparedStatement.setString(2,accountType);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                accountNumber = rs.getString("accnumber");
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }



        String Field2= Constant.TxnCode+PackNumeric.packNumeric2(Constant.FourdigitDate)+
                PackNumeric.packNumeric2(Constant.amount)+Constant.TxnSign;
        String lastDigits=accountNumber.substring(9,13);
        return "trn0b"+"|"+ PackNumeric.packNumeric2(Constant.availableBal)+ "|" +
                Field2 +"|"+PackNumeric.packNumeric2(lastDigits)+"|"+Constant.availableBalSign+"|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
