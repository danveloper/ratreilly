package oreilly;

import ratpack.error.internal.DefaultDevelopmentErrorHandler;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class JavaMain {

  static class Transactions {
    void beginTransaction() {
      System.out.println("Transaction initiated!");
    }

    void endTransaction() {
      System.out.println("Transaction ended!");
    }
  }

  public static void main(String[] args) throws Exception {
    RatpackServer.start(spec -> spec
            .config(ServerConfig.findBaseDirProps("ratpack.properties").development(true))
            .registry(r -> {
              r.add(new Transactions());
              r.add(new DefaultDevelopmentErrorHandler());
            })
            .handlers(chain -> chain
                    .handler(ctx -> {
                      Transactions tx = ctx.get(Transactions.class);
                      tx.beginTransaction();
                      ctx.byMethod(m -> m
                              .get(() ->
                                      ctx.getResponse().send("Default GET handler")
                              )
                              .post(() ->
                                      ctx.getResponse().send("You POSTed to me!")
                              )
                      );
                      tx.endTransaction();
                    })
            )
    );
  }
}
