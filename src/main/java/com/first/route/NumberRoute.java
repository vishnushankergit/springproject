package com.first.route;

import org.apache.camel.builder.RouteBuilder;

public class NumberRoute extends RouteBuilder{

	@Override
	    public void configure() throws Exception {
	    from("jms:queue:number.queue")
	      .marshal("UTF-8")
	      .choice()
	      .when(header("readyToGo").isNotEqualTo(true))
	        .to("jms:queue:big.number.queue");
	    }

}
