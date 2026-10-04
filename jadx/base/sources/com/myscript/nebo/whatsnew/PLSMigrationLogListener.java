package com.myscript.nebo.whatsnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.snt.dms.DMSLogLevel;
import com.myscript.snt.dms.IDMSMigrationToV2LogListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PLSMigrationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B)\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationLogListener;", "Lcom/myscript/snt/dms/IDMSMigrationToV2LogListener;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "delegate", "Lkotlin/Function2;", "Lcom/myscript/snt/dms/DMSLogLevel;", "", "", "Lcom/myscript/nebo/whatsnew/PLSMigrationLogDelegate;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "log", FirebaseAnalytics.Param.LEVEL, "message", "close", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class PLSMigrationLogListener implements IDMSMigrationToV2LogListener, AutoCloseable {
    private Function2<? super DMSLogLevel, ? super String, Unit> delegate;

    public PLSMigrationLogListener(Function2<? super DMSLogLevel, ? super String, Unit> function2) {
        this.delegate = function2;
    }

    @Override // com.myscript.snt.dms.IDMSMigrationToV2LogListener
    public void log(DMSLogLevel level, String message) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(message, "message");
        Function2<? super DMSLogLevel, ? super String, Unit> function2 = this.delegate;
        if (function2 != null) {
            function2.invoke(level, message);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.delegate = null;
    }
}
