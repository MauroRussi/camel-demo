package co.com.home.labs.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class DirectRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Route logic
        from("direct:getHeartbeat")
                // 200 response code by default
                .setBody().simple("""
                        {"status": "API active - current exchangeId: ${exchangeId}"}
                        """)
                .to("log:" + RestRoutes.class.getName() );

        from("direct:fetchUser")
                // Fetch user...
                .setHeader(Exchange.HTTP_RESPONSE_CODE).constant(404)
                .setBody().simple("""
                        {"status": "User with name: ${headers.name} not found}"}
                        """)
                .to("log:" + RestRoutes.class.getName() );

        from("direct:failureExample")
                // Error example...
                .setHeader(Exchange.HTTP_RESPONSE_CODE).constant(500)
                .setBody().simple("""
                        {"status": "Failure for exchange with id: ${exchangeId}}"}
                        """)
                .to("log:" + RestRoutes.class.getName() );
    }
}