package com.example.user.service.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Builder
@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) default ''", name = "name")
    @JsonProperty("name")
    private String name;

    @Column(columnDefinition = "varchar(25) default ''", name = "email")
    @JsonProperty("email")
    private String email;

    @Column(columnDefinition = "varchar(15) default ''", name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(columnDefinition = "varchar(15) default ''", name = "password")
    @JsonProperty("password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @JsonProperty("created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Date updatedAt;

}