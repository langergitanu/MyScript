package org.ejml.dense.row.decomposition.p050qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class QRColPivDecompositionHouseholderColumn_DDRM extends QRDecompositionHouseholderColumn_DDRM implements QRPDecomposition_F64<DMatrixRMaj> {
    protected double maxAbs;
    protected double[] normsCol;
    protected int[] pivots;
    protected int rank;
    protected double singularThreshold;

    public QRColPivDecompositionHouseholderColumn_DDRM(double d) {
        double d2 = UtilEjml.EPS;
        this.singularThreshold = d;
    }

    public QRColPivDecompositionHouseholderColumn_DDRM() {
        this.singularThreshold = UtilEjml.EPS;
    }

    @Override // org.ejml.interfaces.decomposition.QRPDecomposition_F64
    public void setSingularThreshold(double d) {
        this.singularThreshold = d;
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM
    public void setExpectedMaxSize(int i, int i2) {
        super.setExpectedMaxSize(i, i2);
        int[] iArr = this.pivots;
        if (iArr == null || iArr.length < i2) {
            this.pivots = new int[i2];
            this.normsCol = new double[i2];
        }
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM, org.ejml.interfaces.decomposition.QRDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (z) {
            if (dMatrixRMaj == null) {
                dMatrixRMaj = CommonOps_DDRM.identity(this.numRows, this.minLength);
            } else {
                if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != this.minLength) {
                    throw new IllegalArgumentException("Unexpected matrix dimension.");
                }
                CommonOps_DDRM.setIdentity(dMatrixRMaj);
            }
        } else if (dMatrixRMaj == null) {
            dMatrixRMaj = CommonOps_DDRM.identity(this.numRows);
        } else {
            if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != this.numRows) {
                throw new IllegalArgumentException("Unexpected matrix dimension.");
            }
            CommonOps_DDRM.setIdentity(dMatrixRMaj);
        }
        DMatrixRMaj dMatrixRMaj2 = dMatrixRMaj;
        for (int i = this.rank - 1; i >= 0; i--) {
            double[] dArr = this.dataQR[i];
            double d = dArr[i];
            dArr[i] = 1.0d;
            QrHelperFunctions_DDRM.rank1UpdateMultR(dMatrixRMaj2, dArr, this.gammas[i], i, i, this.numRows, this.f2621v);
            dArr[i] = d;
        }
        return dMatrixRMaj2;
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM, org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        convertToColumnMajor(dMatrixRMaj);
        this.maxAbs = CommonOps_DDRM.elementMaxAbs(dMatrixRMaj);
        setupPivotInfo();
        int i = 0;
        while (i < this.minLength) {
            if (i > 0) {
                updateNorms(i);
            }
            swapColumns(i);
            if (!householderPivot(i)) {
                return true;
            }
            updateA(i);
            i++;
            this.rank = i;
        }
        return true;
    }

    private void setupPivotInfo() {
        for (int i = 0; i < this.numCols; i++) {
            this.pivots[i] = i;
            double[] dArr = this.dataQR[i];
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            for (int i2 = 0; i2 < this.numRows; i2++) {
                double d2 = dArr[i2];
                d += d2 * d2;
            }
            this.normsCol[i] = d;
        }
    }

    private void updateNorms(int i) {
        for (int i2 = i; i2 < this.numCols; i2++) {
            double d = this.dataQR[i2][i - 1];
            double[] dArr = this.normsCol;
            double d2 = dArr[i2] - (d * d);
            dArr[i2] = d2;
            if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                for (int i3 = i; i3 < this.numCols; i3++) {
                    double[] dArr2 = this.dataQR[i3];
                    double d3 = 0.0d;
                    for (int i4 = i; i4 < this.numRows; i4++) {
                        double d4 = dArr2[i4];
                        d3 += d4 * d4;
                    }
                    this.normsCol[i3] = d3;
                }
                return;
            }
        }
    }

    private void swapColumns(int i) {
        double d = this.normsCol[i];
        int i2 = i;
        for (int i3 = i + 1; i3 < this.numCols; i3++) {
            double d2 = this.normsCol[i3];
            if (d2 > d) {
                i2 = i3;
                d = d2;
            }
        }
        double[] dArr = this.dataQR[i];
        this.dataQR[i] = this.dataQR[i2];
        this.dataQR[i2] = dArr;
        double[] dArr2 = this.normsCol;
        double d3 = dArr2[i];
        dArr2[i] = dArr2[i2];
        dArr2[i2] = d3;
        int[] iArr = this.pivots;
        int i4 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i4;
    }

    protected boolean householderPivot(int i) {
        double[] dArr = this.dataQR[i];
        double dFindMax = QrHelperFunctions_DDRM.findMax(dArr, i, this.numRows - i);
        if (dFindMax <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        this.tau = QrHelperFunctions_DDRM.computeTauAndDivide(i, this.numRows, dArr, dFindMax);
        double d = dArr[i] + this.tau;
        QrHelperFunctions_DDRM.divideElements(i + 1, this.numRows, dArr, d);
        this.gamma = d / this.tau;
        this.tau *= dFindMax;
        dArr[i] = -this.tau;
        if (Math.abs(this.tau) <= this.singularThreshold) {
            return false;
        }
        this.gammas[i] = this.gamma;
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.QRPDecomposition
    public int getRank() {
        return this.rank;
    }

    @Override // org.ejml.interfaces.decomposition.QRPDecomposition
    public int[] getColPivots() {
        return this.pivots;
    }

    @Override // org.ejml.interfaces.decomposition.QRPDecomposition
    public DMatrixRMaj getColPivotMatrix(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(this.numCols, this.numCols);
        } else {
            if (dMatrixRMaj.numRows != this.numCols) {
                throw new IllegalArgumentException("Number of rows must be " + this.numCols);
            }
            if (dMatrixRMaj.numCols != this.numCols) {
                throw new IllegalArgumentException("Number of columns must be " + this.numCols);
            }
            dMatrixRMaj.zero();
        }
        for (int i = 0; i < this.numCols; i++) {
            dMatrixRMaj.set(this.pivots[i], i, 1.0d);
        }
        return dMatrixRMaj;
    }
}
