package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.model.MessageBody;
import com.sefryek.broker.utils.MyConnection;
import com.sefryek.broker.utils.PackNumeric;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddAccountServiceImpl implements AddAccountService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;
    private static Logger logger = Logger.getLogger(AddAccountService.class);

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }

    @Override
    public String addNewAccount(String serviceName, String request) {
        String servicType = bundle.getString("addNewAccount");
        if (servicType.equals("1")) {
            return add_1(serviceName, request);
        } else if (servicType.equals("2")) {
            return add_2();
        } else if (servicType.equals("3")) {
            return add_3();
        }
        return "";
    }

    public String add_1(String serviceName, String request) {
        if (Constant.OUTPUT.equals("SUCCESS")) {
            String accountToBeCreated = request.substring(4, 17);
            String pass = request.substring(18, 22);
            MyConnection myConnection = new MyConnection();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM mobile_banking.tbl_account";
            String query2 = "SELECT COUNT(*) FROM mobile_banking.tbl_account";
            String query3 = "INSERT into mobile_banking.tbl_account (accnumber,pass,acctype,code) values(?,?,?,?)";
            String query4 = "SELECT * FROM mobile_banking.tbl_account where def=?";
            String query5 = "select max(code) from mobile_banking.tbl_account where acctype=?";
            int numberOfAccounts = 0;
            String acc = "";
            try {
                connection = myConnection.createConnection();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            int location = 0;
            try {
                preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    acc += rs.getString("accnumber") + rs.getString("code");
                }
                rs.close();
                if (acc.contains(accountToBeCreated)) {
                    return "new1" + MessageBody.duplicatedAccount + "~" + accountToBeCreated + "|";
                }
                String accType = accountToBeCreated.substring(0, 2);
                preparedStatement = connection.prepareStatement(query5);
                preparedStatement.setString(1, accType);
                rs = preparedStatement.executeQuery();
                int code = 0;
                try {
                    if (rs.next()) {
                        String val = (rs.getString(1) != null) ? rs.getString(1) : "0";
                        code = Integer.parseInt(val) + 1;
                    }
                } catch (Exception e) {
                    return ">>>>" + e.getMessage();


                }
                preparedStatement = connection.prepareStatement(query3);
                preparedStatement.setString(1, accountToBeCreated);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, accType);
                preparedStatement.setString(4, String.valueOf(code));
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(query4);
                preparedStatement.setInt(1, 1);
                rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    location = rs.getInt("1");
                }
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


            String packed = PackNumeric.packNumeric(acc);

            return "new0" + MessageBody.accountCreated + "~" + accountToBeCreated + "~" + "|" + packed + "|" + location + "|";
        } else return "new1acc.incorrect|";
    }

    public String add_2() {
        return "2";
    }

    public String add_3() {
        return "3";
    }
}
