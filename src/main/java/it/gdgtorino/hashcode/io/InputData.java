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

package it.gdgtorino.hashcode.io;

/**
 * Wrapper class for input data.
 * Just substitute the local variable with the real ones.
 *
 * @author Marco Terrinoni <marco.terrinoni@gmail.com>
 */
public class InputData {

  // First line values
  private int firstValue;
  private int secondValue;
  private int thirdValue;
  private int fourthValue;

  // Following lines data
  private Object data; // this is just a placeholder for the real data-structure

  public InputData() {
  }

  public InputData(int firstValue, int secondValue, int thirdValue, int fourthValue, Object data) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
    this.thirdValue = thirdValue;
    this.fourthValue = fourthValue;
    this.data = data;
  }

  public int getFirstValue() {
    return firstValue;
  }

  public void setFirstValue(int firstValue) {
    this.firstValue = firstValue;
  }

  public int getSecondValue() {
    return secondValue;
  }

  public void setSecondValue(int secondValue) {
    this.secondValue = secondValue;
  }

  public int getThirdValue() {
    return thirdValue;
  }

  public void setThirdValue(int thirdValue) {
    this.thirdValue = thirdValue;
  }

  public int getFourthValue() {
    return fourthValue;
  }

  public void setFourthValue(int fourthValue) {
    this.fourthValue = fourthValue;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "InputData{" + "firstValue=" + firstValue + ", secondValue=" + secondValue
        + ", thirdValue=" + thirdValue + ", fourthValue=" + fourthValue + ", data=" + data
        + '}';
  }

}
