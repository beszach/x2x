package com.example.pptaskspringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "roleName")
    @JsonProperty("roleName")
    private String roleName;

//это обратная часть ссылки-она будет исключена из сериализации
//    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> user;

    public Role() {
    }

    public Role(String roleName) {
        if (roleName.contains("ROLE_ADMIN")){
            this.id=1L;
        } else if (roleName.contains("ROLE_USER")){
            this.id=2L;
        }
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUser() { return user; }

    public void setUser(Set<User> user) { this.user = user; }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
