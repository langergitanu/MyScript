package org.ejml.dense.row;

import androidx.core.internal.view.SupportMenu;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.ejml.data.FMatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrixComponent extends JPanel {
    BufferedImage image;

    public FMatrixComponent(int i, int i2) {
        this.image = new BufferedImage(i, i2, 1);
        setPreferredSize(new Dimension(i, i2));
        setMinimumSize(new Dimension(i, i2));
    }

    public synchronized void setMatrix(FMatrixD1 fMatrixD1) {
        renderMatrix(fMatrixD1, this.image, CommonOps_FDRM.elementMaxAbs(fMatrixD1));
        repaint();
    }

    public static void renderMatrix(FMatrixD1 fMatrixD1, BufferedImage bufferedImage, float f) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        float width2 = fMatrixD1.numCols / bufferedImage.getWidth();
        float height2 = fMatrixD1.numRows / bufferedImage.getHeight();
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                float f2 = fMatrixD1.get((int) (i * height2), (int) (i2 * width2));
                if (f2 == 0.0f) {
                    bufferedImage.setRGB(i2, i, -16777216);
                } else if (f2 > 0.0f) {
                    int i3 = 255 - ((int) ((f2 / f) * 255.0f));
                    bufferedImage.setRGB(i2, i, i3 | (i3 << 8) | SupportMenu.CATEGORY_MASK);
                } else {
                    int i4 = ((int) ((f2 / f) * 255.0f)) + 255;
                    bufferedImage.setRGB(i2, i, (i4 << 8) | (i4 << 16) | (-16777216) | 255);
                }
            }
        }
    }

    public synchronized void paint(Graphics graphics) {
        graphics.drawImage(this.image, 0, 0, this);
    }
}
