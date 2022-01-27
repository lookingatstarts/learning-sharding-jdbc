package com.learning.web;

import com.learning.entity.Order;
import com.learning.repository.OrderRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/v1")
public class TestController {

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping("/{month}")
  public void add(@PathVariable("month") int month) {
    Order order = new Order();
    LocalDateTime now = LocalDateTime.now();
    now = now.withMonth(month);
    order.setOrderName(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd mm:HH:ss")));
    order.setMonth(now.getMonthValue());
    orderRepository.save(order);
  }
}
