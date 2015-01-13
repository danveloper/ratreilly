import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    get {
      response.send "I'm the default route!"
    }
    get("route1") {
      response.send "I'm in route1"
    }
    get("route2/:param") {
      response.send "I'm in route2 and received param: ${pathTokens.param}"
    }
  }
}

