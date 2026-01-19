package com.clinic.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "doctors")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialty;  // chuyên khoa
    private String degree;     // bằng cấp
    private String workSchedule; // lịch làm việc (có thể lưu text)

    // liên kết với user
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}

