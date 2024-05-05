// Zusammenarbeit: Janik Teege, Nele Hüsemann

public class BaseLogger implements Logger{
    protected Logger logger;
    protected LogLevel logLevel = LogLevel.Info;

    public BaseLogger(Logger loggerDecorator) {
        this.logger = loggerDecorator;
    }

    public void setLogLevel(LogLevel level) {
        if (this.logger != null) {
            this.logger.setLogLevel(level);
        }
        this.logLevel = level;
    }

    public void log(LogLevel level, String format, Object... args) {
        if (this.logger != null) {
            this.logger.log(level, String.format(format, args));
        }
    }
}
