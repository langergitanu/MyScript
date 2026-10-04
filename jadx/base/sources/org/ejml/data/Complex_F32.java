package org.ejml.data;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.Serializable;
import org.ejml.ops.ComplexMath_F32;

/* JADX INFO: loaded from: classes9.dex */
public class Complex_F32 implements Serializable {
    public float imaginary;
    public float real;

    public Complex_F32(float f, float f2) {
        this.real = f;
        this.imaginary = f2;
    }

    public Complex_F32() {
    }

    public float getReal() {
        return this.real;
    }

    public float getMagnitude() {
        float f = this.real;
        float f2 = this.imaginary;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public float getMagnitude2() {
        float f = this.real;
        float f2 = this.imaginary;
        return (f * f) + (f2 * f2);
    }

    public void setReal(float f) {
        this.real = f;
    }

    public float getImaginary() {
        return this.imaginary;
    }

    public void setImaginary(float f) {
        this.imaginary = f;
    }

    public void set(float f, float f2) {
        this.real = f;
        this.imaginary = f2;
    }

    public void set(Complex_F32 complex_F32) {
        this.real = complex_F32.real;
        this.imaginary = complex_F32.imaginary;
    }

    public boolean isReal() {
        return this.imaginary == 0.0f;
    }

    public String toString() {
        if (this.imaginary == 0.0f) {
            return "" + this.real;
        }
        return this.real + " " + this.imaginary + CmcdData.OBJECT_TYPE_INIT_SEGMENT;
    }

    public Complex_F32 plus(Complex_F32 complex_F32) {
        Complex_F32 complex_F322 = new Complex_F32();
        ComplexMath_F32.plus(this, complex_F32, complex_F322);
        return complex_F322;
    }

    public Complex_F32 minus(Complex_F32 complex_F32) {
        Complex_F32 complex_F322 = new Complex_F32();
        ComplexMath_F32.minus(this, complex_F32, complex_F322);
        return complex_F322;
    }

    public Complex_F32 times(Complex_F32 complex_F32) {
        Complex_F32 complex_F322 = new Complex_F32();
        ComplexMath_F32.multiply(this, complex_F32, complex_F322);
        return complex_F322;
    }

    public Complex_F32 divide(Complex_F32 complex_F32) {
        Complex_F32 complex_F322 = new Complex_F32();
        ComplexMath_F32.divide(this, complex_F32, complex_F322);
        return complex_F322;
    }
}
