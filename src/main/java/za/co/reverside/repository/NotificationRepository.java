package za.co.reverside.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Notification;

import javax.jms.JMSException;
import javax.jms.Session;

@Repository
public class NotificationRepository
{

    final String queue = "";

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private UserRepository userRepository;

    public void publish(Notification notification)
    {
        publish(notification, "q.notification");
    }


    public void publish(final Notification notification, String queue)
    {
        jmsTemplate.send(queue, new MessageCreator()
        {
            public javax.jms.Message createMessage(Session session) throws JMSException
            {
                return session.createObjectMessage(notification);
            }
        });

    }

    public Notification getNotification()
    {
        String to = userRepository.findByRole("ROLE_REVIEWER").getEmail();
        String subject = "New Application";
        String message = "Please review.";
        Notification notification = new Notification(to, subject, message);
        return notification;
    }

}
