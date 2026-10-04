package com.myscript.nebo.dms.sharepage.contacts.model;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Contacts.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "", "email", "", "contactId", "", "displayName", "avatar", "Landroid/net/Uri;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Landroid/net/Uri;)V", "getEmail", "()Ljava/lang/String;", "getContactId", "()J", "getDisplayName", "getAvatar", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ContactItem {
    private final Uri avatar;
    private final long contactId;
    private final String displayName;
    private final String email;

    public static /* synthetic */ ContactItem copy$default(ContactItem contactItem, String str, long j, String str2, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactItem.email;
        }
        if ((i & 2) != 0) {
            j = contactItem.contactId;
        }
        if ((i & 4) != 0) {
            str2 = contactItem.displayName;
        }
        if ((i & 8) != 0) {
            uri = contactItem.avatar;
        }
        return contactItem.copy(str, j, str2, uri);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getContactId() {
        return this.contactId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Uri getAvatar() {
        return this.avatar;
    }

    public final ContactItem copy(String email, long contactId, String displayName, Uri avatar) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new ContactItem(email, contactId, displayName, avatar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactItem)) {
            return false;
        }
        ContactItem contactItem = (ContactItem) other;
        return Intrinsics.areEqual(this.email, contactItem.email) && this.contactId == contactItem.contactId && Intrinsics.areEqual(this.displayName, contactItem.displayName) && Intrinsics.areEqual(this.avatar, contactItem.avatar);
    }

    public int hashCode() {
        int iHashCode = ((((this.email.hashCode() * 31) + Long.hashCode(this.contactId)) * 31) + this.displayName.hashCode()) * 31;
        Uri uri = this.avatar;
        return iHashCode + (uri == null ? 0 : uri.hashCode());
    }

    public String toString() {
        return "ContactItem(email=" + this.email + ", contactId=" + this.contactId + ", displayName=" + this.displayName + ", avatar=" + this.avatar + ")";
    }

    public ContactItem(String email, long j, String displayName, Uri uri) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.email = email;
        this.contactId = j;
        this.displayName = displayName;
        this.avatar = uri;
    }

    public final String getEmail() {
        return this.email;
    }

    public final long getContactId() {
        return this.contactId;
    }

    public /* synthetic */ ContactItem(String str, long j, String str2, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : uri);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Uri getAvatar() {
        return this.avatar;
    }
}
