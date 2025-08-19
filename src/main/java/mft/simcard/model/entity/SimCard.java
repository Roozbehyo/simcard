package mft.simcard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mft.simcard.model.enums.SimCardOperators;
import mft.simcard.model.enums.SimStatus;

import java.util.Date;

@SuperBuilder
@Data
@Entity
@Table(name = "sim_cards")
@NoArgsConstructor
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("owner")
    private Person person;

    @Column(columnDefinition = "nvarchar2(20)", unique = true, nullable = false)
    @JsonProperty("sim_operator")
    private SimCardOperators operator;

    @Column(columnDefinition = "nvarchar2(11)", unique = true, nullable = false)
    @JsonProperty("number")
    private String number;

    @Column(columnDefinition = "date", nullable = false)
    private Date registrationDate;

    private SimStatus status;
}
