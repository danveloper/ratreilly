package oreilly;

import ratpack.error.internal.DefaultDevelopmentErrorHandler;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class JavaMain {

  public static void main(String[] args) throws Exception {
    RatpackServer.start(spec -> spec
            .config(ServerConfig.noBaseDir().development(true))
            .registry(r -> r.add(new DefaultDevelopmentErrorHandler()))
            .handlers(chain -> chain
                .get(ctx ->
                    ctx.getResponse().send("I'm in the default route!"))

                .get("route1", (ctx) ->
                    ctx.getResponse().send("I'm in route1!"))

                .get("route2/:param", (ctx) ->
                    ctx.getResponse().send(String.format("received param: %s", ctx.getPathTokens().get("param"))))
    )
    );
  }
}
