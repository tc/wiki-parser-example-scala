package wiki

import org.junit.{Test, Assert, Before, Ignore}
import org.junit.Assert._

import java.io._
import org.apache.commons.io.FileUtils

class WikiProcessorTest{

  @Test
  def testExtractFirstImage{
    val xmlContent = FileUtils.readFileToString(new File("src/test/resources/wiki-xml/New_York_City.xml"))
    val record = WikiProcessor.extractFirstImage(xmlContent)

    assertEquals("New York City\t645042\tNYC Montage 2011.jpg", record)
  }

  @Test
  def testOneLineFile{
    val xmlContent = FileUtils.readFileToString(new File("src/test/resources/wiki-xml/one_line.xml"))
    val record = WikiProcessor.extractFirstImage(xmlContent)

    assertEquals("New York City\t645042\tNYC Montage 2011.jpg", record)
  }
}
