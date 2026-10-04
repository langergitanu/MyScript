package com.survicate.surveys.traits;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.utils.DateUtilsKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: UserTrait.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 .2\u00020\u0001:\u0002./B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fBC\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0005\u0010\u0014J\u0006\u0010!\u001a\u00020\tJ\r\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0002\b#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020\u000eH\u0016J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0016R(\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c¨\u00060\u0080å\b\u000f\u0080å\b\u0011\u0080å\b\u0002\u0080å\b\u0004"}, m1599d2 = {"Lcom/survicate/surveys/traits/UserTrait;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/Number;)V", "", "(Ljava/lang/String;Z)V", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "seen0", "", "timestampMs", "", "throttledToMs", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getValue$annotations", "getTimestampMs$survicate_sdk_release$annotations", "getTimestampMs$survicate_sdk_release", "()Ljava/lang/Long;", "setTimestampMs$survicate_sdk_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getThrottledToMs$survicate_sdk_release$annotations", "getThrottledToMs$survicate_sdk_release", "setThrottledToMs$survicate_sdk_release", "hasClearedValue", "copy", "copy$survicate_sdk_release", "equals", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "$serializer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public class UserTrait {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String USER_ID = "user_id";
    public static final String USER_KEY = "user_key";
    public final String key;
    private Long throttledToMs;
    private Long timestampMs;
    public final String value;

    @SerialName(SubscriberAttributeKt.JSON_NAME_KEY)
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("throttled_to_ms")
    public static /* synthetic */ void getThrottledToMs$survicate_sdk_release$annotations() {
    }

    @SerialName("timestamp_ms")
    public static /* synthetic */ void getTimestampMs$survicate_sdk_release$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValue$annotations() {
    }

    public /* synthetic */ UserTrait(int i, String str, String str2, Long l, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, UserTrait$$serializer.INSTANCE.getDescriptor());
        }
        this.key = str;
        this.value = str2;
        if ((i & 4) == 0) {
            this.timestampMs = null;
        } else {
            this.timestampMs = l;
        }
        if ((i & 8) == 0) {
            this.throttledToMs = null;
        } else {
            this.throttledToMs = l2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(UserTrait self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.key);
        output.encodeStringElement(serialDesc, 1, self.value);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.timestampMs != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.timestampMs);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.throttledToMs == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.throttledToMs);
    }

    /* JADX INFO: renamed from: getTimestampMs$survicate_sdk_release, reason: from getter */
    public final Long getTimestampMs() {
        return this.timestampMs;
    }

    public final void setTimestampMs$survicate_sdk_release(Long l) {
        this.timestampMs = l;
    }

    /* JADX INFO: renamed from: getThrottledToMs$survicate_sdk_release, reason: from getter */
    public final Long getThrottledToMs() {
        return this.throttledToMs;
    }

    public final void setThrottledToMs$survicate_sdk_release(Long l) {
        this.throttledToMs = l;
    }

    public UserTrait(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.value = str == null ? "" : str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserTrait(String key, Number value) {
        this(key, value.toString());
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserTrait(String key, boolean z) {
        this(key, String.valueOf(z));
        Intrinsics.checkNotNullParameter(key, "key");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserTrait(String key, Date value) {
        this(key, DateUtilsKt.toIsoString$default(value, null, 1, null));
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public final boolean hasClearedValue() {
        return this.value.length() == 0;
    }

    public final UserTrait copy$survicate_sdk_release() {
        UserTrait userTrait = new UserTrait(this.key, this.value);
        userTrait.timestampMs = this.timestampMs;
        userTrait.throttledToMs = this.throttledToMs;
        return userTrait;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserTrait)) {
            return false;
        }
        UserTrait userTrait = (UserTrait) other;
        return Intrinsics.areEqual(this.timestampMs, userTrait.timestampMs) && Intrinsics.areEqual(this.throttledToMs, userTrait.throttledToMs) && Intrinsics.areEqual(this.key, userTrait.key) && Intrinsics.areEqual(this.value, userTrait.value);
    }

    public int hashCode() {
        Long l = this.timestampMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.throttledToMs;
        return ((((iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31) + this.key.hashCode()) * 31) + this.value.hashCode();
    }

    /* JADX INFO: compiled from: UserTrait.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/traits/UserTrait$Companion;", "", "<init>", "()V", "USER_KEY", "", "USER_ID", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/traits/UserTrait;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserTrait> serializer() {
            return UserTrait$$serializer.INSTANCE;
        }
    }
}
