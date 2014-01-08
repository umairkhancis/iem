package com.netpace.iem.umair.ws;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.netpace.iem.umair.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString() {
		return "Hello World JAX-WS";
	}
}