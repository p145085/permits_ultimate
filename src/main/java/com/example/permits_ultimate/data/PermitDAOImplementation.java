package com.example.permits_ultimate.data;

import com.example.permits_ultimate.Permit;
import com.example.permits_ultimate.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PermitDAOImplementation implements PermitDAO{

    private static PermitDAOImplementation INSTANCE;

    public static PermitDAOImplementation getInstance(){
        if (INSTANCE == null) INSTANCE = new PermitDAOImplementation();
        return INSTANCE;
    }

    List<Permit> permitList = new ArrayList<>();

    @Override
    public Permit save(Permit permit) {
        permitList.add(permit);
        return permit;
    }

    @Override
    public Permit findByUUID(UUID ID) {
        for (Permit permit : permitList) {
            if(permit.getUUID_ID().equals(ID)){
                return permit;
            }
        }
        return null;
    }

    @Override
    public Permit findByID(int ID) {
        for (Permit permit : permitList) {
            if(permit.getId() == ID){
                return permit;
            }
        }
        return null;
    }

    @Override
    public List<Permit> findAll() {
        return Collections.unmodifiableList(permitList);
    }

    @Override
    public List<Permit> findByPlayer(Player player) {
        List<Permit> foundMatches = new ArrayList<>();
        for(Permit permit : permitList){
            if (permit.getPlayer().equals(player)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public List<Permit> findByIssuer(Player issuer) {
        List<Permit> foundMatches = new ArrayList<>();
        for (Permit permit : permitList){
            if(permit.getIssuer().equals(issuer)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public List<Permit> findPermitCreatedBefore(LocalDate createdBefore){
        List<Permit> foundMatches = new ArrayList<>();
        for (Permit permit : permitList){
            if(permit.getPermit_created().isBefore(createdBefore)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public List<Permit> findPermitCreatedAfter(LocalDate createdAfter){
        List<Permit> foundMatches = new ArrayList<>();
        for (Permit permit : permitList){
            if(permit.getPermit_created().isAfter(createdAfter)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public List<Permit> findPermitOfType(String permit_type){
        List<Permit> foundMatches = new ArrayList<>();
        for(Permit permit : permitList){
            if(permit.getPermit_type().equalsIgnoreCase(permit_type)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public List<Permit> searchDescriptionFor(String search){
        List<Permit> foundMatches = new ArrayList<>();
        for(Permit permit : permitList){
            if(permit.getDescription().contains(search)){
                foundMatches.add(permit);
            }
        }
        return null;
    }

    @Override
    public Permit update(UUID ID, Permit updated) {
        return null;
    }

    @Override
    public boolean delete(UUID ID) {
        return permitList.remove(this.findByUUID(ID));
    }
}
