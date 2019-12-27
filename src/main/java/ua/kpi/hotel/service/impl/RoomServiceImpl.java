package ua.kpi.hotel.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.hotel.model.Room;
import ua.kpi.hotel.repository.RoomRepository;
import ua.kpi.hotel.service.RoomService;
import ua.kpi.hotel.service.TemplateService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
  private final TemplateService templateService;
  private final RoomRepository roomRepository;

  public RoomServiceImpl(TemplateService templateService, RoomRepository roomRepository) {
    this.templateService = templateService;
    this.roomRepository = roomRepository;
  }

  @Override
  public List<Room> getRoomsForTemplate(int templateId) {
    var template = templateService.getById(templateId).orElseThrow();
    var size = template.getRoomSize();
    var type = template.getRoomType();
    var status = Room.Status.FREE;
    return roomRepository.findAllBySizeGreaterThanEqualAndTypeAndStatus(size, type, status);
  }

  @Override
  public Optional<Room> getById(int id) {
    return roomRepository.findById(id);
  }

  @Override
  public void save(Room room) {
    roomRepository.save(room);
  }
}
