package com.pdftron.pdf;

import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Optimizer {
    static native void Optimize(long j, int i, int i2, long j2, double d, double d2, boolean z, boolean z2, int i3, int i4, long j3, double d3, double d4, boolean z3, boolean z4, int i5, int i6, double d5, double d6, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, double d7);

    public static class ImageSettings {
        public static final int e_default = 1;
        public static final int e_flate = 1;
        public static final int e_jpeg = 2;
        public static final int e_jpeg2000 = 3;
        public static final int e_none = 4;
        public static final int e_off = 0;
        public static final int e_retain = 0;

        /* JADX INFO: renamed from: a */
        private int f1594a = 0;

        /* JADX INFO: renamed from: b */
        private int f1595b = 1;

        /* JADX INFO: renamed from: c */
        private long f1596c = 5;

        /* JADX INFO: renamed from: d */
        private double f1597d = 225.0d;

        /* JADX INFO: renamed from: e */
        private double f1598e = 150.0d;

        /* JADX INFO: renamed from: f */
        private boolean f1599f = false;

        /* JADX INFO: renamed from: g */
        private boolean f1600g = false;

        public void setImageDPI(double d, double d2) {
            this.f1597d = d;
            this.f1598e = d2;
        }

        public void setCompressionMode(int i) {
            this.f1594a = i;
        }

        public void setDownsampleMode(int i) {
            this.f1595b = i;
        }

        public void setQuality(long j) {
            this.f1596c = j;
        }

        public void forceRecompression(boolean z) {
            this.f1599f = z;
        }

        public void forceChanges(boolean z) {
            this.f1600g = z;
        }
    }

    public static class MonoImageSettings {
        public static final int e_ccitt = 3;
        public static final int e_default = 1;
        public static final int e_flate = 1;
        public static final int e_jbig2 = 0;
        public static final int e_none = 2;
        public static final int e_off = 0;

        /* JADX INFO: renamed from: a */
        private int f1601a = 3;

        /* JADX INFO: renamed from: b */
        private int f1602b = 1;

        /* JADX INFO: renamed from: c */
        private double f1603c = 450.0d;

        /* JADX INFO: renamed from: d */
        private double f1604d = 300.0d;

        /* JADX INFO: renamed from: f */
        private boolean f1606f = false;

        /* JADX INFO: renamed from: g */
        private boolean f1607g = false;

        /* JADX INFO: renamed from: e */
        private double f1605e = 8.5d;

        public void setImageDPI(double d, double d2) {
            this.f1603c = d;
            this.f1604d = d2;
        }

        public void setCompressionMode(int i) {
            this.f1601a = i;
        }

        public void setDownsampleMode(int i) {
            this.f1602b = i;
        }

        public void forceRecompression(boolean z) {
            this.f1606f = z;
        }

        public void forceChanges(boolean z) {
            this.f1607g = z;
        }

        public void setJBIG2Threshold(double d) {
            this.f1605e = d;
        }
    }

    public static class TextSettings {

        /* JADX INFO: renamed from: a */
        private boolean f1613a = false;

        /* JADX INFO: renamed from: b */
        private boolean f1614b = false;

        public void subsetFonts(boolean z) {
            this.f1613a = z;
        }

        public void embedFonts(boolean z) {
            this.f1614b = z;
        }
    }

    public static class OptimizerSettings {

        /* JADX INFO: renamed from: a */
        private ImageSettings f1608a;

        /* JADX INFO: renamed from: b */
        private ImageSettings f1609b;

        /* JADX INFO: renamed from: c */
        private MonoImageSettings f1610c;

        /* JADX INFO: renamed from: d */
        private TextSettings f1611d;

        /* JADX INFO: renamed from: e */
        private boolean f1612e = true;

        public void setColorImageSettings(ImageSettings imageSettings) {
            this.f1608a = imageSettings;
        }

        public void setGrayscaleImageSettings(ImageSettings imageSettings) {
            this.f1609b = imageSettings;
        }

        public void setMonoImageSettings(MonoImageSettings monoImageSettings) {
            this.f1610c = monoImageSettings;
        }

        public void setTextSettings(TextSettings textSettings) {
            this.f1611d = textSettings;
        }

        public void removeCustomEntries(boolean z) {
            this.f1612e = z;
        }
    }

    public static void optimize(PDFDoc pDFDoc) {
        m1171a(pDFDoc, new ImageSettings(), new ImageSettings(), new MonoImageSettings(), new TextSettings(), true);
    }

    public static void optimize(PDFDoc pDFDoc, OptimizerSettings optimizerSettings) {
        m1171a(pDFDoc, optimizerSettings.f1608a == null ? new ImageSettings() : optimizerSettings.f1608a, optimizerSettings.f1609b == null ? new ImageSettings() : optimizerSettings.f1609b, optimizerSettings.f1610c == null ? new MonoImageSettings() : optimizerSettings.f1610c, optimizerSettings.f1611d == null ? new TextSettings() : optimizerSettings.f1611d, optimizerSettings.f1612e);
    }

    /* JADX INFO: renamed from: a */
    private static void m1171a(PDFDoc pDFDoc, ImageSettings imageSettings, ImageSettings imageSettings2, MonoImageSettings monoImageSettings, TextSettings textSettings, boolean z) {
        Optimize(pDFDoc.__GetHandle(), imageSettings.f1594a, imageSettings.f1595b, imageSettings.f1596c, imageSettings.f1597d, imageSettings.f1598e, imageSettings.f1599f, imageSettings.f1600g, imageSettings2.f1594a, imageSettings2.f1595b, imageSettings2.f1596c, imageSettings2.f1597d, imageSettings2.f1598e, imageSettings2.f1599f, imageSettings2.f1600g, monoImageSettings.f1601a, monoImageSettings.f1602b, monoImageSettings.f1603c, monoImageSettings.f1604d, monoImageSettings.f1606f, monoImageSettings.f1607g, textSettings.f1613a, textSettings.f1614b, z, monoImageSettings.f1605e);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    private Optimizer() {
    }
}
