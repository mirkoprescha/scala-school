object Mapping {

  val populationInMillions = Map(
    "Munich" -> 1.388,
    "Hamburg" -> 1.734,
    "Berlin" -> 3.375,
    "London" -> 8.63,
    "Hong Kong" -> 7.188,
    "New York" -> 8.406,
    "Bangkok" -> 6.355,
    "New Delhi" -> 9.879,
    "Beijing" -> 11.51,
    "Tokyo" -> 13.35,
    "Luxembourg" -> 0.543)

  //implement this first
  def getPopulationOf(place: String): Option[Double] = populationInMillions.get(place)

  //implement this second
  def addPopulationsOf(places: String*): Option[Double] = {
    val maybePopulations: Seq[Option[Double]] = places.map (getPopulationOf )
    maybePopulations.foldLeft(Option(0.0))((aggOpt, opt) => aggOpt match {
      case None => None
      case Some(aggV) => opt match {
        case None => None
        case Some (pop) => Some(aggV + pop)
      }
    })
  }

  //implement this third
  def populationOf(places: String*): Any = addPopulationsOf(places:_*) match {
    case _ => ???
  }

}
