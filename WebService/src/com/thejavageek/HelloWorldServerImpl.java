package com.thejavageek;

import javax.jws.WebService;

@WebService(endpointInterface = "com.thejavageek.HelloWorldServer")
public class HelloWorldServerImpl implements HelloWorldServer {

	
	@Override
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}

}
