# Database Speed Test
Is a mini JSF application to test the insert / select / update / delete speed from the application server to the database.

The application is tested with JBoss EAP 6.4.
A datasource with jndi-name "java:/speedtest" has to be defined in the standalone.xml:

    <datasource jndi-name="java:/speedtest" pool-name="speedtest" enabled="true" use-java-context="true" spy="true">
		<connection-url>%CONNECTION-URL%</connection-url>
		<driver>%DRIVER%</driver>
		<pool>
			<min-pool-size>10</min-pool-size>
			<max-pool-size>50</max-pool-size>
		</pool>
		<security>
			<user-name>%USERNAME%</user-name>
			<password>%PASSWORT%</password>
		</security>
    </datasource>

The application creates a table GepardecSpeedTestTempTable at startup.
After the deployment point your browser to http://host:port/database-speed-test/ and start testing.
