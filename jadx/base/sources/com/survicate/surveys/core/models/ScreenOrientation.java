package com.survicate.surveys.core.models;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ScreenOrientation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/models/ScreenOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScreenOrientation[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ScreenOrientation PORTRAIT = new ScreenOrientation("PORTRAIT", 0);
    public static final ScreenOrientation LANDSCAPE = new ScreenOrientation("LANDSCAPE", 1);

    private static final /* synthetic */ ScreenOrientation[] $values() {
        return new ScreenOrientation[]{PORTRAIT, LANDSCAPE};
    }

    public static EnumEntries<ScreenOrientation> getEntries() {
        return $ENTRIES;
    }

    private ScreenOrientation(String str, int i) {
    }

    static {
        ScreenOrientation[] screenOrientationArr$values = $values();
        $VALUES = screenOrientationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(screenOrientationArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: ScreenOrientation.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/models/ScreenOrientation$Companion;", "", "<init>", "()V", "fromString", "Lcom/survicate/surveys/core/models/ScreenOrientation;", "value", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScreenOrientation fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "portrait")) {
                return ScreenOrientation.PORTRAIT;
            }
            if (Intrinsics.areEqual(lowerCase, "landscape")) {
                return ScreenOrientation.LANDSCAPE;
            }
            return null;
        }
    }

    public static ScreenOrientation valueOf(String str) {
        return (ScreenOrientation) Enum.valueOf(ScreenOrientation.class, str);
    }

    public static ScreenOrientation[] values() {
        return (ScreenOrientation[]) $VALUES.clone();
    }
}
