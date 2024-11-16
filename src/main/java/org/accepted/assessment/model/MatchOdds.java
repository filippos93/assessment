package org.accepted.assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.accepted.assessment.dto.MatchOddDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="match_odds")
public class MatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_odds_seq")
    @SequenceGenerator(name="match_odds_seq",sequenceName="match_odds_seq", allocationSize=1)
    @Column(name="id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    @Column(name = "specifier", nullable = false)
    private String specifier;
    @Column(name = "odds", nullable = false)
    private Double odds;

    @Override
    public String toString() {
        return "MatchOdds{" +
                "id=" + id +
                ", match=" + match +
                ", specifier='" + specifier + '\'' +
                ", odds=" + odds +
                '}';
    }
    public MatchOddDto toMatchOddsDto(){
        return this.toMatchOddsDto(false);
    }

    public MatchOddDto toMatchOddsDto(boolean addMatchId){
        return new MatchOddDto(this.id,  addMatchId ? this.match.getId() : null, this.getSpecifier(), this.getOdds());
    }
}
