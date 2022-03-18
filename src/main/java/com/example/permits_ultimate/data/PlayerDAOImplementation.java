package com.example.permits_ultimate.data;


import com.example.permits_ultimate.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PlayerDAOImplementation implements PlayerDAO{

    private static PlayerDAOImplementation INSTANCE;

    public static PlayerDAOImplementation getInstance(){
        if (INSTANCE == null) INSTANCE = new PlayerDAOImplementation();
        return INSTANCE;
    }

    List<Player> playerList = new ArrayList<>();

    @Override
    public Player save(Player player) {
        playerList.add(player);
        return player;
    }

    @Override
    public Player findByUUID(UUID ID) {
        for (Player p : playerList) {
            if(p.getUUID_ID().equals(ID)){
                return p;
            }
        }
        return null;
    }

    @Override
    public Player findByID(int ID) {
        for (Player p : playerList) {
            if(p.getId() == ID){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Player> findAll() {
        return Collections.unmodifiableList(playerList);
    }

    @Override
    public List<Player> findByNickname(String nickname) {
        List<Player> foundMatches = new ArrayList<>();
        for(Player p : playerList){
            for(String nick : p.getNicknames()){
                if (nick.equalsIgnoreCase(nickname)){
                    foundMatches.add(p);
                }
            }
        }
        return null;
    }

    @Override
    public List<Player> findByGuild(String guild) {
        List<String> found = new ArrayList<>();
        for(Player p : playerList) {
            for(String g : p.getGuilds()){
                if(g.equalsIgnoreCase(guild)){
                    found.add(guild);
                }
            }
        }
        return null;
    }

    @Override
    public Player update(UUID ID, Player updated) {
        return null;
    }

    @Override
    public boolean delete(UUID ID) {
        return playerList.remove(findByUUID(ID));
    }
}
