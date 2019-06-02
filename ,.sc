def mostCommonWord(paragraph: String, banned: Array[String]): String = {
  //get list of all words without punctuation and case, and their count

  val filtered = paragraph.toLowerCase()
    .map(_ match {
      case '!' => ' '
      case '?' => ' '
      case '\\' => ' '
      case ',' => ' '
      case ';' => ' '
      case '.' => ' '
      case '\'' => ' '
      case c => c
    }).toString().split(" ").filterNot(banned.contains(_)).filterNot(_ == " ").toSeq.groupBy(identity).mapValues(_.size)
    .toSeq.sortBy(_._2).filterNot(x =>  x._1 == " " || x._1 == "").last._1

  filtered
  //take from the top down while not in the banned list
}

def heightChecker(heights: Array[Int]): Int = {
  val z = heights.toSeq.sorted
  val zipped = z.zip(heights)
  zipped.filter(x => x._1 != x._2).size

}