package pat2026;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class EditWorkerDetails {

    
    private static final int DATA_LINES = 12;
    
    public void updateWorkerDetails(String workerCode, String name, String surname, String gender,
            LocalDate dob, LocalDate startDate, String type, String role, String group, String wage, String status)
            throws IOException {

        int age = Period.between(dob, LocalDate.now()).getYears();
        int numOfYears = Period.between(startDate, LocalDate.now()).getYears();

        String updatedDataLines = "Worker Name: " + name
                + "\nWorker Surname: " + surname
                + "\nGender: " + gender
                + "\nDOB: " + dob
                + "\nAge: " + age
                + "\nDate started working on Farm: " + startDate
                + "\nNumber of years in service: " + numOfYears
                + "\nType of worker: " + type
                + "\nRole of worker: " + role
                + "\nGroup: " + group
                + "\nWage:" + wage
                + "\nStatus:" + status;

        File file = new File("WorkerDetails.txt");
        Scanner scFile = new Scanner(file);
        StringBuilder rebuiltFile = new StringBuilder();

        while (scFile.hasNextLine()) {
            String lineOfCode = scFile.nextLine();

            if (lineOfCode.isBlank()) {
                continue; 
            }

            String currentCode = lineOfCode.substring(
                    lineOfCode.indexOf(":") + 1, lineOfCode.indexOf("(") - 1).trim();

            String separatorLine = scFile.nextLine();

            rebuiltFile.append(lineOfCode).append("\n");
            rebuiltFile.append(separatorLine).append("\n");

            if (currentCode.equalsIgnoreCase(workerCode)) {
                // Discard the OLD data lines for this worker...
                for (int i = 0; i < DATA_LINES; i++) {
                    scFile.nextLine();
                }
                // ...and write the NEW data lines instead
                rebuiltFile.append(updatedDataLines).append("\n");
            } else {
                // Not the worker we're editing - copy their lines through unchanged
                for (int i = 0; i < DATA_LINES; i++) {
                    rebuiltFile.append(scFile.nextLine()).append("\n");
                }
            }

            rebuiltFile.append("\n");
        }

        scFile.close();

        // Overwrite the file completely with the rebuilt content
        PrintWriter writer = new PrintWriter(new FileWriter(file, false));
        writer.print(rebuiltFile.toString());
        writer.close();
    }
}