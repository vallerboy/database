package pl.oskarpolak.database.models;

import pl.oskarpolak.database.models.forms.EmailForm;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Lenovo on 04.09.2017.
 */
@Entity
@Table(name = "email")
public class EmailModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String author;
    private String responder;
    private String subject;
    private String message;
    private LocalDateTime date;

    public EmailModel() {
    }

    public EmailModel(EmailForm form){
        this.author = form.getAuthor();
        this.responder = form.getResponder();
        this.message = form.getMessage();
        this.subject = form.getSubject();
        this.date = LocalDateTime.now();
    }

    public EmailModel(int id, String author, String responder, String subject, String message, LocalDateTime dateSiema) {
        this.id = id;
        this.author = author;
        this.responder = responder;
        this.subject = subject;
        this.message = message;
        this.date = dateSiema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmailModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", responder='" + responder + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
