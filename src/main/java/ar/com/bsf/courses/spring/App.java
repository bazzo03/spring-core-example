package ar.com.bsf.courses.spring;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import ar.com.bsf.courses.spring.dao.GeneralInfoMockDAOImpl;
import ar.com.bsf.courses.spring.entities.Author;
import ar.com.bsf.courses.spring.oxm.Processor;
import ar.com.bsf.courses.spring.services.BadInfoService;
import ar.com.bsf.courses.spring.services.GeneralInfoService;
import ar.com.bsf.courses.spring.services.LocalInfoService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static GeneralInfoService getGeneralInfoService() {
	    //super complex creation of object of GeneralInfoService class
		GeneralInfoService obj = new GeneralInfoService(new GeneralInfoMockDAOImpl());
		return obj;
	}
	
    private static final Logger logger = LogManager.getLogger(App.class);

	public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	MutablePropertySources sources = context.getEnvironment().getPropertySources();
    	System.out.println("### LOOK AT THIS " + sources.get("local.banner"));    	
    
    	// add a shutdown hook for the above context...
        context.registerShutdownHook();
        
    	GeneralInfoService  gralInfoSrv2 = (GeneralInfoService) context.getBean("sampleGenSrv");
            	
    	GeneralInfoService  gralInfoSrv = (GeneralInfoService) context.getBean("generalInfoService");
    	//System.out.println("GENERAL NEWS");
    	System.out.println(gralInfoSrv.getIntroLegend());
        List<String> news = gralInfoSrv.getNews();
    	System.out.println();
        for(String lNews : news) {
        	System.out.println("### " + lNews);
        }
        
        GeneralInfoService  gralInfoSrv3 = (GeneralInfoService) context.getBean("sampleGenSrv");
        
        System.out.println();
        //System.out.println("LOCAL INFO NEWS");
        LocalInfoService  localInfoSrv = context.getBean("localInfoService", LocalInfoService.class);
        System.out.println(localInfoSrv.getIntroLegend());        
        List<String> locInfo = localInfoSrv.getInfoForLocation();        
        System.out.println();
        for(String lin : locInfo) {
        	System.out.println("### " + lin);
        }        
        System.out.println();
        
        
        System.out.println();
        System.out.println("BAD INFO NEWS");
        BadInfoService badInfoSrv = context.getBean("badInfoService", BadInfoService.class);
        
        try {
        	badInfoSrv.getNews(true, false);
        } catch(Exception ex) {
        	System.out.println("Swallowing this nice exception");
        }
        
        //
//        Properties p = System.getProperties();
//        Enumeration keys = p.keys();
//        while (keys.hasMoreElements()) {
//            String key = (String)keys.nextElement();
//            String value = (String)p.get(key);
//            System.out.println(key + ": " + value);
//        }
        
        //OXM Testing
        System.out.println();
        Processor xmlProcessor = (Processor) context.getBean("processor");
        Author a1 = new Author();
        a1.setFirstName("Ernest");
        a1.setLastName("Hemingway");
        a1.setBirthDate(new Date());
        try {
        	//Perform Marshalling
        	System.out.println("Marshalling object");
			xmlProcessor.objectToXML("sample.xml", a1);
			//Perform Unmarshalling
			System.out.println("Unmarshalling object");
			Author a2 = (Author)xmlProcessor.xmlToObject("sample.xml");
			System.out.println(a2);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
}
