package ar.com.bsf.courses.spring;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ar.com.bsf.courses.spring.dao.GeneralInfoMockDAOImpl;
import ar.com.bsf.courses.spring.entities.Author;
import ar.com.bsf.courses.spring.oxm.Processor;
import ar.com.bsf.courses.spring.services.GeneralInfoService;

@Configuration
@ComponentScan("ar.com.bsf")
@EnableTransactionManagement
public class Config {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql")
				.build();
		return db;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean(name = "sampleGenSrv")
	public GeneralInfoService getGeneralInfoService() {
		// super complex creation of object of GeneralInfoService class
		GeneralInfoService obj = new GeneralInfoService(new GeneralInfoMockDAOImpl());
		return obj;
	}
	
	public Jaxb2Marshaller getCastorMarshaller() {
	  Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
	  jaxb2Marshaller.setClassesToBeBound(Author.class);
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("jaxb.formatted.output", true);
	  jaxb2Marshaller.setMarshallerProperties(map);
          return jaxb2Marshaller;
	}
	
	@Bean(name="processor")
	public Processor getHandler(){
	  Processor handler= new Processor();
	  handler.setMarshaller(getCastorMarshaller());
	  handler.setUnmarshaller(getCastorMarshaller());
	  return handler;
	}
}
