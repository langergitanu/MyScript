package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum VO_LAYOUTANALYZER_PROP {
    LAYOUTANALYZER_FORCE_CUT_SPAN_ON_LINE_BOUNDARIES(12510),
    LAYOUTANALYZER_CLASS_REMAPPING(12511),
    LAYOUTANALYZER_EXCLUDE_CLASS_FROM_PE_CONTEXT(12512),
    LAYOUTANALYZER_CONFIG(12513),
    LAYOUTANALYZER_MAX_BATCH_SIZE(12514),
    LAYOUTANALYZER_DISABLE_POST_PROCESS(12515);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static VO_LAYOUTANALYZER_PROP swigToEnum(int i) {
        VO_LAYOUTANALYZER_PROP[] vo_layoutanalyzer_propArr = (VO_LAYOUTANALYZER_PROP[]) VO_LAYOUTANALYZER_PROP.class.getEnumConstants();
        if (i < vo_layoutanalyzer_propArr.length && i >= 0) {
            VO_LAYOUTANALYZER_PROP vo_layoutanalyzer_prop = vo_layoutanalyzer_propArr[i];
            if (vo_layoutanalyzer_prop.swigValue == i) {
                return vo_layoutanalyzer_prop;
            }
        }
        for (VO_LAYOUTANALYZER_PROP vo_layoutanalyzer_prop2 : vo_layoutanalyzer_propArr) {
            if (vo_layoutanalyzer_prop2.swigValue == i) {
                return vo_layoutanalyzer_prop2;
            }
        }
        throw new IllegalArgumentException("No enum " + VO_LAYOUTANALYZER_PROP.class + " with value " + i);
    }

    VO_LAYOUTANALYZER_PROP() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    VO_LAYOUTANALYZER_PROP(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    VO_LAYOUTANALYZER_PROP(VO_LAYOUTANALYZER_PROP vo_layoutanalyzer_prop) {
        int i = vo_layoutanalyzer_prop.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
