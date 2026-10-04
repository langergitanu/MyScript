package org.ejml.ops;

import org.ejml.UtilEjml;
import org.ejml.data.ComplexPolar_F32;
import org.ejml.data.Complex_F32;

/* JADX INFO: loaded from: classes9.dex */
public class ComplexMath_F32 {
    public static void conj(Complex_F32 complex_F32, Complex_F32 complex_F322) {
        complex_F322.real = complex_F32.real;
        complex_F322.imaginary = -complex_F32.imaginary;
    }

    public static void plus(Complex_F32 complex_F32, Complex_F32 complex_F322, Complex_F32 complex_F323) {
        complex_F323.real = complex_F32.real + complex_F322.real;
        complex_F323.imaginary = complex_F32.imaginary + complex_F322.imaginary;
    }

    public static void minus(Complex_F32 complex_F32, Complex_F32 complex_F322, Complex_F32 complex_F323) {
        complex_F323.real = complex_F32.real - complex_F322.real;
        complex_F323.imaginary = complex_F32.imaginary - complex_F322.imaginary;
    }

    public static void multiply(Complex_F32 complex_F32, Complex_F32 complex_F322, Complex_F32 complex_F323) {
        complex_F323.real = (complex_F32.real * complex_F322.real) - (complex_F32.imaginary * complex_F322.imaginary);
        complex_F323.imaginary = (complex_F32.real * complex_F322.imaginary) + (complex_F32.imaginary * complex_F322.real);
    }

    public static void divide(Complex_F32 complex_F32, Complex_F32 complex_F322, Complex_F32 complex_F323) {
        float magnitude2 = complex_F322.getMagnitude2();
        complex_F323.real = ((complex_F32.real * complex_F322.real) + (complex_F32.imaginary * complex_F322.imaginary)) / magnitude2;
        complex_F323.imaginary = ((complex_F32.imaginary * complex_F322.real) - (complex_F32.real * complex_F322.imaginary)) / magnitude2;
    }

    public static void convert(Complex_F32 complex_F32, ComplexPolar_F32 complexPolar_F32) {
        complexPolar_F32.f2395r = complex_F32.getMagnitude();
        complexPolar_F32.theta = (float) Math.atan2(complex_F32.imaginary, complex_F32.real);
    }

    public static void convert(ComplexPolar_F32 complexPolar_F32, Complex_F32 complex_F32) {
        complex_F32.real = complexPolar_F32.f2395r * ((float) Math.cos(complexPolar_F32.theta));
        complex_F32.imaginary = complexPolar_F32.f2395r * ((float) Math.sin(complexPolar_F32.theta));
    }

    public static void multiply(ComplexPolar_F32 complexPolar_F32, ComplexPolar_F32 complexPolar_F322, ComplexPolar_F32 complexPolar_F323) {
        complexPolar_F323.f2395r = complexPolar_F32.f2395r * complexPolar_F322.f2395r;
        complexPolar_F323.theta = complexPolar_F32.theta + complexPolar_F322.theta;
    }

    public static void divide(ComplexPolar_F32 complexPolar_F32, ComplexPolar_F32 complexPolar_F322, ComplexPolar_F32 complexPolar_F323) {
        complexPolar_F323.f2395r = complexPolar_F32.f2395r / complexPolar_F322.f2395r;
        complexPolar_F323.theta = complexPolar_F32.theta - complexPolar_F322.theta;
    }

    public static void pow(ComplexPolar_F32 complexPolar_F32, int i, ComplexPolar_F32 complexPolar_F322) {
        complexPolar_F322.f2395r = (float) Math.pow(complexPolar_F32.f2395r, i);
        complexPolar_F322.theta = i * complexPolar_F32.theta;
    }

    public static void root(ComplexPolar_F32 complexPolar_F32, int i, int i2, ComplexPolar_F32 complexPolar_F322) {
        complexPolar_F322.f2395r = (float) Math.pow(complexPolar_F32.f2395r, 1.0f / r5);
        complexPolar_F322.theta = (complexPolar_F32.theta + ((i2 * 2.0f) * UtilEjml.F_PI)) / i;
    }

    public static void root(Complex_F32 complex_F32, int i, int i2, Complex_F32 complex_F322) {
        float magnitude = complex_F32.getMagnitude();
        float fAtan2 = (float) Math.atan2(complex_F32.imaginary, complex_F32.real);
        float fPow = (float) Math.pow(magnitude, 1.0f / r6);
        double d = (fAtan2 + ((i2 * 2.0f) * UtilEjml.F_PI)) / i;
        complex_F322.real = ((float) Math.cos(d)) * fPow;
        complex_F322.imaginary = fPow * ((float) Math.sin(d));
    }

    public static void sqrt(Complex_F32 complex_F32, Complex_F32 complex_F322) {
        float magnitude = complex_F32.getMagnitude();
        float f = complex_F32.real;
        complex_F322.real = (float) Math.sqrt((magnitude + f) / 2.0f);
        complex_F322.imaginary = (float) Math.sqrt((magnitude - f) / 2.0f);
        if (complex_F32.imaginary < 0.0f) {
            complex_F322.imaginary = -complex_F322.imaginary;
        }
    }
}
