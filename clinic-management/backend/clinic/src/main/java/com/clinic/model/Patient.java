package com.clinic.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;
    private String gender;
    private String medicalHistory;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
