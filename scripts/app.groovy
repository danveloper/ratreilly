@GrabResolver(name='netty', root='http://clinker.netty.io/nexus/content/repositories/snapshots')
@Grab('io.ratpack:ratpack-groovy:0.9.13-SNAPSHOT')

import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    handler { 
      response.send "Hello World!"
    }
  }
}