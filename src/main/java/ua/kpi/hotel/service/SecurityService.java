package ua.kpi.hotel.service;

import ua.kpi.hotel.model.User;

public interface SecurityService {
  User getLoggedInUser();
}
