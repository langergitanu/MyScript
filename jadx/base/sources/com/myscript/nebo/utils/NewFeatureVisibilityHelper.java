package com.myscript.nebo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewFeatureVisibilityHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u001e\u0010\f\u001a\u00020\r*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0007J\f\u0010\u000f\u001a\u00020\r*\u00020\nH\u0007J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/utils/NewFeatureVisibilityHelper;", "", "<init>", "()V", "DISCOVERABLE_FEATURES", "", "Lcom/myscript/nebo/utils/NewFeatureVisibilityHelper$Key;", "[Lcom/myscript/nebo/utils/NewFeatureVisibilityHelper$Key;", "hasFeatureBeenDiscovered", "", "Landroid/content/Context;", "featureKey", "markFeatureDiscovered", "", "discovered", "markAllFeaturesDiscovered", "chooseOverflowIconForNewFeatures", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "Key", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NewFeatureVisibilityHelper {
    public static final NewFeatureVisibilityHelper INSTANCE = new NewFeatureVisibilityHelper();
    private static final Key[] DISCOVERABLE_FEATURES = new Key[0];
    public static final int $stable = 8;

    @JvmStatic
    public static final void markFeatureDiscovered(Context context, Key featureKey) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        markFeatureDiscovered$default(context, featureKey, false, 2, null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: NewFeatureVisibilityHelper.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/utils/NewFeatureVisibilityHelper$Key;", "", "preferencesKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPreferencesKey", "()Ljava/lang/String;", "KEYBOARD", "DRAFT_SECTION", "DRAFT_FULL_PAGE", "FREEFORM_TYPESET", "REGULAR_PAGE", "PDF_INTERACTIVITY", "AUTO_SYNC", "TRASH", "BACKUP_REMINDER", "AI", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Key {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Key[] $VALUES;
        private final String preferencesKey;
        public static final Key KEYBOARD = new Key("KEYBOARD", 0, "KEYBOARD_FEATURE_KEY");
        public static final Key DRAFT_SECTION = new Key("DRAFT_SECTION", 1, "DRAFT_SECTION_FEATURE_KEY");
        public static final Key DRAFT_FULL_PAGE = new Key("DRAFT_FULL_PAGE", 2, "DRAFT_FULL_PAGE_FEATURE_KEY");
        public static final Key FREEFORM_TYPESET = new Key("FREEFORM_TYPESET", 3, "FREEFORM_TYPESET_FEATURE_KEY");
        public static final Key REGULAR_PAGE = new Key("REGULAR_PAGE", 4, "REGULAR_PAGE_FEATURE_KEY");
        public static final Key PDF_INTERACTIVITY = new Key("PDF_INTERACTIVITY", 5, "PDF_INTERACTIVITY_FEATURE_KEY");
        public static final Key AUTO_SYNC = new Key("AUTO_SYNC", 6, "AUTO_SYNC_FEATURE_KEY");
        public static final Key TRASH = new Key("TRASH", 7, "TRASH_FEATURE_KEY");
        public static final Key BACKUP_REMINDER = new Key("BACKUP_REMINDER", 8, "BACKUP_REMINDER_FEATURE_KEY");

        /* JADX INFO: renamed from: AI */
        public static final Key f1377AI = new Key("AI", 9, "AI_FEATURE_KEY");

        private static final /* synthetic */ Key[] $values() {
            return new Key[]{KEYBOARD, DRAFT_SECTION, DRAFT_FULL_PAGE, FREEFORM_TYPESET, REGULAR_PAGE, PDF_INTERACTIVITY, AUTO_SYNC, TRASH, BACKUP_REMINDER, f1377AI};
        }

        public static EnumEntries<Key> getEntries() {
            return $ENTRIES;
        }

        public static Key valueOf(String str) {
            return (Key) Enum.valueOf(Key.class, str);
        }

        public static Key[] values() {
            return (Key[]) $VALUES.clone();
        }

        private Key(String str, int i, String str2) {
            this.preferencesKey = str2;
        }

        public final String getPreferencesKey() {
            return this.preferencesKey;
        }

        static {
            Key[] keyArr$values = $values();
            $VALUES = keyArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(keyArr$values);
        }
    }

    private NewFeatureVisibilityHelper() {
    }

    @JvmStatic
    public static final boolean hasFeatureBeenDiscovered(Context context, Key featureKey) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(featureKey.getPreferencesKey(), false);
    }

    public static /* synthetic */ void markFeatureDiscovered$default(Context context, Key key, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        markFeatureDiscovered(context, key, z);
    }

    @JvmStatic
    public static final void markFeatureDiscovered(Context context, Key featureKey, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(featureKey, "featureKey");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean(featureKey.getPreferencesKey(), z);
        editorEdit.apply();
    }

    @JvmStatic
    public static final void markAllFeaturesDiscovered(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        markFeatureDiscovered$default(context, Key.AUTO_SYNC, false, 2, null);
        markFeatureDiscovered$default(context, Key.TRASH, false, 2, null);
    }

    public final void chooseOverflowIconForNewFeatures(Toolbar toolbar) {
        int i;
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Context context = toolbar.getContext();
        if (context == null) {
            return;
        }
        Key[] keyArr = DISCOVERABLE_FEATURES;
        int length = keyArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i = C6183R.drawable.ic_more_vertical_w12;
                break;
            } else {
                if (!hasFeatureBeenDiscovered(context, keyArr[i2])) {
                    i = C6183R.drawable.ic_more_vertical_new_feature;
                    break;
                }
                i2++;
            }
        }
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
        if (drawable != null) {
            toolbar.setOverflowIcon(drawable.mutate());
            toolbar.invalidate();
        }
    }
}
