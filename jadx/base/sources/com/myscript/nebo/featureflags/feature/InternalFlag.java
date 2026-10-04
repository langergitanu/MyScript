package com.myscript.nebo.featureflags.feature;

import com.myscript.nebo.featureflags.C6462R;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InternalFlag.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013j\u0002\b\u0015¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/featureflags/feature/InternalFlag;", "Lcom/myscript/nebo/featureflags/feature/Feature;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "title", "", "explanation", "readonly", "", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;IIZZ)V", "getKey", "()Ljava/lang/String;", "getTitle", "()I", "getExplanation", "getReadonly", "()Z", "getDefaultValue", "INTERNAL", "feature-flags_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InternalFlag implements Feature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InternalFlag[] $VALUES;
    public static final InternalFlag INTERNAL = new InternalFlag("INTERNAL", 0, "instrumented", C6462R.string.sample_feature_flag_internal_title, C6462R.string.sample_feature_flag_internal_explanation, false, false, 24, null);
    private final boolean defaultValue;
    private final int explanation;
    private final String key;
    private final boolean readonly;
    private final int title;

    private static final /* synthetic */ InternalFlag[] $values() {
        return new InternalFlag[]{INTERNAL};
    }

    public static EnumEntries<InternalFlag> getEntries() {
        return $ENTRIES;
    }

    public static InternalFlag valueOf(String str) {
        return (InternalFlag) Enum.valueOf(InternalFlag.class, str);
    }

    public static InternalFlag[] values() {
        return (InternalFlag[]) $VALUES.clone();
    }

    private InternalFlag(String str, int i, String str2, int i2, int i3, boolean z, boolean z2) {
        this.key = str2;
        this.title = i2;
        this.explanation = i3;
        this.readonly = z;
        this.defaultValue = z2;
    }

    /* synthetic */ InternalFlag(String str, int i, String str2, int i2, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, i2, i3, (i4 & 8) != 0 ? true : z, (i4 & 16) != 0 ? false : z2);
    }

    @Override // com.myscript.nebo.featureflags.feature.Feature
    public String getKey() {
        return this.key;
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
        InternalFlag[] internalFlagArr$values = $values();
        $VALUES = internalFlagArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(internalFlagArr$values);
    }
}
