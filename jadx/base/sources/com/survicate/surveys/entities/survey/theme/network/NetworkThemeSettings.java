package com.survicate.surveys.entities.survey.theme.network;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NetworkThemeSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "", "companyLogo", "", "personalization", "", "shortTextMessage", "avatarImage", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCompanyLogo$annotations", "()V", "getCompanyLogo", "()Ljava/lang/String;", "getPersonalization$annotations", "getPersonalization", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShortTextMessage$annotations", "getShortTextMessage", "getAvatarImage$annotations", "getAvatarImage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkThemeSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatarImage;
    private final String companyLogo;
    private final Boolean personalization;
    private final String shortTextMessage;

    public static /* synthetic */ NetworkThemeSettings copy$default(NetworkThemeSettings networkThemeSettings, String str, Boolean bool, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkThemeSettings.companyLogo;
        }
        if ((i & 2) != 0) {
            bool = networkThemeSettings.personalization;
        }
        if ((i & 4) != 0) {
            str2 = networkThemeSettings.shortTextMessage;
        }
        if ((i & 8) != 0) {
            str3 = networkThemeSettings.avatarImage;
        }
        return networkThemeSettings.copy(str, bool, str2, str3);
    }

    @SerialName("avatar_image")
    public static /* synthetic */ void getAvatarImage$annotations() {
    }

    @SerialName("company_logo")
    public static /* synthetic */ void getCompanyLogo$annotations() {
    }

    @SerialName("personalization")
    public static /* synthetic */ void getPersonalization$annotations() {
    }

    @SerialName("short_text_message")
    public static /* synthetic */ void getShortTextMessage$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCompanyLogo() {
        return this.companyLogo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getPersonalization() {
        return this.personalization;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getShortTextMessage() {
        return this.shortTextMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarImage() {
        return this.avatarImage;
    }

    public final NetworkThemeSettings copy(String companyLogo, Boolean personalization, String shortTextMessage, String avatarImage) {
        return new NetworkThemeSettings(companyLogo, personalization, shortTextMessage, avatarImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkThemeSettings)) {
            return false;
        }
        NetworkThemeSettings networkThemeSettings = (NetworkThemeSettings) other;
        return Intrinsics.areEqual(this.companyLogo, networkThemeSettings.companyLogo) && Intrinsics.areEqual(this.personalization, networkThemeSettings.personalization) && Intrinsics.areEqual(this.shortTextMessage, networkThemeSettings.shortTextMessage) && Intrinsics.areEqual(this.avatarImage, networkThemeSettings.avatarImage);
    }

    public int hashCode() {
        String str = this.companyLogo;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.personalization;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.shortTextMessage;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatarImage;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "NetworkThemeSettings(companyLogo=" + this.companyLogo + ", personalization=" + this.personalization + ", shortTextMessage=" + this.shortTextMessage + ", avatarImage=" + this.avatarImage + ')';
    }

    /* JADX INFO: compiled from: NetworkThemeSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkThemeSettings> serializer() {
            return NetworkThemeSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkThemeSettings(int i, String str, Boolean bool, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, NetworkThemeSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.companyLogo = str;
        this.personalization = bool;
        this.shortTextMessage = str2;
        this.avatarImage = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkThemeSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.companyLogo);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.personalization);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shortTextMessage);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.avatarImage);
    }

    public NetworkThemeSettings(String str, Boolean bool, String str2, String str3) {
        this.companyLogo = str;
        this.personalization = bool;
        this.shortTextMessage = str2;
        this.avatarImage = str3;
    }

    public final String getCompanyLogo() {
        return this.companyLogo;
    }

    public final Boolean getPersonalization() {
        return this.personalization;
    }

    public final String getShortTextMessage() {
        return this.shortTextMessage;
    }

    public final String getAvatarImage() {
        return this.avatarImage;
    }
}
