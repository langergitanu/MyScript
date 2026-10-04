package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShareNotesPayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/ShareNotesPayload;", "", "login", "", "shareWithMyScript", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "shareNotes", "", "(Ljava/lang/String;Z)V", "getLogin", "()Ljava/lang/String;", "getShareWithMyScript", "isSharedWithMyScript", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ShareNotesPayload {

    @SerializedName("login")
    private final String login;

    @SerializedName("share_with_myscript")
    private final String shareWithMyScript;

    public static /* synthetic */ ShareNotesPayload copy$default(ShareNotesPayload shareNotesPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareNotesPayload.login;
        }
        if ((i & 2) != 0) {
            str2 = shareNotesPayload.shareWithMyScript;
        }
        return shareNotesPayload.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShareWithMyScript() {
        return this.shareWithMyScript;
    }

    public final ShareNotesPayload copy(String login, String shareWithMyScript) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(shareWithMyScript, "shareWithMyScript");
        return new ShareNotesPayload(login, shareWithMyScript);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareNotesPayload)) {
            return false;
        }
        ShareNotesPayload shareNotesPayload = (ShareNotesPayload) other;
        return Intrinsics.areEqual(this.login, shareNotesPayload.login) && Intrinsics.areEqual(this.shareWithMyScript, shareNotesPayload.shareWithMyScript);
    }

    public int hashCode() {
        return (this.login.hashCode() * 31) + this.shareWithMyScript.hashCode();
    }

    public String toString() {
        return "ShareNotesPayload(login=" + this.login + ", shareWithMyScript=" + this.shareWithMyScript + ")";
    }

    public ShareNotesPayload(String login, String shareWithMyScript) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(shareWithMyScript, "shareWithMyScript");
        this.login = login;
        this.shareWithMyScript = shareWithMyScript;
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getShareWithMyScript() {
        return this.shareWithMyScript;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareNotesPayload(String login, boolean z) {
        this(login, z ? "1" : "0");
        Intrinsics.checkNotNullParameter(login, "login");
    }

    public final boolean isSharedWithMyScript() {
        return Intrinsics.areEqual(this.shareWithMyScript, "1");
    }
}
