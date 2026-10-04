package com.samsung.android.sdk.pen.util.color;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenColorMatching.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, m1599d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorMatching;", "", "<init>", "()V", "mLastMatchedDistanceValue", "", "mLastMatchedIndex", "", "mHSV2", "", "", "[[F", "matchColor", "", "input", "output", "getMatchedColorIndex", "hsv", "clearMatchedData", "", "resultValue", "getResultValue", "()D", "resultIndex", "getResultIndex", "()I", "getResultColor", "color", "matchHsvColor", "isSaveRecord", "Companion", "Point3", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenColorMatching {
    public static final double INVALID_DISTANCE = 1200.0d;
    private static final String TAG = "SpenColorMatching";
    private final float[][] mHSV2 = {new float[]{0.0f, 0.0f, 0.99f}, new float[]{0.0f, 0.11f, 1.0f}, new float[]{25.0f, 0.13f, 1.0f}, new float[]{43.0f, 0.14f, 1.0f}, new float[]{57.0f, 0.14f, 1.0f}, new float[]{98.0f, 0.09f, 1.0f}, new float[]{143.0f, 0.1f, 0.99f}, new float[]{172.0f, 0.11f, 1.0f}, new float[]{212.0f, 0.14f, 1.0f}, new float[]{228.0f, 0.14f, 1.0f}, new float[]{272.0f, 0.14f, 1.0f}, new float[]{302.0f, 0.11f, 1.0f}, new float[]{337.0f, 0.11f, 1.0f}, new float[]{0.0f, 0.0f, 0.9f}, new float[]{0.0f, 0.21f, 1.0f}, new float[]{26.0f, 0.23f, 1.0f}, new float[]{44.0f, 0.25f, 1.0f}, new float[]{57.0f, 0.25f, 1.0f}, new float[]{98.0f, 0.15f, 1.0f}, new float[]{144.0f, 0.18f, 0.98f}, new float[]{172.0f, 0.2f, 1.0f}, new float[]{211.0f, 0.25f, 1.0f}, new float[]{228.0f, 0.25f, 1.0f}, new float[]{272.0f, 0.21f, 1.0f}, new float[]{302.0f, 0.19f, 1.0f}, new float[]{337.0f, 0.2f, 1.0f}, new float[]{0.0f, 0.0f, 0.8f}, new float[]{1.0f, 0.37f, 1.0f}, new float[]{26.0f, 0.36f, 1.0f}, new float[]{45.0f, 0.4f, 1.0f}, new float[]{57.0f, 0.4f, 1.0f}, new float[]{98.0f, 0.24f, 1.0f}, new float[]{144.0f, 0.29f, 0.98f}, new float[]{172.0f, 0.32f, 1.0f}, new float[]{211.0f, 0.4f, 1.0f}, new float[]{227.0f, 0.4f, 1.0f}, new float[]{272.0f, 0.35f, 1.0f}, new float[]{302.0f, 0.3f, 1.0f}, new float[]{337.0f, 0.32f, 1.0f}, new float[]{0.0f, 0.0f, 0.7f}, new float[]{2.0f, 0.51f, 1.0f}, new float[]{26.0f, 0.49f, 1.0f}, new float[]{45.0f, 0.55f, 1.0f}, new float[]{57.0f, 0.55f, 1.0f}, new float[]{98.0f, 0.33f, 1.0f}, new float[]{144.0f, 0.4f, 0.97f}, new float[]{172.0f, 0.44f, 1.0f}, new float[]{211.0f, 0.55f, 1.0f}, new float[]{227.0f, 0.55f, 1.0f}, new float[]{272.0f, 0.48f, 1.0f}, new float[]{302.0f, 0.41f, 1.0f}, new float[]{337.0f, 0.44f, 1.0f}, new float[]{0.0f, 0.0f, 0.6f}, new float[]{0.0f, 0.65f, 1.0f}, new float[]{26.0f, 0.63f, 1.0f}, new float[]{45.0f, 0.66f, 1.0f}, new float[]{57.0f, 0.7f, 1.0f}, new float[]{98.0f, 0.4f, 1.0f}, new float[]{144.0f, 0.49f, 0.96f}, new float[]{172.0f, 0.53f, 1.0f}, new float[]{211.0f, 0.7f, 1.0f}, new float[]{227.0f, 0.7f, 1.0f}, new float[]{270.0f, 0.58f, 1.0f}, new float[]{302.0f, 0.53f, 1.0f}, new float[]{337.0f, 0.56f, 1.0f}, new float[]{0.0f, 0.0f, 0.5f}, new float[]{0.0f, 0.79f, 1.0f}, new float[]{26.0f, 0.76f, 1.0f}, new float[]{45.0f, 0.81f, 1.0f}, new float[]{58.0f, 0.9f, 0.99f}, new float[]{98.0f, 0.6f, 1.0f}, new float[]{144.0f, 0.68f, 0.96f}, new float[]{172.0f, 0.8f, 1.0f}, new float[]{211.0f, 0.8f, 1.0f}, new float[]{227.0f, 0.8f, 1.0f}, new float[]{270.0f, 0.69f, 1.0f}, new float[]{302.0f, 0.6f, 1.0f}, new float[]{337.0f, 0.64f, 1.0f}, new float[]{0.0f, 0.0f, 0.4f}, new float[]{0.0f, 0.93f, 1.0f}, new float[]{26.0f, 0.9f, 1.0f}, new float[]{45.0f, 1.0f, 0.97f}, new float[]{57.0f, 1.0f, 0.97f}, new float[]{97.0f, 0.6f, 0.97f}, new float[]{143.0f, 0.7f, 0.93f}, new float[]{172.0f, 0.8f, 0.97f}, new float[]{210.0f, 0.94f, 1.0f}, new float[]{227.0f, 0.92f, 1.0f}, new float[]{270.0f, 0.8f, 1.0f}, new float[]{302.0f, 0.75f, 1.0f}, new float[]{337.0f, 0.73f, 1.0f}, new float[]{0.0f, 0.0f, 0.3f}, new float[]{0.0f, 0.93f, 0.91f}, new float[]{26.0f, 0.9f, 0.92f}, new float[]{45.0f, 1.0f, 0.92f}, new float[]{57.0f, 1.0f, 0.92f}, new float[]{98.0f, 0.6f, 0.92f}, new float[]{144.0f, 0.75f, 0.87f}, new float[]{172.0f, 0.8f, 0.92f}, new float[]{211.0f, 1.0f, 0.92f}, new float[]{227.0f, 0.97f, 0.92f}, new float[]{270.0f, 0.91f, 1.0f}, new float[]{302.0f, 0.75f, 0.92f}, new float[]{337.0f, 0.75f, 0.93f}, new float[]{0.0f, 0.0f, 0.25f}, new float[]{0.0f, 0.92f, 0.83f}, new float[]{26.0f, 0.9f, 0.85f}, new float[]{45.0f, 1.0f, 0.85f}, new float[]{57.0f, 1.0f, 0.85f}, new float[]{98.0f, 0.6f, 0.85f}, new float[]{144.0f, 0.75f, 0.81f}, new float[]{172.0f, 0.8f, 0.85f}, new float[]{211.0f, 1.0f, 0.85f}, new float[]{227.0f, 1.0f, 0.85f}, new float[]{270.0f, 1.0f, 0.92f}, new float[]{302.0f, 0.75f, 0.85f}, new float[]{337.0f, 0.8f, 0.85f}, new float[]{0.0f, 0.0f, 0.2f}, new float[]{0.0f, 0.93f, 0.72f}, new float[]{26.0f, 0.9f, 0.72f}, new float[]{45.0f, 1.0f, 0.72f}, new float[]{57.0f, 1.0f, 0.72f}, new float[]{98.0f, 0.6f, 0.72f}, new float[]{143.0f, 0.75f, 0.69f}, new float[]{172.0f, 0.81f, 0.72f}, new float[]{211.0f, 1.0f, 0.72f}, new float[]{227.0f, 1.0f, 0.72f}, new float[]{270.0f, 1.0f, 0.8f}, new float[]{302.0f, 0.75f, 0.72f}, new float[]{337.0f, 0.8f, 0.72f}, new float[]{0.0f, 0.0f, 0.145f}, new float[]{0.0f, 0.93f, 0.6f}, new float[]{26.0f, 1.0f, 0.6f}, new float[]{45.0f, 1.0f, 0.6f}, new float[]{57.0f, 1.0f, 0.6f}, new float[]{98.0f, 0.6f, 0.6f}, new float[]{144.0f, 0.75f, 0.57f}, new float[]{171.0f, 0.8f, 0.58f}, new float[]{211.0f, 1.0f, 0.6f}, new float[]{227.0f, 1.0f, 0.6f}, new float[]{270.0f, 1.0f, 0.64f}, new float[]{302.0f, 0.75f, 0.65f}, new float[]{337.0f, 0.8f, 0.62f}, new float[]{0.0f, 0.0f, 0.1f}, new float[]{0.0f, 0.93f, 0.43f}, new float[]{26.0f, 1.0f, 0.43f}, new float[]{39.0f, 1.0f, 0.43f}, new float[]{57.0f, 1.0f, 0.43f}, new float[]{98.0f, 0.6f, 0.42f}, new float[]{144.0f, 0.75f, 0.41f}, new float[]{172.0f, 0.8f, 0.39f}, new float[]{211.0f, 1.0f, 0.43f}, new float[]{227.0f, 1.0f, 0.43f}, new float[]{270.0f, 1.0f, 0.5f}, new float[]{302.0f, 0.75f, 0.43f}, new float[]{338.0f, 0.8f, 0.49f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.94f, 0.25f}, new float[]{26.0f, 1.0f, 0.32f}, new float[]{40.0f, 1.0f, 0.32f}, new float[]{57.0f, 1.0f, 0.32f}, new float[]{99.0f, 0.61f, 0.29f}, new float[]{144.0f, 0.75f, 0.28f}, new float[]{172.0f, 0.81f, 0.29f}, new float[]{211.0f, 1.0f, 0.32f}, new float[]{228.0f, 1.0f, 0.32f}, new float[]{270.0f, 1.0f, 0.38f}, new float[]{302.0f, 0.76f, 0.29f}, new float[]{337.0f, 0.81f, 0.37f}};
    private double mLastMatchedDistanceValue;
    private int mLastMatchedIndex;

    public final boolean matchColor(float[] input, float[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        int matchedColorIndex = getMatchedColorIndex(input);
        if (matchedColorIndex <= -1) {
            return false;
        }
        System.arraycopy(this.mHSV2[matchedColorIndex], 0, output, 0, 3);
        Log.i(TAG, "matchColor() index=" + matchedColorIndex + " IN[" + input[0] + TextRecallingManager.ANSWER_SEPARATOR + input[1] + TextRecallingManager.ANSWER_SEPARATOR + input[2] + "] -> OUT[" + output[0] + TextRecallingManager.ANSWER_SEPARATOR + output[1] + TextRecallingManager.ANSWER_SEPARATOR + output[2] + "]");
        return true;
    }

    public final int getMatchedColorIndex(float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        int iMatchHsvColor = matchHsvColor(hsv, false);
        if (iMatchHsvColor != -1) {
            return iMatchHsvColor;
        }
        Log.i(TAG, "setColor() Not matchedIndex=" + iMatchHsvColor);
        return -1;
    }

    public final void clearMatchedData() {
        this.mLastMatchedIndex = -1;
        this.mLastMatchedDistanceValue = 1200.0d;
    }

    /* JADX INFO: renamed from: getResultValue, reason: from getter */
    public final double getMLastMatchedDistanceValue() {
        return this.mLastMatchedDistanceValue;
    }

    /* JADX INFO: renamed from: getResultIndex, reason: from getter */
    public final int getMLastMatchedIndex() {
        return this.mLastMatchedIndex;
    }

    public final void getResultColor(float[] color) {
        int i;
        Intrinsics.checkNotNullParameter(color, "color");
        if (color.length != 3 || (i = this.mLastMatchedIndex) == -1) {
            return;
        }
        System.arraycopy(this.mHSV2[i], 0, color, 0, 3);
    }

    public final boolean matchColor(float[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        clearMatchedData();
        return matchHsvColor(input, true) != -1;
    }

    private final int matchHsvColor(float[] hsv, boolean isSaveRecord) {
        Point3 point3 = new Point3(hsv);
        Point3 point32 = new Point3();
        int length = this.mHSV2.length;
        int i = -1;
        double d = 1200.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            float[] fArr = this.mHSV2[i2];
            point32.setColor(fArr[0], fArr[1], fArr[2]);
            double distance = point3.getDistance(point32);
            if (distance == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                if (isSaveRecord) {
                    this.mLastMatchedDistanceValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                i = i2;
            } else {
                if (d > distance) {
                    if (isSaveRecord) {
                        this.mLastMatchedDistanceValue = distance;
                    }
                    i = i2;
                    d = distance;
                }
                i2++;
            }
        }
        if (isSaveRecord) {
            this.mLastMatchedIndex = i;
        }
        return i;
    }

    /* JADX INFO: compiled from: SpenColorMatching.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorMatching$Point3;", "", "<init>", "()V", "hsv", "", "([F)V", "x", "", "y", "z", "setColor", "", "hue", "", "saturation", "value", "getDistance", "pt", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    private static final class Point3 {

        /* JADX INFO: renamed from: PI */
        private static final double f2249PI = 3.14159d;
        private double x;
        private double y;
        private double z;

        public Point3() {
            this.z = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.y = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.x = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public Point3(float[] hsv) {
            Intrinsics.checkNotNullParameter(hsv, "hsv");
            setColor(hsv[0], hsv[1], hsv[2]);
        }

        public final void setColor(float hue, float saturation, float value) {
            double d = saturation;
            double d2 = (float) ((((double) hue) * f2249PI) / ((double) SensibleDefaults.X_OFFSET));
            this.x = (float) (Math.cos(d2) * d);
            this.y = (float) (d * Math.sin(d2));
            this.z = value;
        }

        public final double getDistance(Point3 pt) {
            Intrinsics.checkNotNullParameter(pt, "pt");
            return Math.sqrt(Math.pow(Math.abs(this.x - pt.x), 2.0d) + Math.pow(Math.abs(this.y - pt.y), 2.0d) + Math.pow(Math.abs(this.z - pt.z), 2.0d));
        }
    }
}
