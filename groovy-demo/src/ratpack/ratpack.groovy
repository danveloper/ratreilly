import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    get {
      response.send "Hello World!"
    }
  }
}
