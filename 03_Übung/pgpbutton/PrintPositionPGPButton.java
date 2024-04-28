// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.awt.*;

public class PrintPositionPGPButton extends PGPButton {
    public PrintPositionPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        Point myLocation = this.getLocation();
        System.out.printf("I'm the button at (%d, %d)\n",
                myLocation.x,
                myLocation.y);
    }
}

