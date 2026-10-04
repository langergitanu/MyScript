package kotlinx.datetime;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: TimeZoneJvm.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\r*\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, m1599d2 = {"Lkotlinx/datetime/TimeZone;", "", "zoneId", "Ljava/time/ZoneId;", "<init>", "(Ljava/time/ZoneId;)V", "getZoneId$kotlinx_datetime", "()Ljava/time/ZoneId;", "id", "", "getId", "()Ljava/lang/String;", "toLocalDateTime", "Lkotlinx/datetime/LocalDateTime;", "Lkotlin/time/Instant;", "toInstant", "youShallNotPass", "Lkotlinx/datetime/OverloadMarker;", "equals", "", "other", "hashCode", "", "toString", "Companion", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable(with = TimeZoneSerializer.class)
public class TimeZone {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FixedOffsetTimeZone UTC;
    private final ZoneId zoneId;

    public TimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.zoneId = zoneId;
    }

    /* JADX INFO: renamed from: getZoneId$kotlinx_datetime, reason: from getter */
    public final ZoneId getZoneId() {
        return this.zoneId;
    }

    public final String getId() {
        String id = this.zoneId.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    public final LocalDateTime toLocalDateTime(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return TimeZoneKt.toLocalDateTime(instant, this);
    }

    public final Instant toInstant(LocalDateTime localDateTime, OverloadMarker youShallNotPass) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(youShallNotPass, "youShallNotPass");
        return TimeZoneKt__TimeZoneJvmKt.toInstant$default(localDateTime, this, (OverloadMarker) null, 2, (Object) null);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TimeZone) && Intrinsics.areEqual(this.zoneId, ((TimeZone) other).zoneId);
        }
        return true;
    }

    public int hashCode() {
        return this.zoneId.hashCode();
    }

    public String toString() {
        String string = this.zoneId.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: TimeZoneJvm.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, m1599d2 = {"Lkotlinx/datetime/TimeZone$Companion;", "", "<init>", "()V", "currentSystemDefault", "Lkotlinx/datetime/TimeZone;", "UTC", "Lkotlinx/datetime/FixedOffsetTimeZone;", "getUTC", "()Lkotlinx/datetime/FixedOffsetTimeZone;", "of", "zoneId", "", "ofZone", "Ljava/time/ZoneId;", "ofZone$kotlinx_datetime", "availableZoneIds", "", "getAvailableZoneIds", "()Ljava/util/Set;", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.INSTANCE;
        }

        public final TimeZone currentSystemDefault() {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneIdSystemDefault, "systemDefault(...)");
            return ofZone$kotlinx_datetime(zoneIdSystemDefault);
        }

        public final FixedOffsetTimeZone getUTC() {
            return TimeZone.UTC;
        }

        /* JADX INFO: renamed from: of */
        public final TimeZone m1630of(String zoneId) throws Exception {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                if (Intrinsics.areEqual(zoneId, "z")) {
                    zoneId = "Z";
                }
                ZoneId zoneIdOf = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(zoneIdOf, "of(...)");
                return ofZone$kotlinx_datetime(zoneIdOf);
            } catch (Exception e) {
                if (e instanceof DateTimeException) {
                    throw new IllegalTimeZoneException(e);
                }
                throw e;
            }
        }

        public final TimeZone ofZone$kotlinx_datetime(ZoneId zoneId) {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            if (!(zoneId instanceof ZoneOffset)) {
                if (TimeZoneKt__TimeZoneJvmKt.isFixedOffset$TimeZoneKt__TimeZoneJvmKt(zoneId)) {
                    ZoneId zoneIdNormalized = zoneId.normalized();
                    Intrinsics.checkNotNull(zoneIdNormalized, "null cannot be cast to non-null type java.time.ZoneOffset");
                    return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneIdNormalized), zoneId);
                }
                return new TimeZone(zoneId);
            }
            return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
        }

        public final Set<String> getAvailableZoneIds() {
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            Intrinsics.checkNotNullExpressionValue(availableZoneIds, "getAvailableZoneIds(...)");
            return availableZoneIds;
        }
    }

    static {
        UtcOffset zero = UtcOffset.INSTANCE.getZERO();
        ZoneId zoneIdOf = ZoneId.of("UTC");
        Intrinsics.checkNotNullExpressionValue(zoneIdOf, "of(...)");
        UTC = new FixedOffsetTimeZone(zero, zoneIdOf);
    }

    public static /* synthetic */ Instant toInstant$default(TimeZone timeZone, LocalDateTime localDateTime, OverloadMarker overloadMarker, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toInstant");
        }
        if ((i & 1) != 0) {
            overloadMarker = OverloadMarker.INSTANCE.getINSTANCE$kotlinx_datetime();
        }
        return timeZone.toInstant(localDateTime, overloadMarker);
    }
}
