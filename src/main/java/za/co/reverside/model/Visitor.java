package za.co.reverside.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

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

  @ManyToMany
  @JoinTable(joinColumns = @JoinColumn(name = "guest_id"),
          inverseJoinColumns = @JoinColumn(name = "reasons_id"))
  List<Reason> reasons;

  @ManyToOne
  @JoinColumn(name = "status_id")
  Status status;

  @Column(name = "sick_certificate")
  Boolean sickCertificate;

  @Column(name = "medical_note")
  String medicalConditionNote;

  @Column(name = "medicine_note")
  String medicineNote;

  @ManyToOne
  @JoinColumn(name = " health_status_id")
  HealthStatus healthStatus;

  @ManyToMany
  @JoinTable(joinColumns = @JoinColumn(name = "guest_id"),
          inverseJoinColumns = @JoinColumn(name = "transport_id"))
  List<Transport> transports;

  @Column(name = "comment")
  String comment;

  @Column(name = "agree")
  Boolean agreement;
}
