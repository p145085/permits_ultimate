package com.example.permits_ultimate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import static com.example.permits_ultimate.constants.EntityConstants.GENERATOR;
import static com.example.permits_ultimate.constants.EntityConstants.UUID_GENERATOR;

public class Permit {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name ="UUID_ID")
    private UUID UUID_ID;

    private LocalDate permit_created;
    private Period permit_duration;
    private String permit_type;

    @ManyToMany
    private Player player;

    @ManyToMany
    private Player issuer;

    private String description;

    public Permit() {
    }

    public Permit(int id, Period permit_duration, String permit_type, Player player, Player issuer, String description) {
        this.id = id;
        this.UUID_ID = UUID.randomUUID();
        setPermit_created(LocalDate.now());
        setPermit_duration(permit_duration);
        this.permit_type = permit_type;
        setPlayer(player);
        setIssuer(issuer);
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public UUID getUUID_ID() {
        return UUID_ID;
    }

    public LocalDate getPermit_created() {
        return permit_created;
    }

    public void setPermit_created(LocalDate permit_created) {
        if (permit_created == null) {
            throw new IllegalArgumentException("DateTime NOW required.");
        }
        this.permit_created = permit_created;
    }

    public Period getPermit_duration() {
        return permit_duration;
    }

    public void setPermit_duration(Period permit_duration) {
        if (permit_duration == null) {
            throw new IllegalArgumentException("Cannot be null, set 0 for indefinite duration or a value representing amount of months.");
        }
        this.permit_duration = permit_duration;
    }

    public String getPermit_type() {
        return permit_type;
    }

    public void setPermit_type(String permit_type) {
        this.permit_type = permit_type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Must be issued to a player. (Cannot be null).");
        }
        this.player = player;
    }

    public Player getIssuer() {
        return issuer;
    }

    public void setIssuer(Player issuer) {
        if (issuer == null) {
            throw new IllegalArgumentException("Who's issuing the permit?");
        }
        this.issuer = issuer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permit{" +
                "id=" + id +
                ", UUID_ID=" + UUID_ID +
                ", permit_created=" + permit_created +
                ", permit_duration=" + permit_duration +
                ", permit_type='" + permit_type + '\'' +
                ", player=" + player +
                ", issuer='" + issuer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permit permit = (Permit) o;
        return id == permit.id && Objects.equals(UUID_ID, permit.UUID_ID) && Objects.equals(permit_created, permit.permit_created) && Objects.equals(permit_duration, permit.permit_duration) && Objects.equals(permit_type, permit.permit_type) && Objects.equals(player, permit.player) && Objects.equals(issuer, permit.issuer) && Objects.equals(description, permit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, UUID_ID, permit_created, permit_duration, permit_type, player, issuer, description);
    }
}
