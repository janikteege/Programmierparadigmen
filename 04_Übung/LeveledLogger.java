// Zusammenarbeit: Janik Teege, Nele Hüsemann

class LeveledLogger extends BaseLogger {
    public LeveledLogger(LogLevel level, Logger loggerDecorator) {
        super(loggerDecorator);
        this.logLevel = level;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if (level.compareTo(this.logLevel) >= 0 && this.logger != null) {
            this.logger.log(level, String.format("[%s] %s", level, String.format(format, args)));
        }
    }
    
}
