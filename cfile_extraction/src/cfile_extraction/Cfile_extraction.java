
/*
* Programme to extract keywords from a C file 
* Import Scanner for reading files
* Import Vector for stroring the keywords
* Import io.* for files
* logger for writing to log files in case of exception
*/
package cfile_extraction;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shadowwalker
 */
public class Cfile_extraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            // Create file if not exist ie input.c
            // which would contain the required C code 
            // initialise vector for strings  
            File file = new File("input.c");
            Vector<String> v = new Vector<String> ();
          
            // add the required elements to the required vector
            
            v.addElement("auto");
            v.addElement("enum");
            v.addElement("else");
            v.addElement("double");
            v.addElement("do");
            v.addElement("default");
            v.addElement("continue");
            v.addElement("break");    
            v.addElement("case");
            v.addElement("char");
            v.addElement("const");
            v.addElement("short");
            v.addElement("return");
            v.addElement("register");
            v.addElement("long");
            v.addElement("int");
            v.addElement("if");
            v.addElement("goto");    
            v.addElement("for");
            v.addElement("float");
            v.addElement("extern");
            v.addElement("while");
            v.addElement("void");
            v.addElement("unsigned");
            v.addElement("union");
            v.addElement("typedef");
            v.addElement("switch");
            v.addElement("struct");    
            v.addElement("static");
            v.addElement("sizeof");
            v.addElement("signed");

            // Creating a scanner that would read words from the input file
            //Creating a Printwriter that would write to the output file 
            
            Scanner sc = new Scanner(file);
            PrintWriter pw = new PrintWriter("output.txt");
            String[] arr = {};
            
            //Checking if next word exists
            while (sc.hasNextLine()) {
                String key = sc.nextLine();
                //splitting the required words for with sample regex symbols and checking 
                // if they are present in the vector
                // if they are present then print it to the file.
                
                if (key.contains("//") || key.contains("*/") || key.contains("/*")) {
                    continue;
                }
                
                //System.out.println(key);
                
                String[] val = key.split("[.;%\\(){}''#&<> ,\"\"]");
                int i;
                
                for (i = 0; i < val.length; i++) {
                
                    val[i] = val[i].trim();
                    if (val[i].length() > 1) {
                         if (v.contains(val[i])) {
                            //System.out.println(val[i]);
                             pw.print(val[i]+"\n");
                         }
                    }
                   
                }
           
            }
           //closing the opened files
            
           sc.close();
           pw.close();
           
           //catch for file exceptions
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cfile_extraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
