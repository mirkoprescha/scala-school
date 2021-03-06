class CityNameConstants(cities: List[String]) {
  val citiesByFirst = cities.map(c => c.head -> c).toMap[Char, String]

  def uppercaseGerman(str: String) = if (str.contains('ß')) None else Some(str.toUpperCase())

  //pattern matching
  def getUsingMatch(c: Char): Option[String]= {
    val city = citiesByFirst.get(c)
    val uppercased = city match {
      case Some(str) => uppercaseGerman(str)
      case None => None
    }
    uppercased match {
      case Some(str) => Some(str.replace(' ', ('_')))
      case None => None
    }
  }

  //map
  def getUsingMap(c: Char): Option[String] = {
    val city = citiesByFirst.get(c)
    val uppercased = city.flatMap(x => uppercaseGerman(x))
     uppercased.map(x => x.replace (' ', '_'))

  }

  //for comprehension
  def getUsingFor(c: Char): Option[String] = {
    for {
      city <- citiesByFirst.get(c)
      uppercased <- uppercaseGerman(city)
    } yield uppercased.replace (' ', '_')
  }

  // helper to make the exercise compile
  def ??(): Option[Nothing] = throw new NotImplementedError()
}