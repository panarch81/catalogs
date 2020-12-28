package com.globant.semisenior.entitities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "City")
@Table(name = "CITY")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CityEntity {
  private static final long serialVersionUID = 2651361770157059453L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  private CountryEntity country;
}
