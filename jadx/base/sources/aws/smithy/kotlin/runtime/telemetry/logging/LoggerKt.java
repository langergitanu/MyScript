package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\t\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002*\u0016\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u000b"}, m1599d2 = {"MessageSupplier", "Lkotlin/Function0;", "", "trace", "", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", NotificationCompat.CATEGORY_MESSAGE, "debug", "info", "warn", "error", "telemetry-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoggerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String debug$lambda$0(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String error$lambda$0(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String info$lambda$0(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trace$lambda$0(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String warn$lambda$0(String str) {
        return str;
    }

    public static final void trace(Logger logger, final String msg) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoggerKt.trace$lambda$0(msg);
            }
        }, 1, null);
    }

    public static final void debug(Logger logger, final String msg) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoggerKt.debug$lambda$0(msg);
            }
        }, 1, null);
    }

    public static final void info(Logger logger, final String msg) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.info$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoggerKt.info$lambda$0(msg);
            }
        }, 1, null);
    }

    public static final void warn(Logger logger, final String msg) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.warn$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoggerKt.warn$lambda$0(msg);
            }
        }, 1, null);
    }

    public static final void error(Logger logger, final String msg) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.error$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.LoggerKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoggerKt.error$lambda$0(msg);
            }
        }, 1, null);
    }
}
