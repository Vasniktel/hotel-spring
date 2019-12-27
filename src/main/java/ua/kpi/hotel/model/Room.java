package ua.kpi.hotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rooms")
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int size;
  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;
  @NotNull
  @Enumerated(EnumType.STRING)
  private Type type;
  private double price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public enum Type {
    COMMON, BUSINESS, DELUXE
  }

  public enum Status {
    FREE, RESERVED, OCCUPIED
  }
}
