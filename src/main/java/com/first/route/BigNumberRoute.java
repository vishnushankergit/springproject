package com.first.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class BigNumberRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	    from("jms:queue:big.number.queue")
	    .marshal("UTF-8")
	    .split(body().tokenize("\n")).streaming()
	    .process(new Processor() {
	        @Override
	        public void process(Exchange arg0) throws Exception {
	            arg0.getIn().setHeader("readyToGo", true);
	            System.out.println(arg0.getIn().getBody(
	                    String.class));
	            }
	        })
	        .to("jms:queue:number.queue");
	    
	    from("activemq:queue:test.number.queue")
	    .marshal("UTF-8")
	    .split(body().tokenize("\n")).streaming()
	    .process(new Processor() {
	        @Override
	        public void process(Exchange arg0) throws Exception {
	            arg0.getIn().setHeader("readyToGo", true);
	            System.out.println(arg0.getIn().getBody(
	                    String.class));
	            }
	        })
	        .to("jms:queue:number.queue");
	    
	    }
	}
	
