package com.example.permits_ultimate.temp;

import com.example.permits_ultimate.JsonManager;
import com.example.permits_ultimate.Permit;
import com.example.permits_ultimate.Player;
import com.example.permits_ultimate.URLConstants;
import com.example.permits_ultimate.data.PermitDAOImplementation;
import com.example.permits_ultimate.data.PlayerDAOImplementation;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class App
{
    public static void main( String[] args )
    {

        PlayerDAOImplementation PlayerDAO = new PlayerDAOImplementation();
        PermitDAOImplementation PermitDAO = new PermitDAOImplementation();

        HashSet<String> matronNicks = new HashSet<>();
        HashSet<String> matronGuilds = new HashSet<>();
        matronNicks.add("MatronDeWinter");
        matronNicks.add("Rydia");
        matronGuilds.add("chumbucket & Associates");
        Player playerObjMatron = new Player(1, matronNicks, matronGuilds);

        HashSet<String> populusNicks = new HashSet<>();
        HashSet<String> populusGuilds = new HashSet<>();
        populusNicks.add("Populus");
        populusNicks.add("Ugodatwayigohome");
        populusGuilds.add("chumbucket & Associates");
        populusGuilds.add("the Darkcult");
        populusGuilds.add("Goobys");
        Player playerObjPopulus = new Player(2, populusNicks, populusGuilds);

        PlayerDAO.save(playerObjMatron);
        PlayerDAO.save(playerObjPopulus);


        Permit sheep = new Permit(1,
                Period.of(1,0,0),
                "sheep",
                playerObjMatron,
                playerObjMatron,
                "This permit allows player to shear sheep at Yew pens.");

        Permit covetousHarpies = new Permit(2,
                Period.of(24, 0, 0),
                "Farming",
                playerObjPopulus,
                playerObjPopulus,
                "This permit allows player to kill and harvest harpies in Covetous level one.");

        PermitDAOImplementation.getInstance().save(sheep);
        PermitDAOImplementation.getInstance().save(covetousHarpies);

        PlayerDAOImplementation.getInstance().save(playerObjMatron);
        PlayerDAOImplementation.getInstance().save(playerObjPopulus);

        shutdown();
    }
    public static void shutdown(){
        JsonManager.getInstance().serializeToJson(PlayerDAOImplementation.getInstance().findAll(), new File(URLConstants.PLAYER_URL));
        JsonManager.getInstance().serializeToJson(PermitDAOImplementation.getInstance().findAll(), new File(URLConstants.PERMIT_URL));

    }
}