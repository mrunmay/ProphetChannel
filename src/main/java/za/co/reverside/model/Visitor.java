package za.co.reverside.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "visitors")
public class Visitor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name="dov")
    Date dateOfVisit;

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
    String visaLetter;

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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Long getAge()
    {
        return age;
    }

    public void setAge(Long age)
    {
        this.age = age;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getPassport()
    {
        return passport;
    }

    public void setPassport(String passport)
    {
        this.passport = passport;
    }

    public Long getPhone()
    {
        return phone;
    }

    public void setPhone(Long phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }

    public String getVisaLetter()
    {
        return visaLetter;
    }

    public void setVisaLetter(String visaLetter)
    {
        this.visaLetter = visaLetter;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getMedicalCertificate()
    {
        return medicalCertificate;
    }

    public void setMedicalCertificate(String medicalCertificate)
    {
        this.medicalCertificate = medicalCertificate;
    }

    public String getMedicalNote()
    {
        return medicalNote;
    }

    public void setMedicalNote(String medicalNote)
    {
        this.medicalNote = medicalNote;
    }

    public String getMedicineNote()
    {
        return medicineNote;
    }

    public void setMedicineNote(String medicineNote)
    {
        this.medicineNote = medicineNote;
    }

    public String getHealthStatus()
    {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus)
    {
        this.healthStatus = healthStatus;
    }

    public String getTransport()
    {
        return transport;
    }

    public void setTransport(String transport)
    {
        this.transport = transport;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getAccommodation()
    {
        return accommodation;
    }

    public void setAccommodation(String accommodation)
    {
        this.accommodation = accommodation;
    }

    public Boolean getAgreement()
    {
        return agreement;
    }

    public void setAgreement(Boolean agreement)
    {
        this.agreement = agreement;
    }
}
