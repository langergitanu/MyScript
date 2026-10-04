package org.ejml.ops;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.ComplexPolar_F64;
import org.ejml.data.Complex_F64;

/* JADX INFO: loaded from: classes9.dex */
public class ComplexMath_F64 {
    public static void conj(Complex_F64 complex_F64, Complex_F64 complex_F642) {
        complex_F642.real = complex_F64.real;
        complex_F642.imaginary = -complex_F64.imaginary;
    }

    public static void plus(Complex_F64 complex_F64, Complex_F64 complex_F642, Complex_F64 complex_F643) {
        complex_F643.real = complex_F64.real + complex_F642.real;
        complex_F643.imaginary = complex_F64.imaginary + complex_F642.imaginary;
    }

    public static void minus(Complex_F64 complex_F64, Complex_F64 complex_F642, Complex_F64 complex_F643) {
        complex_F643.real = complex_F64.real - complex_F642.real;
        complex_F643.imaginary = complex_F64.imaginary - complex_F642.imaginary;
    }

    public static void multiply(Complex_F64 complex_F64, Complex_F64 complex_F642, Complex_F64 complex_F643) {
        complex_F643.real = (complex_F64.real * complex_F642.real) - (complex_F64.imaginary * complex_F642.imaginary);
        complex_F643.imaginary = (complex_F64.real * complex_F642.imaginary) + (complex_F64.imaginary * complex_F642.real);
    }

    public static void divide(Complex_F64 complex_F64, Complex_F64 complex_F642, Complex_F64 complex_F643) {
        double magnitude2 = complex_F642.getMagnitude2();
        complex_F643.real = ((complex_F64.real * complex_F642.real) + (complex_F64.imaginary * complex_F642.imaginary)) / magnitude2;
        complex_F643.imaginary = ((complex_F64.imaginary * complex_F642.real) - (complex_F64.real * complex_F642.imaginary)) / magnitude2;
    }

    public static void convert(Complex_F64 complex_F64, ComplexPolar_F64 complexPolar_F64) {
        complexPolar_F64.f2396r = complex_F64.getMagnitude();
        complexPolar_F64.theta = Math.atan2(complex_F64.imaginary, complex_F64.real);
    }

    public static void convert(ComplexPolar_F64 complexPolar_F64, Complex_F64 complex_F64) {
        complex_F64.real = complexPolar_F64.f2396r * Math.cos(complexPolar_F64.theta);
        complex_F64.imaginary = complexPolar_F64.f2396r * Math.sin(complexPolar_F64.theta);
    }

    public static void multiply(ComplexPolar_F64 complexPolar_F64, ComplexPolar_F64 complexPolar_F642, ComplexPolar_F64 complexPolar_F643) {
        complexPolar_F643.f2396r = complexPolar_F64.f2396r * complexPolar_F642.f2396r;
        complexPolar_F643.theta = complexPolar_F64.theta + complexPolar_F642.theta;
    }

    public static void divide(ComplexPolar_F64 complexPolar_F64, ComplexPolar_F64 complexPolar_F642, ComplexPolar_F64 complexPolar_F643) {
        complexPolar_F643.f2396r = complexPolar_F64.f2396r / complexPolar_F642.f2396r;
        complexPolar_F643.theta = complexPolar_F64.theta - complexPolar_F642.theta;
    }

    public static void pow(ComplexPolar_F64 complexPolar_F64, int i, ComplexPolar_F64 complexPolar_F642) {
        double d = i;
        complexPolar_F642.f2396r = Math.pow(complexPolar_F64.f2396r, d);
        complexPolar_F642.theta = d * complexPolar_F64.theta;
    }

    public static void root(ComplexPolar_F64 complexPolar_F64, int i, int i2, ComplexPolar_F64 complexPolar_F642) {
        double d = i;
        complexPolar_F642.f2396r = Math.pow(complexPolar_F64.f2396r, 1.0d / d);
        complexPolar_F642.theta = (complexPolar_F64.theta + ((((double) i2) * 2.0d) * UtilEjml.f2394PI)) / d;
    }

    public static void root(Complex_F64 complex_F64, int i, int i2, Complex_F64 complex_F642) {
        double magnitude = complex_F64.getMagnitude();
        double dAtan2 = Math.atan2(complex_F64.imaginary, complex_F64.real);
        double d = i;
        double dPow = Math.pow(magnitude, 1.0d / d);
        double d2 = (dAtan2 + ((((double) i2) * 2.0d) * UtilEjml.f2394PI)) / d;
        complex_F642.real = Math.cos(d2) * dPow;
        complex_F642.imaginary = dPow * Math.sin(d2);
    }

    public static void sqrt(Complex_F64 complex_F64, Complex_F64 complex_F642) {
        double magnitude = complex_F64.getMagnitude();
        double d = complex_F64.real;
        complex_F642.real = Math.sqrt((magnitude + d) / 2.0d);
        complex_F642.imaginary = Math.sqrt((magnitude - d) / 2.0d);
        if (complex_F64.imaginary < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            complex_F642.imaginary = -complex_F642.imaginary;
        }
    }
}
