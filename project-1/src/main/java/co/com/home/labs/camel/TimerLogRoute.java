package co.com.home.labs.camel;


import org.apache.camel.builder.RouteBuilder;

public class TimerLogRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:example?period=2000")
                .setBody(constant("Hello Quarkus and Camel"))
                .to("log:" + TimerLogRoute.class.getName() );
    }
}