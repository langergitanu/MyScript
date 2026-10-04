package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboAccount.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003567Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\t\u0010.\u001a\u00020\u0011HÆ\u0003Ju\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0014\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010$\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001e¨\u00068"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/NeboAccount;", "", "login", "", "firstName", "lastName", "email", "settings", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Settings;", "inAppPurchases", "", "Lcom/myscript/nebo/account/backend/entity/InApp;", "features", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature;", "isPro", "", "rights", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Rights;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/account/backend/entity/NeboAccount$Settings;Ljava/util/List;Ljava/util/List;ZLcom/myscript/nebo/account/backend/entity/NeboAccount$Rights;)V", "getLogin", "()Ljava/lang/String;", "getFirstName", "getLastName", "getEmail", "getSettings", "()Lcom/myscript/nebo/account/backend/entity/NeboAccount$Settings;", "getInAppPurchases", "()Ljava/util/List;", "getFeatures", "()Z", "getRights", "()Lcom/myscript/nebo/account/backend/entity/NeboAccount$Rights;", "hasFeature", "name", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature$Name;", "canOpenApp", "getCanOpenApp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Feature", "Settings", "Rights", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NeboAccount {

    @SerializedName("email")
    private final String email;

    @SerializedName("features")
    private final List<Feature> features;

    @SerializedName("firstName")
    private final String firstName;

    @SerializedName("inAppPurchases")
    private final List<InApp> inAppPurchases;

    @SerializedName("pro")
    private final boolean isPro;

    @SerializedName("lastName")
    private final String lastName;

    @SerializedName("login")
    private final String login;

    @SerializedName("rights")
    private final Rights rights;

    @SerializedName("settings")
    private final Settings settings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NeboAccount copy$default(NeboAccount neboAccount, String str, String str2, String str3, String str4, Settings settings, List list, List list2, boolean z, Rights rights, int i, Object obj) {
        if ((i & 1) != 0) {
            str = neboAccount.login;
        }
        if ((i & 2) != 0) {
            str2 = neboAccount.firstName;
        }
        if ((i & 4) != 0) {
            str3 = neboAccount.lastName;
        }
        if ((i & 8) != 0) {
            str4 = neboAccount.email;
        }
        if ((i & 16) != 0) {
            settings = neboAccount.settings;
        }
        if ((i & 32) != 0) {
            list = neboAccount.inAppPurchases;
        }
        if ((i & 64) != 0) {
            list2 = neboAccount.features;
        }
        if ((i & 128) != 0) {
            z = neboAccount.isPro;
        }
        if ((i & 256) != 0) {
            rights = neboAccount.rights;
        }
        boolean z2 = z;
        Rights rights2 = rights;
        List list3 = list;
        List list4 = list2;
        Settings settings2 = settings;
        String str5 = str3;
        return neboAccount.copy(str, str2, str5, str4, settings2, list3, list4, z2, rights2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Settings getSettings() {
        return this.settings;
    }

    public final List<InApp> component6() {
        return this.inAppPurchases;
    }

    public final List<Feature> component7() {
        return this.features;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsPro() {
        return this.isPro;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Rights getRights() {
        return this.rights;
    }

    public final NeboAccount copy(String login, String firstName, String lastName, String email, Settings settings, List<InApp> inAppPurchases, List<Feature> features, boolean isPro, Rights rights) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(rights, "rights");
        return new NeboAccount(login, firstName, lastName, email, settings, inAppPurchases, features, isPro, rights);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NeboAccount)) {
            return false;
        }
        NeboAccount neboAccount = (NeboAccount) other;
        return Intrinsics.areEqual(this.login, neboAccount.login) && Intrinsics.areEqual(this.firstName, neboAccount.firstName) && Intrinsics.areEqual(this.lastName, neboAccount.lastName) && Intrinsics.areEqual(this.email, neboAccount.email) && Intrinsics.areEqual(this.settings, neboAccount.settings) && Intrinsics.areEqual(this.inAppPurchases, neboAccount.inAppPurchases) && Intrinsics.areEqual(this.features, neboAccount.features) && this.isPro == neboAccount.isPro && Intrinsics.areEqual(this.rights, neboAccount.rights);
    }

    public int hashCode() {
        int iHashCode = this.login.hashCode() * 31;
        String str = this.firstName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastName;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.email.hashCode()) * 31) + this.settings.hashCode()) * 31;
        List<InApp> list = this.inAppPurchases;
        return ((((((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.features.hashCode()) * 31) + Boolean.hashCode(this.isPro)) * 31) + this.rights.hashCode();
    }

    public String toString() {
        return "NeboAccount(login=" + this.login + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", settings=" + this.settings + ", inAppPurchases=" + this.inAppPurchases + ", features=" + this.features + ", isPro=" + this.isPro + ", rights=" + this.rights + ")";
    }

    public NeboAccount(String login, String str, String str2, String email, Settings settings, List<InApp> list, List<Feature> features, boolean z, Rights rights) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(rights, "rights");
        this.login = login;
        this.firstName = str;
        this.lastName = str2;
        this.email = email;
        this.settings = settings;
        this.inAppPurchases = list;
        this.features = features;
        this.isPro = z;
        this.rights = rights;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NeboAccount(String str, String str2, String str3, String str4, Settings settings, List list, List list2, boolean z, Rights rights, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Rights rights2;
        boolean z2;
        List list3;
        List list4;
        Settings settings2;
        String str5;
        String str6;
        str2 = (i & 2) != 0 ? null : str2;
        if ((i & 4) != 0) {
            rights2 = rights;
            z2 = z;
            list3 = list2;
            list4 = list;
            settings2 = settings;
            str5 = str4;
            str6 = null;
        } else {
            rights2 = rights;
            z2 = z;
            list3 = list2;
            list4 = list;
            settings2 = settings;
            str5 = str4;
            str6 = str3;
        }
        this(str, str2, str6, str5, settings2, list4, list3, z2, rights2);
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    public final List<InApp> getInAppPurchases() {
        return this.inAppPurchases;
    }

    public final List<Feature> getFeatures() {
        return this.features;
    }

    public final boolean isPro() {
        return this.isPro;
    }

    public final Rights getRights() {
        return this.rights;
    }

    /* JADX INFO: compiled from: NeboAccount.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature;", "", "name", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature$Name;", "<init>", "(Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature$Name;)V", "getName", "()Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature$Name;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Name", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Feature {

        @SerializedName("name")
        private final Name name;

        public static /* synthetic */ Feature copy$default(Feature feature, Name name, int i, Object obj) {
            if ((i & 1) != 0) {
                name = feature.name;
            }
            return feature.copy(name);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Name getName() {
            return this.name;
        }

        public final Feature copy(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Feature(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Feature) && this.name == ((Feature) other).name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Feature(name=" + this.name + ")";
        }

        public Feature(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final Name getName() {
            return this.name;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: NeboAccount.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature$Name;", "", "<init>", "(Ljava/lang/String;I)V", "Pro", "PDF", "VolumePurchase", "UnlimitedNotebook", "Share", "OpenApp", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Name {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Name[] $VALUES;

            @SerializedName("PRO")
            public static final Name Pro = new Name("Pro", 0);

            @SerializedName("PDF")
            public static final Name PDF = new Name("PDF", 1);

            @SerializedName("VOLUME_PURCHASE")
            public static final Name VolumePurchase = new Name("VolumePurchase", 2);

            @SerializedName("UNLIMITEDNOTEBOOK")
            public static final Name UnlimitedNotebook = new Name("UnlimitedNotebook", 3);

            @SerializedName("SHARE")
            public static final Name Share = new Name("Share", 4);

            @SerializedName("OPENAPP")
            public static final Name OpenApp = new Name("OpenApp", 5);

            private static final /* synthetic */ Name[] $values() {
                return new Name[]{Pro, PDF, VolumePurchase, UnlimitedNotebook, Share, OpenApp};
            }

            public static EnumEntries<Name> getEntries() {
                return $ENTRIES;
            }

            public static Name valueOf(String str) {
                return (Name) Enum.valueOf(Name.class, str);
            }

            public static Name[] values() {
                return (Name[]) $VALUES.clone();
            }

            private Name(String str, int i) {
            }

            static {
                Name[] nameArr$values = $values();
                $VALUES = nameArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(nameArr$values);
            }
        }
    }

    /* JADX INFO: compiled from: NeboAccount.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/NeboAccount$Settings;", "", "displayNameInPublicPages", "", "<init>", "(Z)V", "getDisplayNameInPublicPages", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Settings {

        @SerializedName("displayNameInPublicPages")
        private final boolean displayNameInPublicPages;

        public static /* synthetic */ Settings copy$default(Settings settings, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = settings.displayNameInPublicPages;
            }
            return settings.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getDisplayNameInPublicPages() {
            return this.displayNameInPublicPages;
        }

        public final Settings copy(boolean displayNameInPublicPages) {
            return new Settings(displayNameInPublicPages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Settings) && this.displayNameInPublicPages == ((Settings) other).displayNameInPublicPages;
        }

        public int hashCode() {
            return Boolean.hashCode(this.displayNameInPublicPages);
        }

        public String toString() {
            return "Settings(displayNameInPublicPages=" + this.displayNameInPublicPages + ")";
        }

        public Settings(boolean z) {
            this.displayNameInPublicPages = z;
        }

        public final boolean getDisplayNameInPublicPages() {
            return this.displayNameInPublicPages;
        }
    }

    /* JADX INFO: compiled from: NeboAccount.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/NeboAccount$Rights;", "", "exportPdf", "", "<init>", "(Z)V", "getExportPdf", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Rights {

        @SerializedName("exportPdf")
        private final boolean exportPdf;

        public static /* synthetic */ Rights copy$default(Rights rights, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = rights.exportPdf;
            }
            return rights.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getExportPdf() {
            return this.exportPdf;
        }

        public final Rights copy(boolean exportPdf) {
            return new Rights(exportPdf);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Rights) && this.exportPdf == ((Rights) other).exportPdf;
        }

        public int hashCode() {
            return Boolean.hashCode(this.exportPdf);
        }

        public String toString() {
            return "Rights(exportPdf=" + this.exportPdf + ")";
        }

        public Rights(boolean z) {
            this.exportPdf = z;
        }

        public final boolean getExportPdf() {
            return this.exportPdf;
        }
    }

    public final boolean hasFeature(Feature.Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<Feature> list = this.features;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Feature) it.next()).getName() == name) {
                return true;
            }
        }
        return false;
    }

    public final boolean getCanOpenApp() {
        return hasFeature(Feature.Name.OpenApp);
    }
}
