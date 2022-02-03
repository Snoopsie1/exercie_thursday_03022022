package logic;

import java.util.ArrayList;
import java.util.List;

public class UserLogic
{

    public List<String> namesOnSystem()
    {
        List<String> usersOnSystem = new ArrayList<>();
        usersOnSystem.add(System.getProperty("user.name"));

        return usersOnSystem;
    }
}
