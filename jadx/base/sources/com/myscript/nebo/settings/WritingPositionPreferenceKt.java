package com.myscript.nebo.settings;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.WritingPosition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WritingPositionPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, m1599d2 = {"toResourceId", "", "Lcom/myscript/nebo/common/WritingPosition;", "fromResourceId", "Lcom/myscript/nebo/common/WritingPosition$Companion;", "resId", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WritingPositionPreferenceKt {

    /* JADX INFO: compiled from: WritingPositionPreference.kt */
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

    public static final int toResourceId(WritingPosition writingPosition) {
        Intrinsics.checkNotNullParameter(writingPosition, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[writingPosition.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return C6079R.id.writing_position_left_top;
            case 3:
                return C6079R.id.writing_position_right_top;
            case 4:
                return C6079R.id.writing_position_left_middle;
            case 5:
                return C6079R.id.writing_position_right_middle;
            case 6:
                return C6079R.id.writing_position_left_bottom;
            case 7:
                return C6079R.id.writing_position_right_bottom;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final WritingPosition fromResourceId(WritingPosition.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return i == C6079R.id.writing_position_left_top ? WritingPosition.TopLeft : i == C6079R.id.writing_position_right_top ? WritingPosition.TopRight : i == C6079R.id.writing_position_left_middle ? WritingPosition.MiddleLeft : i == C6079R.id.writing_position_right_middle ? WritingPosition.MiddleRight : i == C6079R.id.writing_position_left_bottom ? WritingPosition.BottomLeft : i == C6079R.id.writing_position_right_bottom ? WritingPosition.BottomRight : WritingPosition.Undefined;
    }
}
