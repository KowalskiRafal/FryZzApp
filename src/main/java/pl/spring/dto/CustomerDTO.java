package pl.spring.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date visitDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "HH:mm:ss")
    private Date visitTime;
    private String assignedHairdresser;
    private String info;
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getAssignedHairdresser() {
        return assignedHairdresser;
    }

    public void setAssignedHairdresser(String assignedHairdresser) {
        this.assignedHairdresser = assignedHairdresser;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return id.equals(that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(telephoneNumber, that.telephoneNumber) &&
                Objects.equals(visitDate, that.visitDate) &&
                Objects.equals(visitTime, that.visitTime) &&
                Objects.equals(assignedHairdresser, that.assignedHairdresser) &&
                Objects.equals(info, that.info) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, telephoneNumber, visitDate, visitTime, assignedHairdresser, info, comments);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", visitDate=" + visitDate +
                ", visitTime=" + visitTime +
                ", assignedHairdresser='" + assignedHairdresser + '\'' +
                ", info='" + info + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}