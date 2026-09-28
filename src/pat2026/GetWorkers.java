package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GetWorkers {

    private Worker[] workers = new Worker[200]; // max workers kept
    private int count = 0;                      // how many slots are actually filled

    public GetWorkers() throws IOException {
    }

    // Reads every record in WorkerDetails.txt and keeps all of them.
    // Returns true if at least one worker was found.
    public boolean getWorkerData() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("WorkerDetails.txt"));
        count = 0; // start with an empty array each time

        while (scFile.hasNextLine()) {
            String lineOfCode = scFile.nextLine();

            if (lineOfCode.isBlank()) {
                continue;
            }

            // Line looks like: WORKER CODE: PIC003<tab>(Password: #003)
            String workerCode = lineOfCode.substring(lineOfCode.indexOf(":") + 1,
                    lineOfCode.indexOf("(")).trim();

            scFile.nextLine(); // discard the "----" separator line

            String name = getValue(scFile.nextLine());
            String surname = getValue(scFile.nextLine());
            String gender = getValue(scFile.nextLine());
            String dob = getValue(scFile.nextLine());
            String age = getValue(scFile.nextLine());
            String dateStarted = getValue(scFile.nextLine());
            String serviceYears = getValue(scFile.nextLine());
            String type = getValue(scFile.nextLine());   // Type comes before Role in the file
            String role = getValue(scFile.nextLine());
            String group = getValue(scFile.nextLine());
            String wage = getValue(scFile.nextLine());
            String status = "Active"; // PLACEHOLDER: the file has no status line

            if (count < workers.length) {
                workers[count] = new Worker(workerCode, name, surname, gender, dob, age,
                        dateStarted, serviceYears, role, type, group, wage, status);
                count++;
            }
        }

        scFile.close();
        return count > 0;
    }

    // Takes "Worker Name: he" and returns "he"
    private String getValue(String line) {
        return line.substring(line.indexOf(":") + 1).trim();
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public int getCount() {
        return count;
    }
}