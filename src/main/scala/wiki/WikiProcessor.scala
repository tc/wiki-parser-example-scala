package wiki

import java.io._
import org.apache.commons.io.FileUtils

object WikiProcessor{
  val ImageRegex = """(?i)[^\"/\*?<>|:]+\.(?:jpe?g|png|gif|svg)""".r

  /**
    *
    * @return A map of title, id, first_image
    */
  def extractFirstImage(xmlContent:String):String = {
    val xmlRoot = xml.XML.loadString(xmlContent)
    val title = xmlRoot \\ "page" \ "title" text
    val id = xmlRoot \\ "page" \ "id" text
    val content = xmlRoot \\ "page" \ "revision" \"text" text

    val imageIter = ImageRegex.findAllIn(content).take(1)

    var filename = if(imageIter.hasNext) imageIter.next else ""

    // clean filename if image came from infobox
    // the regex captures the whole line
    filename = if(filename.contains("= "))
                 filename.split("= ").last
               else
                 filename.replace("image=", "")

    "%s\t%s\t%s".format(title, id, filename)
  }

  def main(args:Array[String]){
    require(args.size == 1)

    val filename = args(0)
    val xmlContent = FileUtils.readFileToString(new File(filename))
    val output = WikiProcessor.extractFirstImage(xmlContent)

    println(output)
  }
}
