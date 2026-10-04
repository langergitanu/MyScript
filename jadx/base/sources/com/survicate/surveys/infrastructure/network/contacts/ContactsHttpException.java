package com.survicate.surveys.infrastructure.network.contacts;

import com.survicate.surveys.infrastructure.network.HttpException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsHttpException.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsHttpException;", "Lcom/survicate/surveys/infrastructure/network/HttpException;", "responseCode", "", "apiMessage", "", "<init>", "(ILjava/lang/String;)V", "message", "getMessage", "()Ljava/lang/String;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactsHttpException extends HttpException {
    private final String apiMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsHttpException(int i, String apiMessage) {
        super(i, null, 2, null);
        Intrinsics.checkNotNullParameter(apiMessage, "apiMessage");
        this.apiMessage = apiMessage;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "HTTP error (code: " + getResponseCode() + ", message: " + this.apiMessage + ')';
    }
}
