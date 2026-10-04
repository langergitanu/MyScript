package org.ejml.dense.row.decomposition.svd;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.bidiagonal.BidiagonalDecompositionRow_FDRM;
import org.ejml.dense.row.decomposition.bidiagonal.BidiagonalDecompositionTall_FDRM;
import org.ejml.dense.row.decomposition.svd.implicitqr.SvdImplicitQrAlgorithm_FDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F32;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SvdImplicitQrDecompose_FDRM implements SingularValueDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: Ut */
    private FMatrixRMaj f2645Ut;

    /* JADX INFO: renamed from: Vt */
    private FMatrixRMaj f2646Vt;
    private BidiagonalDecomposition_F32<FMatrixRMaj> bidiag;
    private boolean canUseTallBidiagonal;
    private boolean compact;
    private boolean computeU;
    private boolean computeV;
    float[] diag;
    private int numCols;
    private int numColsT;
    private int numRows;
    private int numRowsT;
    private int numSingular;
    float[] off;
    private boolean prefComputeU;
    private boolean prefComputeV;
    private float[] singularValues;
    private boolean transposed;
    private SvdImplicitQrAlgorithm_FDRM qralg = new SvdImplicitQrAlgorithm_FDRM();
    private FMatrixRMaj A_mod = new FMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SvdImplicitQrDecompose_FDRM(boolean z, boolean z2, boolean z3, boolean z4) {
        this.compact = z;
        this.prefComputeU = z2;
        this.prefComputeV = z3;
        this.canUseTallBidiagonal = z4;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition_F32
    public float[] getSingularValues() {
        return this.singularValues;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numberOfSingularValues() {
        return this.numSingular;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public boolean isCompact() {
        return this.compact;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getU(FMatrixRMaj fMatrixRMaj, boolean z) {
        if (!this.prefComputeU) {
            throw new IllegalArgumentException("As requested U was not computed.");
        }
        if (z) {
            if (fMatrixRMaj == null) {
                return this.f2645Ut;
            }
            fMatrixRMaj.set((FMatrixD1) this.f2645Ut);
            return fMatrixRMaj;
        }
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(this.f2645Ut.numCols, this.f2645Ut.numRows);
        } else {
            fMatrixRMaj.reshape(this.f2645Ut.numCols, this.f2645Ut.numRows);
        }
        CommonOps_FDRM.transpose(this.f2645Ut, fMatrixRMaj);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getV(FMatrixRMaj fMatrixRMaj, boolean z) {
        if (!this.prefComputeV) {
            throw new IllegalArgumentException("As requested V was not computed.");
        }
        if (z) {
            if (fMatrixRMaj == null) {
                return this.f2646Vt;
            }
            fMatrixRMaj.set((FMatrixD1) this.f2646Vt);
            return fMatrixRMaj;
        }
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(this.f2646Vt.numCols, this.f2646Vt.numRows);
        } else {
            fMatrixRMaj.reshape(this.f2646Vt.numCols, this.f2646Vt.numRows);
        }
        CommonOps_FDRM.transpose(this.f2646Vt, fMatrixRMaj);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getW(FMatrixRMaj fMatrixRMaj) {
        boolean z = this.compact;
        int i = z ? this.numSingular : this.numRows;
        int i2 = z ? this.numSingular : this.numCols;
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(i, i2);
        } else {
            fMatrixRMaj.reshape(i, i2, false);
            fMatrixRMaj.zero();
        }
        for (int i3 = 0; i3 < this.numSingular; i3++) {
            fMatrixRMaj.unsafe_set(i3, i3, this.singularValues[i3]);
        }
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (!setup(fMatrixRMaj) || bidiagonalization(fMatrixRMaj) || computeUWV()) {
            return false;
        }
        makeSingularPositive();
        undoTranspose();
        return true;
    }

    private boolean bidiagonalization(FMatrixRMaj fMatrixRMaj) {
        if (this.transposed) {
            this.A_mod.reshape(fMatrixRMaj.numCols, fMatrixRMaj.numRows, false);
            CommonOps_FDRM.transpose(fMatrixRMaj, this.A_mod);
        } else {
            this.A_mod.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false);
            this.A_mod.set((FMatrixD1) fMatrixRMaj);
        }
        return !this.bidiag.decompose(this.A_mod);
    }

    private void undoTranspose() {
        if (this.transposed) {
            FMatrixRMaj fMatrixRMaj = this.f2646Vt;
            this.f2646Vt = this.f2645Ut;
            this.f2645Ut = fMatrixRMaj;
        }
    }

    private boolean computeUWV() {
        this.bidiag.getDiagonal(this.diag, this.off);
        this.qralg.setMatrix(this.numRowsT, this.numColsT, this.diag, this.off);
        if (this.computeU) {
            this.f2645Ut = this.bidiag.getU(this.f2645Ut, true, this.compact);
        }
        if (this.computeV) {
            this.f2646Vt = this.bidiag.getV(this.f2646Vt, true, this.compact);
        }
        this.qralg.setFastValues(false);
        if (this.computeU) {
            this.qralg.setUt(this.f2645Ut);
        } else {
            this.qralg.setUt(null);
        }
        if (this.computeV) {
            this.qralg.setVt(this.f2646Vt);
        } else {
            this.qralg.setVt(null);
        }
        return !this.qralg.process();
    }

    private boolean setup(FMatrixRMaj fMatrixRMaj) {
        boolean z = fMatrixRMaj.numCols > fMatrixRMaj.numRows;
        this.transposed = z;
        if (z) {
            this.computeU = this.prefComputeV;
            this.computeV = this.prefComputeU;
            this.numRowsT = fMatrixRMaj.numCols;
            this.numColsT = fMatrixRMaj.numRows;
        } else {
            this.computeU = this.prefComputeU;
            this.computeV = this.prefComputeV;
            this.numRowsT = fMatrixRMaj.numRows;
            this.numColsT = fMatrixRMaj.numCols;
        }
        this.numRows = fMatrixRMaj.numRows;
        int i = fMatrixRMaj.numCols;
        this.numCols = i;
        int i2 = this.numRows;
        if (i2 == 0 || i == 0) {
            return false;
        }
        float[] fArr = this.diag;
        if (fArr == null || fArr.length < this.numColsT) {
            int i3 = this.numColsT;
            this.diag = new float[i3];
            this.off = new float[i3 - 1];
        }
        if (this.canUseTallBidiagonal && i2 > i * 2 && !this.computeU) {
            BidiagonalDecomposition_F32<FMatrixRMaj> bidiagonalDecomposition_F32 = this.bidiag;
            if (bidiagonalDecomposition_F32 == null || !(bidiagonalDecomposition_F32 instanceof BidiagonalDecompositionTall_FDRM)) {
                this.bidiag = new BidiagonalDecompositionTall_FDRM();
            }
        } else {
            BidiagonalDecomposition_F32<FMatrixRMaj> bidiagonalDecomposition_F322 = this.bidiag;
            if (bidiagonalDecomposition_F322 == null || !(bidiagonalDecomposition_F322 instanceof BidiagonalDecompositionRow_FDRM)) {
                this.bidiag = new BidiagonalDecompositionRow_FDRM();
            }
        }
        return true;
    }

    private void makeSingularPositive() {
        this.numSingular = this.qralg.getNumberOfSingularValues();
        this.singularValues = this.qralg.getSingularValues();
        for (int i = 0; i < this.numSingular; i++) {
            float singularValue = this.qralg.getSingularValue(i);
            if (singularValue < 0.0f) {
                this.singularValues[i] = 0.0f - singularValue;
                if (this.computeU) {
                    int i2 = this.f2645Ut.numCols * i;
                    int i3 = this.f2645Ut.numCols + i2;
                    while (i2 < i3) {
                        FMatrixRMaj fMatrixRMaj = this.f2645Ut;
                        fMatrixRMaj.set(i2, 0.0f - fMatrixRMaj.get(i2));
                        i2++;
                    }
                }
            } else {
                this.singularValues[i] = singularValue;
            }
        }
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numRows() {
        return this.numRows;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numCols() {
        return this.numCols;
    }
}
