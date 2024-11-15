package org.accepted.assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.accepted.assessment.model.enums.Sport;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "match_date", nullable = false)
    private Date matchDate;
    @Column(name = "match_time", nullable = false)
    private Time matchTime;
    @Column(name = "team_a", nullable = false)
    private String teamA;
    @Column(name = "team_b", nullable = false)
    private String teamB;
    @Column(name = "sport", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Sport sport;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "match")
    private List<MatchOdds> odds;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", matchDate='" + matchDate + '\'' +
                ", time='" + matchTime + '\'' +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", sport=" + sport +
                '}';
    }
}
