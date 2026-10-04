package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NeboCustomTheme {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NeboCustomTheme(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NeboCustomTheme neboCustomTheme) {
        if (neboCustomTheme == null) {
            return 0L;
        }
        return neboCustomTheme.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_NeboCustomTheme(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getCustomTheme(int i, int i2, boolean z) {
        return new String(NeboEngineJNI.NeboCustomTheme_getCustomTheme__SWIG_0(i, i2, z), StandardCharsets.UTF_8);
    }

    public static String getCustomTheme(int i, int i2) {
        return new String(NeboEngineJNI.NeboCustomTheme_getCustomTheme__SWIG_1(i, i2), StandardCharsets.UTF_8);
    }

    public NeboCustomTheme() {
        this(NeboEngineJNI.new_NeboCustomTheme(), true);
    }

    public enum NeboLightColors {
        DEFAULT_TINT_COLOR(1744895),
        DEFAULT_BACKGROUND_COLOR(-1),
        SILVER_BACKGROUND_COLOR(-353637377),
        GRAY_BACKGROUND_COLOR(-707340033),
        SEPIA_BACKGROUND_COLOR(-253107969),
        YELLOW_BACKGROUND_COLOR(-151729153),
        RED_BACKGROUND_COLOR(-35462401),
        BLUE_BACKGROUND_COLOR(-504235265),
        GREEN_BACKGROUND_COLOR(-638001665);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static NeboLightColors swigToEnum(int i) {
            NeboLightColors[] neboLightColorsArr = (NeboLightColors[]) NeboLightColors.class.getEnumConstants();
            if (i < neboLightColorsArr.length && i >= 0) {
                NeboLightColors neboLightColors = neboLightColorsArr[i];
                if (neboLightColors.swigValue == i) {
                    return neboLightColors;
                }
            }
            for (NeboLightColors neboLightColors2 : neboLightColorsArr) {
                if (neboLightColors2.swigValue == i) {
                    return neboLightColors2;
                }
            }
            throw new IllegalArgumentException("No enum " + NeboLightColors.class + " with value " + i);
        }

        NeboLightColors() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        NeboLightColors(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        NeboLightColors(NeboLightColors neboLightColors) {
            int i = neboLightColors.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }

    public enum NeboDarkColors {
        DARK_DEFAULT_BACKGROUND_COLOR(255),
        DARK_SILVER_BACKGROUND_COLOR(673786623),
        DARK_GRAY_BACKGROUND_COLOR(926431743),
        DARK_SEPIA_BACKGROUND_COLOR(723985151),
        DARK_YELLOW_BACKGROUND_COLOR(808460799),
        DARK_RED_BACKGROUND_COLOR(1042819327),
        DARK_BLUE_BACKGROUND_COLOR(640694015),
        DARK_GREEN_BACKGROUND_COLOR(607332095);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static NeboDarkColors swigToEnum(int i) {
            NeboDarkColors[] neboDarkColorsArr = (NeboDarkColors[]) NeboDarkColors.class.getEnumConstants();
            if (i < neboDarkColorsArr.length && i >= 0) {
                NeboDarkColors neboDarkColors = neboDarkColorsArr[i];
                if (neboDarkColors.swigValue == i) {
                    return neboDarkColors;
                }
            }
            for (NeboDarkColors neboDarkColors2 : neboDarkColorsArr) {
                if (neboDarkColors2.swigValue == i) {
                    return neboDarkColors2;
                }
            }
            throw new IllegalArgumentException("No enum " + NeboDarkColors.class + " with value " + i);
        }

        NeboDarkColors() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        NeboDarkColors(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        NeboDarkColors(NeboDarkColors neboDarkColors) {
            int i = neboDarkColors.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
