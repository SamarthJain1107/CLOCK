import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDateDisplay {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Time and Date Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setForeground(Color.GREEN);
        frame.add(timeLabel);

        JLabel dayLabel = new JLabel("", JLabel.CENTER);
        dayLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        frame.add(dayLabel);

        JLabel dateLabel = new JLabel("", JLabel.CENTER);
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 30));
        frame.add(dateLabel);

        frame.setLayout(new GridLayout(3, 1));
        frame.setVisible(true);

        updateTimeDateLabels(timeLabel, dayLabel, dateLabel);
    }

    public static void updateTimeDateLabels(JLabel timeLabel, JLabel dayLabel, JLabel dateLabel) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        Timer timer = new Timer(1000, e -> {
            String time = timeFormat.format(new Date());
            String day = dayFormat.format(new Date());
            String date = dateFormat.format(new Date());

            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);
        });

        timer.setInitialDelay(0);
        timer.start();
    }
}
