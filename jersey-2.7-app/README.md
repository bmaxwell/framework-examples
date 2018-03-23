1) Build

mvn package

2) Deploy

3) Test

server.log will log:

INFO  [com.redhat.gss.rs.App] (ServerService Thread Pool -- 64) JAXRS Implementation: Jersey
INFO  [com.redhat.gss.rs.App] (ServerService Thread Pool -- 64) JAXRS Version: JAX-RS 2.0


Hitting this URL 
http://localhost:8080/jersey-2.7-app/rest/check

will show:

JAX-RS 2.0 with Jersey
Implementation class
RuntimeDelegate org.glassfish.jersey.server.internal.RuntimeDelegateImpl
ResponseBuilder: org.glassfish.jersey.message.internal.OutboundJaxrsResponse.Builder
UriBuilder: org.glassfish.jersey.uri.internal.JerseyUriBuilder

If the jboss-deployment-structure.xml is not correct or Jersey is not used for some other issue, it will throw this exception:

Caused by: java.lang.RuntimeException: Jersey is not the JAXRS Implementation, the implementation is RESTEasy
