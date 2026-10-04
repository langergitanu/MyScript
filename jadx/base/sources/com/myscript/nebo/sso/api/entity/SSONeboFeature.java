package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.common.events.BackendEvent;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOAccount.kt */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "Use SSO shouldn't deal with Nebo feature flag")
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/SSONeboFeature;", "", "isAvailable", "", "isModifiedByUser", "isActivated", "isReadOnly", "description", "", "platforms", "", "Lcom/myscript/nebo/sso/api/entity/SSONeboFeature$Platform;", "<init>", "(ZZZZLjava/lang/String;Ljava/util/List;)V", "()Z", "getDescription", "()Ljava/lang/String;", "getPlatforms", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Platform", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SSONeboFeature {

    @SerializedName("description")
    private final String description;

    @SerializedName("activated")
    private final boolean isActivated;

    @SerializedName("available")
    private final boolean isAvailable;

    @SerializedName("modifiedByUser")
    private final boolean isModifiedByUser;

    @SerializedName("readonly")
    private final boolean isReadOnly;

    @SerializedName("platforms")
    private final List<Platform> platforms;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SSONeboFeature copy$default(SSONeboFeature sSONeboFeature, boolean z, boolean z2, boolean z3, boolean z4, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sSONeboFeature.isAvailable;
        }
        if ((i & 2) != 0) {
            z2 = sSONeboFeature.isModifiedByUser;
        }
        if ((i & 4) != 0) {
            z3 = sSONeboFeature.isActivated;
        }
        if ((i & 8) != 0) {
            z4 = sSONeboFeature.isReadOnly;
        }
        if ((i & 16) != 0) {
            str = sSONeboFeature.description;
        }
        if ((i & 32) != 0) {
            list = sSONeboFeature.platforms;
        }
        String str2 = str;
        List list2 = list;
        return sSONeboFeature.copy(z, z2, z3, z4, str2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsAvailable() {
        return this.isAvailable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsModifiedByUser() {
        return this.isModifiedByUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsActivated() {
        return this.isActivated;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<Platform> component6() {
        return this.platforms;
    }

    public final SSONeboFeature copy(boolean isAvailable, boolean isModifiedByUser, boolean isActivated, boolean isReadOnly, String description, List<? extends Platform> platforms) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(platforms, "platforms");
        return new SSONeboFeature(isAvailable, isModifiedByUser, isActivated, isReadOnly, description, platforms);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSONeboFeature)) {
            return false;
        }
        SSONeboFeature sSONeboFeature = (SSONeboFeature) other;
        return this.isAvailable == sSONeboFeature.isAvailable && this.isModifiedByUser == sSONeboFeature.isModifiedByUser && this.isActivated == sSONeboFeature.isActivated && this.isReadOnly == sSONeboFeature.isReadOnly && Intrinsics.areEqual(this.description, sSONeboFeature.description) && Intrinsics.areEqual(this.platforms, sSONeboFeature.platforms);
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.isAvailable) * 31) + Boolean.hashCode(this.isModifiedByUser)) * 31) + Boolean.hashCode(this.isActivated)) * 31) + Boolean.hashCode(this.isReadOnly)) * 31) + this.description.hashCode()) * 31) + this.platforms.hashCode();
    }

    public String toString() {
        return "SSONeboFeature(isAvailable=" + this.isAvailable + ", isModifiedByUser=" + this.isModifiedByUser + ", isActivated=" + this.isActivated + ", isReadOnly=" + this.isReadOnly + ", description=" + this.description + ", platforms=" + this.platforms + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSONeboFeature(boolean z, boolean z2, boolean z3, boolean z4, String description, List<? extends Platform> platforms) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(platforms, "platforms");
        this.isAvailable = z;
        this.isModifiedByUser = z2;
        this.isActivated = z3;
        this.isReadOnly = z4;
        this.description = description;
        this.platforms = platforms;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    public final boolean isModifiedByUser() {
        return this.isModifiedByUser;
    }

    public final boolean isActivated() {
        return this.isActivated;
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<Platform> getPlatforms() {
        return this.platforms;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SSOAccount.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/SSONeboFeature$Platform;", "", "<init>", "(Ljava/lang/String;I)V", "IOS", "Android", "Windows", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Platform {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Platform[] $VALUES;

        @SerializedName("ios")
        public static final Platform IOS = new Platform("IOS", 0);

        @SerializedName(BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM)
        public static final Platform Android = new Platform("Android", 1);

        @SerializedName("windows")
        public static final Platform Windows = new Platform("Windows", 2);

        private static final /* synthetic */ Platform[] $values() {
            return new Platform[]{IOS, Android, Windows};
        }

        public static EnumEntries<Platform> getEntries() {
            return $ENTRIES;
        }

        public static Platform valueOf(String str) {
            return (Platform) Enum.valueOf(Platform.class, str);
        }

        public static Platform[] values() {
            return (Platform[]) $VALUES.clone();
        }

        private Platform(String str, int i) {
        }

        static {
            Platform[] platformArr$values = $values();
            $VALUES = platformArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(platformArr$values);
        }
    }
}
