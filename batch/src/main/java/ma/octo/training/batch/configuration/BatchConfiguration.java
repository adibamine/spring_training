package ma.octo.training.batch.configuration;

import javax.persistence.EntityManagerFactory;
import ma.octo.training.batch.Virement;
import ma.octo.training.batch.VirementDto;
import ma.octo.training.batch.VirementException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class BatchConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Autowired
  EntityManagerFactory entityManagerFactory;

  @Autowired
  VirementJobListener virementJobListener;

  @Autowired
  VirementSkipListener vIrementSkipListener;

  @Autowired
  VirementStepListener virementStepListener;

  @Bean(name = "virement_batch")
  public Job importVirementsJob(Step step1) {
    return jobBuilderFactory.get("importVirementJobs")
        .listener(virementJobListener)
        .flow(step1)
        .end()
        .build();
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
        .listener(virementStepListener)
        .<VirementDto, Virement>chunk(10)
        .reader(reader())
        .processor(processor())
        .writer(writer())
        .faultTolerant()
        .skip(VirementException.class)
        .skipLimit(100)
        .listener(vIrementSkipListener)
        .build();
  }

  @Bean
  public FlatFileItemReader<VirementDto> reader() {
    return new FlatFileItemReaderBuilder<VirementDto>()
        .name("VirementItemReader")
        .resource(new ClassPathResource("virements.csv"))
        .delimited()
        .names(new String[]{"destinataire", "amount"})
        .fieldSetMapper(new BeanWrapperFieldSetMapper<VirementDto>() {{
          setTargetType(VirementDto.class);
        }})
        .build();
  }

  @Bean
  public VirementItemProcessor processor() {
    return new VirementItemProcessor();
  }

  @Bean
  public ItemWriter<Virement> writer() {
    final JpaItemWriter<Virement> virementJpaItemWriter = new JpaItemWriter<>();
    virementJpaItemWriter.setEntityManagerFactory(entityManagerFactory);
    return virementJpaItemWriter;
  }
}