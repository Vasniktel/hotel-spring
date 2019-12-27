package ua.kpi.hotel.service;

import ua.kpi.hotel.model.ReservationTemplate;
import ua.kpi.hotel.model.Room;
import ua.kpi.hotel.model.User;

import java.time.LocalDate;
import java.util.Optional;

public interface TemplateService {
  Iterable<ReservationTemplate> getAllTemplates();
  void createTemplate(int roomSize, Room.Type type, User user,
                      LocalDate startDate, LocalDate endDate);
  Optional<ReservationTemplate> getById(int id);
  void delete(ReservationTemplate template);
}
