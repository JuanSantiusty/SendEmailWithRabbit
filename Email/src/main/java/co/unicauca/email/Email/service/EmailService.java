package co.unicauca.email.Email.service;

import co.unicauca.email.Email.domain.Person;
import co.unicauca.email.Email.domain.PersonDTO;
import org.springframework.stereotype.Service;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

@Service
public class EmailService {

    public void sendEmail(PersonDTO chair) {
        Mailer ma= MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "cuychair@gmail.com", "cies amcp hfot rxhh")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();
        Email email= EmailBuilder.startingBlank()
                .from("Notificaciones cuyChair","cuychair@gmail.com")
                .to("Hola",chair.getEmail())
                .withSubject("Notificacion de trabajos")
                .withPlainText("Estimado autor\n\n\n" +
                        "Notificamos que se recibió de forma exitosa su trabajo para la Conferencia: \n\n"
                        +"Autor: "+chair.getName()+"\n")
                .buildEmail();

        ma.sendMail(email);

    }
}