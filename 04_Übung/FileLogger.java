// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.io.FileWriter;
import java.io.IOException;

class FileLogger extends BaseLogger {
    private FileWriter fileWriter;

    public FileLogger(String filename) {
        super(null);
        try {
            this.fileWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // bad idea to use this constructor
    
    // public FileLogger(Logger loggerDecorator) {
    //     super(loggerDecorator);
    // }
    
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