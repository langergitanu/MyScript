package com.revenuecat.purchases.ads.events;

import com.revenuecat.purchases.VerifiedReward;
import com.revenuecat.purchases.ads.events.types.AdRewardFailureReason;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.FeatureEvent;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\t$%&'()*+,R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0018\u0010\u0015\u001a\u00020\u0016X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0001\t-./012345\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent;", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "adUnitId", "", "getAdUnitId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "eventVersion", "", "getEventVersion", "()I", "id", "getId", "impressionId", "getImpressionId", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "getMediatorName-GyoM_N4", "networkName", "getNetworkName", "placement", "getPlacement", DiagnosticsEntry.TIMESTAMP_KEY, "", "getTimestamp", "()J", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "Displayed", "FailedToLoad", "Loaded", "Open", "Revenue", "RewardEarnedUnverified", "RewardFailedToVerify", "RewardGranted", "RewardVerified", "Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;", "Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Open;", "Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardEarnedUnverified;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardFailedToVerify;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardGranted;", "Lcom/revenuecat/purchases/ads/events/AdEvent$RewardVerified;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface AdEvent extends FeatureEvent {
    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name */
    String getAdFormat();

    String getAdUnitId();

    AdCaptureMethod getCaptureMethod();

    int getEventVersion();

    String getId();

    String getImpressionId();

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name */
    String getMediatorName();

    String getNetworkName();

    String getPlacement();

    long getTimestamp();

    AdEventType getType();

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isPriorityEvent(AdEvent adEvent) {
            return AdEvent.super.isPriorityEvent();
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Displayed implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Displayed(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod);
        }

        private Displayed(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Displayed(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.DISPLAYED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$Open;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Open implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Open(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod);
        }

        private Open(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Open(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.OPENED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0019\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "revenueMicros", "currency", "precision", "Lcom/revenuecat/purchases/ads/events/types/AdRevenuePrecision;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getCurrency", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getPrecision-rAcPn4k", "getRevenueMicros", "()J", "getTimestamp", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Revenue implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final String currency;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final long revenueMicros;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Revenue(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, long j2, String str8, String str9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod, j2, str8, str9);
        }

        private Revenue(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod, long j2, String currency, String precision) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(precision, "precision");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
            this.revenueMicros = j2;
            this.currency = currency;
            this.precision = precision;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Revenue(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, long j2, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str10;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str10 = string;
            } else {
                str10 = str;
            }
            this(str10, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.REVENUE : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, j2, str8, str9, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }

        public final long getRevenueMicros() {
            return this.revenueMicros;
        }

        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: getPrecision-rAcPn4k, reason: not valid java name and from getter */
        public final String getPrecision() {
            return this.precision;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Loaded implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Loaded(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod);
        }

        private Loaded(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Loaded(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.LOADED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014R\u001c\u0010\f\u001a\u00020\rX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u00020\u000bX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016R\u0016\u0010#\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "mediatorErrorCode", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Ljava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediatorName-GyoM_N4", "networkName", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class FailedToLoad implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ FailedToLoad(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, AdCaptureMethod adCaptureMethod, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, adCaptureMethod, num);
        }

        private FailedToLoad(String id, int i, AdEventType type, long j, String mediatorName, String adFormat, String str, String adUnitId, String str2, AdCaptureMethod captureMethod, Integer num) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str;
            this.adUnitId = adUnitId;
            this.impressionId = str2;
            this.captureMethod = captureMethod;
            this.mediatorErrorCode = num;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ FailedToLoad(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, AdCaptureMethod adCaptureMethod, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str7;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str7 = string;
            } else {
                str7 = str;
            }
            this(str7, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.FAILED_TO_LOAD : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, (i2 & 256) != 0 ? null : str6, adCaptureMethod, num, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$RewardEarnedUnverified;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "rewardVerificationEnabled", "", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getRewardVerificationEnabled", "()Z", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class RewardEarnedUnverified implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final boolean rewardVerificationEnabled;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ RewardEarnedUnverified(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod, z);
        }

        private RewardEarnedUnverified(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod, boolean z) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
            this.rewardVerificationEnabled = z;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ RewardEarnedUnverified(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.REWARD_EARNED_UNVERIFIED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, z, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }

        public final boolean getRewardVerificationEnabled() {
            return this.rewardVerificationEnabled;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$RewardVerified;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class RewardVerified implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ RewardVerified(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod);
        }

        private RewardVerified(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ RewardVerified(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.REWARD_VERIFIED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$RewardGranted;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "reward", "Lcom/revenuecat/purchases/VerifiedReward;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lcom/revenuecat/purchases/VerifiedReward;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getReward", "()Lcom/revenuecat/purchases/VerifiedReward;", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class RewardGranted implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final VerifiedReward reward;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ RewardGranted(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, VerifiedReward verifiedReward, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod, verifiedReward);
        }

        private RewardGranted(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod, VerifiedReward reward) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            Intrinsics.checkNotNullParameter(reward, "reward");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
            this.reward = reward;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ RewardGranted(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, VerifiedReward verifiedReward, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.REWARD_GRANTED : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, verifiedReward, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }

        public final VerifiedReward getReward() {
            return this.reward;
        }
    }

    /* JADX INFO: compiled from: AdEvent.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016R\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\fX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b#\u0010\u0018R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEvent$RewardFailedToVerify;", "Lcom/revenuecat/purchases/ads/events/AdEvent;", "id", "", "eventVersion", "", "type", "Lcom/revenuecat/purchases/ads/events/AdEventType;", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "failureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCaptureMethod", "()Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "getEventVersion", "()I", "getFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/ads/events/AdEventType;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class RewardFailedToVerify implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final AdCaptureMethod captureMethod;
        private final int eventVersion;
        private final AdRewardFailureReason failureReason;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ RewardFailedToVerify(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, AdRewardFailureReason adRewardFailureReason, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, adEventType, j, str2, str3, str4, str5, str6, str7, adCaptureMethod, adRewardFailureReason);
        }

        private RewardFailedToVerify(String id, int i, AdEventType type, long j, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdCaptureMethod captureMethod, AdRewardFailureReason failureReason) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
            Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            this.id = id;
            this.eventVersion = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.captureMethod = captureMethod;
            this.failureReason = failureReason;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ RewardFailedToVerify(String str, int i, AdEventType adEventType, long j, String str2, String str3, String str4, String str5, String str6, String str7, AdCaptureMethod adCaptureMethod, AdRewardFailureReason adRewardFailureReason, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i2 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? AdEventType.REWARD_FAILED_TO_VERIFY : adEventType, (i2 & 8) != 0 ? System.currentTimeMillis() : j, str2, str3, str4, str5, str6, str7, adCaptureMethod, adRewardFailureReason, null);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: from getter */
        public String getMediatorName() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: from getter */
        public String getAdFormat() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdCaptureMethod getCaptureMethod() {
            return this.captureMethod;
        }

        public final AdRewardFailureReason getFailureReason() {
            return this.failureReason;
        }
    }
}
