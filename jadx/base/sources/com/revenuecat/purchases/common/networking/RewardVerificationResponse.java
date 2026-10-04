package com.revenuecat.purchases.common.networking;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.RewardVerificationPollStatus;
import com.revenuecat.purchases.VerifiedReward;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.utils.Iso8601Utils;
import com.revenuecat.purchases.utils.SerializationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: RewardVerificationResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 62\u00020\u0001:\u000256BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0005HÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/J\f\u00100\u001a\u000201*\u000202H\u0002J\u000e\u00103\u001a\u000201*\u0004\u0018\u00010\u0007H\u0002J\f\u00104\u001a\u000201*\u000202H\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00067"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RewardVerificationResponse;", "", "seen1", "", NotificationCompat.CATEGORY_STATUS, "", "reward", "Lkotlinx/serialization/json/JsonElement;", "moreRewards", "", "failureReason", "message", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getFailureReason$annotations", "()V", "getFailureReason", "()Ljava/lang/String;", "getMessage", "getMoreRewards$annotations", "getMoreRewards", "()Ljava/util/List;", "getReward", "()Lkotlinx/serialization/json/JsonElement;", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toRewardVerificationPollStatus", "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "toEntitlementRewardOrUnsupported", "Lcom/revenuecat/purchases/VerifiedReward;", "Lkotlinx/serialization/json/JsonObject;", "toVerifiedReward", "toVirtualCurrencyRewardOrUnsupported", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class RewardVerificationResponse {
    private final String failureReason;
    private final String message;
    private final List<JsonElement> moreRewards;
    private final JsonElement reward;
    private final String status;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(JsonElementSerializer.INSTANCE), null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RewardVerificationResponse copy$default(RewardVerificationResponse rewardVerificationResponse, String str, JsonElement jsonElement, List list, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rewardVerificationResponse.status;
        }
        if ((i & 2) != 0) {
            jsonElement = rewardVerificationResponse.reward;
        }
        if ((i & 4) != 0) {
            list = rewardVerificationResponse.moreRewards;
        }
        if ((i & 8) != 0) {
            str2 = rewardVerificationResponse.failureReason;
        }
        if ((i & 16) != 0) {
            str3 = rewardVerificationResponse.message;
        }
        String str4 = str3;
        List list2 = list;
        return rewardVerificationResponse.copy(str, jsonElement, list2, str2, str4);
    }

    @SerialName("failure_reason")
    public static /* synthetic */ void getFailureReason$annotations() {
    }

    @SerialName("more_rewards")
    public static /* synthetic */ void getMoreRewards$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonElement getReward() {
        return this.reward;
    }

    public final List<JsonElement> component3() {
        return this.moreRewards;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final RewardVerificationResponse copy(String status, JsonElement reward, List<? extends JsonElement> moreRewards, String failureReason, String message) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new RewardVerificationResponse(status, reward, moreRewards, failureReason, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardVerificationResponse)) {
            return false;
        }
        RewardVerificationResponse rewardVerificationResponse = (RewardVerificationResponse) other;
        return Intrinsics.areEqual(this.status, rewardVerificationResponse.status) && Intrinsics.areEqual(this.reward, rewardVerificationResponse.reward) && Intrinsics.areEqual(this.moreRewards, rewardVerificationResponse.moreRewards) && Intrinsics.areEqual(this.failureReason, rewardVerificationResponse.failureReason) && Intrinsics.areEqual(this.message, rewardVerificationResponse.message);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        JsonElement jsonElement = this.reward;
        int iHashCode2 = (iHashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        List<JsonElement> list = this.moreRewards;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.failureReason;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RewardVerificationResponse(status=" + this.status + ", reward=" + this.reward + ", moreRewards=" + this.moreRewards + ", failureReason=" + this.failureReason + ", message=" + this.message + ')';
    }

    /* JADX INFO: compiled from: RewardVerificationResponse.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/networking/RewardVerificationResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/networking/RewardVerificationResponse;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RewardVerificationResponse> serializer() {
            return RewardVerificationResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RewardVerificationResponse(int i, String str, JsonElement jsonElement, @SerialName("more_rewards") List list, @SerialName("failure_reason") String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, RewardVerificationResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.status = str;
        if ((i & 2) == 0) {
            this.reward = null;
        } else {
            this.reward = jsonElement;
        }
        if ((i & 4) == 0) {
            this.moreRewards = null;
        } else {
            this.moreRewards = list;
        }
        if ((i & 8) == 0) {
            this.failureReason = null;
        } else {
            this.failureReason = str2;
        }
        if ((i & 16) == 0) {
            this.message = null;
        } else {
            this.message = str3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RewardVerificationResponse(String status, JsonElement jsonElement, List<? extends JsonElement> list, String str, String str2) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.reward = jsonElement;
        this.moreRewards = list;
        this.failureReason = str;
        this.message = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(RewardVerificationResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.status);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.reward != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.reward);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.moreRewards != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.moreRewards);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.failureReason != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.failureReason);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.message == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.message);
    }

    public /* synthetic */ RewardVerificationResponse(String str, JsonElement jsonElement, List list, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : jsonElement, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }

    public final JsonElement getReward() {
        return this.reward;
    }

    public final List<JsonElement> getMoreRewards() {
        return this.moreRewards;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final String getMessage() {
        return this.message;
    }

    public final RewardVerificationPollStatus toRewardVerificationPollStatus() {
        String lowerCase = this.status.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1994383672) {
            if (iHashCode != -1281977283) {
                if (iHashCode == -682587753 && lowerCase.equals("pending")) {
                    return RewardVerificationPollStatus.PENDING.INSTANCE;
                }
            } else if (lowerCase.equals("failed")) {
                return new RewardVerificationPollStatus.Failed(this.failureReason, this.message);
            }
        } else if (lowerCase.equals("verified")) {
            VerifiedReward verifiedReward = toVerifiedReward(this.reward);
            List<JsonElement> listEmptyList = this.moreRewards;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<JsonElement> list = listEmptyList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toVerifiedReward((JsonElement) it.next()));
            }
            return new RewardVerificationPollStatus.Verified(verifiedReward, arrayList);
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Unknown reward verification status: " + this.status);
        }
        return RewardVerificationPollStatus.UNKNOWN.INSTANCE;
    }

    private final VerifiedReward toVerifiedReward(JsonElement jsonElement) {
        JsonObject jsonObject;
        VerifiedReward.UnsupportedReward entitlementRewardOrUnsupported;
        JsonPrimitive jsonPrimitive;
        String contentOrNull = null;
        if (jsonElement == null || (jsonElement instanceof JsonNull)) {
            jsonObject = null;
        } else {
            if (!(jsonElement instanceof JsonObject)) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Unexpected reward verification reward payload shape: " + jsonElement);
                }
                return VerifiedReward.UnsupportedReward.INSTANCE;
            }
            jsonObject = (JsonObject) jsonElement;
        }
        if (jsonObject != null) {
            JsonElement jsonElement2 = (JsonElement) jsonObject.get("type");
            if (jsonElement2 != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement2)) != null) {
                contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive);
            }
            if (contentOrNull == null) {
                contentOrNull = "";
            }
            if (Intrinsics.areEqual(contentOrNull, "virtual_currency")) {
                entitlementRewardOrUnsupported = toVirtualCurrencyRewardOrUnsupported(jsonObject);
            } else if (Intrinsics.areEqual(contentOrNull, "entitlement")) {
                entitlementRewardOrUnsupported = toEntitlementRewardOrUnsupported(jsonObject);
            } else {
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), "Unsupported reward verification reward type: " + contentOrNull);
                }
                entitlementRewardOrUnsupported = VerifiedReward.UnsupportedReward.INSTANCE;
            }
            if (entitlementRewardOrUnsupported != null) {
                return entitlementRewardOrUnsupported;
            }
        }
        return VerifiedReward.NoReward.INSTANCE;
    }

    private final VerifiedReward toVirtualCurrencyRewardOrUnsupported(JsonObject jsonObject) {
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2;
        JsonElement jsonElement = (JsonElement) jsonObject.get("code");
        Integer intOrNull = null;
        String contentOrNull = (jsonElement == null || (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive2);
        JsonElement jsonElement2 = (JsonElement) jsonObject.get(Keys.AMOUNT);
        if (jsonElement2 != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement2)) != null) {
            intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
        }
        String str = contentOrNull;
        if (str != null && !StringsKt.isBlank(str) && intOrNull != null && intOrNull.intValue() > 0) {
            return new VerifiedReward.VirtualCurrency(contentOrNull, intOrNull.intValue());
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Malformed virtual_currency reward payload: " + jsonObject);
        }
        return VerifiedReward.UnsupportedReward.INSTANCE;
    }

    private final VerifiedReward toEntitlementRewardOrUnsupported(JsonObject jsonObject) {
        String str;
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2;
        JsonElement jsonElement = (JsonElement) jsonObject.get(Keys.IDENTIFIER);
        String contentOrNull = null;
        String contentOrNull2 = (jsonElement == null || (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive2);
        JsonElement jsonElement2 = (JsonElement) jsonObject.get("expires_at");
        if (jsonElement2 != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement2)) != null) {
            contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive);
        }
        String str2 = contentOrNull2;
        if (str2 != null && !StringsKt.isBlank(str2) && (str = contentOrNull) != null && !StringsKt.isBlank(str)) {
            try {
                Date date = Iso8601Utils.parse(contentOrNull);
                Intrinsics.checkNotNullExpressionValue(date, "parse(expiresAtRaw)");
                return new VerifiedReward.Entitlement(contentOrNull2, date);
            } catch (SerializationException e) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Malformed entitlement reward expires_at '" + contentOrNull + "': " + e.getMessage());
                }
                return VerifiedReward.UnsupportedReward.INSTANCE;
            }
        }
        LogLevel logLevel2 = LogLevel.WARN;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.mo1545w("[Purchases] - " + logLevel2.name(), "Malformed entitlement reward payload: " + jsonObject);
        }
        return VerifiedReward.UnsupportedReward.INSTANCE;
    }
}
