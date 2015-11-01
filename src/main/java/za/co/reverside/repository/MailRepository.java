package za.co.reverside.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Notification;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Repository
public class MailRepository
{
    private String username;
    private Session session;

    @Autowired
    public MailRepository(@Value("${application.mail.host}") String host,
                          @Value("${application.mail.port}") int port,
                          @Value("${application.mail.username}") final String user,
                          @Value("${application.mail.password}") final String pass)
    {

        this.setUsername(user);
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.username", user);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(user, pass);
            }
        };

        session = Session.getDefaultInstance(props, auth);

    }

    public void send(Notification notification) throws MessagingException
    {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(getUsername()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(notification.getTo()));
        message.setSubject(notification.getSubject());
        message.setText(notification.getMessage());
        Transport.send(message);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
