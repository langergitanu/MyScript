package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DangerousSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/DangerousSettings;", "Landroid/os/Parcelable;", "autoSyncPurchases", "", "(Z)V", "customEntitlementComputation", "uiPreviewMode", "applyObfuscatedAccountIdToSubscriptionChanges", "usesRemoteConfigAPISources", "allowTestStoreInReleaseBuild", "(ZZZZZZ)V", "getAllowTestStoreInReleaseBuild$purchases_defaultsRelease", "()Z", "getApplyObfuscatedAccountIdToSubscriptionChanges$purchases_defaultsRelease", "getAutoSyncPurchases", "getCustomEntitlementComputation$purchases_defaultsRelease", "getUiPreviewMode$purchases_defaultsRelease", "getUsesRemoteConfigAPISources$purchases_defaultsRelease", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DangerousSettings implements Parcelable {
    private final boolean allowTestStoreInReleaseBuild;
    private final boolean applyObfuscatedAccountIdToSubscriptionChanges;
    private final boolean autoSyncPurchases;
    private final boolean customEntitlementComputation;
    private final boolean uiPreviewMode;
    private final boolean usesRemoteConfigAPISources;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<DangerousSettings> CREATOR = new Creator();

    /* JADX INFO: compiled from: DangerousSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<DangerousSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z6 = true;
            boolean z7 = false;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z6 = false;
            }
            if (parcel.readInt() != 0) {
                z2 = false;
                z7 = z;
            } else {
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = z2;
                z2 = z;
            } else {
                z3 = z2;
            }
            if (parcel.readInt() != 0) {
                z4 = z3;
                z3 = z;
            } else {
                z4 = z3;
            }
            if (parcel.readInt() != 0) {
                z5 = z4;
                z4 = z;
            } else {
                z5 = z4;
            }
            if (parcel.readInt() != 0) {
                z5 = z;
            }
            return new DangerousSettings(z6, z7, z2, z3, z4, z5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings[] newArray(int i) {
            return new DangerousSettings[i];
        }
    }

    public DangerousSettings() {
        this(false, false, false, false, false, false, 63, null);
    }

    @JvmStatic
    public static final DangerousSettings forPreviewMode() {
        return INSTANCE.forPreviewMode();
    }

    @JvmStatic
    public static final DangerousSettings forTestStoreInReleaseBuild() {
        return INSTANCE.forTestStoreInReleaseBuild();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DangerousSettings)) {
            return false;
        }
        DangerousSettings dangerousSettings = (DangerousSettings) obj;
        return this.autoSyncPurchases == dangerousSettings.autoSyncPurchases && this.customEntitlementComputation == dangerousSettings.customEntitlementComputation && this.uiPreviewMode == dangerousSettings.uiPreviewMode && this.applyObfuscatedAccountIdToSubscriptionChanges == dangerousSettings.applyObfuscatedAccountIdToSubscriptionChanges && this.usesRemoteConfigAPISources == dangerousSettings.usesRemoteConfigAPISources && this.allowTestStoreInReleaseBuild == dangerousSettings.allowTestStoreInReleaseBuild;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.autoSyncPurchases) * 31) + Boolean.hashCode(this.customEntitlementComputation)) * 31) + Boolean.hashCode(this.uiPreviewMode)) * 31) + Boolean.hashCode(this.applyObfuscatedAccountIdToSubscriptionChanges)) * 31) + Boolean.hashCode(this.usesRemoteConfigAPISources)) * 31) + Boolean.hashCode(this.allowTestStoreInReleaseBuild);
    }

    public String toString() {
        return "DangerousSettings(autoSyncPurchases=" + this.autoSyncPurchases + ", customEntitlementComputation=" + this.customEntitlementComputation + ", uiPreviewMode=" + this.uiPreviewMode + ", applyObfuscatedAccountIdToSubscriptionChanges=" + this.applyObfuscatedAccountIdToSubscriptionChanges + ", usesRemoteConfigAPISources=" + this.usesRemoteConfigAPISources + ", allowTestStoreInReleaseBuild=" + this.allowTestStoreInReleaseBuild + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.autoSyncPurchases ? 1 : 0);
        parcel.writeInt(this.customEntitlementComputation ? 1 : 0);
        parcel.writeInt(this.uiPreviewMode ? 1 : 0);
        parcel.writeInt(this.applyObfuscatedAccountIdToSubscriptionChanges ? 1 : 0);
        parcel.writeInt(this.usesRemoteConfigAPISources ? 1 : 0);
        parcel.writeInt(this.allowTestStoreInReleaseBuild ? 1 : 0);
    }

    public DangerousSettings(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.autoSyncPurchases = z;
        this.customEntitlementComputation = z2;
        this.uiPreviewMode = z3;
        this.applyObfuscatedAccountIdToSubscriptionChanges = z4;
        this.usesRemoteConfigAPISources = z5;
        this.allowTestStoreInReleaseBuild = z6;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ DangerousSettings(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 1
        L5:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = r0
        L15:
            r9 = r8 & 16
            if (r9 == 0) goto L1a
            r6 = r0
        L1a:
            r8 = r8 & 32
            if (r8 == 0) goto L26
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L26:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.DangerousSettings.<init>(boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getAutoSyncPurchases() {
        return this.autoSyncPurchases;
    }

    /* JADX INFO: renamed from: getCustomEntitlementComputation$purchases_defaultsRelease, reason: from getter */
    public final boolean getCustomEntitlementComputation() {
        return this.customEntitlementComputation;
    }

    /* JADX INFO: renamed from: getUiPreviewMode$purchases_defaultsRelease, reason: from getter */
    public final boolean getUiPreviewMode() {
        return this.uiPreviewMode;
    }

    /* JADX INFO: renamed from: getApplyObfuscatedAccountIdToSubscriptionChanges$purchases_defaultsRelease, reason: from getter */
    public final boolean getApplyObfuscatedAccountIdToSubscriptionChanges() {
        return this.applyObfuscatedAccountIdToSubscriptionChanges;
    }

    /* JADX INFO: renamed from: getUsesRemoteConfigAPISources$purchases_defaultsRelease, reason: from getter */
    public final boolean getUsesRemoteConfigAPISources() {
        return this.usesRemoteConfigAPISources;
    }

    /* JADX INFO: renamed from: getAllowTestStoreInReleaseBuild$purchases_defaultsRelease, reason: from getter */
    public final boolean getAllowTestStoreInReleaseBuild() {
        return this.allowTestStoreInReleaseBuild;
    }

    public DangerousSettings(boolean z) {
        this(z, false, false, false, false, false);
    }

    public /* synthetic */ DangerousSettings(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* JADX INFO: compiled from: DangerousSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/DangerousSettings$Companion;", "", "()V", "forPreviewMode", "Lcom/revenuecat/purchases/DangerousSettings;", "forTestStoreInReleaseBuild", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DangerousSettings forPreviewMode() {
            return new DangerousSettings(false, false, true, false, false, false, 48, null);
        }

        @JvmStatic
        public final DangerousSettings forTestStoreInReleaseBuild() {
            return new DangerousSettings(false, false, false, false, false, true, 31, null);
        }
    }
}
