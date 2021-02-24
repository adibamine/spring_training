package ma.octo.training.beans;

import java.io.File;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    File file1 = new ClassPathResource("fichier1.txt").getFile();
    File file2 = new FileSystemResource("/home/adib/Bureau/fichier2.txt").getFile();
    String file1Text = new String(
        Files.readAllBytes(file1.toPath()));
    String file2Text = new String(
        Files.readAllBytes(file2.toPath()));
    log.info("file1 text: {}", file1Text);
    log.info("file2 text: {}", file2Text);
  }
}