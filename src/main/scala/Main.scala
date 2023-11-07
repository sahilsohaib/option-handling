object OptionHandling {
  def main(args: Array[String]): Unit = {
    // Define a map of student names and their optional grades
    val studentGrades = Map(
      "Alice" -> Some(95),
      "Bob" -> Some(88),
      "Charlie" -> Some(75),
      "David" -> None
    )

    // Calculate the average grade using map and filter
    val validGrades = studentGrades.values.flatten
    val averageGrade = validGrades.sum.toDouble / validGrades.size
    println(s"Average Grade: $averageGrade")

    // Find the highest grade using getOrElse
    val highestGrade = studentGrades.values.foldLeft(0) { (max, gradeOption) =>
      val grade = gradeOption.getOrElse(0)
      max max grade
    }
    println(s"Highest Grade: $highestGrade")

    // Filter students who scored higher than a specific threshold
    val threshold = 90
    val highScorers = studentGrades.filter {
      case (_, Some(grade)) => grade >= threshold
      case _ => false
    }
    println(s"Students with Grades >= $threshold: $highScorers")
  }
}
