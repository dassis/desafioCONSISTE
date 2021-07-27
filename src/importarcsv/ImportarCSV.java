package importarcsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * @author Daniel
 */
public class ImportarCSV {

    public static void main(String[] args) {
           
      File file = new File("C:\\Users\\daniel\\Desktop\\dataset.CSV");
      
      try{
          String line = new String();
          Scanner sc = new Scanner(file);
          sc.nextLine();
          
          while(sc.hasNext()){
              line = sc.nextLine();
              String[] vet = line.split(";");
              String nome1 = vet[0].trim();
              String sobrenome = vet[1].trim();
              String nome = nome1 + " " + sobrenome;
              Double peso = Double.parseDouble(vet[2].replaceAll(",", "."));
              Double altura = Double.parseDouble(vet[3].replaceAll(",", "."));
              Double IMC =  peso / (altura*altura);
              
              
              System.out.printf("\n%s %.2f", nome.toUpperCase(), IMC);
              
              FileWriter arq = new FileWriter("C:\\Users\\Daniel\\Desktop\\Daniel.txt");
              PrintWriter grava = new PrintWriter(arq);
              grava.printf("\n%s %.2f", nome.toUpperCase(), IMC);
              arq.close();
              
          }
      }
      catch(IOException e){
          System.out.println("ERRO:" + e.getMessage());
      }
      
      
    }
    
}