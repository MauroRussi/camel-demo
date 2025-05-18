package co.com.home.labs.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class RestRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // API definition. Rest does not allow more than one To.
        rest("/testApi")
                .get("/heartbeat")
                    .produces("application/json")
                    .to("direct:getHeartbeat" )
                .get("/user/{name}")
                    .produces("application/json")
                    .to("direct:fetchUser")
                .post("/failure")
                    .produces("application/json")
                    .to("direct:failureExample");
    }
}