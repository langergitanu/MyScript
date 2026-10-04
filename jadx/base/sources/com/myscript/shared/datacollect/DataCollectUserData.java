package com.myscript.shared.datacollect;

import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataCollectUserData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00060"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollectUserData;", "", "deviceLanguage", "", "project", DeviceDimensionProvider.KEY_PLATFORM, "appVersion", "userId", "signature", "uuid", "lastModificationDate", "", "creationDate", "title", "paidStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getDeviceLanguage", "()Ljava/lang/String;", "getProject", "getPlatform", "getAppVersion", "getUserId", "getSignature", "getUuid", "getLastModificationDate", "()J", "getCreationDate", "getTitle", "getPaidStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class DataCollectUserData {

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("creationDate")
    private final long creationDate;

    @SerializedName("deviceLanguage")
    private final String deviceLanguage;

    @SerializedName("lastModificationDate")
    private final long lastModificationDate;

    @SerializedName("paidStatus")
    private final String paidStatus;

    @SerializedName(DeviceDimensionProvider.KEY_PLATFORM)
    private final String platform;

    @SerializedName("project")
    private final String project;

    @SerializedName("signature")
    private final String signature;

    @SerializedName("title")
    private final String title;

    @SerializedName("userId")
    private final String userId;

    @SerializedName("uuid")
    private final String uuid;

    public static /* synthetic */ DataCollectUserData copy$default(DataCollectUserData dataCollectUserData, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, long j2, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dataCollectUserData.deviceLanguage;
        }
        return dataCollectUserData.copy(str, (i & 2) != 0 ? dataCollectUserData.project : str2, (i & 4) != 0 ? dataCollectUserData.platform : str3, (i & 8) != 0 ? dataCollectUserData.appVersion : str4, (i & 16) != 0 ? dataCollectUserData.userId : str5, (i & 32) != 0 ? dataCollectUserData.signature : str6, (i & 64) != 0 ? dataCollectUserData.uuid : str7, (i & 128) != 0 ? dataCollectUserData.lastModificationDate : j, (i & 256) != 0 ? dataCollectUserData.creationDate : j2, (i & 512) != 0 ? dataCollectUserData.title : str8, (i & 1024) != 0 ? dataCollectUserData.paidStatus : str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPaidStatus() {
        return this.paidStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProject() {
        return this.project;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getCreationDate() {
        return this.creationDate;
    }

    public final DataCollectUserData copy(String deviceLanguage, String project, String platform, String appVersion, String userId, String signature, String uuid, long lastModificationDate, long creationDate, String title, String paidStatus) {
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(paidStatus, "paidStatus");
        return new DataCollectUserData(deviceLanguage, project, platform, appVersion, userId, signature, uuid, lastModificationDate, creationDate, title, paidStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCollectUserData)) {
            return false;
        }
        DataCollectUserData dataCollectUserData = (DataCollectUserData) other;
        return Intrinsics.areEqual(this.deviceLanguage, dataCollectUserData.deviceLanguage) && Intrinsics.areEqual(this.project, dataCollectUserData.project) && Intrinsics.areEqual(this.platform, dataCollectUserData.platform) && Intrinsics.areEqual(this.appVersion, dataCollectUserData.appVersion) && Intrinsics.areEqual(this.userId, dataCollectUserData.userId) && Intrinsics.areEqual(this.signature, dataCollectUserData.signature) && Intrinsics.areEqual(this.uuid, dataCollectUserData.uuid) && this.lastModificationDate == dataCollectUserData.lastModificationDate && this.creationDate == dataCollectUserData.creationDate && Intrinsics.areEqual(this.title, dataCollectUserData.title) && Intrinsics.areEqual(this.paidStatus, dataCollectUserData.paidStatus);
    }

    public int hashCode() {
        return (((((((((((((((((((this.deviceLanguage.hashCode() * 31) + this.project.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.signature.hashCode()) * 31) + this.uuid.hashCode()) * 31) + Long.hashCode(this.lastModificationDate)) * 31) + Long.hashCode(this.creationDate)) * 31) + this.title.hashCode()) * 31) + this.paidStatus.hashCode();
    }

    public String toString() {
        return "DataCollectUserData(deviceLanguage=" + this.deviceLanguage + ", project=" + this.project + ", platform=" + this.platform + ", appVersion=" + this.appVersion + ", userId=" + this.userId + ", signature=" + this.signature + ", uuid=" + this.uuid + ", lastModificationDate=" + this.lastModificationDate + ", creationDate=" + this.creationDate + ", title=" + this.title + ", paidStatus=" + this.paidStatus + ")";
    }

    public DataCollectUserData(String deviceLanguage, String project, String platform, String appVersion, String userId, String signature, String uuid, long j, long j2, String title, String paidStatus) {
        Intrinsics.checkNotNullParameter(deviceLanguage, "deviceLanguage");
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(paidStatus, "paidStatus");
        this.deviceLanguage = deviceLanguage;
        this.project = project;
        this.platform = platform;
        this.appVersion = appVersion;
        this.userId = userId;
        this.signature = signature;
        this.uuid = uuid;
        this.lastModificationDate = j;
        this.creationDate = j2;
        this.title = title;
        this.paidStatus = paidStatus;
    }

    public final String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public final String getProject() {
        return this.project;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    public final long getCreationDate() {
        return this.creationDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPaidStatus() {
        return this.paidStatus;
    }
}
