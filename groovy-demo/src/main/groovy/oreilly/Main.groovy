package oreilly

import ratpack.groovy.launch.GroovyScriptFileHandlerFactory
import ratpack.server.RatpackServer
import ratpack.server.ServerConfig

class Main {

  static void main(_) {
    RatpackServer.start { spec ->
      spec
        .config(ServerConfig.findBaseDirProps("ratpack.groovy"))
        .handler { r ->
          new GroovyScriptFileHandlerFactory().create(r)
        }
    }
  }
}
