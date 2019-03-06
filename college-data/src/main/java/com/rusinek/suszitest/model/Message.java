package com.rusinek.suszitest.model;

import com.rusinek.suszitest.enums.TypeOfMessage;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Lecturer sender;

    @ManyToOne
    private Student recipient;

    @Enumerated(value = EnumType.STRING)
    private TypeOfMessage typeOfMessage;

    @Lob
    private String message;

    private Date sent;

    private Calendar expirationDate;

    @PreUpdate
    @PrePersist
    public void updateTimeTimeStamps() {
       if(sent == null) {
           sent = new Date();
       }
       expirationDate = Calendar.getInstance();
       expirationDate.setTime(sent);
       expirationDate.add(Calendar.DATE,14);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return recipient;
    }

    public void setStudent(Student recipient) {
        this.recipient = recipient;
    }

    public Lecturer getSender() {
        return sender;
    }

    public void setSender(Lecturer sender) {
        this.sender = sender;
    }

    public TypeOfMessage getTypeOfMessage() {
        return typeOfMessage;
    }

    public void setTypeOfMessage(TypeOfMessage typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }
}
