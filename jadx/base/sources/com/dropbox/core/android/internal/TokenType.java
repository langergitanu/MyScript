package com.dropbox.core.android.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: TokenType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/dropbox/core/android/internal/TokenType;", "", TypedValues.Custom.S_STRING, "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "OAUTH2", "OAUTH2CODE", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public enum TokenType {
    OAUTH2("oauth2:"),
    OAUTH2CODE("oauth2code:");

    private final String string;

    TokenType(String str) {
        this.string = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}
