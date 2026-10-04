package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class QRColPivDecompositionHouseholderColumn_FDRM extends QRDecompositionHouseholderColumn_FDRM implements QRPDecomposition_F32<FMatrixRMaj> {
    protected float maxAbs;
    protected float[] normsCol;
    protected int[] pivots;
    protected int rank;
    protected float singularThreshold;

    public QRColPivDecompositionHouseholderColumn_FDRM(float f) {
        float f2 = UtilEjml.F_EPS;
        this.singularThreshold = f;
    }

    public QRColPivDecompositionHouseholderColumn_FDRM() {
        this.singularThreshold = UtilEjml.F_EPS;
    }

    @Override // org.ejml.interfaces.decomposition.QRPDecomposition_F32
    public void setSingularThreshold(float f) {
        this.singularThreshold = f;
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM
    public void setExpectedMaxSize(int i, int i2) {
        super.setExpectedMaxSize(i, i2);
        int[] iArr = this.pivots;
        if (iArr == null || iArr.length < i2) {
            this.pivots = new int[i2];
            this.normsCol = new float[i2];
        }
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM, org.ejml.interfaces.decomposition.QRDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        if (z) {
            if (fMatrixRMaj == null) {
                fMatrixRMaj = CommonOps_FDRM.identity(this.numRows, this.minLength);
            } else {
                if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != this.minLength) {
                    throw new IllegalArgumentException("Unexpected matrix dimension.");
                }
                CommonOps_FDRM.setIdentity(fMatrixRMaj);
            }
        } else if (fMatrixRMaj == null) {
            fMatrixRMaj = CommonOps_FDRM.identity(this.numRows);
        } else {
            if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != this.numRows) {
                throw new IllegalArgumentException("Unexpected matrix dimension.");
            }
            CommonOps_FDRM.setIdentity(fMatrixRMaj);
        }
        FMatrixRMaj fMatrixRMaj2 = fMatrixRMaj;
        for (int i = this.rank - 1; i >= 0; i--) {
            float[] fArr = this.dataQR[i];
            float f = fArr[i];
            fArr[i] = 1.0f;
            QrHelperFunctions_FDRM.rank1UpdateMultR(fMatrixRMaj2, fArr, this.gammas[i], i, i, this.numRows, this.f2622v);
            fArr[i] = f;
        }
        return fMatrixRMaj2;
    }

    @Override // org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM, org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        convertToColumnMajor(fMatrixRMaj);
        this.maxAbs = CommonOps_FDRM.elementMaxAbs(fMatrixRMaj);
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
            float[] fArr = this.dataQR[i];
            float f = 0.0f;
            for (int i2 = 0; i2 < this.numRows; i2++) {
                float f2 = fArr[i2];
                f += f2 * f2;
            }
            this.normsCol[i] = f;
        }
    }

    private void updateNorms(int i) {
        for (int i2 = i; i2 < this.numCols; i2++) {
            float f = this.dataQR[i2][i - 1];
            float[] fArr = this.normsCol;
            float f2 = fArr[i2] - (f * f);
            fArr[i2] = f2;
            if (f2 < 0.0f) {
                for (int i3 = i; i3 < this.numCols; i3++) {
                    float[] fArr2 = this.dataQR[i3];
                    float f3 = 0.0f;
                    for (int i4 = i; i4 < this.numRows; i4++) {
                        float f4 = fArr2[i4];
                        f3 += f4 * f4;
                    }
                    this.normsCol[i3] = f3;
                }
                return;
            }
        }
    }

    private void swapColumns(int i) {
        float f = this.normsCol[i];
        int i2 = i;
        for (int i3 = i + 1; i3 < this.numCols; i3++) {
            float f2 = this.normsCol[i3];
            if (f2 > f) {
                i2 = i3;
                f = f2;
            }
        }
        float[] fArr = this.dataQR[i];
        this.dataQR[i] = this.dataQR[i2];
        this.dataQR[i2] = fArr;
        float[] fArr2 = this.normsCol;
        float f3 = fArr2[i];
        fArr2[i] = fArr2[i2];
        fArr2[i2] = f3;
        int[] iArr = this.pivots;
        int i4 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i4;
    }

    protected boolean householderPivot(int i) {
        float[] fArr = this.dataQR[i];
        float fFindMax = QrHelperFunctions_FDRM.findMax(fArr, i, this.numRows - i);
        if (fFindMax <= 0.0f) {
            return false;
        }
        this.tau = QrHelperFunctions_FDRM.computeTauAndDivide(i, this.numRows, fArr, fFindMax);
        float f = fArr[i] + this.tau;
        QrHelperFunctions_FDRM.divideElements(i + 1, this.numRows, fArr, f);
        this.gamma = f / this.tau;
        this.tau *= fFindMax;
        fArr[i] = -this.tau;
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
    public FMatrixRMaj getColPivotMatrix(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(this.numCols, this.numCols);
        } else {
            if (fMatrixRMaj.numRows != this.numCols) {
                throw new IllegalArgumentException("Number of rows must be " + this.numCols);
            }
            if (fMatrixRMaj.numCols != this.numCols) {
                throw new IllegalArgumentException("Number of columns must be " + this.numCols);
            }
            fMatrixRMaj.zero();
        }
        for (int i = 0; i < this.numCols; i++) {
            fMatrixRMaj.set(this.pivots[i], i, 1.0f);
        }
        return fMatrixRMaj;
    }
}
