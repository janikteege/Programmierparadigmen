// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class TimestampedLogger extends BaseLogger {

    public TimestampedLogger(Logger loggerDecorator) {
        super(loggerDecorator);
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.logger != null) {
            this.logger.log(level, String.format("%s %s", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), String.format(format, args)));
        }
    }
}
