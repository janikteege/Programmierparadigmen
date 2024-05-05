// Zusammenarbeit: Janik Teege, Nele Hüsemann

enum LogLevel {
    Trace,
    Debug,
    Info,
    Warn,
    Error;
}

interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }
    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }
    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }
    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }
    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }
    void setLogLevel(LogLevel level);
    void log(LogLevel level, String format, Object... args);
}
class Logging {
    public static void main(String[] args) {
        Logger logger = new LeveledLogger(LogLevel.Trace, new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt"))));
        logger.trace("This is a trace message\n");
        logger.debug("This is a debug message\n");
        logger.info("This is an info message\n");
        logger.warn("This is a warning message\n");
        logger.error("This is an error message\n");
    }
}