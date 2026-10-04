package org.ejml.dense.row;

import javax.swing.JFrame;
import org.ejml.data.DMatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class DMatrixVisualization {
    public static void show(DMatrixD1 dMatrixD1, String str) {
        int i;
        JFrame jFrame = new JFrame(str);
        int i2 = 300;
        if (dMatrixD1.numRows > dMatrixD1.numCols) {
            i2 = (dMatrixD1.numCols * 300) / dMatrixD1.numRows;
            i = 300;
        } else {
            i = (dMatrixD1.numRows * 300) / dMatrixD1.numCols;
        }
        DMatrixComponent dMatrixComponent = new DMatrixComponent(i2, i);
        dMatrixComponent.setMatrix(dMatrixD1);
        jFrame.add(dMatrixComponent, "Center");
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
