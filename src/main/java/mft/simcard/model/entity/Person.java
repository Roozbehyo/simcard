package mft.simcard.model.entity;


//import com.fasterxml.jackson.databind.annotation.;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import mft.simcard.model.enums.SimCardOperators;
import org.hibernate.boot.models.annotations.internal.AssociationOverrideJpaAnnotation;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name="personEntity")
@Table(name = "persons")
@AssociationOverrides({})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name="name",columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("نام")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Name !!!")
    private String name;

    @Column(name="family",columnDefinition = "nvarchar2(30)", nullable = false)
    @JsonProperty("نام خانوادگی")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Family !!!")
    private String family;

}
