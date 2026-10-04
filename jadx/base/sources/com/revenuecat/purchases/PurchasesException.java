package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchasesException.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/PurchasesException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "overridenMessage", "", "(Lcom/revenuecat/purchases/PurchasesError;Ljava/lang/String;)V", "code", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "getCode", "()Lcom/revenuecat/purchases/PurchasesErrorCode;", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "message", "getMessage", "()Ljava/lang/String;", "getOverridenMessage$purchases_defaultsRelease", "underlyingErrorMessage", "getUnderlyingErrorMessage", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public class PurchasesException extends Exception {
    private final PurchasesError error;
    private final String overridenMessage;

    public /* synthetic */ PurchasesException(PurchasesError purchasesError, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesError, (i & 2) != 0 ? null : str);
    }

    public final PurchasesError getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: getOverridenMessage$purchases_defaultsRelease, reason: from getter */
    public final String getOverridenMessage() {
        return this.overridenMessage;
    }

    public PurchasesException(PurchasesError error, String str) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.overridenMessage = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PurchasesException(PurchasesError error) {
        this(error, null);
        Intrinsics.checkNotNullParameter(error, "error");
    }

    public final PurchasesErrorCode getCode() {
        return this.error.getCode();
    }

    public final String getUnderlyingErrorMessage() {
        return this.error.getUnderlyingErrorMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.overridenMessage;
        return str == null ? this.error.getMessage() : str;
    }
}
