package com.globant.semisenior.entitities;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
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

@Entity(name = "Category")
@Table(name = "CATEGORY")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryEntity{
  private static final long serialVersionUID = 2651361770157059453L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "category")
  private List<ElementEntity> elements;
}
