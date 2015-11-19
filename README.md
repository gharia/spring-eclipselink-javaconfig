

This project is well configured architecture which have Spring Data Jpa, EclipseLink, Sitemesh, Spring Rest API and all the configuration are Java Annotation bases, no xml. You can just download the project &amp; start creating your application.

<b>Steps to run/deploy project</b>

You can view the detail dexplanation on https://ghariaonline.wordpress.com/2015/11/19/spring-mvc-and-spring-data-jpa-with-eclipselink-sitemesh-restful-web-service-annotation-based-configuration/. 

Here listing down the steps for running & deploying the project.

1> Execute yoursite.sql in your MySql database.

2> In eclipse, choose file > Import > Existing Maven Project.

3> Select the location of pom file of the project you downloaded and click on finish.

4> Right Click on Project > Maven > Update Project. This will update the structure of project if needed.

5> For development environment, you need to set up load time weaving of POJOs. For this you need to specify weaver jar using    javaagent to your tomcat server. Here we are using  Spring Instrument for load time weaving. You can download latest jar     from this link. Now open launch configuration of your tomcat server from eclipse (Double click on your tomcat in Servers     tab & click on Open launch configuration). Now click on Arguments tab and append following line to VM arguments.

	-javaagent:<Path to Spring Instrument jar you downloaded>

   For e.g. I downloaded spring-instrument-4.2.3.RELEASE.jar and placed in D drive. Then javaagent argument will be as    follow:

	-javaagent:D:\spring-instrument-4.2.3.RELEASE.jar

   In development environment you should use load time weaving. But when you are preparing war file you should use static weaving. So when creating war comment @EnableLoadTimeWeaving and make changes in entityManagerFactoryBean()  method of DBConfig.java as mentioned in comments of method.
   
6> In application.properties, change jdbc.url, jdbc.username, jdbc.password & eclipselink.persistenceUnitName as per your database settings. Also make the same changes in persistence.xml

7> Add project to tomcat and start the tomcat.

8> The project has Person domain class, controller, service & repository. To access on browser, go to http://localhost:8085/yoursite/person?startIndex=0&limit=10. This will open list of person, which initially will be blank. Click on "Add" button to add a new person. Once added it will be listed there. You can edit it.

9>You can access one sample REST endpoint at http://localhost:8080/yoursite/greeting/<personId>. Replace "personId" with the added person id.
