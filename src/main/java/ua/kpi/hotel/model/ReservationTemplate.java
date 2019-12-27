package ua.kpi.hotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation_templates")
public class ReservationTemplate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(targetEntity = User.class)
  @NotNull
  private User user;

  @Column(name = "room_size")
  private int roomSize;

  @NotNull
  @Column(name = "room_type")
  @Enumerated(EnumType.STRING)
  private Room.Type roomType;

  @NotNull
  @Column(name = "start_date")
  private LocalDate startDate;

  @NotNull
  @Column(name = "end_date")
  private LocalDate endDate;

  @NotNull
  @Column(name = "creation_time")
  private LocalDateTime creationTime = LocalDateTime.now();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getRoomSize() {
    return roomSize;
  }

  public void setRoomSize(int roomSize) {
    this.roomSize = roomSize;
  }

  public Room.Type getRoomType() {
    return roomType;
  }

  public void setRoomType(Room.Type roomType) {
    this.roomType = roomType;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public Reservation toReservation(Room room, double price) {
    var reservation = new Reservation();
    reservation.setUser(user);
    reservation.setRoom(room);
    reservation.setStartDate(startDate);
    reservation.setEndDate(endDate);
    reservation.setPrice(price);
    return reservation;
  }
}
