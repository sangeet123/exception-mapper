package error;

import exception.mapper.DataIntegrityViolationMapper;
import exception.mapper.mapperimpl.DataIntegrityViolationMapperImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by sangeet on 4/5/2017.
 */
@Configuration("exception-config")
public class Config {
  public static String appContext;

  @Value("${app.context:\"\"}")
  public void setAppContext(final String context){
    Config.appContext = context;
  }

  @Bean()
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    return messageSource;
  }

  @Bean()
  @ConditionalOnMissingBean({ DataIntegrityViolationMapper.class})
  public DataIntegrityViolationMapper getMapper(){
    return new DataIntegrityViolationMapperImpl();
  }
}
