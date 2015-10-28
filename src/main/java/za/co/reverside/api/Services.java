package za.co.reverside.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.User;
import za.co.reverside.model.Visitor;
import za.co.reverside.repository.UserRepository;
import za.co.reverside.repository.VisitorRepository;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Slf4j
public class Services
{
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Services.class));

    @Autowired
    VisitorRepository visitorRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "api/visitors", method = RequestMethod.GET, produces = "application/json")
    public List<Visitor> getVisitors()
    {
        return visitorRepository.findAll();
    }

    @RequestMapping(value = "api/visitor/create", method = RequestMethod.POST, consumes = "application/json")
    public void createVisitor(@RequestBody Visitor visitor)
    {
        visitor.setStatus(false);
        visitorRepository.save(visitor);
        LOGGER.info("New visitor created");
    }

    @RequestMapping(value = "/login/{userName}", method = RequestMethod.POST, consumes = "text/html")
    public String login(@PathVariable("userName") String userName, @RequestBody String password)
    {
        User user = userRepository.findByUserNameAndPassword(userName, password);

        if (user != null)
        {
            byte[] token = Base64.encode((userName + ":" + password).getBytes());
            return new String(token);
        }
        throw new RuntimeException("Invalid Credentials");
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = "text/html")
    public void validate(@RequestBody String token)
    {
        byte[] decodedInfo = Base64.decode(token.getBytes());

        String str = new String(decodedInfo);

        String[] split = str.split(":");
        String userName = split[0];
        String password = split[1];

        User loginDetails = userRepository.findByUserNameAndPassword(userName, password);

        if (loginDetails == null)
        {
            throw new RuntimeException("Invalid Token");
        }
    }

    @RequestMapping(value = "api/users/me", method = RequestMethod.GET, produces = "application/json")
    public User getUser(Principal principal)
    {
        String userName = principal.getName();
        return userRepository.findByUserName(userName);
    }
}
