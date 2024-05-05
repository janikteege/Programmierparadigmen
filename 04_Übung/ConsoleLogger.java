// Zusammenarbeit: Janik Teege, Nele Hüsemann

class ConsoleLogger extends BaseLogger {

    public ConsoleLogger(Logger loggerDecorator) {
        super(loggerDecorator);
    }

    public void log(LogLevel level, String format, Object... args) {
        System.out.printf(String.format(format, args));
        if (this.logger != null) {
            this.logger.log(level, format, args);
        }
    }
}