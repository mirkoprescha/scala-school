// examples inspired by http://danielwestheide.com/
object PatternMatching {

  trait User {
    def name: String
    def score: Int
  }

  case class FreeUserCC( name: String, score: Int, upgradeProbability: Double) extends User

  case class PremiumUserCC(name: String, score: Int) extends User

  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
  object FreeUser {
    def unapply (f:FreeUser) : Option [(String, Int, Double)] = Some (f.name,f.score, f.upgradeProbability)
  }

  class PremiumUser(val name: String, val score: Int) extends User
  object PremiumUser {
    def unapply (f:PremiumUser) : Option [(String, Int)] = Some (f.name,f.score)
  }

//
  def personalizedGreeting(user: User): String = {
    val msg: String = user match {
      case FreeUserCC(name, score, 1.0) => name + ", what can we do for you today?"
      case FreeUserCC(name, score, up) => "Hello " + name
      case PremiumUserCC (a,b) => "Welcome back, dear " + a

      case FreeUser(name, score, 1.0) => name + ", what can we do for you today?"
      case FreeUser(name, score, up) => "Hello " + name
      case PremiumUser (a,b) => "Welcome back, dear " + a
    }
    return msg
  }
  def freePremiumForThirdUser(s: Seq[User]): Option[String] = s match {
    case a::b::FreeUserCC(name,_,up)::_ if up < 0.5 => Some("Congratulations, " + name + ", you won a free premium membership!")
       case _ => None
  }

  //"Congratulations, Tom, you won a free premium membership!"

  def reverse(s: List[User]): List[User] = ???
}
