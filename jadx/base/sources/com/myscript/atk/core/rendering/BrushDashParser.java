package com.myscript.atk.core.rendering;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class BrushDashParser {
    private static final String DASH_STROKE_STYLE = "dash";
    private static final float DEFAULT_DASH_OFF = 2.0f;
    private static final float DEFAULT_DASH_ON = 2.0f;
    private static final String DOTTED_STROKE_STYLE = "dotted";
    private final Map<String, BrushData> Cache = new HashMap();

    public static class BrushData {
        public static final String DASH_TYPE = "dash";
        public static final String DOTTED_TYPE = "dotted";
        public static final String NONE_TYPE = "";
        public final float dashOff;
        public final float dashOn;
        public final String type;
        private static final BrushData DEFAULT_DASH = new BrushData("dash", 2.0f, 2.0f);
        private static final BrushData DEFAULT_DOTTED = new BrushData("dotted", 0.0f, 2.0f);
        private static final BrushData NONE = new BrushData("", 0.0f, 0.0f);

        public BrushData(String str, float f, float f2) {
            this.type = str;
            this.dashOn = f;
            this.dashOff = f2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BrushData brushData = (BrushData) obj;
                if (Float.compare(brushData.dashOn, this.dashOn) == 0 && Float.compare(brushData.dashOff, this.dashOff) == 0 && this.type.equals(brushData.type)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.type, Float.valueOf(this.dashOn), Float.valueOf(this.dashOff));
        }

        public String toString() {
            return String.format("%s(%2f,%2f)", this.type, Float.valueOf(this.dashOn), Float.valueOf(this.dashOff));
        }
    }

    public BrushData parseBrush(String str) {
        String strTrim = str.trim();
        BrushData brushData = this.Cache.get(strTrim);
        if (brushData != null) {
            return brushData;
        }
        int iIndexOf = strTrim.indexOf("dash");
        if (iIndexOf != -1) {
            int length = iIndexOf + "dash".length();
            int i = length + 1;
            if (strTrim.length() > i && strTrim.charAt(length) == '.') {
                try {
                    String[] strArrSplit = strTrim.substring(i).split("\\s");
                    if (strArrSplit.length > 0) {
                        String[] strArrSplit2 = strArrSplit[0].split(",");
                        if (strArrSplit2.length > 0) {
                            BrushData brushData2 = new BrushData("dash", Float.parseFloat(strArrSplit2[0]), strArrSplit2.length > 1 ? Float.parseFloat(strArrSplit2[1]) : 2.0f);
                            this.Cache.put(strTrim, brushData2);
                            return brushData2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.Cache.put(strTrim, BrushData.DEFAULT_DASH);
            return BrushData.DEFAULT_DASH;
        }
        int iIndexOf2 = strTrim.indexOf("dotted");
        if (iIndexOf2 != -1) {
            int length2 = iIndexOf2 + "dotted".length();
            int i2 = length2 + 1;
            if (strTrim.length() > i2 && strTrim.charAt(length2) == '.') {
                try {
                    String[] strArrSplit3 = strTrim.substring(i2).split("\\s");
                    if (strArrSplit3.length > 0) {
                        BrushData brushData3 = new BrushData("dotted", 0.0f, Float.parseFloat(strArrSplit3[0]));
                        this.Cache.put(strTrim, brushData3);
                        return brushData3;
                    }
                } catch (Exception unused2) {
                }
            }
            this.Cache.put(strTrim, BrushData.DEFAULT_DOTTED);
            return BrushData.DEFAULT_DOTTED;
        }
        this.Cache.put(strTrim, BrushData.NONE);
        return BrushData.NONE;
    }
}
