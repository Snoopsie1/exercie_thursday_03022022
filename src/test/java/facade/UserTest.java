package facade;

import DataAccess.DBconnector;
import logic.UserLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest
{
    UserLogic userLogic = new UserLogic();

    @BeforeEach
    void setUp()
    {
        System.out.println("TESTINNNNGGGG");
        Connection con = null;
        try {
            con = DBconnector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() throws SQLException, ClassNotFoundException
    {
        Connection con = DBconnector.connection();
        try
        {
            String dropTable = " DROP TABLE IF EXISTS `startcode_test`.`usertable`";
            con.prepareStatement(dropTable).executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //TODO:
    // US 1
    // As a user I want to see a list of all users on the system by their names only
    @Test
    public void namesOnSystem_Test_US1()
    {
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = userLogic.namesOnSystem();
        actualList.add("Hans Hansen");

        assertEquals(expectedList, actualList);
    }

    //TODO:
    // US 2
    // As a user I want to see details of a specific user from the list
    @Test
    public void detailsOnUser_Test_US2()
    {
        String actualUserDetails = userLogic.getUserDetails("Hans", "Hansen");
        String expectedUserDetails = "Hans Hansen Hemmelig123 40404040 Rolighedsvej 3";

        assertEquals(expectedUserDetails, actualUserDetails);
    }
}
