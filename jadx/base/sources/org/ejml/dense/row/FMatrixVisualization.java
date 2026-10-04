package org.ejml.dense.row;

import javax.swing.JFrame;
import org.ejml.data.FMatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class FMatrixVisualization {
    public static void show(FMatrixD1 fMatrixD1, String str) {
        int i;
        JFrame jFrame = new JFrame(str);
        int i2 = 300;
        if (fMatrixD1.numRows > fMatrixD1.numCols) {
            i2 = (fMatrixD1.numCols * 300) / fMatrixD1.numRows;
            i = 300;
        } else {
            i = (fMatrixD1.numRows * 300) / fMatrixD1.numCols;
        }
        FMatrixComponent fMatrixComponent = new FMatrixComponent(i2, i);
        fMatrixComponent.setMatrix(fMatrixD1);
        jFrame.add(fMatrixComponent, "Center");
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
