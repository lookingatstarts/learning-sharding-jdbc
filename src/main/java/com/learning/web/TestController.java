package com.learning.web;

import com.learning.entity.City;
import com.learning.entity.Order;
import com.learning.entity.User;
import com.learning.repository.CityRepository;
import com.learning.repository.OrderRepository;
import com.learning.repository.UserRepository;
import java.util.concurrent.ThreadLocalRandom;
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
  @Autowired
  private CityRepository cityRepository;
  @Autowired
  private UserRepository userRepository;

  @PostMapping("/city/{cityName}")
  public void addCity(@PathVariable("cityName") String cityName) {
    City city = new City();
    city.setCityName(cityName);
    cityRepository.save(city);
  }

  @PostMapping("/order/{month}")
  public void addOrder(@PathVariable("month") int month) {
    Order order = new Order();
    order.setUserId(ThreadLocalRandom.current().nextLong(1, 11));
    order.setMonth(month);
    order.setCreatedAt(System.currentTimeMillis());
    orderRepository.save(order);
  }

  @PostMapping("/user/{username}")
  public void addOrder(@PathVariable("username") String username) {
    User user = new User();
    user.setUsername(username);
    userRepository.save(user);
  }
}
