package ua.kpi.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.hotel.model.Room;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
  List<Room> findAllBySizeGreaterThanEqualAndTypeAndStatus(int size, Room.Type type, Room.Status status);
}
