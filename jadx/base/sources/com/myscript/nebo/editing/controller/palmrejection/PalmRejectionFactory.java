package com.myscript.nebo.editing.controller.palmrejection;

import com.myscript.nebo.editing.impl.p027ui.IInputHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PalmRejectionFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/palmrejection/PalmRejectionFactory;", "", "<init>", "()V", "getInstance", "Lcom/myscript/nebo/editing/controller/palmrejection/FirstPointIsRightPolicy;", "inputHandler", "Lcom/myscript/nebo/editing/impl/ui/IInputHandler;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PalmRejectionFactory {
    public static final PalmRejectionFactory INSTANCE = new PalmRejectionFactory();

    private PalmRejectionFactory() {
    }

    @JvmStatic
    public static final FirstPointIsRightPolicy getInstance(IInputHandler inputHandler) {
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        return new FirstPointIsRightPolicy(inputHandler);
    }
}
