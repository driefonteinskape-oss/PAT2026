package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GetWorkerDetails {

    private Worker employee;
    private String workerCode, password, name, surname, gender, dob, age,
            dateStarted, serviceYears, role, type, group, wage, status;

    public GetWorkerDetails() throws IOException {
    }

    // Now takes the code we're searching for, and only builds
    // the Worker object once it finds a matching record.
    public boolean getWorkerData(String codeToFind) throws FileNotFoundException {
    Scanner scFile = new Scanner(new File("WorkerDetails.txt"));
    boolean found = false;

    while (scFile.hasNextLine()) {
        String lineOfWorkerCode = scFile.nextLine();

        if (lineOfWorkerCode.isBlank()) {
            continue;
        }

        workerCode = lineOfWorkerCode.substring(lineOfWorkerCode.indexOf(":") + 1, lineOfWorkerCode.indexOf("(") - 1).trim();
        password = lineOfWorkerCode.substring(lineOfWorkerCode.indexOf("(") + 9, lineOfWorkerCode.indexOf(")") - 1);

        scFile.nextLine(); // discard the "----" separator line

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
        
        String lineOfStatus = scFile.nextLine();
        status = lineOfStatus.substring(lineOfStatus.indexOf(":") + 1).trim();

        if (workerCode.equalsIgnoreCase(codeToFind)) {
            employee = new Worker(workerCode, name, surname, gender, dob, age,
                    dateStarted, serviceYears, role, type, group, wage, status);
            found = true;
            break;
        }
        
    }

    scFile.close();
    return found;
}

    public Worker getEmployee() {
        return employee;
    }
}