package com.myscript.nebo.utils;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.featureflags.feature.Feature;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EarlyAccessFeaturesProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B=\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/utils/EarlyAccessFeature;", "Lcom/myscript/nebo/featureflags/feature/Feature;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "sharedPreferenceKey", "", "title", "explanation", "readonly", "", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;IIIZZ)V", "getKey", "()Ljava/lang/String;", "getSharedPreferenceKey", "()I", "getTitle", "getExplanation", "getReadonly", "()Z", "getDefaultValue", "DMS", "PDF", "SHAPE", "MATH", "TEXT", "CENTERED_FIT_TO", "COLORIZE_PREDICTION", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EarlyAccessFeature implements Feature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EarlyAccessFeature[] $VALUES;
    public static final EarlyAccessFeature CENTERED_FIT_TO;
    public static final EarlyAccessFeature COLORIZE_PREDICTION;
    public static final EarlyAccessFeature DMS;
    public static final EarlyAccessFeature MATH;
    public static final EarlyAccessFeature PDF;
    public static final EarlyAccessFeature SHAPE;
    public static final EarlyAccessFeature TEXT;
    private final boolean defaultValue;
    private final int explanation;
    private final String key;
    private final boolean readonly;
    private final int sharedPreferenceKey;
    private final int title;

    private static final /* synthetic */ EarlyAccessFeature[] $values() {
        return new EarlyAccessFeature[]{DMS, PDF, SHAPE, MATH, TEXT, CENTERED_FIT_TO, COLORIZE_PREDICTION};
    }

    public static EnumEntries<EarlyAccessFeature> getEntries() {
        return $ENTRIES;
    }

    public static EarlyAccessFeature valueOf(String str) {
        return (EarlyAccessFeature) Enum.valueOf(EarlyAccessFeature.class, str);
    }

    public static EarlyAccessFeature[] values() {
        return (EarlyAccessFeature[]) $VALUES.clone();
    }

    private EarlyAccessFeature(String str, int i, String str2, int i2, int i3, int i4, boolean z, boolean z2) {
        this.key = str2;
        this.sharedPreferenceKey = i2;
        this.title = i3;
        this.explanation = i4;
        this.readonly = z;
        this.defaultValue = z2;
    }

    /* synthetic */ EarlyAccessFeature(String str, int i, String str2, int i2, int i3, int i4, boolean z, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, i2, i3, i4, (i5 & 16) != 0 ? true : z, (i5 & 32) != 0 ? false : z2);
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public String getKey() {
        return this.key;
    }

    public final int getSharedPreferenceKey() {
        return this.sharedPreferenceKey;
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public int getTitle() {
        return this.title;
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public int getExplanation() {
        return this.explanation;
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public boolean getReadonly() {
        return this.readonly;
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public boolean getDefaultValue() {
        return this.defaultValue;
    }

    static {
        boolean z = false;
        DMS = new EarlyAccessFeature("DMS", 0, "dms_early_access", C6079R.string.pref_internal_dms_early_access_features_key, C6079R.string.pref_internal_dms_early_access_features_title, C6079R.string.pref_internal_dms_early_access_features_summary, false, z, 48, null);
        boolean z2 = false;
        PDF = new EarlyAccessFeature("PDF", 1, "pdf_early_access", C6079R.string.pref_internal_pdf_early_access_features_key, C6079R.string.pref_internal_pdf_early_access_features_title, C6079R.string.pref_internal_pdf_early_access_features_summary, z, z2, 48, null);
        boolean z3 = false;
        SHAPE = new EarlyAccessFeature("SHAPE", 2, "shape_early_access", C6079R.string.pref_internal_shape_early_access_features_key, C6079R.string.pref_internal_shape_early_access_features_title, C6079R.string.pref_internal_shape_early_access_features_summary, z2, z3, 48, null);
        boolean z4 = false;
        MATH = new EarlyAccessFeature("MATH", 3, "math_early_access", C6079R.string.pref_internal_math_early_access_features_key, C6079R.string.pref_internal_math_early_access_features_title, C6079R.string.pref_internal_math_early_access_features_summary, z3, z4, 48, null);
        boolean z5 = false;
        TEXT = new EarlyAccessFeature("TEXT", 4, "text_early_access", C6079R.string.pref_internal_text_early_access_features_key, C6079R.string.pref_internal_text_early_access_features_title, C6079R.string.pref_internal_text_early_access_features_summary, z4, z5, 48, null);
        boolean z6 = false;
        CENTERED_FIT_TO = new EarlyAccessFeature("CENTERED_FIT_TO", 5, "centered_fit_to_early_access", C6079R.string.pref_internal_centered_fit_to_early_access_features_key, C6079R.string.pref_internal_centered_fit_to_early_access_features_title, C6079R.string.pref_internal_centered_fit_to_early_access_features_summary, z5, z6, 48, null);
        COLORIZE_PREDICTION = new EarlyAccessFeature("COLORIZE_PREDICTION", 6, "colorize_prediction_early_access", C6079R.string.pref_internal_colorize_prediction_early_access_features_key, C6079R.string.pref_internal_colorize_prediction_early_access_features_title, C6079R.string.pref_internal_colorize_prediction_early_access_features_summary, z6, false, 48, null);
        EarlyAccessFeature[] earlyAccessFeatureArr$values = $values();
        $VALUES = earlyAccessFeatureArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(earlyAccessFeatureArr$values);
    }
}
