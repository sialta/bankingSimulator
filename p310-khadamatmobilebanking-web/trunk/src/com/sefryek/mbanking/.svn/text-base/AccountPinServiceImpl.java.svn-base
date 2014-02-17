package com.sefryek.mbanking;

import com.sefryek.mbanking.model.Constant;
import com.sefryek.mbanking.model.MessageBody;
import com.sefryek.mbanking.utils.MyConnection;
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
public class AccountPinServiceImpl implements AccountPinService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String getAccountPin(String serviceName, String request) {
        String servicType = bundle.getString("accountPin");
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

        if(Constant.OUTPUT.equals("SUCCESS")){
        String cardNumber = request.substring(4, 20);
        String PIN2 = request.substring(21, 27);
        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM test.tbl_account where cardnumber=? and secondpin=?";
        String accPass = "";
        try {
            connection = myConnection.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            //get password for requested account
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, PIN2);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                accPass = rs.getString("pass");
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return MessageBody.accountPIN + "|" + accPass + "|";
        }else return "gap1acc.incorrect|";
    }

    public String get_2() {
        return "2";
    }

    public String get_3() {
        return "3";
    }
}
