package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class GetWorkerWorkdays {

    private Workday[] workdays = new Workday[600]; // max workdays kept for one worker
    private int count = 0;                         // how many slots are actually filled
    private String jobID, workerCode, typeOfWork;
    private LocalDate dateWorked;
    private LocalTime startTime, endTime, lunchStart, lunchEnd;
    private Duration lunchDuration, hoursWorked;
    private int rowsCompleted;

    public GetWorkerWorkdays() throws IOException {
    }

    // Reads every record in WorkdayDetails.txt and keeps the ones that
    // belong to codeToFind. Returns true if at least one was found.
    public boolean getWorkdayData(String codeToFind) throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("WorkdayDetails.txt"));
        count = 0; // start with an empty array each time

        while (scFile.hasNextLine()) {
            String lineOfJobID = scFile.nextLine();

            if (lineOfJobID.isBlank()) {
                continue;
            }

            // Line looks like: JobID: #0001<tab>Worker Code: GEN001
            jobID = lineOfJobID.substring(lineOfJobID.indexOf(":") + 1, lineOfJobID.indexOf("\t")).trim();
            workerCode = lineOfJobID.substring(lineOfJobID.lastIndexOf(":") + 1).trim();

            scFile.nextLine(); // discard the "----" separator line

            String lineOfDate = scFile.nextLine();
            dateWorked = LocalDate.parse(lineOfDate.substring(lineOfDate.indexOf(":") + 1).trim());

            String lineOfStart = scFile.nextLine();
            startTime = LocalTime.parse(lineOfStart.substring(lineOfStart.indexOf(":") + 1).trim());

            String lineOfEnd = scFile.nextLine();
            endTime = LocalTime.parse(lineOfEnd.substring(lineOfEnd.indexOf(":") + 1).trim());

            String lineOfLunchStart = scFile.nextLine();
            lunchStart = LocalTime.parse(lineOfLunchStart.substring(lineOfLunchStart.indexOf(":") + 1).trim());

            String lineOfLunchEnd = scFile.nextLine();
            lunchEnd = LocalTime.parse(lineOfLunchEnd.substring(lineOfLunchEnd.indexOf(":") + 1).trim());

            String lineOfLunchDuration = scFile.nextLine();
            lunchDuration = toDuration(lineOfLunchDuration.substring(lineOfLunchDuration.indexOf(":") + 1).trim());

            String lineOfHoursWorked = scFile.nextLine();
            hoursWorked = toDuration(lineOfHoursWorked.substring(lineOfHoursWorked.indexOf(":") + 1).trim());

            String lineOfType = scFile.nextLine();
            typeOfWork = lineOfType.substring(lineOfType.indexOf(":") + 1).trim();

            String lineOfRows = scFile.nextLine();
            rowsCompleted = Integer.parseInt(lineOfRows.substring(lineOfRows.indexOf(":") + 1).trim());

            // No break: a worker can have many workdays, so we read to the end of the file.
            if (workerCode.equalsIgnoreCase(codeToFind) && count < workdays.length) {
                workdays[count] = new Workday(jobID, workerCode, dateWorked, startTime, endTime,
                        lunchStart, lunchEnd, lunchDuration, hoursWorked, typeOfWork, rowsCompleted);
                count++;
            }
        }

        scFile.close();
        return count > 0;
    }

    // Turns "6 hour(s) 0 minute(s)" back into a Duration
    private Duration toDuration(String text) {
        
        int hours = Integer.parseInt(text.substring(0, text.indexOf(" hour")).trim());
        int minutes = Integer.parseInt(text.substring(text.indexOf(")") + 1, text.indexOf(" minute")).trim());
        return Duration.ofHours(hours).plusMinutes(minutes);
        
    }

    public Workday[] getWorkdays() {
        return workdays;
    }

    public int getCount() {
        return count;
    }
}