package com.myscript.nebo.dms.sharepage.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel;", "", "email", "", "name", "permission", "Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel$Permission;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel$Permission;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Permission", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ContactModel {

    @SerializedName("email")
    public final String email;

    @SerializedName("name")
    public final String name;

    @SerializedName("permission")
    public final Permission permission;

    public static /* synthetic */ ContactModel copy$default(ContactModel contactModel, String str, String str2, Permission permission, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactModel.email;
        }
        if ((i & 2) != 0) {
            str2 = contactModel.name;
        }
        if ((i & 4) != 0) {
            permission = contactModel.permission;
        }
        return contactModel.copy(str, str2, permission);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Permission getPermission() {
        return this.permission;
    }

    public final ContactModel copy(String email, String name, Permission permission) {
        Intrinsics.checkNotNullParameter(email, "email");
        return new ContactModel(email, name, permission);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactModel)) {
            return false;
        }
        ContactModel contactModel = (ContactModel) other;
        return Intrinsics.areEqual(this.email, contactModel.email) && Intrinsics.areEqual(this.name, contactModel.name) && this.permission == contactModel.permission;
    }

    public int hashCode() {
        int iHashCode = this.email.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Permission permission = this.permission;
        return iHashCode2 + (permission != null ? permission.hashCode() : 0);
    }

    public String toString() {
        return "ContactModel(email=" + this.email + ", name=" + this.name + ", permission=" + this.permission + ")";
    }

    public ContactModel(String email, String str, Permission permission) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.email = email;
        this.name = str;
        this.permission = permission;
    }

    public /* synthetic */ ContactModel(String str, String str2, Permission permission, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : permission);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ContactModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel$Permission;", "", "<init>", "(Ljava/lang/String;I)V", "READ", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Permission {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Permission[] $VALUES;

        @SerializedName("READ")
        public static final Permission READ = new Permission("READ", 0);

        private static final /* synthetic */ Permission[] $values() {
            return new Permission[]{READ};
        }

        public static EnumEntries<Permission> getEntries() {
            return $ENTRIES;
        }

        public static Permission valueOf(String str) {
            return (Permission) Enum.valueOf(Permission.class, str);
        }

        public static Permission[] values() {
            return (Permission[]) $VALUES.clone();
        }

        private Permission(String str, int i) {
        }

        static {
            Permission[] permissionArr$values = $values();
            $VALUES = permissionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(permissionArr$values);
        }
    }
}
