package za.co.reverside.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.HealthStatus;
import za.co.reverside.model.Reason;
import za.co.reverside.model.Status;
import za.co.reverside.model.Transport;
import za.co.reverside.model.Visitor;
import za.co.reverside.repository.HealthStatusRepository;
import za.co.reverside.repository.ReasonRepository;
import za.co.reverside.repository.StatusRepository;
import za.co.reverside.repository.TransportRepository;
import za.co.reverside.repository.VisitorRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class Services
{
  @Autowired
  VisitorRepository visitorRepository;

  @Autowired
  ReasonRepository reasonRepository;

  @Autowired
  StatusRepository statusRepository;

  @Autowired
  HealthStatusRepository healthStatusRepository;

  @Autowired
  TransportRepository transportRepository;

  @RequestMapping(value = "visitors", method = RequestMethod.GET, produces = "application/json")
  public List<Visitor> getVisitors()
  {
    return visitorRepository.findAll();
  }

  /**
   * Method to get all reasons
   * @return List<Reason>
   */
  @RequestMapping(value = "reasons", method = RequestMethod.GET, produces = "application/json")
  public List<Reason> getReasons()
  {
    return reasonRepository.findAll();
  }

  @RequestMapping(value = "status", method = RequestMethod.GET, produces = "application/json")
  public List<Status> getStatus()
  {
    return statusRepository.findAll();
  }

  @RequestMapping(value = "health", method = RequestMethod.GET, produces = "application/json")
  public List<HealthStatus> getProblems()
  {
    return healthStatusRepository.findAll();
  }

  @RequestMapping(value = "transports", method = RequestMethod.GET, produces = "application/json")
  public List<Transport> getTransports()
  {
    return transportRepository.findAll();
  }
}
