package com.survicate.surveys.infrastructure.network;

import android.os.Build;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;

/* JADX INFO: compiled from: UserAgentBuilder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/UserAgentBuilder;", "", "<init>", "()V", "build", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class UserAgentBuilder {
    public static final UserAgentBuilder INSTANCE = new UserAgentBuilder();

    private UserAgentBuilder() {
    }

    public final String build() {
        return "SurvicateSDK/8.3.0 (Android " + Build.VERSION.SDK_INT + JsonPointer.SEPARATOR + Build.VERSION.RELEASE + ')';
    }
}
