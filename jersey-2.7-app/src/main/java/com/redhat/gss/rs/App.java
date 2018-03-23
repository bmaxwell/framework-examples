package com.redhat.gss.rs;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class App extends Application {
	
	private Logger log = Logger.getLogger(App.class.getName());
	private Set<Object> singletons = new HashSet<Object>();

	public App() {
		singletons.add(new CheckImplementationClassesResource());
	}

	@PostConstruct
	public void init() {		
		log.info("JAXRS Implementation: " + JAXRSUtil.getImpl());
		log.info("JAXRS Version: " + JAXRSUtil.getJAXRSVersion());
		if(!JAXRSUtil.isJersey())
			throw new RuntimeException("Jersey is not the JAXRS Implementation, the implementation is " + JAXRSUtil.getImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
