Simple HelloWorld Exercise

From the base directory of this exercise (i.e., where this README file is
located), the maven pom.xml file can be used to build and run the demo. 


1) To build the exercise type:

  mvn install (builds the demo)


2) To run the server in standalone mode:


  mvn -P server  (from one command line window)

  mvn -P client  (from a second command line window)
  
Note: In the pom file you will notice a "profile" for both client and server.
The profile designates a CXF (Spring) configuration file to use for client, and a 
configuration file to use for server. These files can be found here:
etc\test-client.xml
etc\test-server.xml

3) To Deploy / Install the OSGi bundle into Servicemix 4.x, first make sure the 
	standalone version of server is stopped. Then, from the servicemix console type:
    
    osgi:install -s mvn:com.fusesource.training/cxf-exercises-hello-world/2010.08.01

Note: The CXF (Spring) configuration file that is used in the bundle comes from the
following directory:
src\main\resources\META-INF\spring\beans.xml 

Test the deployment with the Client:

    mvn -P client  (from a second command line window)
    