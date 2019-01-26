/*
 * The MIT License
 *
 * Copyright 2019 Google Developer Group Torino.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package it.gdgtorino.hashcode.utils;

import it.gdgtorino.hashcode.io.InputData;
import it.gdgtorino.hashcode.io.OutputData;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Objects;
import java.util.Scanner;

import static it.gdgtorino.hashcode.utils.Constants.INPUT_FILENAME;
import static it.gdgtorino.hashcode.utils.Constants.OUTPUT_FILENAME;
import static it.gdgtorino.hashcode.utils.Constants.MSG_ERR_FIND_INPUT_FILE;
import static it.gdgtorino.hashcode.utils.Constants.MSG_ERR_CREATE_OUTPUT_FILE;
import static it.gdgtorino.hashcode.utils.Constants.MSG_ERR_FIND_OUTPUT_FILE;

/**
 * The Utility class provide some useful methods that can be accessible from other parts of the
 * code.
 * Please note that this is a Singleton class and indeed the inner class UtilityHolder actually
 * holds the instance of Utility, which is basically the only one available in the source code.
 *
 * @author Marco Terrinoni <marco.terrinoni@gmail.com>
 */
public class Utility {

  /**
   * Private constructor; it's not available outside this class.
   */
  private Utility() {
  }

  /**
   * The method return the same Utility instance all the time.
   *
   * @return Worker
   */
  public static Utility getInstance() {
    return UtilityHolder.INSTANCE;
  }

  /**
   * This inner class contains the unique Utility class instance.
   */
  private static class UtilityHolder {

    private static final Utility INSTANCE = new Utility();
  }

  /**
   * Reader method for input acquisition phase; it iterates over the input file and instantiates
   * an InputData class with the input values.
   *
   * @return InputData
   */
  public InputData read() {
    InputData inputData = new InputData(); // input wrapper initialization

    // Input acquisition phase starts here
    ClassLoader classLoader =
        getClass().getClassLoader(); // classloader useful to localize the file
    File file = new File(
        Objects.requireNonNull(classLoader.getResource(INPUT_FILENAME)).getFile()); // file loading
    try (
        Reader r = new FileReader(file);
        Scanner s = new Scanner(r)
    ) {
      // First line acquisition
      inputData.setFirstValue(s.nextInt());
      inputData.setSecondValue(s.nextInt());
      inputData.setThirdValue(s.nextInt());
      inputData.setFourthValue(s.nextInt());

      // Following lines acquisition
      /*
       * TODO: in this section the remaining lines of the input file are read
       */
    } catch (IOException ex) {
      System.err.println(MSG_ERR_FIND_INPUT_FILE);
      throw new RuntimeException(MSG_ERR_FIND_INPUT_FILE, ex);
    }

    System.out.println("Input data acquired: " + inputData.toString());

    return inputData;
  }

  /**
   * Writer method for output creation; it takes the information contained in the OutputData
   * instance and generates the output file.
   *
   * @param outputData the OutputData instance that contains the information to be printed in
   *     the output file.
   */
  public void write(OutputData outputData) {
    // Output acquisition phase starts here
    File file = new File(OUTPUT_FILENAME); // file loading
    if (!file.exists()) { // if the file doesn't exist create a new one
      try {
        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();
      } catch (IOException ex) {
        System.err.println(MSG_ERR_CREATE_OUTPUT_FILE);
        throw new RuntimeException(MSG_ERR_CREATE_OUTPUT_FILE, ex);
      }
    }
    try (
        PrintWriter pw = new PrintWriter(file)) { // use of PrintWriter instead of FileWriter
      pw.println(outputData.getFirstValue());
      pw.println(outputData.getSecondValue());

      /*
       * TODO: in this section the remaining lines of the output file are created
       */
    } catch (IOException ex) {
      System.err.println(MSG_ERR_FIND_OUTPUT_FILE);
      throw new RuntimeException(MSG_ERR_FIND_OUTPUT_FILE, ex);
    }

    System.out.println("Output data file completed");
  }
}
