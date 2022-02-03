package logic;

import DataAccess.DBconnector;
import facade.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLogic
{

    public List<String> namesOnSystem()
    {
        User tmpUser = null;
        ArrayList<String> namesOnSystemList = new ArrayList<>();
        try
        {
            Connection connection = DBconnector.connection();
            String sql = " SELECT * FROM usertable";
            try
            {
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next())
                {
                    String firstName = rs.getString("fname");
                    String lastName = rs.getString("lname");

                    tmpUser = new User(firstName, lastName);
                    namesOnSystemList.add(tmpUser.getFullName());
                }

                return namesOnSystemList;
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserDetails(String usersFname, String usersLname)
    {
        User tmpUser = null;
        try
        {
            Connection connection = DBconnector.connection();
            String sql = " SELECT * FROM usertable WHERE fname='"+usersFname+"' AND lname='"+usersLname+"'";
            try
            {
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);

                if(rs.next())
                {
                    String firstName = rs.getString("fname");
                    String lastName = rs.getString("lname");
                    String password = rs.getString("pw");
                    String phoneNumber = rs.getString("phone");
                    String address = rs.getString("address");

                    tmpUser = new User(firstName,lastName,password,phoneNumber, address);
                }

                return tmpUser.toString();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }



}
