package moot.queue_management_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email @Column(unique = true)
    private String email;

    @NotBlank @Size(min = 8)
    private String password;

    @NotBlank @Size(max=50, min=2)
    private String first_name;

    @NotBlank @Size(max=50, min=2)
    private String last_name;

    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "pedestrian" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Ticket> tickets;

    private boolean active = true;
    private Instant created_at;
    private Instant updated_at;
}

