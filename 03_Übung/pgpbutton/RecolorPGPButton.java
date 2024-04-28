// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.awt.*;
import java.util.Random;


public class RecolorPGPButton extends PGPButton {
    public RecolorPGPButton(String label) {
        super(label);
        this.setOpaque(true);
    }

    private void recolor() {
        Random rand = new Random();
        Color newColor = new Color(
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256));
        this.setBackground(newColor);
        this.repaint();
    }

    @Override
    public void click() {
        super.click();
        recolor();
    }
}
