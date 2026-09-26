package pat2026;

import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock {

    private int hour;
    private int minute;
    private int second;

    private Timer timer;
    private JLabel lblClock;
    private JLabel lblDate;

    public Clock(JLabel lblClock, JLabel lblDate) {

        this.lblClock = lblClock;
        this.lblDate = lblDate;

        timer = new Timer(1000, e -> {
            lblClock.setText(getTime());
            lblDate.setText(getDate());
        });

        timer.start();
    }

    public String getTime() {

        LocalTime time = LocalTime.now();

        hour = time.getHour();
        minute = time.getMinute();
        second = time.getSecond();

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String getDate() {

        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return date.format(formatter);
    }
}