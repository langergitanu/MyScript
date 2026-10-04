package com.myscript.snt.dms;

import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
class NeboDMS implements NeboDMSConstants {
    NeboDMS() {
    }

    protected static byte[] getBytesUTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Exception unused) {
            throw new RuntimeException("UTF8 Not supported");
        }
    }

    public static int computeARGBGradientEndColor(int i, float f) {
        return NeboDMSJNI.computeARGBGradientEndColor__SWIG_0(i, f);
    }

    public static int computeARGBGradientEndColor(int i) {
        return NeboDMSJNI.computeARGBGradientEndColor__SWIG_1(i);
    }

    public static int migrateLegacyCoverColorIndexToARGBColor(long j) {
        return NeboDMSJNI.migrateLegacyCoverColorIndexToARGBColor(j);
    }

    public static List<String> getSyncStateLabels() {
        long jSyncStateLabels_get = NeboDMSJNI.SyncStateLabels_get();
        if (jSyncStateLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jSyncStateLabels_get, false);
    }

    public static List<String> getSyncStateCauseLabels() {
        long jSyncStateCauseLabels_get = NeboDMSJNI.SyncStateCauseLabels_get();
        if (jSyncStateCauseLabels_get == 0) {
            return null;
        }
        return new SWIGVectorString(jSyncStateCauseLabels_get, false);
    }

    public static long getDEFAULT_BACKGROUND_COLOR() {
        return NeboDMSJNI.DEFAULT_BACKGROUND_COLOR_get();
    }

    public static String getDEFAULT_RAW_CONTENT_BACKGROUND_PATTERN() {
        return new String(NeboDMSJNI.DEFAULT_RAW_CONTENT_BACKGROUND_PATTERN_get(), StandardCharsets.UTF_8);
    }

    public static long getUndefinedPosition() {
        return NeboDMSJNI.UndefinedPosition_get();
    }

    public static String getInvalidPageId() {
        return new String(NeboDMSJNI.InvalidPageId_get(), StandardCharsets.UTF_8);
    }

    public static boolean isResultCodeSuccess(SharePageRequestResultCode sharePageRequestResultCode) {
        return NeboDMSJNI.isResultCodeSuccess(sharePageRequestResultCode.swigValue());
    }
}
