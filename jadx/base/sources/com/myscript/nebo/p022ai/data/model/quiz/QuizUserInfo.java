package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizUserInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;", "", "osName", "", "osVersion", "appName", "appVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOsName", "()Ljava/lang/String;", "getOsVersion", "getAppName", "getAppVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizUserInfo {
    public static final int $stable = 0;

    @SerializedName("app_name")
    private final String appName;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("os_name")
    private final String osName;

    @SerializedName("os_version")
    private final String osVersion;

    public static /* synthetic */ QuizUserInfo copy$default(QuizUserInfo quizUserInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizUserInfo.osName;
        }
        if ((i & 2) != 0) {
            str2 = quizUserInfo.osVersion;
        }
        if ((i & 4) != 0) {
            str3 = quizUserInfo.appName;
        }
        if ((i & 8) != 0) {
            str4 = quizUserInfo.appVersion;
        }
        return quizUserInfo.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOsName() {
        return this.osName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final QuizUserInfo copy(String osName, String osVersion, String appName, String appVersion) {
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return new QuizUserInfo(osName, osVersion, appName, appVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizUserInfo)) {
            return false;
        }
        QuizUserInfo quizUserInfo = (QuizUserInfo) other;
        return Intrinsics.areEqual(this.osName, quizUserInfo.osName) && Intrinsics.areEqual(this.osVersion, quizUserInfo.osVersion) && Intrinsics.areEqual(this.appName, quizUserInfo.appName) && Intrinsics.areEqual(this.appVersion, quizUserInfo.appVersion);
    }

    public int hashCode() {
        return (((((this.osName.hashCode() * 31) + this.osVersion.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.appVersion.hashCode();
    }

    public String toString() {
        return "QuizUserInfo(osName=" + this.osName + ", osVersion=" + this.osVersion + ", appName=" + this.appName + ", appVersion=" + this.appVersion + ")";
    }

    public QuizUserInfo(String osName, String osVersion, String appName, String appVersion) {
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.osName = osName;
        this.osVersion = osVersion;
        this.appName = appName;
        this.appVersion = appVersion;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }
}
