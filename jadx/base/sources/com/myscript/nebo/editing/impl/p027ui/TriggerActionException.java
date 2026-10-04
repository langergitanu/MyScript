package com.myscript.nebo.editing.impl.p027ui;

import com.myscript.atk.core.Point;
import com.myscript.atk.p021ui.ActionMenuEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TriggerActionException.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/TriggerActionException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "action", "Lcom/myscript/atk/ui/ActionMenuEntry;", "actionIndex", "", "actionId", "actionMenuPoint", "Lcom/myscript/atk/core/Point;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Lcom/myscript/atk/ui/ActionMenuEntry;IILcom/myscript/atk/core/Point;Ljava/lang/Exception;)V", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TriggerActionException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerActionException(ActionMenuEntry action, int i, int i2, Point point, Exception cause) {
        super("Contextual menu exception while executing " + action.name() + " with id: " + i2 + ", index: " + i + " and point: " + point, cause);
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
