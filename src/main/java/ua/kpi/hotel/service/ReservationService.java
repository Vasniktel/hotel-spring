package ua.kpi.hotel.service;

import ua.kpi.hotel.model.Reservation;
import ua.kpi.hotel.model.User;

public interface ReservationService {
  void createReservation(int templateId, int roomId);
  Iterable<Reservation> getForUser(User user);
  void payForReservation(int reservationId);
  Iterable<Reservation> getAll();
  void delete(int reservationId);
}
