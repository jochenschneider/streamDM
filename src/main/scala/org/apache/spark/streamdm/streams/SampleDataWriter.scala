/*
 * Copyright (C) 2015 Holmes Team at HUAWEI Noah's Ark Lab.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.spark.streamdm.streams

import com.github.javacliparser.{ IntOption, StringOption, ClassOption }
import org.apache.spark.streamdm.streams.generators._

/**
 * FileWriter use generator to generate data and save to file or HDFS for simulation or test.
 *
 * <p>It uses the following options:
 * <ul>
 *  <li> Chunk number (<b>-n</b>)
 *  <li> File Name (<b>-f</b>)
 *  <li> Generator (<b>-g</b>)
 * </ul>
 */

class FileWriter {
  val chunkNumberOption: IntOption = new IntOption("chunkNumber", 'c',
    "Chunk Number", 1000, 1, Integer.MAX_VALUE)

  val fileNameOption: StringOption = new StringOption("fileName", 'f',
    "File Name", "./sampleData")

  val generatorOption: ClassOption = new ClassOption("generator", 'g',
    "generator to use", classOf[Generator], "xx")

  var generator: Generator = null

  def write(): Unit = {
    generator = generatorOption.getValue()
    if (generator != null)
      write(fileNameOption.getValue, generator.chunkSizeOption.getValue(), chunkNumberOption.getValue)
  }

  private def write(fileName: String, chunkSize: Int, chunkNumber: Int): Unit = {
    if (fileName.startsWith("HDFS")) writeToHDFS(fileName, chunkSize, chunkNumber)
    else writeToFile(fileName, chunkSize, chunkNumber)
  }

  private def writeToFile(fileName: String, chunkSize: Int, chunkNumber: Int): Unit = {

  }

  private def writeToHDFS(fileName: String, chunkSize: Int, chunkNumber: Int): Unit = {

  }

}

object SampleDataWriter {
  def main(args: Array[String]) {

  }

}