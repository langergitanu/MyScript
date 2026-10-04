package org.ejml.dense.row.decomposition.svd;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.bidiagonal.BidiagonalDecompositionRow_DDRM;
import org.ejml.dense.row.decomposition.bidiagonal.BidiagonalDecompositionTall_DDRM;
import org.ejml.dense.row.decomposition.svd.implicitqr.SvdImplicitQrAlgorithm_DDRM;
import org.ejml.interfaces.decomposition.BidiagonalDecomposition_F64;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SvdImplicitQrDecompose_DDRM implements SingularValueDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: Ut */
    private DMatrixRMaj f2643Ut;

    /* JADX INFO: renamed from: Vt */
    private DMatrixRMaj f2644Vt;
    private BidiagonalDecomposition_F64<DMatrixRMaj> bidiag;
    private boolean canUseTallBidiagonal;
    private boolean compact;
    private boolean computeU;
    private boolean computeV;
    double[] diag;
    private int numCols;
    private int numColsT;
    private int numRows;
    private int numRowsT;
    private int numSingular;
    double[] off;
    private boolean prefComputeU;
    private boolean prefComputeV;
    private double[] singularValues;
    private boolean transposed;
    private SvdImplicitQrAlgorithm_DDRM qralg = new SvdImplicitQrAlgorithm_DDRM();
    private DMatrixRMaj A_mod = new DMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SvdImplicitQrDecompose_DDRM(boolean z, boolean z2, boolean z3, boolean z4) {
        this.compact = z;
        this.prefComputeU = z2;
        this.prefComputeV = z3;
        this.canUseTallBidiagonal = z4;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition_F64
    public double[] getSingularValues() {
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
    public DMatrixRMaj getU(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (!this.prefComputeU) {
            throw new IllegalArgumentException("As requested U was not computed.");
        }
        if (z) {
            if (dMatrixRMaj == null) {
                return this.f2643Ut;
            }
            dMatrixRMaj.set((DMatrixD1) this.f2643Ut);
            return dMatrixRMaj;
        }
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(this.f2643Ut.numCols, this.f2643Ut.numRows);
        } else {
            dMatrixRMaj.reshape(this.f2643Ut.numCols, this.f2643Ut.numRows);
        }
        CommonOps_DDRM.transpose(this.f2643Ut, dMatrixRMaj);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public DMatrixRMaj getV(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (!this.prefComputeV) {
            throw new IllegalArgumentException("As requested V was not computed.");
        }
        if (z) {
            if (dMatrixRMaj == null) {
                return this.f2644Vt;
            }
            dMatrixRMaj.set((DMatrixD1) this.f2644Vt);
            return dMatrixRMaj;
        }
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(this.f2644Vt.numCols, this.f2644Vt.numRows);
        } else {
            dMatrixRMaj.reshape(this.f2644Vt.numCols, this.f2644Vt.numRows);
        }
        CommonOps_DDRM.transpose(this.f2644Vt, dMatrixRMaj);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public DMatrixRMaj getW(DMatrixRMaj dMatrixRMaj) {
        boolean z = this.compact;
        int i = z ? this.numSingular : this.numRows;
        int i2 = z ? this.numSingular : this.numCols;
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(i, i2);
        } else {
            dMatrixRMaj.reshape(i, i2, false);
            dMatrixRMaj.zero();
        }
        for (int i3 = 0; i3 < this.numSingular; i3++) {
            dMatrixRMaj.unsafe_set(i3, i3, this.singularValues[i3]);
        }
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (!setup(dMatrixRMaj) || bidiagonalization(dMatrixRMaj) || computeUWV()) {
            return false;
        }
        makeSingularPositive();
        undoTranspose();
        return true;
    }

    private boolean bidiagonalization(DMatrixRMaj dMatrixRMaj) {
        if (this.transposed) {
            this.A_mod.reshape(dMatrixRMaj.numCols, dMatrixRMaj.numRows, false);
            CommonOps_DDRM.transpose(dMatrixRMaj, this.A_mod);
        } else {
            this.A_mod.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false);
            this.A_mod.set((DMatrixD1) dMatrixRMaj);
        }
        return !this.bidiag.decompose(this.A_mod);
    }

    private void undoTranspose() {
        if (this.transposed) {
            DMatrixRMaj dMatrixRMaj = this.f2644Vt;
            this.f2644Vt = this.f2643Ut;
            this.f2643Ut = dMatrixRMaj;
        }
    }

    private boolean computeUWV() {
        this.bidiag.getDiagonal(this.diag, this.off);
        this.qralg.setMatrix(this.numRowsT, this.numColsT, this.diag, this.off);
        if (this.computeU) {
            this.f2643Ut = this.bidiag.getU(this.f2643Ut, true, this.compact);
        }
        if (this.computeV) {
            this.f2644Vt = this.bidiag.getV(this.f2644Vt, true, this.compact);
        }
        this.qralg.setFastValues(false);
        if (this.computeU) {
            this.qralg.setUt(this.f2643Ut);
        } else {
            this.qralg.setUt(null);
        }
        if (this.computeV) {
            this.qralg.setVt(this.f2644Vt);
        } else {
            this.qralg.setVt(null);
        }
        return !this.qralg.process();
    }

    private boolean setup(DMatrixRMaj dMatrixRMaj) {
        boolean z = dMatrixRMaj.numCols > dMatrixRMaj.numRows;
        this.transposed = z;
        if (z) {
            this.computeU = this.prefComputeV;
            this.computeV = this.prefComputeU;
            this.numRowsT = dMatrixRMaj.numCols;
            this.numColsT = dMatrixRMaj.numRows;
        } else {
            this.computeU = this.prefComputeU;
            this.computeV = this.prefComputeV;
            this.numRowsT = dMatrixRMaj.numRows;
            this.numColsT = dMatrixRMaj.numCols;
        }
        this.numRows = dMatrixRMaj.numRows;
        int i = dMatrixRMaj.numCols;
        this.numCols = i;
        int i2 = this.numRows;
        if (i2 == 0 || i == 0) {
            return false;
        }
        double[] dArr = this.diag;
        if (dArr == null || dArr.length < this.numColsT) {
            int i3 = this.numColsT;
            this.diag = new double[i3];
            this.off = new double[i3 - 1];
        }
        if (this.canUseTallBidiagonal && i2 > i * 2 && !this.computeU) {
            BidiagonalDecomposition_F64<DMatrixRMaj> bidiagonalDecomposition_F64 = this.bidiag;
            if (bidiagonalDecomposition_F64 == null || !(bidiagonalDecomposition_F64 instanceof BidiagonalDecompositionTall_DDRM)) {
                this.bidiag = new BidiagonalDecompositionTall_DDRM();
            }
        } else {
            BidiagonalDecomposition_F64<DMatrixRMaj> bidiagonalDecomposition_F642 = this.bidiag;
            if (bidiagonalDecomposition_F642 == null || !(bidiagonalDecomposition_F642 instanceof BidiagonalDecompositionRow_DDRM)) {
                this.bidiag = new BidiagonalDecompositionRow_DDRM();
            }
        }
        return true;
    }

    private void makeSingularPositive() {
        this.numSingular = this.qralg.getNumberOfSingularValues();
        this.singularValues = this.qralg.getSingularValues();
        for (int i = 0; i < this.numSingular; i++) {
            double singularValue = this.qralg.getSingularValue(i);
            if (singularValue < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.singularValues[i] = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - singularValue;
                if (this.computeU) {
                    int i2 = this.f2643Ut.numCols * i;
                    int i3 = this.f2643Ut.numCols + i2;
                    while (i2 < i3) {
                        DMatrixRMaj dMatrixRMaj = this.f2643Ut;
                        dMatrixRMaj.set(i2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - dMatrixRMaj.get(i2));
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
