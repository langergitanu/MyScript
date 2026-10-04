package org.ejml.simple;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.ejml.UtilEjml;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrixIterator;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FMatrixSparseCSC;
import org.ejml.data.Matrix;
import org.ejml.data.MatrixType;
import org.ejml.data.ReshapeMatrix;
import org.ejml.data.SingularMatrixException;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.MatrixFeatures_FDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;
import org.ejml.equation.Equation;
import org.ejml.ops.MatrixIO;
import org.ejml.simple.SimpleBase;
import org.ejml.simple.ops.SimpleOperations_CDRM;
import org.ejml.simple.ops.SimpleOperations_DDRM;
import org.ejml.simple.ops.SimpleOperations_FDRM;
import org.ejml.simple.ops.SimpleOperations_SPARSE;
import org.ejml.simple.ops.SimpleOperations_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public abstract class SimpleBase<T extends SimpleBase> implements Serializable {
    static final long serialVersionUID = 2342556642L;
    protected Matrix mat;
    protected SimpleOperations ops;

    protected abstract T createMatrix(int i, int i2, MatrixType matrixType);

    protected abstract T wrapMatrix(Matrix matrix);

    public SimpleBase(int i, int i2) {
        setMatrix(new DMatrixRMaj(i, i2));
    }

    protected SimpleBase() {
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lorg/ejml/data/Matrix;>()TT; */
    public Matrix getMatrix() {
        return this.mat;
    }

    public DMatrixRMaj getDDRM() {
        return (DMatrixRMaj) this.mat;
    }

    public FMatrixRMaj getFDRM() {
        return (FMatrixRMaj) this.mat;
    }

    public ZMatrixRMaj getZDRM() {
        return (ZMatrixRMaj) this.mat;
    }

    public CMatrixRMaj getCDRM() {
        return (CMatrixRMaj) this.mat;
    }

    public DMatrixSparseCSC getDSCC() {
        return (DMatrixSparseCSC) this.mat;
    }

    public FMatrixSparseCSC getFSCC() {
        return (FMatrixSparseCSC) this.mat;
    }

    /* JADX INFO: renamed from: org.ejml.simple.SimpleBase$1 */
    static /* synthetic */ class C91431 {
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
        }
    }

    protected SimpleOperations lookupOps(MatrixType matrixType) {
        int i = C91431.$SwitchMap$org$ejml$data$MatrixType[matrixType.ordinal()];
        if (i == 1) {
            return new SimpleOperations_DDRM();
        }
        if (i == 2) {
            return new SimpleOperations_FDRM();
        }
        if (i == 3) {
            return new SimpleOperations_ZDRM();
        }
        if (i == 4) {
            return new SimpleOperations_CDRM();
        }
        if (i == 5) {
            return new SimpleOperations_SPARSE();
        }
        throw new RuntimeException("Unknown Matrix Type");
    }

    public T transpose() {
        T t = (T) createMatrix(this.mat.getNumCols(), this.mat.getNumRows(), this.mat.getType());
        this.ops.transpose(this.mat, t.mat);
        return t;
    }

    public T mult(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), t.getMatrix().getNumCols(), this.mat.getType());
        this.ops.mult(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T kron(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows() * t.numRows(), this.mat.getNumCols() * t.numCols(), this.mat.getType());
        this.ops.kron(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T plus(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.plus(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T minus(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.minus(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T minus(double d) {
        T t = (T) copy();
        if (bits() == 64) {
            CommonOps_DDRM.subtract((DMatrixRMaj) getMatrix(), d, (DMatrixRMaj) t.getMatrix());
            return t;
        }
        CommonOps_FDRM.subtract((FMatrixRMaj) getMatrix(), (float) d, (FMatrixRMaj) t.getMatrix());
        return t;
    }

    public T plus(double d) {
        T t = (T) createMatrix(numRows(), numCols(), this.mat.getType());
        if (bits() == 64) {
            CommonOps_DDRM.add((DMatrixRMaj) getMatrix(), d, (DMatrixRMaj) t.getMatrix());
            return t;
        }
        CommonOps_FDRM.add((FMatrixRMaj) getMatrix(), (float) d, (FMatrixRMaj) t.getMatrix());
        return t;
    }

    public T plus(double d, T t) {
        T t2 = (T) copy();
        if (bits() == 64) {
            CommonOps_DDRM.addEquals((DMatrixRMaj) t2.getMatrix(), d, (DMatrixRMaj) t.getMatrix());
            return t2;
        }
        CommonOps_FDRM.addEquals((FMatrixRMaj) t2.getMatrix(), (float) d, (FMatrixRMaj) t.getMatrix());
        return t2;
    }

    public double dot(T t) {
        if (!isVector()) {
            throw new IllegalArgumentException("'this' matrix is not a vector.");
        }
        if (!t.isVector()) {
            throw new IllegalArgumentException("'v' matrix is not a vector.");
        }
        if (bits() == 64) {
            return VectorVectorMult_DDRM.innerProd((DMatrixRMaj) this.mat, (DMatrixRMaj) t.getMatrix());
        }
        return VectorVectorMult_FDRM.innerProd((FMatrixRMaj) this.mat, (FMatrixRMaj) t.getMatrix());
    }

    public boolean isVector() {
        return this.mat.getNumRows() == 1 || this.mat.getNumCols() == 1;
    }

    public T scale(double d) {
        T t = (T) copy();
        if (bits() == 64) {
            CommonOps_DDRM.scale(d, (DMatrixRMaj) t.getMatrix());
            return t;
        }
        CommonOps_FDRM.scale((float) d, (FMatrixRMaj) t.getMatrix());
        return t;
    }

    public T divide(double d) {
        T t = (T) copy();
        if (bits() == 64) {
            CommonOps_DDRM.divide((DMatrixRMaj) t.getMatrix(), d);
            return t;
        }
        CommonOps_FDRM.divide((FMatrixRMaj) t.getMatrix(), (float) d);
        return t;
    }

    public T invert() {
        T t = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        if (!this.ops.invert(this.mat, t.mat)) {
            throw new SingularMatrixException();
        }
        if (this.ops.hasUncountable(t.mat)) {
            throw new SingularMatrixException("Solution contains uncountable numbers");
        }
        return t;
    }

    public T pseudoInverse() {
        T t = (T) createMatrix(this.mat.getNumCols(), this.mat.getNumRows(), this.mat.getType());
        if (bits() == 64) {
            CommonOps_DDRM.pinv((DMatrixRMaj) this.mat, (DMatrixRMaj) t.getMatrix());
            return t;
        }
        CommonOps_FDRM.pinv((FMatrixRMaj) this.mat, (FMatrixRMaj) t.getMatrix());
        return t;
    }

    public T solve(T t) {
        T t2 = (T) createMatrix(this.mat.getNumCols(), t.getMatrix().getNumCols(), this.mat.getType());
        if (!this.ops.solve(this.mat, t2.mat, t.mat)) {
            throw new SingularMatrixException();
        }
        if (this.ops.hasUncountable(t2.mat)) {
            throw new SingularMatrixException("Solution contains uncountable numbers");
        }
        return t2;
    }

    public void set(T t) {
        this.mat.set(t.getMatrix());
    }

    public void set(double d) {
        if (bits() == 64) {
            CommonOps_DDRM.fill((DMatrixRMaj) this.mat, d);
        } else {
            CommonOps_FDRM.fill((FMatrixRMaj) this.mat, (float) d);
        }
    }

    public void zero() {
        if (bits() == 64) {
            ((DMatrixRMaj) this.mat).zero();
        } else {
            ((FMatrixRMaj) this.mat).zero();
        }
    }

    public double normF() {
        return this.ops.normF(this.mat);
    }

    public double conditionP2() {
        return this.ops.conditionP2(this.mat);
    }

    public double determinant() {
        double dDeterminant = this.ops.determinant(this.mat);
        return UtilEjml.isUncountable(dDeterminant) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : dDeterminant;
    }

    public double trace() {
        return this.ops.trace(this.mat);
    }

    public void reshape(int i, int i2) {
        if (this.mat.getType().isFixed()) {
            throw new IllegalArgumentException("Can't rename a fixed sized matrix");
        }
        ((ReshapeMatrix) this.mat).reshape(i, i2);
    }

    public void set(int i, int i2, double d) {
        if (bits() == 64) {
            ((DMatrixRMaj) this.mat).set(i, i2, d);
        } else {
            ((FMatrixRMaj) this.mat).set(i, i2, (float) d);
        }
    }

    public void set(int i, double d) {
        if (bits() == 64) {
            ((DMatrixRMaj) this.mat).set(i, d);
        } else {
            ((FMatrixRMaj) this.mat).set(i, (float) d);
        }
    }

    public void setRow(int i, int i2, double... dArr) {
        this.ops.setRow(this.mat, i, i2, dArr);
    }

    public void setColumn(int i, int i2, double... dArr) {
        this.ops.setColumn(this.mat, i, i2, dArr);
    }

    public double get(int i, int i2) {
        if (this.mat.getType().getBits() == 64) {
            return ((DMatrix) this.mat).get(i, i2);
        }
        return ((FMatrix) this.mat).get(i, i2);
    }

    public double get(int i) {
        if (bits() == 64) {
            return ((DMatrixRMaj) this.mat).data[i];
        }
        return ((FMatrixRMaj) this.mat).data[i];
    }

    public int getIndex(int i, int i2) {
        return (i * this.mat.getNumCols()) + i2;
    }

    public DMatrixIterator iterator(boolean z, int i, int i2, int i3, int i4) {
        return new DMatrixIterator((DMatrixRMaj) this.mat, z, i, i2, i3, i4);
    }

    public T copy() {
        T t = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        t.getMatrix().set(getMatrix());
        return t;
    }

    public int numRows() {
        return this.mat.getNumRows();
    }

    public int numCols() {
        return this.mat.getNumCols();
    }

    public int getNumElements() {
        if (bits() == 64) {
            return ((DMatrixRMaj) this.mat).getNumElements();
        }
        return ((FMatrixRMaj) this.mat).getNumElements();
    }

    public void print() {
        this.ops.print(System.out, this.mat);
    }

    public void print(int i, int i2) {
        if (bits() == 64) {
            MatrixIO.print(System.out, (DMatrixRMaj) this.mat, i, i2);
        } else {
            MatrixIO.print(System.out, (FMatrixRMaj) this.mat, i, i2);
        }
    }

    public void print(String str) {
        if (bits() == 64) {
            MatrixIO.print(System.out, (DMatrixRMaj) this.mat, str);
        } else {
            MatrixIO.print(System.out, (FMatrixRMaj) this.mat, str);
        }
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bits() == 64) {
            MatrixIO.print(new PrintStream(byteArrayOutputStream), (DMatrixRMaj) this.mat);
        } else {
            MatrixIO.print(new PrintStream(byteArrayOutputStream), (FMatrixRMaj) this.mat);
        }
        return byteArrayOutputStream.toString();
    }

    public T extractMatrix(int i, int i2, int i3, int i4) {
        if (i == Integer.MAX_VALUE) {
            i = this.mat.getNumRows();
        }
        int i5 = i;
        if (i2 == Integer.MAX_VALUE) {
            i2 = this.mat.getNumRows();
        }
        int i6 = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = this.mat.getNumCols();
        }
        int i7 = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = this.mat.getNumCols();
        }
        int i8 = i4;
        T t = (T) createMatrix(i6 - i5, i8 - i7, this.mat.getType());
        this.ops.extract(this.mat, i5, i6, i7, i8, t.mat, 0, 0);
        return t;
    }

    public T extractVector(boolean z, int i) {
        Matrix matrix = this.mat;
        int numCols = z ? matrix.getNumCols() : matrix.getNumRows();
        MatrixType type = this.mat.getType();
        T t = z ? (T) createMatrix(1, numCols, type) : (T) createMatrix(numCols, 1, type);
        if (bits() == 64) {
            if (z) {
                SpecializedOps_DDRM.subvector((DMatrixRMaj) this.mat, i, 0, numCols, true, 0, (DMatrixRMaj) t.getMatrix());
                return t;
            }
            SpecializedOps_DDRM.subvector((DMatrixRMaj) this.mat, 0, i, numCols, false, 0, (DMatrixRMaj) t.getMatrix());
            return t;
        }
        if (z) {
            SpecializedOps_FDRM.subvector((FMatrixRMaj) this.mat, i, 0, numCols, true, 0, (FMatrixRMaj) t.getMatrix());
            return t;
        }
        SpecializedOps_FDRM.subvector((FMatrixRMaj) this.mat, 0, i, numCols, false, 0, (FMatrixRMaj) t.getMatrix());
        return t;
    }

    public T diag() {
        if (bits() == 64) {
            if (MatrixFeatures_DDRM.isVector(this.mat)) {
                int iMax = Math.max(this.mat.getNumCols(), this.mat.getNumRows());
                T t = (T) createMatrix(iMax, iMax, this.mat.getType());
                CommonOps_DDRM.diag((DMatrixRMaj) t.getMatrix(), iMax, ((DMatrixRMaj) this.mat).data);
                return t;
            }
            T t2 = (T) createMatrix(Math.min(this.mat.getNumCols(), this.mat.getNumRows()), 1, this.mat.getType());
            CommonOps_DDRM.extractDiag((DMatrixRMaj) this.mat, (DMatrixRMaj) t2.getMatrix());
            return t2;
        }
        if (MatrixFeatures_FDRM.isVector(this.mat)) {
            int iMax2 = Math.max(this.mat.getNumCols(), this.mat.getNumRows());
            T t3 = (T) createMatrix(iMax2, iMax2, this.mat.getType());
            CommonOps_FDRM.diag((FMatrixRMaj) t3.getMatrix(), iMax2, ((FMatrixRMaj) this.mat).data);
            return t3;
        }
        T t4 = (T) createMatrix(Math.min(this.mat.getNumCols(), this.mat.getNumRows()), 1, this.mat.getType());
        CommonOps_FDRM.extractDiag((FMatrixRMaj) this.mat, (FMatrixRMaj) t4.getMatrix());
        return t4;
    }

    public boolean isIdentical(T t, double d) {
        if (bits() == 64) {
            return MatrixFeatures_DDRM.isIdentical((DMatrixRMaj) this.mat, (DMatrixRMaj) t.getMatrix(), d);
        }
        return MatrixFeatures_FDRM.isIdentical((FMatrixRMaj) this.mat, (FMatrixRMaj) t.getMatrix(), (float) d);
    }

    public boolean hasUncountable() {
        return this.ops.hasUncountable(this.mat);
    }

    public SimpleSVD<T> svd() {
        return new SimpleSVD<>(this.mat, false);
    }

    public SimpleSVD<T> svd(boolean z) {
        return new SimpleSVD<>(this.mat, z);
    }

    public SimpleEVD<T> eig() {
        return new SimpleEVD<>(this.mat);
    }

    public void insertIntoThis(int i, int i2, T t) {
        if (bits() == 64) {
            CommonOps_DDRM.insert((DMatrixRMaj) t.getMatrix(), (DMatrixRMaj) this.mat, i, i2);
        } else {
            CommonOps_FDRM.insert((FMatrixRMaj) t.getMatrix(), (FMatrixRMaj) this.mat, i, i2);
        }
    }

    public T combine(int i, int i2, T t) {
        T t2;
        if (i == Integer.MAX_VALUE) {
            i = this.mat.getNumRows();
        }
        if (i2 == Integer.MAX_VALUE) {
            i2 = this.mat.getNumCols();
        }
        int iNumRows = t.numRows() + i;
        int iNumCols = t.numCols() + i2;
        if (iNumRows > this.mat.getNumRows() || iNumCols > this.mat.getNumCols()) {
            t2 = (T) createMatrix(Math.max(iNumRows, this.mat.getNumRows()), Math.max(iNumCols, this.mat.getNumCols()), this.mat.getType());
            t2.insertIntoThis(0, 0, this);
        } else {
            t2 = (T) copy();
        }
        t2.insertIntoThis(i, i2, t);
        return t2;
    }

    public double elementMaxAbs() {
        return this.ops.elementMaxAbs(this.mat);
    }

    public double elementSum() {
        return this.ops.elementSum(this.mat);
    }

    public T elementMult(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementMult(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T elementDiv(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementDiv(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T elementPower(T t) {
        T t2 = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementPower(this.mat, t.mat, t2.mat);
        return t2;
    }

    public T elementPower(double d) {
        T t = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementPower(this.mat, d, t.mat);
        return t;
    }

    public T elementExp() {
        T t = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementExp(this.mat, t.mat);
        return t;
    }

    public T elementLog() {
        T t = (T) createMatrix(this.mat.getNumRows(), this.mat.getNumCols(), this.mat.getType());
        this.ops.elementLog(this.mat, t.mat);
        return t;
    }

    public T negative() {
        T t = (T) copy();
        this.ops.changeSign(t.mat);
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void equation(String str, Object... objArr) {
        String str2;
        if (objArr.length >= 25) {
            throw new IllegalArgumentException("Too many variables!  At most 25");
        }
        if (this.mat instanceof DMatrixRMaj) {
            Equation equation = new Equation();
            int i = 0;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    str2 = (String) obj;
                    if (objArr.length % 2 != 1) {
                        throw new IllegalArgumentException("Expected and odd length for variables");
                    }
                    i = 1;
                } else {
                    if (objArr.length % 2 != 0) {
                        throw new IllegalArgumentException("Expected and even length for variables");
                    }
                    str2 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                }
            }
            equation.alias((DMatrixRMaj) this.mat, str2);
            while (i < objArr.length) {
                Object obj2 = objArr[i + 1];
                if (!(obj2 instanceof String)) {
                    throw new IllegalArgumentException("String expected at variables index " + i);
                }
                Object obj3 = objArr[i];
                String str3 = (String) obj2;
                if (SimpleBase.class.isAssignableFrom(obj3.getClass())) {
                    equation.alias(((SimpleBase) obj3).getDDRM(), str3);
                } else if (obj3 instanceof DMatrixRMaj) {
                    equation.alias((DMatrixRMaj) obj3, str3);
                } else if (obj3 instanceof Double) {
                    equation.alias(((Double) obj3).doubleValue(), str3);
                } else if (obj3 instanceof Integer) {
                    equation.alias(((Integer) obj3).intValue(), str3);
                } else {
                    throw new IllegalArgumentException("Variable type not supported by Equation! " + (obj3 == null ? AbstractJsonLexerKt.NULL : obj3.getClass().getSimpleName()));
                }
                i += 2;
            }
            if (!str.contains("=")) {
                str = str2 + " = " + str;
            }
            equation.process(str);
        }
    }

    public void saveToFileBinary(String str) throws IOException {
        MatrixIO.saveBin((DMatrixRMaj) this.mat, str);
    }

    public static SimpleMatrix loadBinary(String str) throws IOException {
        DMatrix dMatrixLoadBin = MatrixIO.loadBin(str);
        if (dMatrixLoadBin instanceof DMatrixRMaj) {
            return SimpleMatrix.wrap((DMatrixRMaj) dMatrixLoadBin);
        }
        return SimpleMatrix.wrap(new DMatrixRMaj(dMatrixLoadBin));
    }

    public void saveToFileCSV(String str) throws IOException {
        MatrixIO.saveDenseCSV((DMatrixRMaj) this.mat, str);
    }

    public T loadCSV(String str) throws IOException {
        DMatrix dMatrixLoadCSV = MatrixIO.loadCSV(str, true);
        T t = (T) createMatrix(1, 1, dMatrixLoadCSV.getType());
        t.setMatrix(dMatrixLoadCSV);
        return t;
    }

    public boolean isInBounds(int i, int i2) {
        return i >= 0 && i2 >= 0 && i < this.mat.getNumRows() && i2 < this.mat.getNumCols();
    }

    public void printDimensions() {
        System.out.println("[rows = " + numRows() + " , cols = " + numCols() + " ]");
    }

    public int bits() {
        return this.mat.getType().getBits();
    }

    public T concatColumns(SimpleBase... simpleBaseArr) {
        Matrix matrixConcatColumns;
        int i = 0;
        if (this.mat.getClass() == DMatrixRMaj.class) {
            DMatrixRMaj[] dMatrixRMajArr = new DMatrixRMaj[simpleBaseArr.length + 1];
            dMatrixRMajArr[0] = (DMatrixRMaj) this.mat;
            while (i < simpleBaseArr.length) {
                dMatrixRMajArr[1] = simpleBaseArr[i].getDDRM();
                i++;
            }
            matrixConcatColumns = CommonOps_DDRM.concatColumns(dMatrixRMajArr);
        } else if (this.mat.getClass() == FMatrixRMaj.class) {
            FMatrixRMaj[] fMatrixRMajArr = new FMatrixRMaj[simpleBaseArr.length + 1];
            fMatrixRMajArr[0] = (FMatrixRMaj) this.mat;
            while (i < simpleBaseArr.length) {
                fMatrixRMajArr[1] = simpleBaseArr[i].getFDRM();
                i++;
            }
            matrixConcatColumns = CommonOps_FDRM.concatColumns(fMatrixRMajArr);
        } else {
            throw new RuntimeException("Unknown matrix type");
        }
        return (T) wrapMatrix(matrixConcatColumns);
    }

    public T concatRows(SimpleBase... simpleBaseArr) {
        Matrix matrixConcatRows;
        int i = 0;
        if (this.mat.getClass() == DMatrixRMaj.class) {
            DMatrixRMaj[] dMatrixRMajArr = new DMatrixRMaj[simpleBaseArr.length + 1];
            dMatrixRMajArr[0] = (DMatrixRMaj) this.mat;
            while (i < simpleBaseArr.length) {
                dMatrixRMajArr[1] = simpleBaseArr[i].getDDRM();
                i++;
            }
            matrixConcatRows = CommonOps_DDRM.concatRows(dMatrixRMajArr);
        } else if (this.mat.getClass() == FMatrixRMaj.class) {
            FMatrixRMaj[] fMatrixRMajArr = new FMatrixRMaj[simpleBaseArr.length + 1];
            fMatrixRMajArr[0] = (FMatrixRMaj) this.mat;
            while (i < simpleBaseArr.length) {
                fMatrixRMajArr[1] = simpleBaseArr[i].getFDRM();
                i++;
            }
            matrixConcatRows = CommonOps_FDRM.concatRows(fMatrixRMajArr);
        } else {
            throw new RuntimeException("Unknown matrix type");
        }
        return (T) wrapMatrix(matrixConcatRows);
    }

    public T rows(int i, int i2) {
        return (T) extractMatrix(i, i2, 0, Integer.MAX_VALUE);
    }

    public T cols(int i, int i2) {
        return (T) extractMatrix(0, Integer.MAX_VALUE, i, i2);
    }

    public MatrixType getType() {
        return this.mat.getType();
    }

    protected void setMatrix(Matrix matrix) {
        this.mat = matrix;
        this.ops = lookupOps(matrix.getType());
    }
}
