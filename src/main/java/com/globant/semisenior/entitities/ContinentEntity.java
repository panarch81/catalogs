package com.globant.semisenior.entitities;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Continent")
@Table(name = "CONTINENT")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ContinentEntity {
  private static final long serialVersionUID = -4899287672005321303L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "continent", cascade = {CascadeType.ALL})
  private List<CountryEntity> countries;
}
