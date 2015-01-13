package oreilly;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class JavaMain {

  public static void main(String[] args) throws Exception {
    RatpackServer.start(spec -> spec
        .config(ServerConfig.noBaseDir())
        .handler(r -> (ctx) -> ctx.getResponse().send("Hello World!"))
    );
  }
}
