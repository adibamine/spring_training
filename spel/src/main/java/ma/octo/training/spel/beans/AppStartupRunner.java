package ma.octo.training.spel.beans;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

  @Value("#{'${employee.names}'.split(',')}")
  private List<String> employeeNames;

  @Value("#{'${employee.names}'.split(',')[0]}")
  private String firstEmployeeName;

  @Value("${employee.type}")
  private List<String> employeeType;

  @Value("#{${employee.age}}")
  private Map<String, Integer> employeeAge;

  @Value("#{${employee.age}.two}")
  private String employeeAgeTwo;

  @Value("#{${employee.age}['five'] ?: 30}")
  private Integer ageWithDefaultValue;

  @Value("#{systemProperties['java.home']}")
  private String javaHome;

  @Value("#{systemProperties['user.dir']}")
  private String userDir;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("{}", employeeNames);
    log.info("{}", firstEmployeeName);
    log.info("{}", employeeType);
    log.info("{}", employeeAge);
    log.info("{}", employeeAgeTwo);
    log.info("{}", ageWithDefaultValue);
    log.info("{}", javaHome);
    log.info("{}", userDir);
  }
}
