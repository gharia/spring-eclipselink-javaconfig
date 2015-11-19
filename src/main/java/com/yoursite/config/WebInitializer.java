package com.yoursite.config;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * THis class will start ServletContext and load dispatcher servlet & other mentioned servlets, filters etc
 * @author Hemrajsinh Gharia
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	private static org.apache.log4j.Logger log = Logger.getLogger(WebInitializer.class);
	
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// TODO Auto-generated method stub
		log.debug("WebApplicationInitializer started...");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
				
		 // Manage the lifecycle of the root application context
	    servletContext.addListener(new ContextLoaderListener(rootContext));
	    servletContext.setInitParameter("contextConfigLocation", "<NONE>");
	    
	    
	    rootContext.register(DBConfig.class);
	    rootContext.register(WebConfig.class);	    
	      
		rootContext.setServletContext(servletContext);
						
		log.debug("Starting Dispatcher Servlet.....");
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		servlet.setMultipartConfig(new MultipartConfigElement("/img", 1024*1024*5, 1024*1024*5*5, 1024*1024));
		log.debug("Started Dispatcher Servlet.....");
			
		registerSitemeshFilter(servletContext);
	    
	}
	
	private void registerSitemeshFilter(ServletContext servletContext){
		log.debug("Registering sitemesh filter....");
		FilterRegistration.Dynamic registration = servletContext.addFilter("sitemesh", new SitemeshConfig());
		registration.addMappingForUrlPatterns(null, true, "/*");
		log.debug("Sitemesh filter Registered....");
	}

}
