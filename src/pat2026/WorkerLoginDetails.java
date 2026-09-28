package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.String;

public class WorkerLoginDetails {
    private String workerCode, workerPassword;    
    // private int num;
    
    // Data for generating code
    private int codeNum;
    private int lastNum;
    private String[] rolesOfWorkers = {"MAN", "GEN", "PIC", "PLU", "WAR"};
    private String codeNumString, codeWorkerRole, password;
    
    
    public WorkerLoginDetails() throws IOException {        
        genWorkerLoginDetails();
        
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
    
    private void genWorkerLoginDetails() throws IOException {
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
        codeWorkerRole = (String) JOptionPane.showInputDialog(null, "What is the worker's role?", "Worker Role.", JOptionPane.QUESTION_MESSAGE, null, rolesOfWorkers, "GEN");
        
        if (codeWorkerRole == null) {
            System.exit(0);
        }
        
        workerCode = codeWorkerRole + codeNumString;
        
        password = "#" + codeNumString;
        
        PrintWriter genCode = new PrintWriter(new FileWriter("WorkerCodes.txt", true));
        
        genCode.println(workerCode + "," + password);
        
        genCode.close();
    }
    
    public String getWorkerCode() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("WorkerCodes.txt"));

            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter(",");
                workerCode = scLine.next();
                workerPassword = scLine.next();
                
                scLine.close();
            }
            
            scFile.close();
        return workerCode + "," + workerPassword;
    }
    
        
}
