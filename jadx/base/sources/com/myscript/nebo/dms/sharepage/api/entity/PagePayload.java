package com.myscript.nebo.dms.sharepage.api.entity;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagePayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@kotlin.Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0004=>?@B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aBM\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010 J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÀ\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0014\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\u0003HÖ\u0081\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006A"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload;", "", "bigThumbnailURL", "", "contacts", "", "Lcom/myscript/nebo/dms/sharepage/api/entity/ContactModel;", "contentURL", TtmlNode.TAG_METADATA, "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Metadata;", "owner", "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Owner;", "signature", "pageType", "smallThumbnailURL", NotificationCompat.CATEGORY_STATUS, "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;", DiagnosticsEntry.TIMESTAMP_KEY, "", "upcomingStatus", "uuid", "visibility", "Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;", "self", "lastPublicationDate", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Metadata;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Owner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;Ljava/lang/Long;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;Ljava/lang/String;Ljava/lang/String;)V", "creationTimestampMicros", "lastModificationTimestampMicros", "lastMetadataModificationTimestampMicros", "pageId", "pageTitle", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Long;", "publicationTimestamp", "getPublicationTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Long;", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Metadata;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Owner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;Ljava/lang/Long;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;Ljava/lang/String;Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;Ljava/lang/String;Ljava/lang/String;)Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload;", "equals", "", "other", "hashCode", "", "toString", "Status", "Visibility", "Metadata", "Owner", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PagePayload {

    @SerializedName("bigThumbnailURL")
    public final String bigThumbnailURL;

    @SerializedName("contacts")
    public final List<ContactModel> contacts;

    @SerializedName("contentURL")
    public final String contentURL;

    @SerializedName("lastPublicationDate")
    public final String lastPublicationDate;

    @SerializedName(TtmlNode.TAG_METADATA)
    public final Metadata metadata;

    @SerializedName("owner")
    public final Owner owner;

    @SerializedName("type")
    public final String pageType;

    @SerializedName("self")
    public final String self;

    @SerializedName("signature")
    public final String signature;

    @SerializedName("smallThumbnailURL")
    public final String smallThumbnailURL;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    public final Status status;

    @SerializedName(DiagnosticsEntry.TIMESTAMP_KEY)
    public final Long timestamp;

    @SerializedName("upcomingStatus")
    public final Status upcomingStatus;

    @SerializedName("uuid")
    public final String uuid;

    @SerializedName("visibility")
    public final Visibility visibility;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBigThumbnailURL() {
        return this.bigThumbnailURL;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Status getUpcomingStatus() {
        return this.upcomingStatus;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Visibility getVisibility() {
        return this.visibility;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSelf() {
        return this.self;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getLastPublicationDate() {
        return this.lastPublicationDate;
    }

    public final List<ContactModel> component2() {
        return this.contacts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentURL() {
        return this.contentURL;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Metadata getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPageType() {
        return this.pageType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSmallThumbnailURL() {
        return this.smallThumbnailURL;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final PagePayload copy(String bigThumbnailURL, List<ContactModel> contacts, String contentURL, Metadata metadata, Owner owner, String signature, String pageType, String smallThumbnailURL, Status status, Long timestamp, Status upcomingStatus, String uuid, Visibility visibility, String self, String lastPublicationDate) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new PagePayload(bigThumbnailURL, contacts, contentURL, metadata, owner, signature, pageType, smallThumbnailURL, status, timestamp, upcomingStatus, uuid, visibility, self, lastPublicationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagePayload)) {
            return false;
        }
        PagePayload pagePayload = (PagePayload) other;
        return Intrinsics.areEqual(this.bigThumbnailURL, pagePayload.bigThumbnailURL) && Intrinsics.areEqual(this.contacts, pagePayload.contacts) && Intrinsics.areEqual(this.contentURL, pagePayload.contentURL) && Intrinsics.areEqual(this.metadata, pagePayload.metadata) && Intrinsics.areEqual(this.owner, pagePayload.owner) && Intrinsics.areEqual(this.signature, pagePayload.signature) && Intrinsics.areEqual(this.pageType, pagePayload.pageType) && Intrinsics.areEqual(this.smallThumbnailURL, pagePayload.smallThumbnailURL) && this.status == pagePayload.status && Intrinsics.areEqual(this.timestamp, pagePayload.timestamp) && this.upcomingStatus == pagePayload.upcomingStatus && Intrinsics.areEqual(this.uuid, pagePayload.uuid) && this.visibility == pagePayload.visibility && Intrinsics.areEqual(this.self, pagePayload.self) && Intrinsics.areEqual(this.lastPublicationDate, pagePayload.lastPublicationDate);
    }

    public int hashCode() {
        String str = this.bigThumbnailURL;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ContactModel> list = this.contacts;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.contentURL;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.metadata.hashCode()) * 31;
        Owner owner = this.owner;
        int iHashCode4 = (((((iHashCode3 + (owner == null ? 0 : owner.hashCode())) * 31) + this.signature.hashCode()) * 31) + this.pageType.hashCode()) * 31;
        String str3 = this.smallThumbnailURL;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Status status = this.status;
        int iHashCode6 = (iHashCode5 + (status == null ? 0 : status.hashCode())) * 31;
        Long l = this.timestamp;
        int iHashCode7 = (iHashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        Status status2 = this.upcomingStatus;
        int iHashCode8 = (((iHashCode7 + (status2 == null ? 0 : status2.hashCode())) * 31) + this.uuid.hashCode()) * 31;
        Visibility visibility = this.visibility;
        int iHashCode9 = (iHashCode8 + (visibility == null ? 0 : visibility.hashCode())) * 31;
        String str4 = this.self;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.lastPublicationDate;
        return iHashCode10 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "PagePayload(bigThumbnailURL=" + this.bigThumbnailURL + ", contacts=" + this.contacts + ", contentURL=" + this.contentURL + ", metadata=" + this.metadata + ", owner=" + this.owner + ", signature=" + this.signature + ", pageType=" + this.pageType + ", smallThumbnailURL=" + this.smallThumbnailURL + ", status=" + this.status + ", timestamp=" + this.timestamp + ", upcomingStatus=" + this.upcomingStatus + ", uuid=" + this.uuid + ", visibility=" + this.visibility + ", self=" + this.self + ", lastPublicationDate=" + this.lastPublicationDate + ")";
    }

    public PagePayload(String str, List<ContactModel> list, String str2, Metadata metadata, Owner owner, String signature, String pageType, String str3, Status status, Long l, Status status2, String uuid, Visibility visibility, String str4, String str5) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.bigThumbnailURL = str;
        this.contacts = list;
        this.contentURL = str2;
        this.metadata = metadata;
        this.owner = owner;
        this.signature = signature;
        this.pageType = pageType;
        this.smallThumbnailURL = str3;
        this.status = status;
        this.timestamp = l;
        this.upcomingStatus = status2;
        this.uuid = uuid;
        this.visibility = visibility;
        this.self = str4;
        this.lastPublicationDate = str5;
    }

    public /* synthetic */ PagePayload(String str, List list, String str2, Metadata metadata, Owner owner, String str3, String str4, String str5, Status status, Long l, Status status2, String str6, Visibility visibility, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, metadata, (i & 16) != 0 ? null : owner, str3, str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : status, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : status2, str6, (i & 4096) != 0 ? null : visibility, (i & 8192) != 0 ? null : str7, (i & 16384) != 0 ? null : str8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagePayload(long j, long j2, long j3, String str, String str2, String pageType, String signature, String uuid) {
        this(null, null, null, new Metadata(DateUtilsKt.formatDateISO8601(j), DateUtilsKt.formatDateISO8601(j2), Long.valueOf(j3), str, str2), null, signature, pageType, null, null, null, null, uuid, null, null, null, 30615, null);
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
    }

    public final long getPublicationTimestamp() {
        String str = this.lastPublicationDate;
        if (str != null) {
            return DateUtilsKt.parseTimestampISO8601(str);
        }
        return 0L;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PagePayload.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Status;", "", "<init>", "(Ljava/lang/String;I)V", "PROCESSING", "READY", "UNSHARED", "ERROR", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;

        @SerializedName("PROCESSING")
        public static final Status PROCESSING = new Status("PROCESSING", 0);

        @SerializedName("READY")
        public static final Status READY = new Status("READY", 1);

        @SerializedName("UNSHARED")
        public static final Status UNSHARED = new Status("UNSHARED", 2);

        @SerializedName("ERROR")
        public static final Status ERROR = new Status("ERROR", 3);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{PROCESSING, READY, UNSHARED, ERROR};
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        private Status(String str, int i) {
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PagePayload.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Visibility;", "", "<init>", "(Ljava/lang/String;I)V", "PUBLIC", "PRIVATE", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Visibility {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Visibility[] $VALUES;

        @SerializedName("PUBLIC")
        public static final Visibility PUBLIC = new Visibility("PUBLIC", 0);

        @SerializedName("PRIVATE")
        public static final Visibility PRIVATE = new Visibility("PRIVATE", 1);

        private static final /* synthetic */ Visibility[] $values() {
            return new Visibility[]{PUBLIC, PRIVATE};
        }

        public static EnumEntries<Visibility> getEntries() {
            return $ENTRIES;
        }

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        private Visibility(String str, int i) {
        }

        static {
            Visibility[] visibilityArr$values = $values();
            $VALUES = visibilityArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(visibilityArr$values);
        }
    }

    /* JADX INFO: compiled from: PagePayload.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Metadata;", "", "creationDate", "", "lastModificationDate", "lastMetadataModificationDate", "", "pageId", "pageTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "()Ljava/lang/Long;", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Metadata;", "equals", "", "other", "hashCode", "", "toString", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Metadata {

        @SerializedName("creationDate")
        public final String creationDate;

        @SerializedName("lastMetadataModificationDate")
        public final Long lastMetadataModificationDate;

        @SerializedName("lastModificationDate")
        public final String lastModificationDate;

        @SerializedName("pageId")
        public final String pageId;

        @SerializedName("pageTitle")
        public final String pageTitle;

        public Metadata() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, Long l, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metadata.creationDate;
            }
            if ((i & 2) != 0) {
                str2 = metadata.lastModificationDate;
            }
            if ((i & 4) != 0) {
                l = metadata.lastMetadataModificationDate;
            }
            if ((i & 8) != 0) {
                str3 = metadata.pageId;
            }
            if ((i & 16) != 0) {
                str4 = metadata.pageTitle;
            }
            String str5 = str4;
            Long l2 = l;
            return metadata.copy(str, str2, l2, str3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCreationDate() {
            return this.creationDate;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLastModificationDate() {
            return this.lastModificationDate;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getLastMetadataModificationDate() {
            return this.lastMetadataModificationDate;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPageId() {
            return this.pageId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPageTitle() {
            return this.pageTitle;
        }

        public final Metadata copy(String creationDate, String lastModificationDate, Long lastMetadataModificationDate, String pageId, String pageTitle) {
            return new Metadata(creationDate, lastModificationDate, lastMetadataModificationDate, pageId, pageTitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return Intrinsics.areEqual(this.creationDate, metadata.creationDate) && Intrinsics.areEqual(this.lastModificationDate, metadata.lastModificationDate) && Intrinsics.areEqual(this.lastMetadataModificationDate, metadata.lastMetadataModificationDate) && Intrinsics.areEqual(this.pageId, metadata.pageId) && Intrinsics.areEqual(this.pageTitle, metadata.pageTitle);
        }

        public int hashCode() {
            String str = this.creationDate;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.lastModificationDate;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l = this.lastMetadataModificationDate;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            String str3 = this.pageId;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.pageTitle;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Metadata(creationDate=" + this.creationDate + ", lastModificationDate=" + this.lastModificationDate + ", lastMetadataModificationDate=" + this.lastMetadataModificationDate + ", pageId=" + this.pageId + ", pageTitle=" + this.pageTitle + ")";
        }

        public Metadata(String str, String str2, Long l, String str3, String str4) {
            this.creationDate = str;
            this.lastModificationDate = str2;
            this.lastMetadataModificationDate = l;
            this.pageId = str3;
            this.pageTitle = str4;
        }

        public /* synthetic */ Metadata(String str, String str2, Long l, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }
    }

    /* JADX INFO: compiled from: PagePayload.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/api/entity/PagePayload$Owner;", "", "email", "", "firstName", "lastName", "login", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Owner {

        @SerializedName("email")
        public final String email;

        @SerializedName("firstName")
        public final String firstName;

        @SerializedName("lastname")
        public final String lastName;

        @SerializedName("login")
        public final String login;

        public Owner() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Owner copy$default(Owner owner, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = owner.email;
            }
            if ((i & 2) != 0) {
                str2 = owner.firstName;
            }
            if ((i & 4) != 0) {
                str3 = owner.lastName;
            }
            if ((i & 8) != 0) {
                str4 = owner.login;
            }
            return owner.copy(str, str2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
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
        public final String getLogin() {
            return this.login;
        }

        public final Owner copy(String email, String firstName, String lastName, String login) {
            return new Owner(email, firstName, lastName, login);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Owner)) {
                return false;
            }
            Owner owner = (Owner) other;
            return Intrinsics.areEqual(this.email, owner.email) && Intrinsics.areEqual(this.firstName, owner.firstName) && Intrinsics.areEqual(this.lastName, owner.lastName) && Intrinsics.areEqual(this.login, owner.login);
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.firstName;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.lastName;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.login;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Owner(email=" + this.email + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", login=" + this.login + ")";
        }

        public Owner(String str, String str2, String str3, String str4) {
            this.email = str;
            this.firstName = str2;
            this.lastName = str3;
            this.login = str4;
        }

        public /* synthetic */ Owner(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }
    }
}
