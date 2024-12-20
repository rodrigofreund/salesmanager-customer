package com.rodrigofreund.salesmanager.customer.infra.persistency.entity;

import org.hibernate.annotations.SoftDelete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "customer",
        indexes = {
                @Index(name="IDX_NM", columnList="name"),
                @Index(name="IDX_SOC_NM", columnList="socialName"),
                @Index(name="IDX_FIN_NMB", columnList="finantialNumber"),
                @Index(name="IDX_SOC_NMB", columnList="socialNumber")
                },
        uniqueConstraints = {
                @UniqueConstraint(name="UNQ_NM", columnNames = {"socialNumber"}),
                @UniqueConstraint(name="UNQ_FNT_NMB", columnNames = {"finantialNumber"})})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@SoftDelete
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(nullable = false)
    private String name;
    @Setter
    private String socialName;
    @Column(nullable = false)
    private String finantialNumber;
    @Setter
    private String socialNumber;

    //enums
    //@Enumerated(EnumType.STRING)
    //private EnumType enum;
    
    //@Embedded
    //private StoredTogetherWithCustomerTable enbeddableEntity
}
