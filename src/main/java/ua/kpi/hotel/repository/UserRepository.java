package ua.kpi.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.hotel.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByLogin(String login);
}
