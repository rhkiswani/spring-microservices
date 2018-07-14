package com.rhkiswani.backbasetask.core.entites;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractEntity<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean active = true;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void deactivate() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public enum Role {

        ADMIN, USER;

        public static Role value(String name) {
            return Role.valueOf(name.toUpperCase());
        }

        public static Role value(Integer ordinal) {
            return Role.values()[ordinal];
        }
    }

}
