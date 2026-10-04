package com.myscript.nebo.editing;

import com.myscript.snt.core.NeboSanitizer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PageLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"isCorruption", "", "Lcom/myscript/snt/core/NeboSanitizer$SanitizerStatus;", "(Lcom/myscript/snt/core/NeboSanitizer$SanitizerStatus;)Z", "editing_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageLoaderKt {

    /* JADX INFO: compiled from: PageLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NeboSanitizer.SanitizerStatus.values().length];
            try {
                iArr[NeboSanitizer.SanitizerStatus.Ok.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NeboSanitizer.SanitizerStatus.ResetedFields.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NeboSanitizer.SanitizerStatus.Corrupted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isCorruption(NeboSanitizer.SanitizerStatus sanitizerStatus) {
        int i = sanitizerStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sanitizerStatus.ordinal()];
        if (i == -1 || i == 1 || i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
