package org.ejml.dense.row;

import androidx.core.internal.view.SupportMenu;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.ejml.data.DMatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixComponent extends JPanel {
    BufferedImage image;

    public DMatrixComponent(int i, int i2) {
        this.image = new BufferedImage(i, i2, 1);
        setPreferredSize(new Dimension(i, i2));
        setMinimumSize(new Dimension(i, i2));
    }

    public synchronized void setMatrix(DMatrixD1 dMatrixD1) {
        renderMatrix(dMatrixD1, this.image, CommonOps_DDRM.elementMaxAbs(dMatrixD1));
        repaint();
    }

    public static void renderMatrix(DMatrixD1 dMatrixD1, BufferedImage bufferedImage, double d) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        double width2 = ((double) dMatrixD1.numCols) / ((double) bufferedImage.getWidth());
        double height2 = ((double) dMatrixD1.numRows) / ((double) bufferedImage.getHeight());
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                double d2 = dMatrixD1.get((int) (((double) i) * height2), (int) (((double) i2) * width2));
                if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    bufferedImage.setRGB(i2, i, -16777216);
                } else if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    int i3 = 255 - ((int) ((d2 / d) * 255.0d));
                    bufferedImage.setRGB(i2, i, i3 | (i3 << 8) | SupportMenu.CATEGORY_MASK);
                } else {
                    int i4 = ((int) ((d2 / d) * 255.0d)) + 255;
                    bufferedImage.setRGB(i2, i, (i4 << 8) | (i4 << 16) | (-16777216) | 255);
                }
            }
        }
    }

    public synchronized void paint(Graphics graphics) {
        graphics.drawImage(this.image, 0, 0, this);
    }
}
