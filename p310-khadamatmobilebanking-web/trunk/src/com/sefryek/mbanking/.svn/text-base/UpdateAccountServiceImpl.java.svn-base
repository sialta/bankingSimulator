package com.sefryek.mbanking;

import com.sefryek.mbanking.model.MessageBody;
import com.sefryek.mbanking.utils.MyConnection;
import com.sefryek.mbanking.utils.PackNumeric;
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
public class UpdateAccountServiceImpl implements UpdateAccountService{
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String updateAccountList(String serviceName, String request) {
        String servicType = bundle.getString("updateAccount");
        if (servicType.equals("1")) {
            return update_1(serviceName, request);
        } else if (servicType.equals("2")) {
            return update_2();
        } else if (servicType.equals("3")) {
            return update_3();
        }
        return "";
    }

    public String update_1(String serviceName, String request) {


        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM test.tbl_account";
        String query4 = "SELECT * FROM test.tbl_account where def=?";


        String acc = "";
        int location=0;
        try {
            connection = myConnection.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                acc += rs.getString("accnumber") + rs.getString("code");
            }

            preparedStatement=connection.prepareStatement(query4);
            preparedStatement.setInt(1,1);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                location = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String packed = PackNumeric.packNumeric(acc);
        return MessageBody.accountListUpdated + "|" + packed + "|" + location + "|";
    }

    public String update_2() {
        return "2";
    }

    public String update_3() {
        return "3";
    }
}
