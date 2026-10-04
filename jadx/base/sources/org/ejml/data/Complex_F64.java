package org.ejml.data;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import org.ejml.ops.ComplexMath_F64;

/* JADX INFO: loaded from: classes9.dex */
public class Complex_F64 implements Serializable {
    public double imaginary;
    public double real;

    public Complex_F64(double d, double d2) {
        this.real = d;
        this.imaginary = d2;
    }

    public Complex_F64() {
    }

    public double getReal() {
        return this.real;
    }

    public double getMagnitude() {
        double d = this.real;
        double d2 = this.imaginary;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    public double getMagnitude2() {
        double d = this.real;
        double d2 = this.imaginary;
        return (d * d) + (d2 * d2);
    }

    public void setReal(double d) {
        this.real = d;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public void setImaginary(double d) {
        this.imaginary = d;
    }

    public void set(double d, double d2) {
        this.real = d;
        this.imaginary = d2;
    }

    public void set(Complex_F64 complex_F64) {
        this.real = complex_F64.real;
        this.imaginary = complex_F64.imaginary;
    }

    public boolean isReal() {
        return this.imaginary == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public String toString() {
        if (this.imaginary == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return "" + this.real;
        }
        return this.real + " " + this.imaginary + CmcdData.OBJECT_TYPE_INIT_SEGMENT;
    }

    public Complex_F64 plus(Complex_F64 complex_F64) {
        Complex_F64 complex_F642 = new Complex_F64();
        ComplexMath_F64.plus(this, complex_F64, complex_F642);
        return complex_F642;
    }

    public Complex_F64 minus(Complex_F64 complex_F64) {
        Complex_F64 complex_F642 = new Complex_F64();
        ComplexMath_F64.minus(this, complex_F64, complex_F642);
        return complex_F642;
    }

    public Complex_F64 times(Complex_F64 complex_F64) {
        Complex_F64 complex_F642 = new Complex_F64();
        ComplexMath_F64.multiply(this, complex_F64, complex_F642);
        return complex_F642;
    }

    public Complex_F64 divide(Complex_F64 complex_F64) {
        Complex_F64 complex_F642 = new Complex_F64();
        ComplexMath_F64.divide(this, complex_F64, complex_F642);
        return complex_F642;
    }
}
