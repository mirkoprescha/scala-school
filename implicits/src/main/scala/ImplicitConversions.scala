object ImplicitConversions {

  case class RichString(str: String) {
    def toUpper: String = str.toUpperCase
  }

  //TODO: Exercise 1 - provide implicit conversions from String to RichString anc vice versa
  implicit def stringToRichString (str: String): RichString = RichString(str)
  implicit def RichStringToString (rs: RichString): String = rs.str


}
