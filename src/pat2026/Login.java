package pat2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login {

    private String enteredCode;
    private String enteredPassword;
    private boolean loginSuccessful;

    public Login(String enteredCode, String enteredPassword) {
        this.enteredCode = enteredCode;
        this.enteredPassword = enteredPassword;
        this.loginSuccessful = false;
    }

    public boolean checkLogin() {
        try {
            Scanner scFile = new Scanner(new File("WorkerCodes.txt"));

            while (scFile.hasNextLine()) {
                String line = scFile.nextLine();

                if (line.isBlank()) {
                    continue;
                }

                Scanner scLine = new Scanner(line).useDelimiter(",");

                String fileCode = scLine.next().trim();
                String filePassword = scLine.next().trim();

                scLine.close();

                if (fileCode.equalsIgnoreCase(enteredCode) && filePassword.equals(enteredPassword)) {
                    loginSuccessful = true;
                    break;
                }
            }

            scFile.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Worker code file not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return loginSuccessful;
    }

    // Checks login, then sends managers to ManagerHome and workers to WorkerHome
    public void attemptLogin(JFrame currentFrame) {
        if (!checkLogin()) {
            JOptionPane.showMessageDialog(currentFrame, "Invalid worker code or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // NEW: a code containing "MAN" is a manager, so open the manager screen
        if (enteredCode.toUpperCase().contains("MAN")) {
            ManagerHome managerHome = new ManagerHome();
            managerHome.setVisible(true);
            currentFrame.dispose();
            return; // stop here, managers do not need a worker profile
        }

        try {
            GetWorkerDetails details = new GetWorkerDetails();
            boolean found = details.getWorkerData(enteredCode);

            if (!found) {
                JOptionPane.showMessageDialog(currentFrame, "Login worked, but no matching profile was found.");
                return;
            }

            Worker loggedInWorker = details.getEmployee();

            WorkerHome home = new WorkerHome(loggedInWorker);
            home.setVisible(true);

            currentFrame.dispose();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(currentFrame, "Error reading worker details: " + e.getMessage());
        }
    }

    public String getEnteredCode() {
        return enteredCode;
    }
}