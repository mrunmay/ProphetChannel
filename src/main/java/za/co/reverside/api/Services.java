package za.co.reverside.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.Visitor;
import za.co.reverside.repository.VisitorRepository;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "api")
@Slf4j
public class Services
{
  private static final Logger LOGGER = Logger.getLogger(String.valueOf(Services.class));

  @Autowired
  VisitorRepository visitorRepository;

  @RequestMapping(value = "visitors", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public List<Visitor> getVisitors()
  {
    return visitorRepository.findAll();
  }

  @RequestMapping(value = "visitor/create", method = RequestMethod.POST, consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void createVisitor(@RequestBody Visitor visitor)
  {
    visitorRepository.save(visitor);
    LOGGER.info("New visitor created.");
  }
}
