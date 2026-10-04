package org.ejml.equation;

import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class VariableMatrix extends Variable {
    public DMatrixRMaj matrix;
    public boolean temp;

    public VariableMatrix(DMatrixRMaj dMatrixRMaj) {
        super(VariableType.MATRIX);
        this.matrix = dMatrixRMaj;
    }

    public static VariableMatrix createTemp() {
        VariableMatrix variableMatrix = new VariableMatrix(new DMatrixRMaj(1, 1));
        variableMatrix.setTemp(true);
        return variableMatrix;
    }

    public boolean isTemp() {
        return this.temp;
    }

    public void setTemp(boolean z) {
        this.temp = z;
    }
}
