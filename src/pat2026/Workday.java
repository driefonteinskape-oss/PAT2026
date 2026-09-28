package pat2026;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Workday {
    private String jobID;
    private String workerCode;
    private LocalDate dateWorked;
    private LocalTime startTime, endTime, lunchStart, lunchEnd;
    private Duration lunchDuration, hoursWorked;
    private String typeOfWork;
    private int rowsCompleted;

    public Workday(String jobID, String workerCode, LocalDate dateWorked,
                   LocalTime startTime, LocalTime endTime,
                   LocalTime lunchStart, LocalTime lunchEnd,
                   Duration lunchDuration, Duration hoursWorked,
                   String typeOfWork, int rowsCompleted) {
        this.jobID = jobID;
        this.workerCode = workerCode;
        this.dateWorked = dateWorked;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lunchStart = lunchStart;
        this.lunchEnd = lunchEnd;
        this.lunchDuration = lunchDuration;
        this.hoursWorked = hoursWorked;
        this.typeOfWork = typeOfWork;
        this.rowsCompleted = rowsCompleted;
    }

    public String getJobID() { return jobID; }
    public String getWorkerCode() { return workerCode; }
    public LocalDate getDateWorked() { return dateWorked; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public LocalTime getLunchStart() { return lunchStart; }
    public LocalTime getLunchEnd() { return lunchEnd; }
    public Duration getLunchDuration() { return lunchDuration; }
    public Duration getHoursWorked() { return hoursWorked; }
    public String getTypeOfWork() { return typeOfWork; }
    public int getRowsCompleted() { return rowsCompleted; }
}