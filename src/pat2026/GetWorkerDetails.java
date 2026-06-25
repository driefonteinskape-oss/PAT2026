package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetWorkerDetails {
    Worker employee;
    String workerCode, name, surname, gender, dob, age, dateStarted, serviceYears, role, type, group, wage;
    
    public GetWorkerDetails() throws IOException {
        
        
        
    }
    
    private void getWorkerData() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("WorkerDetails.txt"));
        
        while (scFile.hasNextLine()) {
        
            
        String lineOfWorkerCode = scFile.nextLine();
        workerCode = lineOfWorkerCode.substring(lineOfWorkerCode.indexOf(":") + 1).trim();
        
        String lineOfName = scFile.nextLine();
        name = lineOfName.substring(lineOfName.indexOf(":") + 1).trim();
        
        String lineOfSurname = scFile.nextLine();
        surname = lineOfSurname.substring(lineOfSurname.indexOf(":") + 1).trim();
        
        String lineOfGender = scFile.nextLine();
        gender = lineOfGender.substring(lineOfGender.indexOf(":") + 1).trim();
        
        String lineOfDOB = scFile.nextLine();
        dob = lineOfDOB.substring(lineOfDOB.indexOf(":") + 1).trim();
        
        String lineOfAge = scFile.nextLine();
        age = lineOfAge.substring(lineOfAge.indexOf(":") + 1).trim();
        
        String lineOfDateStart = scFile.nextLine();
        dateStarted = lineOfDateStart.substring(lineOfDateStart.indexOf(":") + 1).trim();
        
        String lineofYearsInService = scFile.nextLine();
        serviceYears = lineofYearsInService.substring(lineofYearsInService.indexOf(":") + 1).trim();
        
        String lineOfRole = scFile.nextLine();
        role = lineOfRole.substring(lineOfRole.indexOf(":") + 1).trim();
        
        String lindeOfWorkerType = scFile.nextLine();
        type = lindeOfWorkerType.substring(lindeOfWorkerType.indexOf(":") + 1).trim();
        
        String lineOfGroup = scFile.nextLine();
        group = lineOfGroup.substring(lineOfGroup.indexOf(":") + 1).trim();
        
        String lineOfWage = scFile.nextLine();
        wage = lineOfWage.substring(lineOfWage.indexOf(":") + 1).trim();
            
        employee = new Worker(workerCode, name, surname, gender, dob, age, dateStarted, serviceYears, role, type, group, wage);
            
            if (scFile.hasNextLine()) {
                scFile.nextLine(); 
            }
            
        }
        
        scFile.close();
        
        
    }
    
    
    
}
