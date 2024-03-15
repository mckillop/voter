package org.mckillop;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class voterGetCandidates extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().bindingMode(RestBindingMode.json);
        rest("/api")
                .get("/candidate")
                .to("direct:candidate");

                from("direct:candidate")
                        .setBody(constant("SELECT name FROM candidate"))
                        .to("jdbc:dataSource");
    }
}
