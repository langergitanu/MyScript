package com.myscript.nebo.log;

import android.os.Bundle;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.IPageCorruptionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirebaseCorruptionListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/log/FirebaseCorruptionListener;", "Lcom/myscript/snt/dms/IPageCorruptionListener;", "<init>", "()V", "corruptionStateChanged", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "result", "Lcom/myscript/snt/core/NeboSanitizer$SanitizerResult;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FirebaseCorruptionListener implements IPageCorruptionListener {
    public static final int $stable = 0;
    public static final FirebaseCorruptionListener INSTANCE = new FirebaseCorruptionListener();

    /* JADX INFO: compiled from: FirebaseCorruptionListener.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NeboSanitizer.SanitizerStatus.values().length];
            try {
                iArr[NeboSanitizer.SanitizerStatus.Corrupted.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NeboSanitizer.SanitizerStatus.ResetedFields.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FirebaseCorruptionListener() {
    }

    @Override // com.myscript.snt.dms.IPageCorruptionListener
    public void corruptionStateChanged(PageKey pageKey, NeboSanitizer.SanitizerResult result) {
        String str;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(result, "result");
        NeboSanitizer.SanitizerStatus status = result.getStatus();
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            str = "Corrupted-Page";
        } else if (i != 2) {
            return;
        } else {
            str = "Recovered-Page";
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("origin", result.getSource());
        bundle.putString("trigger", result.getReason());
        bundle.putString("selected", result.getMessage());
        AnalyticsController.logDevAnalytics("Corruptions", bundle);
    }
}
