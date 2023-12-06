package com.example.Transport.schedule.models;

import com.example.Transport.schedule.repository.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationUser extends Auditable<String>{

    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    @NotEmpty
    @ValidPassword
    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Enumerated(value = EnumType.STRING)
    @Column(name ="role")
    private ApplicationUserRole role;

}
