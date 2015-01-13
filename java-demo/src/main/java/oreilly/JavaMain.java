package oreilly;

import ratpack.error.internal.DefaultDevelopmentErrorHandler;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class JavaMain {

  public static void main(String[] args) throws Exception {
    RatpackServer.start(spec -> spec
            .config(ServerConfig.findBaseDirProps("ratpack.properties").development(true))
            .registry(r -> r.add(new DefaultDevelopmentErrorHandler()))
            .handlers(chain -> chain
                .get("/route1", ctx ->
                    ctx.getResponse().send("I'm in route1!"))
                .assets("public", "index.html")
    )
    );
  }
}
