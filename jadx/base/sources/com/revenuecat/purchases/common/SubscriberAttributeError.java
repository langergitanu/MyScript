package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: errors.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "", "keyName", "", "message", "backendErrorCode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBackendErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKeyName", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "equals", "", "other", "hashCode", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class SubscriberAttributeError {
    private final Integer backendErrorCode;
    private final String keyName;
    private final String message;

    public static /* synthetic */ SubscriberAttributeError copy$default(SubscriberAttributeError subscriberAttributeError, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriberAttributeError.keyName;
        }
        if ((i & 2) != 0) {
            str2 = subscriberAttributeError.message;
        }
        if ((i & 4) != 0) {
            num = subscriberAttributeError.backendErrorCode;
        }
        return subscriberAttributeError.copy(str, str2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKeyName() {
        return this.keyName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }

    public final SubscriberAttributeError copy(String keyName, String message, Integer backendErrorCode) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SubscriberAttributeError(keyName, message, backendErrorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriberAttributeError)) {
            return false;
        }
        SubscriberAttributeError subscriberAttributeError = (SubscriberAttributeError) other;
        return Intrinsics.areEqual(this.keyName, subscriberAttributeError.keyName) && Intrinsics.areEqual(this.message, subscriberAttributeError.message) && Intrinsics.areEqual(this.backendErrorCode, subscriberAttributeError.backendErrorCode);
    }

    public int hashCode() {
        int iHashCode = ((this.keyName.hashCode() * 31) + this.message.hashCode()) * 31;
        Integer num = this.backendErrorCode;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SubscriberAttributeError(keyName=" + this.keyName + ", message=" + this.message + ", backendErrorCode=" + this.backendErrorCode + ')';
    }

    public SubscriberAttributeError(String keyName, String message, Integer num) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(message, "message");
        this.keyName = keyName;
        this.message = message;
        this.backendErrorCode = num;
    }

    public /* synthetic */ SubscriberAttributeError(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : num);
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }
}
