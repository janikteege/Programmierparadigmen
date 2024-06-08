// Zusammenarbeit Nele Hüsemann, Janik Teege

abstract class Message {
    val content: String
}

case class Error(time: Long, content: String) extends Message {
    override def toString() = {
        s"$content happened at $time"
    }
}

case class Info(content: String) extends Message {
    override def toString() = {
        s"$content"
    }
}

case class Warn(severity: String, content: String) extends Message {
    override def toString() = {
        s"$severity: $content"
    }
}

case class Debug(events: List[String], content: String) extends Message {
    override def toString() = {
        s"$content with $events"
    }
}


def msg_format(msg: Any): String = {
    msg match {
        case error: Error => s"Error: ${error.toString()}"
        case info: Info => s"Info: ${info.toString()}"
        case warn: Warn => s"Warn: ${warn.toString()}"
        case debug: Debug =>
            if (debug.events.length >= 2) {
                val lastEvent = debug.events.last
                s"Debug: ${debug.content} with $lastEvent"
            } else {
                s"Debug: ${debug.content}"
            }
        case _ => "Unknown"
    }
}

def debug_filter(msg: Debug): String = {
    msg.events match {
        case "Initialization" :: tail => s"Debug: ${msg.toString()}"
        case _ :: Nil => ""
        case _ => "Unknown"
    }
}

object Main {
    def main(Args: Array[String]) = {
        val error: Error = Error(System.currentTimeMillis(), "Foo")
        val info: Info = Info("More")
        val warn: Warn = Warn("Minor", "Bar")
        val debug: Debug = Debug(List("Initialization", "Bar", "FooBar"), "Some Events happened")
        val debug_short: Debug = Debug(List("Foo"), "Some Event happened")

        val mgs = List(error, info, warn, debug, debug_short)
        
        mgs.foreach(msg => println(msg_format(msg)))
        
        println(debug_filter(debug))
        println(debug_filter(debug_short))
    }
}