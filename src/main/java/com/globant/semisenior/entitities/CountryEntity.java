package com.globant.semisenior.entitities;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Country")
@Table(name = "COUNTRY")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CountryEntity {
  private static final long serialVersionUID = -9025461685430951577L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL})
  private List<CityEntity> cities;

  @ManyToOne
  private ContinentEntity continent;

}
