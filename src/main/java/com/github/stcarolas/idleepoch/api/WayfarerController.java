package  com.github.stcarolas.idleepoch.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wayfarer/{id}/activity")
public class WayfarerController {
  static final Logger log = LogManager.getLogger();

  @PostMapping
  public void setActivity(
    @PathVariable("id") String id
  ){
  }
}
