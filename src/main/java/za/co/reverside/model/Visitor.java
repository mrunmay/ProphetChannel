package za.co.reverside.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitor")
@Getter
@Setter
public class Visitor
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  Long id;

  @Column(name = "status")
  Boolean status;

  @Column(name = "name")
  String name;

  @Column(name = "gender")
  String gender;

  @Column(name = "age")
  Long age;

  @Column(name = "nationality")
  String nationality;

  @Column(name = "passport")
  String passport;

  @Column(name = "phone")
  Long phone;

  @Column(name = "email")
  String email;

  @Column(name = "occupation")
  String occupation;

  @Column(name = "visa_letter")
  Boolean visaLetter;

  @Column(name = "reason")
  String reason;

  @Column(name = "medical_certificate")
  String medicalCertificate;

  @Column(name = "medical_note")
  String medicalNote;

  @Column(name = "medicine_note")
  String medicineNote;

  @Column(name = "health_status")
  String healthStatus;

  @Column(name = "transport")
  String transport;

  @Column(name = "comment")
  String comment;

  @Column(name = "accommodation")
  String accommodation;

  @Column(name = "agreement")
  Boolean agreement;
}
