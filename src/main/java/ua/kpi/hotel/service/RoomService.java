package ua.kpi.hotel.service;

import ua.kpi.hotel.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
  List<Room> getRoomsForTemplate(int templateId);
  Optional<Room> getById(int id);
  void save(Room room);
}
