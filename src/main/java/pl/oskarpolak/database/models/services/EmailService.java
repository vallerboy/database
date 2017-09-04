package pl.oskarpolak.database.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.oskarpolak.database.models.EmailModel;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Lenovo on 04.09.2017.
 */

@Service
public class EmailService {

    @Autowired
    JavaMailSender sender;

    public void sendEmail(EmailModel model) {
        MimeMessage mail = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            // do kogo
            helper.setTo(model.getResponder());
            // odpowiedz do
            helper.setReplyTo(model.getAuthor());
            // od kogo
            helper.setFrom(model.getAuthor());
            // tytuł
            helper.setSubject(model.getSubject());
            // text
            helper.setText(model.getMessage(), true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        sender.send(mail);
    }
}
