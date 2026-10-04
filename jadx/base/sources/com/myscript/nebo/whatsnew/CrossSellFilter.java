package com.myscript.nebo.whatsnew;

import android.content.SharedPreferences;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.LongSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.common.IClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: CrossSellFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010#\u001a\u00020$J \u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020$J\b\u0010+\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00198B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001c¨\u0006."}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/CrossSellFilter;", "", "prefs", "Landroid/content/SharedPreferences;", "clock", "Lcom/myscript/nebo/common/IClock;", "<init>", "(Landroid/content/SharedPreferences;Lcom/myscript/nebo/common/IClock;)V", "<set-?>", "", "displayCount", "getDisplayCount", "()I", "setDisplayCount", "(I)V", "displayCount$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "", "lastDisplayTimestamp", "getLastDisplayTimestamp", "()J", "setLastDisplayTimestamp", "(J)V", "lastDisplayTimestamp$delegate", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "", "mathConversionSeen", "getMathConversionSeen", "()Z", "setMathConversionSeen", "(Z)V", "mathConversionSeen$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "sawLegacyCampaign", "getSawLegacyCampaign", "notifyMathConversion", "", "resolveOrigin", "Lcom/myscript/nebo/whatsnew/CrossSellOrigin;", "sessionCount", "isMathInstalled", "canShow", "onDisplayed", "elapsedSinceLastDisplay", "Provider", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CrossSellFilter {
    private static final long FIRST_BACKOFF;
    private static final String LEGACY_CROSS_SELL_KEY = "pref_cross_sell_math_shown";
    public static final int MAX_DISPLAYS = 3;
    private static final String PREF_DISPLAY_COUNT = "pref_cross_sell_display_count";
    private static final String PREF_LAST_DISPLAY_TIMESTAMP = "pref_cross_sell_last_display_timestamp";
    private static final String PREF_MATH_CONVERSION_SEEN = "pref_cross_sell_math_conversion_seen";
    public static final int REQUIRED_SESSION_COUNT = 3;
    private static final long SECOND_BACKOFF;
    private final IClock clock;

    /* JADX INFO: renamed from: displayCount$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty displayCount;

    /* JADX INFO: renamed from: lastDisplayTimestamp$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty lastDisplayTimestamp;

    /* JADX INFO: renamed from: mathConversionSeen$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty mathConversionSeen;
    private final SharedPreferences prefs;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(CrossSellFilter.class, "displayCount", "getDisplayCount()I", 0), new MutablePropertyReference1Impl(CrossSellFilter.class, "lastDisplayTimestamp", "getLastDisplayTimestamp()J", 0), new MutablePropertyReference1Impl(CrossSellFilter.class, "mathConversionSeen", "getMathConversionSeen()Z", 0)};
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CrossSellFilter.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/CrossSellFilter$Provider;", "", "provideCrossSellFilter", "Lcom/myscript/nebo/whatsnew/CrossSellFilter;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        CrossSellFilter provideCrossSellFilter();
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        FIRST_BACKOFF = Duration.m15867getInWholeMillisecondsimpl(DurationKt.toDuration(30, DurationUnit.DAYS));
        Duration.Companion companion2 = Duration.INSTANCE;
        SECOND_BACKOFF = Duration.m15867getInWholeMillisecondsimpl(DurationKt.toDuration(60, DurationUnit.DAYS));
    }

    public CrossSellFilter(SharedPreferences prefs, IClock clock) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.prefs = prefs;
        this.clock = clock;
        this.displayCount = SharedPreferencesExtKt.intPref(prefs, PREF_DISPLAY_COUNT, 0);
        this.lastDisplayTimestamp = SharedPreferencesExtKt.longPref$default(prefs, PREF_LAST_DISPLAY_TIMESTAMP, 0L, 2, null);
        this.mathConversionSeen = SharedPreferencesExtKt.booleanPref(prefs, PREF_MATH_CONVERSION_SEEN, false);
    }

    private final int getDisplayCount() {
        return this.displayCount.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    private final void setDisplayCount(int i) {
        this.displayCount.setValue(this, $$delegatedProperties[0], i);
    }

    private final long getLastDisplayTimestamp() {
        return this.lastDisplayTimestamp.getValue((Object) this, $$delegatedProperties[1]).longValue();
    }

    private final void setLastDisplayTimestamp(long j) {
        this.lastDisplayTimestamp.setValue(this, $$delegatedProperties[1], j);
    }

    private final boolean getMathConversionSeen() {
        return this.mathConversionSeen.getValue((Object) this, $$delegatedProperties[2]).booleanValue();
    }

    private final void setMathConversionSeen(boolean z) {
        this.mathConversionSeen.setValue(this, $$delegatedProperties[2], z);
    }

    private final boolean getSawLegacyCampaign() {
        return this.prefs.getInt(LEGACY_CROSS_SELL_KEY, 0) == 2;
    }

    public final void notifyMathConversion() {
        setMathConversionSeen(true);
    }

    public final CrossSellOrigin resolveOrigin(int sessionCount, boolean isMathInstalled, boolean canShow) {
        if (RetailMode.INSTANCE.isEnabled() || isMathInstalled || getSawLegacyCampaign() || getDisplayCount() >= 3 || !canShow) {
            return null;
        }
        int displayCount = getDisplayCount();
        if (displayCount == 0) {
            if (getMathConversionSeen()) {
                return CrossSellOrigin.MathConversion;
            }
            if (sessionCount >= 3) {
                return CrossSellOrigin.SessionThreshold;
            }
            return null;
        }
        if (displayCount == 1) {
            if (elapsedSinceLastDisplay() >= FIRST_BACKOFF) {
                return CrossSellOrigin.Repeat30d;
            }
            return null;
        }
        if (displayCount == 2 && elapsedSinceLastDisplay() >= SECOND_BACKOFF) {
            return CrossSellOrigin.Repeat60d;
        }
        return null;
    }

    public final void onDisplayed() {
        setDisplayCount(getDisplayCount() + 1);
        setLastDisplayTimestamp(this.clock.getTime());
    }

    private final long elapsedSinceLastDisplay() {
        return this.clock.getTime() - getLastDisplayTimestamp();
    }
}
