package pat2026;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import javax.swing.JOptionPane;

public class MakeNewWorker {
    // Direct Worker Details
    private WorkerCode code = new WorkerCode(); // Unigue worker code
    
    private String workerName, workerSurname, workerType;
    private int age, numOfYears;
    private char gender;
    private double wage;
    
    private LocalDate DOB;
    private LocalDate startWork; //Date worker started working on farm
    
    //Details used for Direct Worker Details
    private LocalDate dateNow = LocalDate.now();
    
    private int yearDOB, monthDOB, dayDOB; //Details for DOB
    private int yearStart, monthStart, dayStart; //Details for startWork
    
    private Period diffAge;
    private Period diffWork;
    
    
    public MakeNewWorker() throws IOException {
        workerName = JOptionPane.showInputDialog("What is the worker's name?");
        workerSurname = JOptionPane.showInputDialog("What is the worker's surname?");
        
        gender = JOptionPane.showInputDialog("Enter the worker's gender").charAt(0);        
        
        // Input DOB specifications
        yearDOB = Integer.parseInt(JOptionPane.showInputDialog("Input year of DOB"));
        monthDOB = Integer.parseInt(JOptionPane.showInputDialog("Input month of DOB"));
        dayDOB = Integer.parseInt(JOptionPane.showInputDialog("Input day of DOB"));
        
        DOB = LocalDate.of(yearDOB, monthDOB, dayDOB);
        diffAge = Period.between(DOB, dateNow);
        age = diffAge.getYears();
        
        //Input Starting date specifications
        yearStart = Integer.parseInt(JOptionPane.showInputDialog("Input year of Start"));
        monthStart = Integer.parseInt(JOptionPane.showInputDialog("Input month of Start"));
        dayStart = Integer.parseInt(JOptionPane.showInputDialog("Input day of Start"));
        
        startWork = LocalDate.of(yearStart,monthStart, dayStart);
        diffWork = Period.between(startWork, dateNow);
        numOfYears = diffWork.getYears();
        
        workerType = JOptionPane.showInputDialog("What is the worker's type?");
        
        wage = Double.parseDouble(JOptionPane.showInputDialog("Give Worker Wage"));
        
        
        
        PrintWriter workerDetails = new PrintWriter(new FileWriter("WorkerDetails.txt", true));
        
        workerDetails.println(toString());
        
        workerDetails.close();
        
    }
    
    
    
    // Setting of the alues needed
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }


    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }


    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }


    public void setGender(char gender) {
        this.gender = gender;
    }


    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setStartWork(LocalDate startWork) {
        this.startWork = startWork;
    }

    public void setYearDOB(int yearDOB) {
        this.yearDOB = yearDOB;
    }

    public void setMonthDOB(int monthDOB) {
        this.monthDOB = monthDOB;
    }

    public void setDayDOB(int dayDOB) {
        this.dayDOB = dayDOB;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public void setMonthStart(int monthStart) {
        this.monthStart = monthStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public String toString() {
        return "WORKER 0001:\n--------------------------------------------------------------------------------------------------\n"
                + "Worker Name: " + workerName + "\nWorker Surname: " + workerSurname  + "\nGender: " + gender  
                + "\nDOB: " + DOB + "\nAge: " + age + "\nDate started working on Farm: " + startWork + "\nNumber of years in service: " + numOfYears + "\nType of Worker: " + workerType
                + "\nWage:" + wage + "\n";
    }
    
    
    
    
    
}
