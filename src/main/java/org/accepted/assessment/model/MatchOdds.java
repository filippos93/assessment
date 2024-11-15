package org.accepted.assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="match_odds")
public class MatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    @Column(name = "specifier", nullable = false)
    private String specifier;
    @Column(name = "odds", nullable = false)
    private Float odds;

    @Override
    public String toString() {
        return "MatchOdds{" +
                "id=" + id +
                ", match=" + match +
                ", specifier='" + specifier + '\'' +
                ", odds=" + odds +
                '}';
    }
}
