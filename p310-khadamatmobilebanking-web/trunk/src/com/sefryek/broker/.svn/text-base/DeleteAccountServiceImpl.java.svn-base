package com.sefryek.broker;

import com.sefryek.broker.model.Constant;
import com.sefryek.broker.model.MessageBody;
import com.sefryek.broker.utils.MyConnection;
import com.sefryek.broker.utils.PackNumeric;
import com.sun.net.httpserver.HttpExchange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/9/13
 * Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteAccountServiceImpl implements DeleteAccountService {
    private static final String MESSAGES = "servicesType";
    private static ResourceBundle bundle = null;

    static {
        bundle = ResourceBundle.getBundle(MESSAGES);
    }





    @Override
    public String deleteAccount(String serviceName, String request) {
        String servicType = bundle.getString("deleteAccount");
        if (servicType.equals("1")) {
            return delete_1(serviceName,request);
        } else if (servicType.equals("2")) {
            return delete_2();
        } else if (servicType.equals("3")) {
            return delete_3();
        }
        return "";
    }



    public String delete_1(String serviceName, String request) {
        if(Constant.OUTPUT.equals("SUCCESS")){
        String accountToBeDeleted = request.substring(4, 17);
        MyConnection myConnection = new MyConnection();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM mobile_banking.tbl_account";
        String query2 = "SELECT COUNT(*) FROM mobile_banking.tbl_account";
        String query3= "DELETE from mobile_banking.tbl_account WHERE accnumber=?";
        String query4 = "SELECT * FROM mobile_banking.tbl_account where def=?";

        int numberOfAccounts = 0;
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
            ArrayList<String> list = new ArrayList<String>(numberOfAccounts);
            while (rs.next()) {
                int i = 0;
                list.add(i, rs.getString("accnumber"));
                acc += rs.getString("accnumber");
                i++;
            }
            if(!acc.contains(accountToBeDeleted)){
                return "rmw1acc.invalid"+"~"+accountToBeDeleted+"|";
            }
            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setString(1,accountToBeDeleted);
            int tt = preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(query2);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                numberOfAccounts = rs.getInt(1);
            }

            preparedStatement = connection.prepareStatement(query);
             rs = preparedStatement.executeQuery();
            acc="";
            while (rs.next()) {
                acc += rs.getString("accnumber")+rs.getString("code");
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

        return "rmw0" + MessageBody.accountDeleted + "~" + accountToBeDeleted + "~" + "|" + packed + "|" + location + "|";
        }else return "rmw1acc.incorrect|";
        }

    public String delete_2() {
        return "2";
    }

    public String delete_3() {
        return "3";
    }
}
