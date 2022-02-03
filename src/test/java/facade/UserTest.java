package facade;

import logic.UserLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest
{
    UserLogic userLogic;

    @BeforeEach
    void setUp()
    {
        userLogic = new UserLogic();
    }

    @AfterEach
    void tearDown()
    {
    }

    //TODO:
    // US 1
    // As a user I want to see a list of all users on the system by their names only
    @Test
    public void namesOnSystem_Test_US1()
    {

    }

    //TODO:
    // US 2
    // As a user I want to see details of a specific user from the list
    @Test
    public void detailsOnUser_Test_US2()
    {

    }
}
