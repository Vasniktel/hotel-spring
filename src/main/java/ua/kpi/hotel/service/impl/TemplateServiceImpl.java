package ua.kpi.hotel.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.hotel.model.ReservationTemplate;
import ua.kpi.hotel.model.Room;
import ua.kpi.hotel.model.User;
import ua.kpi.hotel.repository.TemplateRepository;
import ua.kpi.hotel.service.TemplateService;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {
  private final TemplateRepository templateRepository;

  public TemplateServiceImpl(TemplateRepository templateRepository) {
    this.templateRepository = templateRepository;
  }

  @Override
  public Iterable<ReservationTemplate> getAllTemplates() {
    return templateRepository.findAll();
  }

  @Override
  public void createTemplate(int roomSize, Room.Type type, User user,
                             LocalDate startDate, LocalDate endDate) {
    var template = new ReservationTemplate();
    template.setUser(user);
    template.setRoomSize(roomSize);
    template.setRoomType(type);
    template.setStartDate(startDate);
    template.setEndDate(endDate);

    templateRepository.save(template);
  }

  @Override
  public Optional<ReservationTemplate> getById(int id) {
    return templateRepository.findById(id);
  }

  @Override
  public void delete(ReservationTemplate template) {
    templateRepository.delete(template);
  }
}
