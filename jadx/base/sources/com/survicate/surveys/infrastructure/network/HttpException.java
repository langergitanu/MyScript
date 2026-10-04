package com.survicate.surveys.infrastructure.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/HttpException;", "Ljava/io/IOException;", "responseCode", "", "errorBody", "", "<init>", "(ILjava/lang/String;)V", "getResponseCode", "()I", "getErrorBody", "()Ljava/lang/String;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public class HttpException extends IOException {
    public static final int CONFLICT_RESPONSE_CODE = 409;
    public static final int TOO_MANY_REQUESTS_RESPONSE_CODE = 429;
    private final String errorBody;
    private final int responseCode;

    public /* synthetic */ HttpException(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getErrorBody() {
        return this.errorBody;
    }

    public HttpException(int i, String str) {
        super("HTTP error code: " + i);
        this.responseCode = i;
        this.errorBody = str;
    }
}
