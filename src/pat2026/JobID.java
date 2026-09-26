package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.String;

public class JobID {

    // Data for generating code
    private int codeNum;
    private int lastNum;
    private String codeNumString, jobIDCode, jobID;

    public JobID() throws IOException {
        genJobID();

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
    private void genJobID() throws IOException {
        Scanner scFile = new Scanner(new File("JobID.txt"));

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
        codeNumString = String.format("%04d", codeNum);

        jobIDCode = "#" + codeNumString;

        PrintWriter genJobIDCode = new PrintWriter(new FileWriter("JobID.txt", true));

        genJobIDCode.println(jobIDCode);

        genJobIDCode.close();

    }
    
    public String getJobIDCode() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("JobID.txt"));

            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine());
                jobID = scLine.next();
                
                scLine.close();
            }
            
            scFile.close();
        return jobID;
    }
    
}
