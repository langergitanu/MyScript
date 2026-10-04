package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;

/* JADX INFO: loaded from: classes7.dex */
public class Redactor {

    public static class Appearance {
        public Font font;
        public ColorPt positiveOverlayColor = new ColorPt(1.0d, 1.0d, 1.0d);
        public ColorPt negativeOverlayColor = new ColorPt(1.0d, 1.0d, 1.0d);
        public ColorPt textColor = new ColorPt(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        public ColorPt redactedContentColor = new ColorPt(0.3d, 0.3d, 0.3d);
        public boolean redactionOverlay = true;
        public boolean border = true;
        public boolean useOverlayText = true;
        public double minFontSize = 2.0d;
        public double maxFontSize = 24.0d;
        public int horizTextAlignment = -1;
        public int vertTextAlignment = 1;
        public boolean enableTextWrapping = false;
        public boolean showRedactedContentRegions = false;
    }

    static native void Redact(long j, long[] jArr, boolean z, long j2, long j3, boolean z2, boolean z3, long j4, double d, double d2, long j5, int i, int i2, boolean z4, boolean z5, long j6, boolean z6, boolean z7);

    static native long RedactionCreate(int i, long j, boolean z, String str);

    static native void RedactionDestroy(long j);

    public static class Redaction implements AutoCloseable {

        /* JADX INFO: renamed from: a */
        long f2039a;

        public Redaction(int i, Rect rect, boolean z, String str) throws PDFNetException {
            this.f2039a = Redactor.RedactionCreate(i, rect.f2037a, z, str);
            ReachabilityHelper.ensureReachable(rect);
        }

        protected void finalize() throws Throwable {
            destroy();
        }

        public void destroy() {
            long j = this.f2039a;
            if (j != 0) {
                Redactor.RedactionDestroy(j);
                this.f2039a = 0L;
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() throws PDFNetException {
            destroy();
        }
    }

    public static void redact(Doc doc, Redaction[] redactionArr, Appearance appearance, boolean z, boolean z2) throws PDFNetException {
        long[] jArr = new long[redactionArr.length];
        for (int i = 0; i < redactionArr.length; i++) {
            jArr[i] = redactionArr[i].f2039a;
        }
        long j = appearance.font != null ? appearance.font.f1556a : 0L;
        Redact(doc.__GetHandle(), jArr, appearance.redactionOverlay, appearance.positiveOverlayColor != null ? appearance.positiveOverlayColor.f1458a : 0L, appearance.negativeOverlayColor != null ? appearance.negativeOverlayColor.f1458a : 0L, appearance.border, appearance.useOverlayText, j, appearance.minFontSize, appearance.maxFontSize, appearance.textColor != null ? appearance.textColor.f1458a : 0L, appearance.horizTextAlignment, appearance.vertTextAlignment, appearance.enableTextWrapping, appearance.showRedactedContentRegions, appearance.redactedContentColor != null ? appearance.redactedContentColor.f1458a : 0L, z, z2);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(appearance);
        ReachabilityHelper.ensureReachable(redactionArr);
    }
}
