package com.pdftron.helpers;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes7.dex */
public class DoubleRectangle2D {
    public double height;
    public double width;

    /* JADX INFO: renamed from: x */
    public double f1418x;

    /* JADX INFO: renamed from: y */
    public double f1419y;

    public DoubleRectangle2D() {
        this.f1418x = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f1419y = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.width = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.height = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public DoubleRectangle2D(double d, double d2, double d3, double d4) {
        this.f1418x = d;
        this.f1419y = d2;
        this.width = d3;
        this.height = d4;
    }
}
