package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/purchase/PurchaseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "kind", "Lcom/myscript/nebo/purchase/PurchaseErrorKind;", "message", "", "<init>", "(Lcom/myscript/nebo/purchase/PurchaseErrorKind;Ljava/lang/String;)V", "getKind", "()Lcom/myscript/nebo/purchase/PurchaseErrorKind;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PurchaseException extends RuntimeException {
    public static final int $stable = 8;
    private final PurchaseErrorKind kind;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseException(PurchaseErrorKind kind, String message) {
        super(message);
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(message, "message");
        this.kind = kind;
    }

    public final PurchaseErrorKind getKind() {
        return this.kind;
    }
}
