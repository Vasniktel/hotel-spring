package ua.kpi.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.hotel.model.Reservation;
import ua.kpi.hotel.model.User;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
  Iterable<Reservation> findAllByUserAndPayTimeIsNull(User user);
}
