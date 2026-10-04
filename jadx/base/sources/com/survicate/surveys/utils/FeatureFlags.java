package com.survicate.surveys.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFlags.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0007¢\u0006\u0002\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/utils/FeatureFlags;", "", "<init>", "()V", "value", "", "isBackendTargetingEnabled", "()Z", "isMultipleQuestionsPerPageEnabled", "testWith", "", "action", "Lkotlin/Function0;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FeatureFlags {
    public static final FeatureFlags INSTANCE = new FeatureFlags();
    private static boolean isBackendTargetingEnabled = true;
    private static boolean isMultipleQuestionsPerPageEnabled;

    private FeatureFlags() {
    }

    public final boolean isBackendTargetingEnabled() {
        return isBackendTargetingEnabled;
    }

    public final boolean isMultipleQuestionsPerPageEnabled() {
        return isMultipleQuestionsPerPageEnabled;
    }

    public static /* synthetic */ void testWith$default(FeatureFlags featureFlags, Boolean bool, Boolean bool2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        featureFlags.testWith(bool, bool2, function0);
    }

    public final void testWith(Boolean isBackendTargetingEnabled2, Boolean isMultipleQuestionsPerPageEnabled2, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = isBackendTargetingEnabled;
        boolean z2 = isMultipleQuestionsPerPageEnabled;
        isBackendTargetingEnabled = isBackendTargetingEnabled2 != null ? isBackendTargetingEnabled2.booleanValue() : z;
        isMultipleQuestionsPerPageEnabled = isMultipleQuestionsPerPageEnabled2 != null ? isMultipleQuestionsPerPageEnabled2.booleanValue() : isMultipleQuestionsPerPageEnabled;
        try {
            action.invoke();
        } finally {
            isBackendTargetingEnabled = z;
            isMultipleQuestionsPerPageEnabled = z2;
        }
    }
}
