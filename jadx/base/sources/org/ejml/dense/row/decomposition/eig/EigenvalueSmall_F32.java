package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F32;

/* JADX INFO: loaded from: classes9.dex */
public class EigenvalueSmall_F32 {
    public Complex_F32 value0 = new Complex_F32();
    public Complex_F32 value1 = new Complex_F32();

    public void value2x2(float f, float f2, float f3, float f4) {
        float f5;
        float fSqrt;
        float fSqrt2;
        float f6 = f2 + f3;
        float fSqrt3 = 1.0f;
        if (f6 == 0.0f) {
            fSqrt = 1.0f / ((float) Math.sqrt(2.0d));
            f5 = fSqrt;
        } else {
            float fSqrt4 = ((f - f4) / f6) / (((float) Math.sqrt((r2 * r2) + 1.0f)) + 1.0f);
            float fSqrt5 = 1.0f / ((float) Math.sqrt((fSqrt4 * fSqrt4) + 1.0f));
            f5 = fSqrt4 * fSqrt5;
            fSqrt = fSqrt5;
        }
        float f7 = fSqrt * fSqrt;
        float f8 = f5 * f5;
        float f9 = fSqrt * f5;
        float f10 = ((f7 * f) + (f8 * f4)) - (f6 * f9);
        float f11 = f9 * (f - f4);
        float f12 = ((f7 * f2) - (f8 * f3)) + f11;
        float f13 = ((f7 * f3) - (f8 * f2)) + f11;
        if (f13 * f12 >= 0.0f) {
            if (f12 == 0.0f) {
                fSqrt2 = 0.0f;
            } else {
                float f14 = f12 + f13;
                fSqrt3 = (float) Math.sqrt(f13 / f14);
                fSqrt2 = (float) Math.sqrt(f12 / f14);
            }
            float f15 = fSqrt2 * fSqrt3 * (f12 + f13);
            this.value0.real = f10 - f15;
            this.value1.real = f10 + f15;
            Complex_F32 complex_F32 = this.value0;
            this.value1.imaginary = 0.0f;
            complex_F32.imaginary = 0.0f;
            return;
        }
        Complex_F32 complex_F322 = this.value0;
        this.value1.real = f10;
        complex_F322.real = f10;
        this.value0.imaginary = (float) Math.sqrt((-f13) * f12);
        this.value1.imaginary = -this.value0.imaginary;
    }

    public void value2x2_fast(float f, float f2, float f3, float f4) {
        float f5 = (f + f4) / 2.0f;
        float f6 = f - f4;
        float f7 = (f2 * 4.0f * f3) + (f6 * f6);
        if (f7 < 0.0f) {
            Complex_F32 complex_F32 = this.value0;
            this.value1.real = f5;
            complex_F32.real = f5;
            this.value0.imaginary = ((float) Math.sqrt(-f7)) / 2.0f;
            this.value1.imaginary = -this.value0.imaginary;
            return;
        }
        float fSqrt = ((float) Math.sqrt(f7)) / 2.0f;
        this.value0.real = f5 + fSqrt;
        this.value1.real = f5 - fSqrt;
        Complex_F32 complex_F322 = this.value0;
        this.value1.imaginary = 0.0f;
        complex_F322.imaginary = 0.0f;
    }

    public void symm2x2_fast(float f, float f2, float f3) {
        float f4 = (f + f3) * 0.5f;
        float f5 = (f - f3) * 0.5f;
        float fSqrt = (float) Math.sqrt((f5 * f5) + (f2 * f2));
        this.value0.real = f4 + fSqrt;
        this.value1.real = f4 - fSqrt;
    }
}
