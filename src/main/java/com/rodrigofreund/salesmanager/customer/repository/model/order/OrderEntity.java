package com.rodrigofreund.salesmanager.customer.repository.model.order;

import java.time.LocalDateTime;

import org.hibernate.annotations.SoftDelete;

import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "request")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@SoftDelete
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Column(nullable = false)
    private LocalDateTime date;
    @Setter
    //owning side
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;
}
