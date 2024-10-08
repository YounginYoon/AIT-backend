package aivle.ait.Entity;

import aivle.ait.Dto.CompanyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "company")
//@Table(indexes = {@Index(name = "member_index", columnList = "member_id")}) // 인덱싱
@Entity
@Getter
@Setter
public class Company extends Time{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String role; // USER, ADMIN

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<InterviewGroup> interviewGroups = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    public void setDtoToObject(CompanyDTO companyDTO) {
        if (companyDTO.getName() != null)
            this.setName(companyDTO.getName());
        if (companyDTO.getEmail() != null)
            this.setEmail(companyDTO.getEmail());
        if (companyDTO.getPassword() != null)
            this.setPassword(companyDTO.getPassword());
        if (companyDTO.getRole() != null)
            this.setRole(companyDTO.getRole());
    }
}
