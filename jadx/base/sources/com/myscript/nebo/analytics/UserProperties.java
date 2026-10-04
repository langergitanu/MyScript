package com.myscript.nebo.analytics;

import kotlin.Metadata;

/* JADX INFO: compiled from: UserProperties.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/analytics/UserProperties;", "", "<init>", "()V", "USER_TYPE_KEY", "", "USER_TYPE_PAYING", "USER_TYPE_TRIAL", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserProperties {
    public static final UserProperties INSTANCE = new UserProperties();
    public static final String USER_TYPE_KEY = "user_type";
    public static final String USER_TYPE_PAYING = "paying";
    public static final String USER_TYPE_TRIAL = "trial";

    private UserProperties() {
    }
}
