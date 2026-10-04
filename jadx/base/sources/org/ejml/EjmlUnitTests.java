package org.ejml;

import org.ejml.data.CMatrix;
import org.ejml.data.Complex_F32;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrix;
import org.ejml.data.FMatrix;
import org.ejml.data.Matrix;
import org.ejml.data.ZMatrix;

/* JADX INFO: loaded from: classes7.dex */
public class EjmlUnitTests {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void assertCountable(DMatrix dMatrix) {
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                assertTrue(!Double.isNaN(dMatrix.get(i, i2)), "NaN found at " + i + " " + i2);
                assertTrue(!Double.isInfinite(dMatrix.get(i, i2)), "Infinite found at " + i + " " + i2);
            }
        }
    }

    public static void assertShape(Matrix matrix, Matrix matrix2) {
        assertTrue(matrix.getNumRows() == matrix2.getNumRows(), "Number of rows do not match");
        assertTrue(matrix.getNumCols() == matrix2.getNumCols(), "Number of columns do not match");
    }

    public static void assertShape(Matrix matrix, int i, int i2) {
        assertTrue(matrix.getNumRows() == i, "Unexpected number of rows.");
        assertTrue(matrix.getNumCols() == i2, "Unexpected number of columns.");
    }

    public static void assertEqualsUncountable(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        assertShape(dMatrix, dMatrix2);
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                double d2 = dMatrix.get(i, i2);
                double d3 = dMatrix2.get(i, i2);
                if (Double.isNaN(d2)) {
                    assertTrue(Double.isNaN(d3), "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                } else if (Double.isInfinite(d2)) {
                    assertTrue(Double.isInfinite(d3), "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                } else {
                    assertTrue(Math.abs(d2 - d3) <= d, "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                }
            }
        }
    }

    public static void assertEquals(Matrix matrix, Matrix matrix2) {
        if (matrix instanceof DMatrix) {
            assertEquals((DMatrix) matrix, (DMatrix) matrix2, UtilEjml.TEST_F64);
        } else {
            assertEquals((FMatrix) matrix, (FMatrix) matrix2, UtilEjml.TEST_F32);
        }
    }

    public static void assertEquals(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        assertShape(dMatrix, dMatrix2);
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                double d2 = dMatrix.get(i, i2);
                double d3 = dMatrix2.get(i, i2);
                boolean z = true;
                assertTrue((Double.isNaN(d2) || Double.isNaN(d3)) ? false : true, "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                assertTrue((Double.isInfinite(d2) || Double.isInfinite(d3)) ? false : true, "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                if (Math.abs(d2 - d3) > d) {
                    z = false;
                }
                assertTrue(z, "At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
            }
        }
    }

    public static void assertRelativeEquals(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        assertShape(dMatrix, dMatrix2);
        int i = 0;
        while (i < dMatrix.getNumRows()) {
            int i2 = 0;
            while (i2 < dMatrix.getNumCols()) {
                double d2 = dMatrix.get(i, i2);
                double d3 = dMatrix2.get(i, i2);
                if (Double.isNaN(d2) != Double.isNaN(d3) || Double.isInfinite(d2) != Double.isInfinite(d3)) {
                    throw new AssertionError("At (" + i + "," + i2 + ") A = " + d2 + " B = " + d3);
                }
                int i3 = i;
                double dAbs = Math.abs(d2 - d3) / Math.max(Math.abs(d2), Math.abs(d3));
                if (dAbs > d) {
                    System.out.println("------------  A  -----------");
                    dMatrix.print();
                    System.out.println("\n------------  B  -----------");
                    dMatrix2.print();
                    throw new AssertionError("At (" + i3 + "," + i2 + ") A = " + d2 + " B = " + d3 + "   error = " + dAbs);
                }
                i2++;
                i = i3;
            }
            i++;
        }
    }

    public static void assertEquals(FMatrix fMatrix, FMatrix fMatrix2, float f) {
        assertShape(fMatrix, fMatrix2);
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                float f2 = fMatrix.get(i, i2);
                float f3 = fMatrix2.get(i, i2);
                boolean z = true;
                assertTrue((Float.isNaN(f2) || Float.isNaN(f3)) ? false : true, "At (" + i + "," + i2 + ") A = " + f2 + " B = " + f3);
                assertTrue((Float.isInfinite(f2) || Float.isInfinite(f3)) ? false : true, "At (" + i + "," + i2 + ") A = " + f2 + " B = " + f3);
                if (Math.abs(f2 - f3) > f) {
                    z = false;
                }
                assertTrue(z, "At (" + i + "," + i2 + ") A = " + f2 + " B = " + f3);
            }
        }
    }

    public static void assertEquals(Complex_F64 complex_F64, Complex_F64 complex_F642, double d) {
        assertTrue((Double.isNaN(complex_F64.real) || Double.isNaN(complex_F642.real)) ? false : true, "real a = " + complex_F64.real + " b = " + complex_F642.real);
        assertTrue((Double.isInfinite(complex_F64.real) || Double.isInfinite(complex_F642.real)) ? false : true, "real a = " + complex_F64.real + " b = " + complex_F642.real);
        assertTrue(Math.abs(complex_F64.real - complex_F642.real) <= d, "real a = " + complex_F64.real + " b = " + complex_F642.real);
        assertTrue((Double.isNaN(complex_F64.imaginary) || Double.isNaN(complex_F642.imaginary)) ? false : true, "imaginary a = " + complex_F64.imaginary + " b = " + complex_F642.imaginary);
        assertTrue((Double.isInfinite(complex_F64.imaginary) || Double.isInfinite(complex_F642.imaginary)) ? false : true, "imaginary a = " + complex_F64.imaginary + " b = " + complex_F642.imaginary);
        assertTrue(Math.abs(complex_F64.imaginary - complex_F642.imaginary) <= d, "imaginary a = " + complex_F64.imaginary + " b = " + complex_F642.imaginary);
    }

    public static void assertEquals(Complex_F32 complex_F32, Complex_F32 complex_F322, float f) {
        assertTrue((Float.isNaN(complex_F32.real) || Float.isNaN(complex_F322.real)) ? false : true, "real a = " + complex_F32.real + " b = " + complex_F322.real);
        assertTrue((Float.isInfinite(complex_F32.real) || Float.isInfinite(complex_F322.real)) ? false : true, "real a = " + complex_F32.real + " b = " + complex_F322.real);
        assertTrue(Math.abs(complex_F32.real - complex_F322.real) <= f, "real a = " + complex_F32.real + " b = " + complex_F322.real);
        assertTrue((Float.isNaN(complex_F32.imaginary) || Float.isNaN(complex_F322.imaginary)) ? false : true, "imaginary a = " + complex_F32.imaginary + " b = " + complex_F322.imaginary);
        assertTrue((Float.isInfinite(complex_F32.imaginary) || Float.isInfinite(complex_F322.imaginary)) ? false : true, "imaginary a = " + complex_F32.imaginary + " b = " + complex_F322.imaginary);
        assertTrue(Math.abs(complex_F32.imaginary - complex_F322.imaginary) <= f, "imaginary a = " + complex_F32.imaginary + " b = " + complex_F322.imaginary);
    }

    public static void assertEquals(ZMatrix zMatrix, ZMatrix zMatrix2, double d) {
        assertShape(zMatrix, zMatrix2);
        Complex_F64 complex_F64 = new Complex_F64();
        Complex_F64 complex_F642 = new Complex_F64();
        for (int i = 0; i < zMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < zMatrix.getNumCols(); i2++) {
                zMatrix.get(i, i2, complex_F64);
                zMatrix2.get(i, i2, complex_F642);
                assertTrue((Double.isNaN(complex_F64.real) || Double.isNaN(complex_F642.real)) ? false : true, "Real At (" + i + "," + i2 + ") A = " + complex_F64.real + " B = " + complex_F642.real);
                assertTrue((Double.isInfinite(complex_F64.real) || Double.isInfinite(complex_F642.real)) ? false : true, "Real At (" + i + "," + i2 + ") A = " + complex_F64.real + " B = " + complex_F642.real);
                assertTrue(Math.abs(complex_F64.real - complex_F642.real) <= d, "Real At (" + i + "," + i2 + ") A = " + complex_F64.real + " B = " + complex_F642.real);
                assertTrue((Double.isNaN(complex_F64.imaginary) || Double.isNaN(complex_F642.imaginary)) ? false : true, "Img At (" + i + "," + i2 + ") A = " + complex_F64.imaginary + " B = " + complex_F642.imaginary);
                assertTrue((Double.isInfinite(complex_F64.imaginary) || Double.isInfinite(complex_F642.imaginary)) ? false : true, "Img At (" + i + "," + i2 + ") A = " + complex_F64.imaginary + " B = " + complex_F642.imaginary);
                assertTrue(Math.abs(complex_F64.imaginary - complex_F642.imaginary) <= d, "Img At (" + i + "," + i2 + ") A = " + complex_F64.imaginary + " B = " + complex_F642.imaginary);
            }
        }
    }

    public static void assertEquals(CMatrix cMatrix, CMatrix cMatrix2, float f) {
        assertShape(cMatrix, cMatrix2);
        Complex_F32 complex_F32 = new Complex_F32();
        Complex_F32 complex_F322 = new Complex_F32();
        for (int i = 0; i < cMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < cMatrix.getNumCols(); i2++) {
                cMatrix.get(i, i2, complex_F32);
                cMatrix2.get(i, i2, complex_F322);
                boolean z = true;
                assertTrue((Float.isNaN(complex_F32.real) || Float.isNaN(complex_F322.real)) ? false : true, "Real At (" + i + "," + i2 + ") A = " + complex_F32.real + " B = " + complex_F322.real);
                assertTrue((Float.isInfinite(complex_F32.real) || Float.isInfinite(complex_F322.real)) ? false : true, "Real At (" + i + "," + i2 + ") A = " + complex_F32.real + " B = " + complex_F322.real);
                assertTrue(Math.abs(complex_F32.real - complex_F322.real) <= f, "Real At (" + i + "," + i2 + ") A = " + complex_F32.real + " B = " + complex_F322.real);
                assertTrue((Float.isNaN(complex_F32.imaginary) || Float.isNaN(complex_F322.imaginary)) ? false : true, "Img At (" + i + "," + i2 + ") A = " + complex_F32.imaginary + " B = " + complex_F322.imaginary);
                assertTrue((Float.isInfinite(complex_F32.imaginary) || Float.isInfinite(complex_F322.imaginary)) ? false : true, "Img At (" + i + "," + i2 + ") A = " + complex_F32.imaginary + " B = " + complex_F322.imaginary);
                if (Math.abs(complex_F32.imaginary - complex_F322.imaginary) > f) {
                    z = false;
                }
                assertTrue(z, "Img At (" + i + "," + i2 + ") A = " + complex_F32.imaginary + " B = " + complex_F322.imaginary);
            }
        }
    }

    public static void assertEqualsTrans(DMatrix dMatrix, DMatrix dMatrix2, double d) {
        assertShape(dMatrix, dMatrix2.getNumCols(), dMatrix2.getNumRows());
        for (int i = 0; i < dMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < dMatrix.getNumCols(); i2++) {
                double d2 = dMatrix.get(i, i2);
                double d3 = dMatrix2.get(i2, i);
                boolean z = true;
                assertTrue((Double.isNaN(d2) || Double.isNaN(d3)) ? false : true, "A(" + i + "," + i2 + ") = " + d2 + ") B(" + i2 + "," + i + ") = " + d3);
                assertTrue((Double.isInfinite(d2) || Double.isInfinite(d3)) ? false : true, "A(" + i + "," + i2 + ") = " + d2 + ") B(" + i2 + "," + i + ") = " + d3);
                if (Math.abs(d2 - d3) > d) {
                    z = false;
                }
                assertTrue(z, "A(" + i + "," + i2 + ") = " + d2 + ") B(" + i2 + "," + i + ") = " + d3);
            }
        }
    }

    public static void assertEqualsTrans(FMatrix fMatrix, FMatrix fMatrix2, double d) {
        assertShape(fMatrix, fMatrix2.getNumCols(), fMatrix2.getNumRows());
        for (int i = 0; i < fMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < fMatrix.getNumCols(); i2++) {
                Float fValueOf = Float.valueOf(fMatrix.get(i, i2));
                Float fValueOf2 = Float.valueOf(fMatrix2.get(i2, i));
                boolean z = true;
                assertTrue((Float.isNaN(fValueOf.floatValue()) || Float.isNaN(fValueOf2.floatValue())) ? false : true, "A(" + i + "," + i2 + ") = " + fValueOf + ") B(" + i2 + "," + i + ") = " + fValueOf2);
                assertTrue((Float.isInfinite(fValueOf.floatValue()) || Float.isInfinite(fValueOf2.floatValue())) ? false : true, "A(" + i + "," + i2 + ") = " + fValueOf + ") B(" + i2 + "," + i + ") = " + fValueOf2);
                if (Math.abs(fValueOf.floatValue() - fValueOf2.floatValue()) > d) {
                    z = false;
                }
                assertTrue(z, "A(" + i + "," + i2 + ") = " + fValueOf + ") B(" + i2 + "," + i + ") = " + fValueOf2);
            }
        }
    }

    private static void assertTrue(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }
}
