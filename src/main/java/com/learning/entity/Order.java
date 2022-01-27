package com.learning.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "f_id", nullable = false, insertable = false, updatable = false)
  private Long id;

  @Column(name = "f_month", nullable = false)
  private Integer month;

  @Column(name = "f_order_name", nullable = false)
  private String orderName;
}
