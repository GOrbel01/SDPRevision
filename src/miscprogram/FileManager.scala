package miscprogram

import java.io._

import scala.swing.FileChooser

/**
 * Created by Squall on 11/05/2015.
 */
object FileManager {
  def writeFile[A](f: File, vect: Vector[A]): Unit = {
      var fos: Option[FileOutputStream] = None
      var oos: Option[ObjectOutputStream] = None
      fos = Some(new FileOutputStream(f))
      oos = Some(new ObjectOutputStream(fos.get))
      oos.get.writeObject(vect)
  }

  def readFile[A](f: File): Vector[A] = {
    var fis: Option[FileInputStream] = None
    var ois: Option[ObjectInputStream] = None
    fis = Some(new FileInputStream(f))
    ois = Some(new ObjectInputStream(fis.get))
    ois.get.readObject().asInstanceOf[Vector[A]]
  }

}

object DataStore extends App {
  var personaList = Vector()
  var personList = Vector()

  personaList = FileManager.readFile(new File("PersonaList.txt"))
  personList = FileManager.readFile(new File("Person.txt"))
}
