package org.ejml.dense.row.decomposition.hessenberg;

import org.ejml.EjmlParameters;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.decomposition.hessenberg.TridiagonalDecompositionHouseholder_FDRB;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.BaseDecomposition_FDRB_to_FDRM;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class TridiagonalDecomposition_FDRB_to_FDRM extends BaseDecomposition_FDRB_to_FDRM implements TridiagonalSimilarDecomposition_F32<FMatrixRMaj> {
    public TridiagonalDecomposition_FDRB_to_FDRM() {
        this(EjmlParameters.BLOCK_WIDTH);
    }

    public TridiagonalDecomposition_FDRB_to_FDRM(int i) {
        super(new TridiagonalDecompositionHouseholder_FDRB(), i);
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRMaj getT(FMatrixRMaj fMatrixRMaj) {
        int i = this.Ablock.numRows;
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(i, i);
        } else {
            CommonOps_FDRM.fill(fMatrixRMaj, 0.0f);
        }
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        ((TridiagonalDecompositionHouseholder_FDRB) this.alg).getDiagonal(fArr, fArr2);
        fMatrixRMaj.unsafe_set(0, 0, fArr[0]);
        for (int i2 = 1; i2 < i; i2++) {
            fMatrixRMaj.unsafe_set(i2, i2, fArr[i2]);
            int i3 = i2 - 1;
            fMatrixRMaj.unsafe_set(i2, i3, fArr2[i3]);
            fMatrixRMaj.unsafe_set(i3, i2, fArr2[i3]);
        }
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition
    public FMatrixRMaj getQ(FMatrixRMaj fMatrixRMaj, boolean z) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(this.Ablock.numRows, this.Ablock.numCols);
        }
        FMatrixRBlock fMatrixRBlock = new FMatrixRBlock();
        fMatrixRBlock.numRows = fMatrixRMaj.numRows;
        fMatrixRBlock.numCols = fMatrixRMaj.numCols;
        fMatrixRBlock.blockLength = this.blockLength;
        fMatrixRBlock.data = fMatrixRMaj.data;
        ((TridiagonalDecompositionHouseholder_FDRB) this.alg).getQ(fMatrixRBlock, z);
        convertBlockToRow(fMatrixRMaj.numRows, fMatrixRMaj.numCols, this.Ablock.blockLength, fMatrixRMaj.data);
        return fMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32
    public void getDiagonal(float[] fArr, float[] fArr2) {
        ((TridiagonalDecompositionHouseholder_FDRB) this.alg).getDiagonal(fArr, fArr2);
    }
}
