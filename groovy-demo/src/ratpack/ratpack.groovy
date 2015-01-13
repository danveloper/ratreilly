import ratpack.error.internal.DefaultDevelopmentErrorHandler


import static groovy.json.JsonOutput.toJson
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    bindInstance(new DefaultDevelopmentErrorHandler())
  }
  handlers {
    handler {
      byContent {
        json {
          render(toJson([msg: "You wanted JSON"]))
        }
        type("application/vnd.foo.app+json") {
          render(toJson([msg: "You wanted hypermedia!!"]))
        }
      }
    }
  }
}

