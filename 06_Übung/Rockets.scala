object Rockets {

    case class Rocket(name: String, stages: Int, fuel: String);

    def printIf2Stages(rocket: Rocket) = {
        //TODO: Filter based on if a rocket has 2 stages
        rocket match {
            case Rocket(_, 2, _) => println(rocket)
            case _ => ()
        }
    }

    def printIfLH2LOX(rocket: Rocket) = {
        //TODO: Filter based on if a rocket uses LH2/LOX as fuel
        rocket match {
            case Rocket(_, _, "LH2/LOX") => println(rocket)
            case _ => ()
        }
    }

    def printIfLOX(rocket: Rocket) = {
        //TODO: Filter based on if a rocket uses LOX in its fuel
        rocket match {
            case Rocket(_, _, fuel) if fuel.contains("LOX") => println(rocket)
            case _ => ()
        }
    }

    def main(Args: Array[String]) = {
        val rockets = List(
            Rocket("Falcon 9", 2, "RP-1/LOX"),
            Rocket("Ariane 5", 2, "LH2/LOX"),
            Rocket("Soyuz", 2, "RP-1/LOX"),
            Rocket("Proton", 3, "N2H4/UDMH"),
            Rocket("Delta IV", 2, "LH2/LOX")
        )

        println("All rockets with 2 stages:")
        for (rocket <- rockets) {
            printIf2Stages(rocket)
        }

        println("All rockets with LH2/LOX:")
        for (rocket <- rockets) {  
            printIfLH2LOX(rocket)
        }

        println("All rockets that use LOX as oxidizer:")
        for (rocket <- rockets) {
            printIfLOX(rocket)
        }
    }
}