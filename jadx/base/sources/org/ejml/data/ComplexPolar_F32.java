package org.ejml.data;

import org.ejml.ops.ComplexMath_F32;

/* JADX INFO: loaded from: classes9.dex */
public class ComplexPolar_F32 {

    /* JADX INFO: renamed from: r */
    public float f2395r;
    public float theta;

    public ComplexPolar_F32(float f, float f2) {
        this.f2395r = f;
        this.theta = f2;
    }

    public ComplexPolar_F32(Complex_F32 complex_F32) {
        ComplexMath_F32.convert(complex_F32, this);
    }

    public ComplexPolar_F32() {
    }

    public Complex_F32 toStandard() {
        Complex_F32 complex_F32 = new Complex_F32();
        ComplexMath_F32.convert(this, complex_F32);
        return complex_F32;
    }

    public float getR() {
        return this.f2395r;
    }

    public void setR(float f) {
        this.f2395r = f;
    }

    public float getTheta() {
        return this.theta;
    }

    public void setTheta(float f) {
        this.theta = f;
    }

    public String toString() {
        return "( r = " + this.f2395r + " theta = " + this.theta + " )";
    }
}
