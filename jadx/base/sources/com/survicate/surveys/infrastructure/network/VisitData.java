package com.survicate.surveys.infrastructure.network;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: VisitData.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000fR&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/VisitData;", "", "<init>", "()V", "seen0", "", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "", DeviceDimensionProvider.KEY_PLATFORM, "userAgent", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguageCode$annotations", "getLanguageCode", "()Ljava/lang/String;", "setLanguageCode", "(Ljava/lang/String;)V", "value", "getPlatform$annotations", "getPlatform", "getUserAgent$annotations", "getUserAgent", "equals", "", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class VisitData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String languageCode;
    private String platform;
    private String userAgent;

    @SerialName("translation")
    public static /* synthetic */ void getLanguageCode$annotations() {
    }

    @SerialName(DeviceDimensionProvider.KEY_PLATFORM)
    public static /* synthetic */ void getPlatform$annotations() {
    }

    @SerialName("user_agent")
    public static /* synthetic */ void getUserAgent$annotations() {
    }

    /* JADX INFO: compiled from: VisitData.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/VisitData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/VisitData;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VisitData> serializer() {
            return VisitData$$serializer.INSTANCE;
        }
    }

    public VisitData() {
        this.platform = "Android";
        this.userAgent = UserAgentBuilder.INSTANCE.build();
    }

    public /* synthetic */ VisitData(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        this.languageCode = (i & 1) == 0 ? null : str;
        if ((i & 2) == 0) {
            this.platform = "Android";
        } else {
            this.platform = str2;
        }
        if ((i & 4) == 0) {
            this.userAgent = UserAgentBuilder.INSTANCE.build();
        } else {
            this.userAgent = str3;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(VisitData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.languageCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.languageCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.platform, "Android")) {
            output.encodeStringElement(serialDesc, 1, self.platform);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.userAgent, UserAgentBuilder.INSTANCE.build())) {
            return;
        }
        output.encodeStringElement(serialDesc, 2, self.userAgent);
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.infrastructure.network.VisitData");
        VisitData visitData = (VisitData) other;
        return Intrinsics.areEqual(this.platform, visitData.platform) && Intrinsics.areEqual(this.userAgent, visitData.userAgent) && Intrinsics.areEqual(this.languageCode, visitData.languageCode);
    }

    public int hashCode() {
        int iHashCode = ((this.platform.hashCode() * 31) + this.userAgent.hashCode()) * 31;
        String str = this.languageCode;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
