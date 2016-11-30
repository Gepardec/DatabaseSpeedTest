# Database Speed Test
Is a mini JSF application to test the insert / select / update / delete speed from the application server to the database.

The application is tested with Tomcat 8.5.6

Tomcat has to be configured the following way:

## Define Datasource

In ${catalina.base}/conf/server.xml in GlobalNamingResources define a resource for a datasource. For Example:

	<Resource 
		name="ds/speedtest" 
		auth="Container" 
		type="javax.sql.DataSource"
       maxActive="100" 
       maxIdle="30" 
       maxWait="10000" 
       username="sa" 
       password="sa"
       driverClassName="org.h2.Driver"
       url="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE" />

## Add driver

Copy the JDBC driver to ${catalina.base}/lib

## Configure Logging (optional)

Modify ${catalina.base}/conf/logging.properties:

handlers = 5speedtest.org.apache.juli.AsyncFileHandler, "+ existing"

5speedtest.org.apache.juli.AsyncFileHandler.level = FINE
5speedtest.org.apache.juli.AsyncFileHandler.directory = ${catalina.base}/logs
5speedtest.org.apache.juli.AsyncFileHandler.prefix = speedtest.

com.gepardec.level = FINE
com.gepardec.handlers=5speedtest.org.apache.juli.AsyncFileHandler

This configuration should create a logfile with name speedtest.YYYY-MM-DD.log in ${catalina.base}/logs

## Deployment

Deploy it with the manager-gui or copy it to ${catalina.base}/webapps/

After the deployment point your browser to http://host:port/warFileName/ and start testing.
