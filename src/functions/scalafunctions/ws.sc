val names: Vector[String] = Vector("June", "Jane", "James", "Iain", "Kate", "Beth", "George",
  "Jack", "Ben", "Bob", "Neil", "Simon")

val try1 = names.reduceLeft((str1, str2) => str1.substring(0, 2) + str2.substring(0, 2))
val try2 = names.reduceLeft((str1, str2) => str1 + str2.substring(0, 2))