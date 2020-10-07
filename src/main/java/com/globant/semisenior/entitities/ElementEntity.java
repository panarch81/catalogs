package com.globant.semisenior.entitities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity(name = "Element")
@Table(name = "ELEMENT")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ElementEntity implements Serializable {

  private static final long serialVersionUID = 1718410130951726308L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @ManyToOne
  private ElementEntity parent;

  @OneToMany(mappedBy = "parent")
  private List<ElementEntity> components;

}
