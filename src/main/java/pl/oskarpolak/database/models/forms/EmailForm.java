package pl.oskarpolak.database.models.forms;

import java.time.LocalDateTime;

/**
 * Created by Lenovo on 04.09.2017.
 */
public class EmailForm {
    private String author;
    private String responder;
    private String subject;
    private String message;


    public EmailForm() {
    }

    public EmailForm(String author, String responder, String subject, String message) {
        this.author = author;
        this.responder = responder;
        this.subject = subject;
        this.message = message;
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
}
