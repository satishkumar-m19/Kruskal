package kruskal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStreamReader;

import java.util.Random;
//import java.util.Scanner;

public class GenerateInputFile {
  public static void main(String[] args) throws IOException {

      int noOfLines = 100;
      int min = 25;
      int max = 10000;
      String formattedline = null;
      Random random = new Random();
      int randomNumber1 = 0, randomNumber2 = 0;
      File file = new File("/home/sati/inputfile.txt");

      if (!file.exists()) {
          file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
     /*Use this part of code to read the input from user. Goto project settings and allow user input option before you execute.
      try {
          BufferedReader bufferRead =
              new BufferedReader(new InputStreamReader(System.in));
          noOfLines = bufferRead.readLine();
          System.out.println(s);
      } catch (IOException e) {
          e.printStackTrace();
      }
*/
      System.out.println(noOfLines);
      for (int i = 1; i <= noOfLines; i++) {
          randomNumber1 = random.nextInt(max - min) + min;
          randomNumber2 = random.nextInt(max - min) + min;
          if (i == 1) {
              bw.write(String.valueOf(noOfLines));
              bw.newLine();
          }
          System.out.println("<" + i + "," + randomNumber1 + "," +
                             randomNumber2 + ">");
          formattedline =
                  "<" + i + "," + randomNumber1 + "," + randomNumber2 + ">";
          bw.write(formattedline);
          bw.newLine();
      }
      bw.close();
  }
}
