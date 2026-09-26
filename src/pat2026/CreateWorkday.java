package pat2026;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateWorkday {
    // Direct Workday Details
    private String workerCode; // Links this workday record back to a specific worker
    private String jobID, typeOfWork, rowsString;
    private int rowsDone;

    private LocalTime startTime, endTime;
    private LocalTime lunchStart, lunchEnd;

    // Details used for time input (same pattern as DOB in CreateWorker)
    private int startHour, startMinute;
    private int endHour, endMinute;
    private int lunchStartHour, lunchStartMinute;
    private int lunchEndHour, lunchEndMinute;

    private LocalDate dateWorked = LocalDate.now(); // Day the workday is being logged for

    private Duration lunchDuration;
    private Duration hoursWorked;


    public CreateWorkday() throws IOException {
        JobID job = new JobID();
        jobID = job.getJobIDCode();
    }

    // Setting of the values needed
    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public void setLunchStartHour(int lunchStartHour) {
        this.lunchStartHour = lunchStartHour;
    }

    public void setLunchStartMinute(int lunchStartMinute) {
        this.lunchStartMinute = lunchStartMinute;
    }

    public void setLunchEndHour(int lunchEndHour) {
        this.lunchEndHour = lunchEndHour;
    }

    public void setLunchEndMinute(int lunchEndMinute) {
        this.lunchEndMinute = lunchEndMinute;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public void setRowsDone(int rowsDone) {
        this.rowsDone = rowsDone;
    }

    public void logWorkday(String workerCode) throws IOException {
        this.workerCode = workerCode;

        startTime = LocalTime.of(startHour, startMinute);
        lunchStart = LocalTime.of(lunchStartHour, lunchStartMinute);
        lunchEnd = LocalTime.of(lunchEndHour, lunchEndMinute);
        endTime = LocalTime.of(endHour, endMinute);

        // Calculate hours actually worked (total time minus lunch break)
        lunchDuration = Duration.between(lunchStart, lunchEnd);
        hoursWorked = Duration.between(startTime, endTime).minus(lunchDuration);

        rowsString = String.valueOf(rowsDone);

        PrintWriter workdayDetails = new PrintWriter(new FileWriter("WorkdayDetails.txt", true));
        workdayDetails.println(DetailsDisplay());
        workdayDetails.close();
    }

    public String DetailsDisplay() {
        return "JobID: " + jobID + "\tWorker Code: " + workerCode
                + "\n--------------------------------------------------------------------------------------------------\n"
                + "Date Worked: " + dateWorked
                + "\nStart Time: " + startTime + "\nEnd Time: " + endTime
                + "\nLunch Start: " + lunchStart + "\nLunch End: " + lunchEnd
                + "\nLunch Duration: " + lunchDuration.toHours() + " hour(s) " + lunchDuration.toMinutesPart() + " minute(s)"
                + "\nHours Worked (excl. lunch): " + hoursWorked.toHours() + " hour(s) " + hoursWorked.toMinutesPart() + " minute(s)"
                + "\nType of Work: " + typeOfWork + "\nRows Completed: " + rowsString + "\n";
    }
}