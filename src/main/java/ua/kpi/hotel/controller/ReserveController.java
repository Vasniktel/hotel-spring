package ua.kpi.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kpi.hotel.service.RoomService;
import ua.kpi.hotel.service.TemplateService;

@Controller
public class ReserveController {
  private final TemplateService templateService;
  private final RoomService roomService;

  public ReserveController(TemplateService templateService, RoomService roomService) {
    this.templateService = templateService;
    this.roomService = roomService;
  }

  @GetMapping("/reserve")
  public String getTemplatesPage(Model model) {
    model.addAttribute("templateList", templateService.getAllTemplates());
    return "template_list";
  }

  @PostMapping("/reserve")
  public String getTemplatesPage(@RequestParam int templateId, Model model) {
    var rooms = roomService.getRoomsForTemplate(templateId);
    model.addAttribute("roomList", rooms);
    model.addAttribute("templateId", templateId);
    return "room_list";
  }
}
