object OptionExamples {

  val ListFunction = { a : Int => List(a + 1) }
  val OptionFunction = { a : Int => Some(a + 1) }
  val filterFunction = { a : Int => a > 2 }

  def incrementList(aList: List[Int]): List[List[Int]] = aList.map(ListFunction)
  
  def incrementAndFlattenList(aList: List[Int]): List[Int] = aList.flatMap(ListFunction)
  
  def filterList(aList: List[Int]): List[Int] = aList.filter(filterFunction)

  def incrementOption(option: Option[Int]): Option[Option[Int]] = option.map(OptionFunction)

  def incrementAndFlattenOption(option: Option[Int]): Option[Int] = option.flatMap(OptionFunction)

  def filterOption(option: Option[Int]): Option[Int] = option.filter(filterFunction)
}
