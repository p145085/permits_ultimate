package com.example.permits_ultimate.data;

import com.example.permits_ultimate.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerDAO extends GenericCRUD<Player, UUID> {

    Player save(Player player);

    Player findByUUID(UUID ID);
    Player findByID(int ID);
    List<Player> findAll();
    List<Player> findByNickname(String nickname);
    List<Player> findByGuild(String guild);

    Player update(UUID ID, Player updated);

    boolean delete(UUID ID);

}
