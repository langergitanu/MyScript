package org.ejml.dense.row.decomposition.eig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;

/* JADX INFO: loaded from: classes9.dex */
public class EigenvalueSmall_F64 {
    public Complex_F64 value0 = new Complex_F64();
    public Complex_F64 value1 = new Complex_F64();

    public void value2x2(double d, double d2, double d3, double d4) {
        double d5;
        double dSqrt;
        double dSqrt2;
        double dSqrt3;
        double d6 = d2 + d3;
        if (d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dSqrt = 1.0d / Math.sqrt(2.0d);
            d5 = dSqrt;
        } else {
            double d7 = (d - d4) / d6;
            double dSqrt4 = d7 / (Math.sqrt((d7 * d7) + 1.0d) + 1.0d);
            double dSqrt5 = 1.0d / Math.sqrt((dSqrt4 * dSqrt4) + 1.0d);
            d5 = dSqrt4 * dSqrt5;
            dSqrt = dSqrt5;
        }
        double d8 = dSqrt * dSqrt;
        double d9 = d5 * d5;
        double d10 = dSqrt * d5;
        double d11 = ((d8 * d) + (d9 * d4)) - (d6 * d10);
        double d12 = d10 * (d - d4);
        double d13 = ((d8 * d2) - (d9 * d3)) + d12;
        double d14 = ((d8 * d3) - (d9 * d2)) + d12;
        if (d14 * d13 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d13 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dSqrt2 = 1.0d;
                dSqrt3 = 0.0d;
            } else {
                double d15 = d13 + d14;
                dSqrt2 = Math.sqrt(d14 / d15);
                dSqrt3 = Math.sqrt(d13 / d15);
            }
            double d16 = dSqrt3 * dSqrt2 * (d13 + d14);
            this.value0.real = d11 - d16;
            this.value1.real = d11 + d16;
            Complex_F64 complex_F64 = this.value0;
            this.value1.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            complex_F64.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            return;
        }
        Complex_F64 complex_F642 = this.value0;
        this.value1.real = d11;
        complex_F642.real = d11;
        this.value0.imaginary = Math.sqrt((-d14) * d13);
        this.value1.imaginary = -this.value0.imaginary;
    }

    public void value2x2_fast(double d, double d2, double d3, double d4) {
        double d5 = (d + d4) / 2.0d;
        double d6 = d - d4;
        double d7 = (d2 * 4.0d * d3) + (d6 * d6);
        if (d7 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            Complex_F64 complex_F64 = this.value0;
            this.value1.real = d5;
            complex_F64.real = d5;
            this.value0.imaginary = Math.sqrt(-d7) / 2.0d;
            this.value1.imaginary = -this.value0.imaginary;
            return;
        }
        double dSqrt = Math.sqrt(d7) / 2.0d;
        this.value0.real = d5 + dSqrt;
        this.value1.real = d5 - dSqrt;
        Complex_F64 complex_F642 = this.value0;
        this.value1.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        complex_F642.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public void symm2x2_fast(double d, double d2, double d3) {
        double d4 = (d + d3) * 0.5d;
        double d5 = (d - d3) * 0.5d;
        double dSqrt = Math.sqrt((d5 * d5) + (d2 * d2));
        this.value0.real = d4 + dSqrt;
        this.value1.real = d4 - dSqrt;
    }
}
