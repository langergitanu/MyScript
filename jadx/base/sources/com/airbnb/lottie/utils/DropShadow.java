package com.airbnb.lottie.utils;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.airbnb.lottie.utils.OffscreenLayer;

/* JADX INFO: loaded from: classes4.dex */
public class DropShadow {
    private int color;

    /* JADX INFO: renamed from: dx */
    private float f544dx;

    /* JADX INFO: renamed from: dy */
    private float f545dy;
    private float radius;
    private float[] vecs;

    public DropShadow() {
        this.radius = 0.0f;
        this.f544dx = 0.0f;
        this.f545dy = 0.0f;
        this.color = 0;
    }

    public DropShadow(float f, float f2, float f3, int i) {
        this.radius = f;
        this.f544dx = f2;
        this.f545dy = f3;
        this.color = i;
        this.vecs = null;
    }

    public DropShadow(DropShadow dropShadow) {
        this.radius = 0.0f;
        this.f544dx = 0.0f;
        this.f545dy = 0.0f;
        this.color = 0;
        this.radius = dropShadow.radius;
        this.f544dx = dropShadow.f544dx;
        this.f545dy = dropShadow.f545dy;
        this.color = dropShadow.color;
        this.vecs = null;
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public float getDx() {
        return this.f544dx;
    }

    public void setDx(float f) {
        this.f544dx = f;
    }

    public float getDy() {
        return this.f545dy;
    }

    public void setDy(float f) {
        this.f545dy = f;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public boolean sameAs(DropShadow dropShadow) {
        return this.radius == dropShadow.radius && this.f544dx == dropShadow.f544dx && this.f545dy == dropShadow.f545dy && this.color == dropShadow.color;
    }

    public void transformBy(Matrix matrix) {
        if (this.vecs == null) {
            this.vecs = new float[2];
        }
        float[] fArr = this.vecs;
        fArr[0] = this.f544dx;
        fArr[1] = this.f545dy;
        matrix.mapVectors(fArr);
        float[] fArr2 = this.vecs;
        this.f544dx = fArr2[0];
        this.f545dy = fArr2[1];
        this.radius = matrix.mapRadius(this.radius);
    }

    public void multiplyOpacity(int i) {
        this.color = Color.argb(Math.round((Color.alpha(this.color) * MiscUtils.clamp(i, 0, 255)) / 255.0f), Color.red(this.color), Color.green(this.color), Color.blue(this.color));
    }

    public void applyTo(Paint paint) {
        if (Color.alpha(this.color) > 0) {
            paint.setShadowLayer(Math.max(this.radius, Float.MIN_VALUE), this.f544dx, this.f545dy, this.color);
        } else {
            paint.clearShadowLayer();
        }
    }

    public void applyWithAlpha(int i, Paint paint) {
        int iMixOpacities = Utils.mixOpacities(Color.alpha(this.color), MiscUtils.clamp(i, 0, 255));
        if (iMixOpacities > 0) {
            paint.setShadowLayer(Math.max(this.radius, Float.MIN_VALUE), this.f544dx, this.f545dy, Color.argb(iMixOpacities, Color.red(this.color), Color.green(this.color), Color.blue(this.color)));
        } else {
            paint.clearShadowLayer();
        }
    }

    public void applyWithAlpha(int i, OffscreenLayer.ComposeOp composeOp) {
        composeOp.shadow = new DropShadow(this);
        composeOp.shadow.multiplyOpacity(i);
    }

    public void applyTo(OffscreenLayer.ComposeOp composeOp) {
        if (Color.alpha(this.color) > 0) {
            composeOp.shadow = this;
        } else {
            composeOp.shadow = null;
        }
    }
}
