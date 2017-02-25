/*
 * The MIT License
 *
 * Copyright 2017 Google Developer Group Torino.
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
package it.gdgtorino.hashcode;

import it.gdgtorino.hashcode.io.InputData;
import it.gdgtorino.hashcode.io.OutputData;
import it.gdgtorino.hashcode.utils.Utility;

import static it.gdgtorino.hashcode.utils.Constants.INPUT_FILENAME;

/**
 * The Worker class contains the implementation of the real algorithm; all the "magic" happens here.
 * Please note that this is a Singleton class and indeed the inner class WorkerHolder actually holds
 * the instance of Worker, which is basically the only one available in the source code.
 *
 * @author Marco Terrinoni <marco.terrinoni@gmail.com>
 */
public class Worker {

    private InputData inputData; // this will hold the input data
    private OutputData outputData; // this will hold the output data
    private final Utility utils;

    /**
     * Private constructor; it's not available outside this class.
     */
    private Worker () {
        utils = Utility.getInstance();
    }

    /**
     * The method return the same Worker instance all the time.
     *
     * @return Worker
     */
    public static Worker getInstance () {
        return WorkerHolder.INSTANCE;
    }

    /**
     * This inner class contains the unique Worker class instance.
     */
    private static class WorkerHolder {

        private static final Worker INSTANCE = new Worker();
    }

    /**
     * Main method for Worker class; it executes the real algorithm.
     * The structure of this method consists in:
     * 1. initial input acquisition phase;
     * 2. intermediate elaboration;
     * 3. output generation phase.
     */
    public void execute () {
        System.out.println("Main execution starts for " + INPUT_FILENAME + " file");

        // Initial input acquisition
        inputData = utils.read();

        // Intermediate elaboration
        outputData = new OutputData();
        outputData.setFirstValue(inputData.getFirstValue() + inputData.getSecondValue());
        outputData.setSecondValue(inputData.getThirdValue() - inputData.getFourthValue());
        System.out.println("Output data created: " + outputData.toString());

        // Final output generation
        utils.write(outputData);

        System.out.println("Main execution correctly completed");
    }
}
