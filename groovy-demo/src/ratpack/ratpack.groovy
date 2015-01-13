import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    get "route1", {
      response.send "I'm in route1!"
    }
    assets("public", "index.html")
  }
}

