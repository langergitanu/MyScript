package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voTextImporterScriptType {
    SCRIPT_UNSUPPORTED(-1),
    SCRIPT_STANDARD(0),
    SCRIPT_CHINESE,
    SCRIPT_JAPANESE,
    SCRIPT_KOREAN,
    SCRIPT_THAI;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voTextImporterScriptType swigToEnum(int i) {
        voTextImporterScriptType[] votextimporterscripttypeArr = (voTextImporterScriptType[]) voTextImporterScriptType.class.getEnumConstants();
        if (i < votextimporterscripttypeArr.length && i >= 0) {
            voTextImporterScriptType votextimporterscripttype = votextimporterscripttypeArr[i];
            if (votextimporterscripttype.swigValue == i) {
                return votextimporterscripttype;
            }
        }
        for (voTextImporterScriptType votextimporterscripttype2 : votextimporterscripttypeArr) {
            if (votextimporterscripttype2.swigValue == i) {
                return votextimporterscripttype2;
            }
        }
        throw new IllegalArgumentException("No enum " + voTextImporterScriptType.class + " with value " + i);
    }

    voTextImporterScriptType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voTextImporterScriptType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voTextImporterScriptType(voTextImporterScriptType votextimporterscripttype) {
        int i = votextimporterscripttype.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
