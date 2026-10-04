package com.myscript.nebo.editing;

import androidx.core.app.NotificationCompat;
import com.myscript.snt.core.NeboSanitizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\b\u0016\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nR\"\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageControllerLoadingException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", NotificationCompat.CATEGORY_STATUS, "Lcom/myscript/snt/core/NeboSanitizer$SanitizerStatus;", "(Lcom/myscript/snt/core/NeboSanitizer$SanitizerStatus;)V", "value", "getStatus", "()Lcom/myscript/snt/core/NeboSanitizer$SanitizerStatus;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageControllerLoadingException extends RuntimeException {
    private NeboSanitizer.SanitizerStatus status;

    public final NeboSanitizer.SanitizerStatus getStatus() {
        return this.status;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageControllerLoadingException(Exception cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageControllerLoadingException(NeboSanitizer.SanitizerStatus status) {
        super(status.name());
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }
}
