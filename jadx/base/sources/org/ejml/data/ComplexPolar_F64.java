package org.ejml.data;

import org.ejml.ops.ComplexMath_F64;

/* JADX INFO: loaded from: classes9.dex */
public class ComplexPolar_F64 {

    /* JADX INFO: renamed from: r */
    public double f2396r;
    public double theta;

    public ComplexPolar_F64(double d, double d2) {
        this.f2396r = d;
        this.theta = d2;
    }

    public ComplexPolar_F64(Complex_F64 complex_F64) {
        ComplexMath_F64.convert(complex_F64, this);
    }

    public ComplexPolar_F64() {
    }

    public Complex_F64 toStandard() {
        Complex_F64 complex_F64 = new Complex_F64();
        ComplexMath_F64.convert(this, complex_F64);
        return complex_F64;
    }

    public double getR() {
        return this.f2396r;
    }

    public void setR(double d) {
        this.f2396r = d;
    }

    public double getTheta() {
        return this.theta;
    }

    public void setTheta(double d) {
        this.theta = d;
    }

    public String toString() {
        return "( r = " + this.f2396r + " theta = " + this.theta + " )";
    }
}
