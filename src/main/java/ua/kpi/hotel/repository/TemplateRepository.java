package ua.kpi.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kpi.hotel.model.ReservationTemplate;

public interface TemplateRepository extends CrudRepository<ReservationTemplate, Integer> {
}
