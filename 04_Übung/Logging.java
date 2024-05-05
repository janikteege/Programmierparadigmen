// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

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

class ConsoleLogger implements Logger {
    private Logger logger;
    private LogLevel logLevel = LogLevel.Info;

    public ConsoleLogger(Logger loggerDecorator) {
        this.logger = loggerDecorator;
    }

    public void setLogLevel(LogLevel level) {
        if (this.logger != null) {
            this.logger.setLogLevel(level);
        }
        this.logLevel = level;
    }

    // "[%s] %s: %s\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), level, 
    public void log(LogLevel level, String format, Object... args) {
        System.out.printf(String.format(format, args));
        if (this.logger != null) {
            this.logger.log(level, format, args);
        }
    }
}

class FileLogger implements Logger {
    private Logger logger;
    private LogLevel logLevel = LogLevel.Info;
    private FileWriter fileWriter;

    public FileLogger(String filename) {
        try {
            this.fileWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileLogger(Logger loggerDecorator) {
        this.logger = loggerDecorator;
    }

    public void setLogLevel(LogLevel level) {
        if (this.logger != null) {
            this.logger.setLogLevel(level);
        }
        this.logLevel = level;
    }
    
    public void log(LogLevel level, String format, Object... args) {
        try {
            this.fileWriter.write(String.format(format, args));
            this.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.logger != null) {
            this.logger.log(level, format, args);
        }
    }
}

class TimestampedLogger implements Logger {
    private Logger logger;
    private LogLevel logLevel = LogLevel.Info;

    public TimestampedLogger(Logger loggerDecorator) {
        this.logger = loggerDecorator;
    }

    public void setLogLevel(LogLevel level) {
        if (this.logger != null) {
            this.logger.setLogLevel(level);
        }
        this.logLevel = level;
    }

    // "[%s] %s: %s\n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), level, 
    public void log(LogLevel level, String format, Object... args) {
        if (this.logger != null) {
            this.logger.log(level, String.format("%s %s", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), String.format(format, args)));
        }
    }
}

class LeveledLogger implements Logger {
    private Logger logger;
    private LogLevel logLevel;

    public LeveledLogger(LogLevel level, Logger loggerDecorator) {
        this.logLevel = level;
        this.logger = loggerDecorator;
    }

    @Override
    public void setLogLevel(LogLevel level) {
        if (this.logger != null) {
            this.logger.setLogLevel(level);
        }
        this.logLevel = level;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if (level.compareTo(this.logLevel) >= 0 && this.logger != null) {
            this.logger.log(level, String.format("[%s] %s", level, String.format(format, args)));
        }
    }
    
}

class Logging {
    public static void main(String[] args) {
        Logger logger = new LeveledLogger(LogLevel.Error, new TimestampedLogger(new ConsoleLogger(new FileLogger("log.txt"))));
        logger.trace("This is a trace message\n");
        logger.debug("This is a debug message\n");
        logger.info("This is an info message\n");
        logger.warn("This is a warning message\n");
        logger.error("This is an error message\n");
    }
}