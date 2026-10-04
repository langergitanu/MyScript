package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextSelectionModifier {
    TEXT_SELECTION_INCLUDE_WHITESPACES_ON_LINE,
    TEXT_SELECTION_INCLUDE_ANY_WHITESPACES,
    TEXT_SELECTION_EXCLUDE_WHITESPACES;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextSelectionModifier swigToEnum(int i) {
        voTextSelectionModifier[] votextselectionmodifierArr = (voTextSelectionModifier[]) voTextSelectionModifier.class.getEnumConstants();
        if (i < votextselectionmodifierArr.length && i >= 0) {
            voTextSelectionModifier votextselectionmodifier = votextselectionmodifierArr[i];
            if (votextselectionmodifier.swigValue == i) {
                return votextselectionmodifier;
            }
        }
        for (voTextSelectionModifier votextselectionmodifier2 : votextselectionmodifierArr) {
            if (votextselectionmodifier2.swigValue == i) {
                return votextselectionmodifier2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextSelectionModifier.class + " with value " + i);
    }

    voTextSelectionModifier() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextSelectionModifier(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextSelectionModifier(voTextSelectionModifier votextselectionmodifier) {
        int i = votextselectionmodifier.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
