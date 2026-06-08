package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.String;

public class WorkerCode {
    private String workerCode;    
    // private int num;
    
    // Data for generating code
    private int codeNum;
    private int lastNum;
    private String[] typesOfWorkers = {"MAN", "GEN", "PIC", "PLU", "WAR"};
    private String codeNumString, codeWorkerType;
    
    
    public WorkerCode() throws IOException {        
        Scanner scFile = new Scanner(new File("WorkerCodes.txt"));
        
        while (scFile.hasNextLine()) {
            Scanner scLine = new Scanner(scFile.nextLine());
            
            if (scLine.hasNext()) { 
            String code = scLine.next();
        
            String num = code.substring(3, 6);
            lastNum = Integer.parseInt(num);
            }
            
            scLine.close();
        }
        
        scFile.close();
        
        codeNum = lastNum + 1;
        codeNumString = String.format("%03d", codeNum);
        
        // I asked Gemini to help me code this menu
        codeWorkerType = (String) JOptionPane.showInputDialog(null, "What is the worker's type?", "Worker Type.", JOptionPane.QUESTION_MESSAGE, null, typesOfWorkers, "GEN");
        
        if (codeWorkerType == null) {
            System.exit(0);
        }
        workerCode = codeWorkerType + codeNumString;
        
        PrintWriter genCode = new PrintWriter(new FileWriter("WorkerCodes.txt", true));
        
        genCode.println(workerCode);
        
        genCode.close();
        
    }
    
    /* Delete if do not know:
        public int getNum() throws FileNotFoundException {
        
        Scanner scFile = new Scanner(new File("WorkerCodes.txt"));

            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine());
                num =  Integer.parseInt(scLine.next().substring(3, 6));
                scLine.close();
            }
            
            scFile.close();
        return num;
    }
    */

    public String getWorkerCode() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("WorkerCodes.txt"));

            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine());
                workerCode = scLine.next();
                scLine.close();
            }
            
            scFile.close();
        return workerCode;
    }
    
    
        
}
