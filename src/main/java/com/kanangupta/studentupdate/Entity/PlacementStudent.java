package com.kanangupta.studentupdate.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Placement_Student")
@Getter
@Setter
public class PlacementStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "placement_id", nullable = false)
    private Integer placementId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students students;

    @Column(name = "cv_application", nullable = false)
    private String cvApplication;

    @Column(name = "about", nullable = false)
    private String about;

    @Column(name = "acceptance", nullable = false)
    private Boolean acceptance;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;
}
