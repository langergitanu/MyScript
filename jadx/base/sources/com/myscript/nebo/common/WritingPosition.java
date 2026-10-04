package com.myscript.nebo.common;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: WritingPosition.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/common/WritingPosition;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "TopLeft", "TopRight", "MiddleLeft", "MiddleRight", "BottomLeft", "BottomRight", "serialize", "", "Companion", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WritingPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WritingPosition[] $VALUES;

    /* JADX INFO: renamed from: BL */
    private static final String f1350BL = "BL";

    /* JADX INFO: renamed from: BR */
    private static final String f1351BR = "BR";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: ML */
    private static final String f1352ML = "ML";

    /* JADX INFO: renamed from: MR */
    private static final String f1353MR = "MR";

    /* JADX INFO: renamed from: TL */
    private static final String f1354TL = "TL";

    /* JADX INFO: renamed from: TR */
    private static final String f1355TR = "TR";
    public static final WritingPosition Undefined = new WritingPosition("Undefined", 0);
    public static final WritingPosition TopLeft = new WritingPosition("TopLeft", 1);
    public static final WritingPosition TopRight = new WritingPosition("TopRight", 2);
    public static final WritingPosition MiddleLeft = new WritingPosition("MiddleLeft", 3);
    public static final WritingPosition MiddleRight = new WritingPosition("MiddleRight", 4);
    public static final WritingPosition BottomLeft = new WritingPosition("BottomLeft", 5);
    public static final WritingPosition BottomRight = new WritingPosition("BottomRight", 6);

    /* JADX INFO: compiled from: WritingPosition.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WritingPosition.values().length];
            try {
                iArr[WritingPosition.Undefined.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WritingPosition.TopLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WritingPosition.TopRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WritingPosition.MiddleLeft.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WritingPosition.MiddleRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WritingPosition.BottomLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WritingPosition.BottomRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ WritingPosition[] $values() {
        return new WritingPosition[]{Undefined, TopLeft, TopRight, MiddleLeft, MiddleRight, BottomLeft, BottomRight};
    }

    public static EnumEntries<WritingPosition> getEntries() {
        return $ENTRIES;
    }

    public static WritingPosition valueOf(String str) {
        return (WritingPosition) Enum.valueOf(WritingPosition.class, str);
    }

    public static WritingPosition[] values() {
        return (WritingPosition[]) $VALUES.clone();
    }

    private WritingPosition(String str, int i) {
    }

    static {
        WritingPosition[] writingPositionArr$values = $values();
        $VALUES = writingPositionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(writingPositionArr$values);
        INSTANCE = new Companion(null);
    }

    public final String serialize() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "";
            case 2:
                return f1354TL;
            case 3:
                return f1355TR;
            case 4:
                return f1352ML;
            case 5:
                return f1353MR;
            case 6:
                return f1350BL;
            case 7:
                return f1351BR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: WritingPosition.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/common/WritingPosition$Companion;", "", "<init>", "()V", WritingPosition.f1354TL, "", WritingPosition.f1355TR, WritingPosition.f1352ML, WritingPosition.f1353MR, WritingPosition.f1350BL, WritingPosition.f1351BR, "deserialize", "Lcom/myscript/nebo/common/WritingPosition;", "value", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WritingPosition deserialize(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int iHashCode = value.hashCode();
            if (iHashCode != 2122) {
                if (iHashCode != 2128) {
                    if (iHashCode != 2463) {
                        if (iHashCode != 2469) {
                            if (iHashCode != 2680) {
                                if (iHashCode == 2686 && value.equals(WritingPosition.f1355TR)) {
                                    return WritingPosition.TopRight;
                                }
                            } else if (value.equals(WritingPosition.f1354TL)) {
                                return WritingPosition.TopLeft;
                            }
                        } else if (value.equals(WritingPosition.f1353MR)) {
                            return WritingPosition.MiddleRight;
                        }
                    } else if (value.equals(WritingPosition.f1352ML)) {
                        return WritingPosition.MiddleLeft;
                    }
                } else if (value.equals(WritingPosition.f1351BR)) {
                    return WritingPosition.BottomRight;
                }
            } else if (value.equals(WritingPosition.f1350BL)) {
                return WritingPosition.BottomLeft;
            }
            return WritingPosition.Undefined;
        }
    }
}
