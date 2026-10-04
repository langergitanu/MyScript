package com.chuckerteam.chucker.api;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetentionManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/RetentionManager;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "retentionPeriod", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "doMaintenance", "", "Period", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RetentionManager {
    /* JADX WARN: Illegal instructions before constructor call */
    public RetentionManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(context, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    public RetentionManager(Context context, Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RetentionManager(Context context, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : obj);
    }

    public final synchronized void doMaintenance() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: RetentionManager.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/RetentionManager$Period;", "", "<init>", "(Ljava/lang/String;I)V", "ONE_HOUR", "ONE_DAY", "ONE_WEEK", "FOREVER", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Period {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Period[] $VALUES;
        public static final Period ONE_HOUR = new Period("ONE_HOUR", 0);
        public static final Period ONE_DAY = new Period("ONE_DAY", 1);
        public static final Period ONE_WEEK = new Period("ONE_WEEK", 2);
        public static final Period FOREVER = new Period("FOREVER", 3);

        private static final /* synthetic */ Period[] $values() {
            return new Period[]{ONE_HOUR, ONE_DAY, ONE_WEEK, FOREVER};
        }

        public static EnumEntries<Period> getEntries() {
            return $ENTRIES;
        }

        public static Period valueOf(String str) {
            return (Period) Enum.valueOf(Period.class, str);
        }

        public static Period[] values() {
            return (Period[]) $VALUES.clone();
        }

        private Period(String str, int i) {
        }

        static {
            Period[] periodArr$values = $values();
            $VALUES = periodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(periodArr$values);
        }
    }
}
