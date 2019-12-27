package ua.kpi.hotel.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Room room;

  @NotNull
  @Column(name = "start_date")
  private LocalDate startDate;

  @NonNull
  @Column(name = "end_date")
  private LocalDate endDate;

  @NonNull
  @Column(name = "creation_time")
  private LocalDateTime creationTime = LocalDateTime.now();

  @Column(name = "pay_time")
  private LocalDateTime payTime;

  private double price;

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

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  @NonNull
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(@NonNull LocalDate endDate) {
    this.endDate = endDate;
  }

  @NonNull
  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(@NonNull LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public LocalDateTime getPayTime() {
    return payTime;
  }

  public void setPayTime(LocalDateTime payTime) {
    this.payTime = payTime;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
