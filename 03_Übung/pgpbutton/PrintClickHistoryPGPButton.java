import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PrintClickHistoryPGPButton extends PGPButton {
    public PrintClickHistoryPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("I was clicked at %s", timestamp.format(formatter));
    }
}
