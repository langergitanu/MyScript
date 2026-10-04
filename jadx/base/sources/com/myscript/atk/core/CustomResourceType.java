package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum CustomResourceType {
    STANDARD,
    MUTABLE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static CustomResourceType swigToEnum(int i) {
        CustomResourceType[] customResourceTypeArr = (CustomResourceType[]) CustomResourceType.class.getEnumConstants();
        if (i < customResourceTypeArr.length && i >= 0) {
            CustomResourceType customResourceType = customResourceTypeArr[i];
            if (customResourceType.swigValue == i) {
                return customResourceType;
            }
        }
        for (CustomResourceType customResourceType2 : customResourceTypeArr) {
            if (customResourceType2.swigValue == i) {
                return customResourceType2;
            }
        }
        throw new IllegalArgumentException("No enum " + CustomResourceType.class + " with value " + i);
    }

    CustomResourceType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    CustomResourceType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    CustomResourceType(CustomResourceType customResourceType) {
        int i = customResourceType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
