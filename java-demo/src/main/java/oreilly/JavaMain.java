package oreilly;

import ratpack.error.internal.DefaultDevelopmentErrorHandler;
import ratpack.guice.Guice;
import ratpack.jackson.JacksonModule;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

import java.util.HashMap;

import static ratpack.jackson.Jackson.json;

public class JavaMain {

  public static void main(String[] args) throws Exception {
    RatpackServer.start(spec -> spec
            .config(ServerConfig.findBaseDirProps("ratpack.properties").development(true))
            .registry(r -> {
              r.add(new DefaultDevelopmentErrorHandler());
            })
            .handler(r ->
                    Guice.builder(r)
                        .bindings(bindings -> {
                          bindings.add(new JacksonModule());
                        }).build(chain -> chain
                            .handler(ctx ->
                                    ctx.byContent(c -> c
                                            .json(() ->
                                                    ctx.render(json(new HashMap<String, String>() {{
                                                      put("msg", "You wanted JSON!");
                                                    }}))
                                            )
                                            .type("application/vnd.foo.app+json", () ->
                                                    ctx.render(json(new HashMap<String, String>() {{
                                                      put("msg", "You wanted HYPERMEDIA!!");
                                                    }}))
                                            )
                                    )
                            )
                    )
            )
    );
  }
}
