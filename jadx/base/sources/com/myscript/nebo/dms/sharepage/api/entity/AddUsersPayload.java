package com.myscript.nebo.dms.sharepage.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddUsersPayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0006HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/AddUsersPayload;", "", "contacts", "", "Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel;", "message", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AddUsersPayload {

    @SerializedName("contacts")
    public final List<ContactModel> contacts;

    @SerializedName("message")
    public final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public AddUsersPayload() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddUsersPayload copy$default(AddUsersPayload addUsersPayload, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = addUsersPayload.contacts;
        }
        if ((i & 2) != 0) {
            str = addUsersPayload.message;
        }
        return addUsersPayload.copy(list, str);
    }

    public final List<ContactModel> component1() {
        return this.contacts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final AddUsersPayload copy(List<ContactModel> contacts, String message) {
        return new AddUsersPayload(contacts, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddUsersPayload)) {
            return false;
        }
        AddUsersPayload addUsersPayload = (AddUsersPayload) other;
        return Intrinsics.areEqual(this.contacts, addUsersPayload.contacts) && Intrinsics.areEqual(this.message, addUsersPayload.message);
    }

    public int hashCode() {
        List<ContactModel> list = this.contacts;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.message;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AddUsersPayload(contacts=" + this.contacts + ", message=" + this.message + ")";
    }

    public AddUsersPayload(List<ContactModel> list, String str) {
        this.contacts = list;
        this.message = str;
    }

    public /* synthetic */ AddUsersPayload(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
    }
}
