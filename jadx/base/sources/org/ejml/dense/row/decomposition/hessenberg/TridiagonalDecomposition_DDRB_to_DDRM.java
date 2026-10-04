package org.ejml.dense.row.decomposition.hessenberg;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.EjmlParameters;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.decomposition.hessenberg.TridiagonalDecompositionHouseholder_DDRB;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.BaseDecomposition_DDRB_to_DDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecomposition_DDRB_to_DDRM extends BaseDecomposition_DDRB_to_DDRM implements TridiagonalSimilarDecomposition_F64<DMatrixRMaj> {
    public TridiagonalDecomposition_DDRB_to_DDRM() {
        this(EjmlParameters.BLOCK_WIDTH);
    }

    public TridiagonalDecomposition_DDRB_to_DDRM(int i) {
        super(new TridiagonalDecompositionHouseholder_DDRB(), i);
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRMaj getT(DMatrixRMaj dMatrixRMaj) {
        int i = this.Ablock.numRows;
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(i, i);
        } else {
            CommonOps_DDRM.fill(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        double[] dArr = new double[i];
        double[] dArr2 = new double[i];
        ((TridiagonalDecompositionHouseholder_DDRB) this.alg).getDiagonal(dArr, dArr2);
        dMatrixRMaj.unsafe_set(0, 0, dArr[0]);
        for (int i2 = 1; i2 < i; i2++) {
            dMatrixRMaj.unsafe_set(i2, i2, dArr[i2]);
            int i3 = i2 - 1;
            dMatrixRMaj.unsafe_set(i2, i3, dArr2[i3]);
            dMatrixRMaj.unsafe_set(i3, i2, dArr2[i3]);
        }
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public DMatrixRMaj getQ(DMatrixRMaj dMatrixRMaj, boolean z) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(this.Ablock.numRows, this.Ablock.numCols);
        }
        DMatrixRBlock dMatrixRBlock = new DMatrixRBlock();
        dMatrixRBlock.numRows = dMatrixRMaj.numRows;
        dMatrixRBlock.numCols = dMatrixRMaj.numCols;
        dMatrixRBlock.blockLength = this.blockLength;
        dMatrixRBlock.data = dMatrixRMaj.data;
        ((TridiagonalDecompositionHouseholder_DDRB) this.alg).getQ(dMatrixRBlock, z);
        convertBlockToRow(dMatrixRMaj.numRows, dMatrixRMaj.numCols, this.Ablock.blockLength, dMatrixRMaj.data);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64
    public void getDiagonal(double[] dArr, double[] dArr2) {
        ((TridiagonalDecompositionHouseholder_DDRB) this.alg).getDiagonal(dArr, dArr2);
    }
}
