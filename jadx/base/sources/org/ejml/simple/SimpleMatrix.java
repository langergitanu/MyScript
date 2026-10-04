package org.ejml.simple;

import java.util.Random;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FMatrixSparseCSC;
import org.ejml.data.Matrix;
import org.ejml.data.MatrixType;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.CovarianceRandomDraw_DDRM;
import org.ejml.dense.row.CovarianceRandomDraw_FDRM;
import org.ejml.dense.row.RandomMatrices_DDRM;
import org.ejml.dense.row.RandomMatrices_FDRM;
import org.ejml.ops.ConvertDMatrixStruct;
import org.ejml.ops.ConvertFMatrixStruct;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleMatrix extends SimpleBase<SimpleMatrix> {
    public static final int END = Integer.MAX_VALUE;

    public SimpleMatrix(int i, int i2, boolean z, double... dArr) {
        setMatrix(new DMatrixRMaj(i, i2, z, dArr));
    }

    public SimpleMatrix(int i, int i2, boolean z, float... fArr) {
        setMatrix(new FMatrixRMaj(i, i2, z, fArr));
    }

    public SimpleMatrix(double[][] dArr) {
        setMatrix(new DMatrixRMaj(dArr));
    }

    public SimpleMatrix(int i, int i2) {
        setMatrix(new DMatrixRMaj(i, i2));
    }

    public SimpleMatrix(int i, int i2, Class cls) {
        if (cls == DMatrixRMaj.class) {
            setMatrix(new DMatrixRMaj(i, i2));
        } else {
            setMatrix(new FMatrixRMaj(i, i2));
        }
    }

    /* JADX INFO: renamed from: org.ejml.simple.SimpleMatrix$1 */
    static /* synthetic */ class C91441 {
        static final /* synthetic */ int[] $SwitchMap$org$ejml$data$MatrixType;

        static {
            int[] iArr = new int[MatrixType.values().length];
            $SwitchMap$org$ejml$data$MatrixType = iArr;
            try {
                iArr[MatrixType.DDRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ejml$data$MatrixType[MatrixType.FDRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$ejml$data$MatrixType[MatrixType.ZDRM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$ejml$data$MatrixType[MatrixType.CDRM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$ejml$data$MatrixType[MatrixType.DSCC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$ejml$data$MatrixType[MatrixType.FSCC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public SimpleMatrix(int i, int i2, MatrixType matrixType) {
        switch (C91441.$SwitchMap$org$ejml$data$MatrixType[matrixType.ordinal()]) {
            case 1:
                setMatrix(new DMatrixRMaj(i, i2));
                return;
            case 2:
                setMatrix(new FMatrixRMaj(i, i2));
                return;
            case 3:
                setMatrix(new ZMatrixRMaj(i, i2));
                return;
            case 4:
                setMatrix(new CMatrixRMaj(i, i2));
                return;
            case 5:
                setMatrix(new DMatrixSparseCSC(i, i2));
                return;
            case 6:
                setMatrix(new FMatrixSparseCSC(i, i2));
                return;
            default:
                throw new RuntimeException("Unknown matrix type");
        }
    }

    public SimpleMatrix(SimpleMatrix simpleMatrix) {
        setMatrix(simpleMatrix.mat.copy());
    }

    public SimpleMatrix(Matrix matrix) {
        Matrix matrixCopy;
        if (matrix instanceof DMatrixRBlock) {
            DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(matrix.getNumRows(), matrix.getNumCols());
            ConvertDMatrixStruct.convert((DMatrixRBlock) matrix, dMatrixRMaj);
            matrixCopy = dMatrixRMaj;
        } else if (matrix instanceof FMatrixRBlock) {
            FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(matrix.getNumRows(), matrix.getNumCols());
            ConvertFMatrixStruct.convert((FMatrixRBlock) matrix, fMatrixRMaj);
            matrixCopy = fMatrixRMaj;
        } else {
            matrixCopy = matrix.copy();
        }
        setMatrix(matrixCopy);
    }

    public SimpleMatrix() {
    }

    public static SimpleMatrix wrap(Matrix matrix) {
        SimpleMatrix simpleMatrix = new SimpleMatrix();
        simpleMatrix.setMatrix(matrix);
        return simpleMatrix;
    }

    public static SimpleMatrix identity(int i) {
        SimpleMatrix simpleMatrix = new SimpleMatrix(i, i);
        CommonOps_DDRM.setIdentity((DMatrixRMaj) simpleMatrix.mat);
        return simpleMatrix;
    }

    public static SimpleMatrix identity(int i, Class cls) {
        SimpleMatrix simpleMatrix = new SimpleMatrix(i, i, cls);
        if (cls == DMatrixRMaj.class) {
            CommonOps_DDRM.setIdentity((DMatrixRMaj) simpleMatrix.mat);
            return simpleMatrix;
        }
        CommonOps_FDRM.setIdentity((FMatrixRMaj) simpleMatrix.mat);
        return simpleMatrix;
    }

    public static SimpleMatrix diag(double... dArr) {
        return wrap(CommonOps_DDRM.diag(dArr));
    }

    public static SimpleMatrix diag(Class cls, double... dArr) {
        Matrix matrixDiag;
        if (cls == DMatrixRMaj.class) {
            matrixDiag = CommonOps_DDRM.diag(dArr);
        } else {
            int length = dArr.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = (float) dArr[i];
            }
            matrixDiag = CommonOps_FDRM.diag(fArr);
        }
        return wrap(matrixDiag);
    }

    public static SimpleMatrix random64(int i, int i2, double d, double d2, Random random) {
        SimpleMatrix simpleMatrix = new SimpleMatrix(i, i2);
        RandomMatrices_DDRM.fillUniform((DMatrixRMaj) simpleMatrix.mat, d, d2, random);
        return simpleMatrix;
    }

    public static SimpleMatrix random32(int i, int i2, float f, float f2, Random random) {
        SimpleMatrix simpleMatrix = new SimpleMatrix(i, i2, FMatrixRMaj.class);
        RandomMatrices_FDRM.fillUniform((FMatrixRMaj) simpleMatrix.mat, f, f2, random);
        return simpleMatrix;
    }

    public static SimpleMatrix randomNormal(SimpleMatrix simpleMatrix, Random random) {
        SimpleMatrix simpleMatrix2 = new SimpleMatrix(simpleMatrix.numRows(), 1);
        if (simpleMatrix.bits() == 64) {
            new CovarianceRandomDraw_DDRM(random, (DMatrixRMaj) simpleMatrix.getMatrix()).next((DMatrixRMaj) simpleMatrix2.getMatrix());
            return simpleMatrix2;
        }
        new CovarianceRandomDraw_FDRM(random, (FMatrixRMaj) simpleMatrix.getMatrix()).next((FMatrixRMaj) simpleMatrix2.getMatrix());
        return simpleMatrix2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.ejml.simple.SimpleBase
    public SimpleMatrix createMatrix(int i, int i2, MatrixType matrixType) {
        return new SimpleMatrix(i, i2, matrixType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.ejml.simple.SimpleBase
    public SimpleMatrix wrapMatrix(Matrix matrix) {
        return new SimpleMatrix(matrix);
    }
}
