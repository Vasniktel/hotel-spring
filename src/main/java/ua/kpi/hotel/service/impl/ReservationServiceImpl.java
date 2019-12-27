package ua.kpi.hotel.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.hotel.model.Reservation;
import ua.kpi.hotel.model.Room;
import ua.kpi.hotel.model.User;
import ua.kpi.hotel.repository.ReservationRepository;
import ua.kpi.hotel.service.ReservationService;
import ua.kpi.hotel.service.RoomService;
import ua.kpi.hotel.service.TemplateService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ReservationServiceImpl implements ReservationService {
  private final RoomService roomService;
  private final TemplateService templateService;
  private final ReservationRepository reservationRepository;

  public ReservationServiceImpl(RoomService roomService, TemplateService templateService, ReservationRepository reservationRepository) {
    this.roomService = roomService;
    this.templateService = templateService;
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void createReservation(int templateId, int roomId) {
    var template = templateService.getById(templateId).orElseThrow();
    var room = roomService.getById(roomId).orElseThrow();
    room.setStatus(Room.Status.RESERVED);
    roomService.save(room);

    var price = ChronoUnit.DAYS.between(template.getStartDate(), template.getEndDate()) * room.getPrice();

    reservationRepository.save(template.toReservation(room, price));
    templateService.delete(template);
  }

  @Override
  public Iterable<Reservation> getForUser(User user) {
    return reservationRepository.findAllByUserAndPayTimeIsNull(user);
  }

  @Override
  public void payForReservation(int reservationId) {
    var reservation = reservationRepository.findById(reservationId).orElseThrow();
    reservation.setPayTime(LocalDateTime.now());
    reservationRepository.save(reservation);
  }

  @Override
  public Iterable<Reservation> getAll() {
    return reservationRepository.findAll();
  }

  @Override
  public void delete(int reservationId) {
    var reservation = reservationRepository.findById(reservationId).orElseThrow();
    var room = reservation.getRoom();
    room.setStatus(Room.Status.FREE);
    roomService.save(room);
    reservationRepository.delete(reservation);
  }
}
