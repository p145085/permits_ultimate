package com.example.permits_ultimate.data;

import com.example.permits_ultimate.Permit;
import com.example.permits_ultimate.Player;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface PermitDAO extends GenericCRUD<Permit, UUID>{

    Permit save(Permit permit);

    Permit findByUUID(UUID ID);
    Permit findByID(int ID);
    List<Permit> findAll();
    List<Permit> findPermitCreatedBefore(LocalDate createdBefore);
    List<Permit> findPermitCreatedAfter(LocalDate createdAfter);
    //TO-DO: Create "findPermitActive" - permit_created + permit_duration = isAfter LocalDate.now();
    List<Permit> findPermitOfType(String permit_type);
    List<Permit> findByPlayer(Player player);
    List<Permit> findByIssuer(Player issuer);
    List<Permit> searchDescriptionFor(String search);

    Permit update(UUID ID, Permit updated);

    boolean delete(UUID ID);
}