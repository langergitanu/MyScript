package org.ejml.sparse.csc.factory;

import java.util.Random;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.ComputePermutation;
import org.ejml.sparse.FillReducing;

/* JADX INFO: loaded from: classes9.dex */
public class FillReductionFactory_DSCC {
    public static final Random rand = new Random(234234);

    /* JADX INFO: renamed from: org.ejml.sparse.csc.factory.FillReductionFactory_DSCC$3 */
    static /* synthetic */ class C91473 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$sparse$FillReducing;

        static {
            int[] iArr = new int[FillReducing.values().length];
            $SwitchMap$org$ejml$sparse$FillReducing = iArr;
            try {
                iArr[FillReducing.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$sparse$FillReducing[FillReducing.RANDOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$sparse$FillReducing[FillReducing.IDENTITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ComputePermutation<DMatrixSparseCSC> create(FillReducing fillReducing) {
        int i = C91473.$SwitchMap$org$ejml$sparse$FillReducing[fillReducing.ordinal()];
        boolean z = true;
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            return new ComputePermutation<DMatrixSparseCSC>(z, z) { // from class: org.ejml.sparse.csc.factory.FillReductionFactory_DSCC.1
                @Override // org.ejml.sparse.ComputePermutation
                public void process(DMatrixSparseCSC dMatrixSparseCSC) {
                    Random random;
                    this.prow.reshape(dMatrixSparseCSC.numRows);
                    this.pcol.reshape(dMatrixSparseCSC.numCols);
                    FillReductionFactory_DSCC.fillSequence(this.prow);
                    FillReductionFactory_DSCC.fillSequence(this.pcol);
                    synchronized (FillReductionFactory_DSCC.rand) {
                        random = new Random(FillReductionFactory_DSCC.rand.nextInt());
                    }
                    UtilEjml.shuffle(this.prow.data, this.prow.length, 0, this.prow.length, random);
                    UtilEjml.shuffle(this.pcol.data, this.pcol.length, 0, this.pcol.length, random);
                }
            };
        }
        if (i == 3) {
            return new ComputePermutation<DMatrixSparseCSC>(z, z) { // from class: org.ejml.sparse.csc.factory.FillReductionFactory_DSCC.2
                @Override // org.ejml.sparse.ComputePermutation
                public void process(DMatrixSparseCSC dMatrixSparseCSC) {
                    this.prow.reshape(dMatrixSparseCSC.numRows);
                    this.pcol.reshape(dMatrixSparseCSC.numCols);
                    FillReductionFactory_DSCC.fillSequence(this.prow);
                    FillReductionFactory_DSCC.fillSequence(this.pcol);
                }
            };
        }
        throw new RuntimeException("Unknown " + fillReducing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillSequence(IGrowArray iGrowArray) {
        for (int i = 0; i < iGrowArray.length; i++) {
            iGrowArray.data[i] = i;
        }
    }
}
