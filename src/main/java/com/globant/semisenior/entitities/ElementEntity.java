package com.globant.semisenior.entitities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "element")
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

  @Column(name = "parent_id")
  private String parentId;

}
