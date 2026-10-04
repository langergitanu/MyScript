package com.myscript.nebo.editing;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.myscript.snt.core.ToolbarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputException.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\n\u0010\u000bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\n\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/editing/InputException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "toolbar", "Lcom/myscript/snt/core/ToolbarConfiguration;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Landroid/view/MotionEvent;Lcom/myscript/snt/core/ToolbarConfiguration;Ljava/lang/Exception;)V", "(Landroid/view/MotionEvent;Ljava/lang/Exception;)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InputException extends RuntimeException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputException(MotionEvent event, ToolbarConfiguration toolbar, Exception cause) {
        super(event + " Input error with toolbar <<< " + toolbar + " >>> on '" + toolbar.getContentType() + "'", cause);
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputException(MotionEvent event, Exception cause) {
        super(event + " Input error with unknown toolbar state", cause);
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
