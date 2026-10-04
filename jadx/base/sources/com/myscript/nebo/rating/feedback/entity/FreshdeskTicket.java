package com.myscript.nebo.rating.feedback.entity;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: FreshdeskTicket.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/entity/FreshdeskTicket;", "", "subject", "", "description", NotificationCompat.CATEGORY_STATUS, "", LogFactory.PRIORITY_KEY, "email", "tags", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getSubject", "()Ljava/lang/String;", "getDescription", "getStatus", "()I", "getPriority", "getEmail", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FreshdeskTicket {
    public static final int $stable = 8;

    @SerializedName("description")
    private final String description;

    @SerializedName("email")
    private final String email;

    @SerializedName(LogFactory.PRIORITY_KEY)
    private final int priority;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final int status;

    @SerializedName("subject")
    private final String subject;

    @SerializedName("tags")
    private final List<String> tags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FreshdeskTicket copy$default(FreshdeskTicket freshdeskTicket, String str, String str2, int i, int i2, String str3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = freshdeskTicket.subject;
        }
        if ((i3 & 2) != 0) {
            str2 = freshdeskTicket.description;
        }
        if ((i3 & 4) != 0) {
            i = freshdeskTicket.status;
        }
        if ((i3 & 8) != 0) {
            i2 = freshdeskTicket.priority;
        }
        if ((i3 & 16) != 0) {
            str3 = freshdeskTicket.email;
        }
        if ((i3 & 32) != 0) {
            list = freshdeskTicket.tags;
        }
        String str4 = str3;
        List list2 = list;
        return freshdeskTicket.copy(str, str2, i, i2, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final FreshdeskTicket copy(String subject, String description, int status, int priority, String email, List<String> tags) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new FreshdeskTicket(subject, description, status, priority, email, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FreshdeskTicket)) {
            return false;
        }
        FreshdeskTicket freshdeskTicket = (FreshdeskTicket) other;
        return Intrinsics.areEqual(this.subject, freshdeskTicket.subject) && Intrinsics.areEqual(this.description, freshdeskTicket.description) && this.status == freshdeskTicket.status && this.priority == freshdeskTicket.priority && Intrinsics.areEqual(this.email, freshdeskTicket.email) && Intrinsics.areEqual(this.tags, freshdeskTicket.tags);
    }

    public int hashCode() {
        return (((((((((this.subject.hashCode() * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.priority)) * 31) + this.email.hashCode()) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "FreshdeskTicket(subject=" + this.subject + ", description=" + this.description + ", status=" + this.status + ", priority=" + this.priority + ", email=" + this.email + ", tags=" + this.tags + ")";
    }

    public FreshdeskTicket(String subject, String description, int i, int i2, String email, List<String> tags) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.subject = subject;
        this.description = description;
        this.status = i;
        this.priority = i2;
        this.email = email;
        this.tags = tags;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<String> getTags() {
        return this.tags;
    }
}
