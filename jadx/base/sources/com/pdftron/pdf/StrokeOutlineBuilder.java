package com.pdftron.pdf;

/* JADX INFO: loaded from: classes7.dex */
public class StrokeOutlineBuilder {

    /* JADX INFO: renamed from: a */
    private long f2055a;

    static native int AddPoint(long j, double d, double d2, double d3);

    static native double[] GetLastSegmentOutline(long j, int i, long j2);

    static native double[] GetOutline(long j);

    static native long StrokeOutlineBuilderCreate(double d);

    public enum TipOptions {
        HAS_END_TIP(1),
        NO_SPECIAL_OPTIONS(2);


        /* JADX INFO: renamed from: a */
        private final int f2057a;

        TipOptions(int i) {
            this.f2057a = i;
        }

        public final int getValue() {
            return this.f2057a;
        }
    }

    public StrokeOutlineBuilder(double d) {
        this.f2055a = StrokeOutlineBuilderCreate(d);
    }

    public void addPoint(double d, double d2, double d3) {
        AddPoint(this.f2055a, d, d2, d3);
    }

    public double[] getOutline() {
        return GetOutline(this.f2055a);
    }

    public double[] getLastSegmentOutline(int i, TipOptions tipOptions) {
        return GetLastSegmentOutline(this.f2055a, i, tipOptions.getValue());
    }
}
