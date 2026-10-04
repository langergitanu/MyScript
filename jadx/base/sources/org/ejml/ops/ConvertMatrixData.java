package org.ejml.ops;

import org.ejml.data.DMatrix2x2;
import org.ejml.data.DMatrix3x3;
import org.ejml.data.DMatrix4x4;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.FMatrix2x2;
import org.ejml.data.FMatrix3x3;
import org.ejml.data.FMatrix4x4;
import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class ConvertMatrixData {
    public static void convert(DMatrixRMaj dMatrixRMaj, FMatrixRMaj fMatrixRMaj) {
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixRMaj.data[i] = (float) dMatrixRMaj.data[i];
        }
    }

    public static void convert(FMatrixRMaj fMatrixRMaj, DMatrixRMaj dMatrixRMaj) {
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixRMaj.data[i] = fMatrixRMaj.data[i];
        }
    }

    public static void convert(DMatrix2x2 dMatrix2x2, FMatrix2x2 fMatrix2x2) {
        fMatrix2x2.a11 = (float) dMatrix2x2.a11;
        fMatrix2x2.a12 = (float) dMatrix2x2.a12;
        fMatrix2x2.a21 = (float) dMatrix2x2.a21;
        fMatrix2x2.a22 = (float) dMatrix2x2.a22;
    }

    public static void convert(DMatrix3x3 dMatrix3x3, FMatrix3x3 fMatrix3x3) {
        fMatrix3x3.a11 = (float) dMatrix3x3.a11;
        fMatrix3x3.a12 = (float) dMatrix3x3.a12;
        fMatrix3x3.a13 = (float) dMatrix3x3.a13;
        fMatrix3x3.a21 = (float) dMatrix3x3.a21;
        fMatrix3x3.a22 = (float) dMatrix3x3.a22;
        fMatrix3x3.a23 = (float) dMatrix3x3.a23;
        fMatrix3x3.a31 = (float) dMatrix3x3.a31;
        fMatrix3x3.a32 = (float) dMatrix3x3.a32;
        fMatrix3x3.a33 = (float) dMatrix3x3.a33;
    }

    public static void convert(DMatrix4x4 dMatrix4x4, FMatrix4x4 fMatrix4x4) {
        fMatrix4x4.a11 = (float) dMatrix4x4.a11;
        fMatrix4x4.a12 = (float) dMatrix4x4.a12;
        fMatrix4x4.a13 = (float) dMatrix4x4.a13;
        fMatrix4x4.a14 = (float) dMatrix4x4.a14;
        fMatrix4x4.a21 = (float) dMatrix4x4.a21;
        fMatrix4x4.a22 = (float) dMatrix4x4.a22;
        fMatrix4x4.a23 = (float) dMatrix4x4.a23;
        fMatrix4x4.a24 = (float) dMatrix4x4.a24;
        fMatrix4x4.a31 = (float) dMatrix4x4.a31;
        fMatrix4x4.a32 = (float) dMatrix4x4.a32;
        fMatrix4x4.a33 = (float) dMatrix4x4.a33;
        fMatrix4x4.a34 = (float) dMatrix4x4.a34;
        fMatrix4x4.a41 = (float) dMatrix4x4.a41;
        fMatrix4x4.a42 = (float) dMatrix4x4.a42;
        fMatrix4x4.a43 = (float) dMatrix4x4.a43;
        fMatrix4x4.a44 = (float) dMatrix4x4.a44;
    }

    public static void convert(FMatrix2x2 fMatrix2x2, DMatrix2x2 dMatrix2x2) {
        dMatrix2x2.a11 = fMatrix2x2.a11;
        dMatrix2x2.a12 = fMatrix2x2.a12;
        dMatrix2x2.a21 = fMatrix2x2.a21;
        dMatrix2x2.a22 = fMatrix2x2.a22;
    }

    public static void convert(FMatrix3x3 fMatrix3x3, DMatrix3x3 dMatrix3x3) {
        dMatrix3x3.a11 = fMatrix3x3.a11;
        dMatrix3x3.a12 = fMatrix3x3.a12;
        dMatrix3x3.a13 = fMatrix3x3.a13;
        dMatrix3x3.a21 = fMatrix3x3.a21;
        dMatrix3x3.a22 = fMatrix3x3.a22;
        dMatrix3x3.a23 = fMatrix3x3.a23;
        dMatrix3x3.a31 = fMatrix3x3.a31;
        dMatrix3x3.a32 = fMatrix3x3.a32;
        dMatrix3x3.a33 = fMatrix3x3.a33;
    }

    public static void convert(FMatrix4x4 fMatrix4x4, DMatrix4x4 dMatrix4x4) {
        dMatrix4x4.a11 = fMatrix4x4.a11;
        dMatrix4x4.a12 = fMatrix4x4.a12;
        dMatrix4x4.a13 = fMatrix4x4.a13;
        dMatrix4x4.a14 = fMatrix4x4.a14;
        dMatrix4x4.a21 = fMatrix4x4.a21;
        dMatrix4x4.a22 = fMatrix4x4.a22;
        dMatrix4x4.a23 = fMatrix4x4.a23;
        dMatrix4x4.a24 = fMatrix4x4.a24;
        dMatrix4x4.a31 = fMatrix4x4.a31;
        dMatrix4x4.a32 = fMatrix4x4.a32;
        dMatrix4x4.a33 = fMatrix4x4.a33;
        dMatrix4x4.a34 = fMatrix4x4.a34;
        dMatrix4x4.a41 = fMatrix4x4.a41;
        dMatrix4x4.a42 = fMatrix4x4.a42;
        dMatrix4x4.a43 = fMatrix4x4.a43;
        dMatrix4x4.a44 = fMatrix4x4.a44;
    }
}
