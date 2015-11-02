package za.co.reverside.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.Notification;
import za.co.reverside.model.Visitor;
import za.co.reverside.repository.NotificationRepository;
import za.co.reverside.repository.UserRepository;
import za.co.reverside.repository.VisitorRepository;

import java.util.List;

@RestController
public class VisitorService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitorService.class);

    @Autowired
    VisitorRepository visitorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationRepository notificationRepository;
    
    @RequestMapping(value = "api/visitors", method = RequestMethod.GET, produces = "application/json")
    public List<Visitor> getVisitors()
    {
        return visitorRepository.findAll();
    }

    @RequestMapping(value = "api/visitor/create", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    public String createVisitor(@RequestBody Visitor visitor)
    {
        visitor.setStatus(null);
        visitor = visitorRepository.save(visitor);
        Notification notification = notificationRepository.getNotification();
        notificationRepository.publish(notification);
        LOGGER.info("New visitor created : " + visitor.getId());
        return visitor.getId().toString();
    }

    @RequestMapping(value = "api/visitor/{id}", method = RequestMethod.GET, produces = "application/json")
    public Visitor getVisitor(@PathVariable ("id") Long id)
    {
        return visitorRepository.findOne(id);
    }

    @RequestMapping(value = "api/visitor/{id}/cancel", method = RequestMethod.GET, produces = "application/json")
    public Visitor cancelApplication(@PathVariable ("id") Long id)
    {
        Visitor visitor = visitorRepository.findOne(id);
        visitor.setStatus(false);
        visitorRepository.save(visitor);
        LOGGER.info("Application cancelled");
        return visitor;
    }

    @RequestMapping(value = "api/visitor/{id}/approve", method = RequestMethod.GET, produces = "application/json")
    public Visitor approveApplication(@PathVariable ("id") Long id)
    {
        Visitor visitor = visitorRepository.findOne(id);
        visitor.setStatus(true);
        visitorRepository.save(visitor);
        LOGGER.info("Application approved");
        return visitor;
    }
}
