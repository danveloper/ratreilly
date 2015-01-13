import ratpack.error.internal.DefaultDevelopmentErrorHandler


import static ratpack.groovy.Groovy.ratpack

class Transactions {
  void beginTransaction() {
    println "Beginning Transaction"
  }
  void endTransaction() {
    println "Ending Transaction"
  }
}

ratpack {
  bindings {
    bindInstance(new Transactions())
    bindInstance(new DefaultDevelopmentErrorHandler())
  }
  handlers {
    handler { Transactions tx ->
      tx.beginTransaction()
      byMethod {
        get {
          response.send "Default GET handler"
        }
        post {
          response.send "You POSTED to me!"
        }
      }
      tx.endTransaction()
    }
  }
}

