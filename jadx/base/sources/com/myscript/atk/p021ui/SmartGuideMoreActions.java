package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum SmartGuideMoreActions {
    None(1),
    Cut(2),
    Copy(4),
    Delete(8),
    Typeset(16),
    Edit(32),
    Finish(64),
    Beautify(128),
    MathSolver(256),
    MathApprox(512),
    MathDegRad(1024),
    MathDec(2048),
    ExportPPT(4096),
    ResizeHomothetic(8192),
    ResizeDistortion(16384);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static SmartGuideMoreActions swigToEnum(int i) {
        SmartGuideMoreActions[] smartGuideMoreActionsArr = (SmartGuideMoreActions[]) SmartGuideMoreActions.class.getEnumConstants();
        if (i < smartGuideMoreActionsArr.length && i >= 0) {
            SmartGuideMoreActions smartGuideMoreActions = smartGuideMoreActionsArr[i];
            if (smartGuideMoreActions.swigValue == i) {
                return smartGuideMoreActions;
            }
        }
        for (SmartGuideMoreActions smartGuideMoreActions2 : smartGuideMoreActionsArr) {
            if (smartGuideMoreActions2.swigValue == i) {
                return smartGuideMoreActions2;
            }
        }
        throw new IllegalArgumentException("No enum " + SmartGuideMoreActions.class + " with value " + i);
    }

    SmartGuideMoreActions() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    SmartGuideMoreActions(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    SmartGuideMoreActions(SmartGuideMoreActions smartGuideMoreActions) {
        int i = smartGuideMoreActions.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
