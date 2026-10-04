package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voLayoutGroupStatus {
    LAYOUTGROUP_ADDED,
    LAYOUTGROUP_ATTRIBUTES_CHANGED,
    LAYOUTGROUP_REMOVED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voLayoutGroupStatus swigToEnum(int i) {
        voLayoutGroupStatus[] volayoutgroupstatusArr = (voLayoutGroupStatus[]) voLayoutGroupStatus.class.getEnumConstants();
        if (i < volayoutgroupstatusArr.length && i >= 0) {
            voLayoutGroupStatus volayoutgroupstatus = volayoutgroupstatusArr[i];
            if (volayoutgroupstatus.swigValue == i) {
                return volayoutgroupstatus;
            }
        }
        for (voLayoutGroupStatus volayoutgroupstatus2 : volayoutgroupstatusArr) {
            if (volayoutgroupstatus2.swigValue == i) {
                return volayoutgroupstatus2;
            }
        }
        throw new IllegalArgumentException("No enum " + voLayoutGroupStatus.class + " with value " + i);
    }

    voLayoutGroupStatus() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voLayoutGroupStatus(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voLayoutGroupStatus(voLayoutGroupStatus volayoutgroupstatus) {
        int i = volayoutgroupstatus.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
