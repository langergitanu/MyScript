package com.revenuecat.purchases.rules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/rules/PrintLogger;", "Lcom/revenuecat/purchases/rules/RulesEngineLogger;", "()V", "log", "", "message", "", "warn", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PrintLogger implements RulesEngineLogger {
    public static final PrintLogger INSTANCE = new PrintLogger();

    private PrintLogger() {
    }

    @Override // com.revenuecat.purchases.rules.RulesEngineLogger
    public void warn(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.err.println(message);
    }

    @Override // com.revenuecat.purchases.rules.RulesEngineLogger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println((Object) message);
    }
}
