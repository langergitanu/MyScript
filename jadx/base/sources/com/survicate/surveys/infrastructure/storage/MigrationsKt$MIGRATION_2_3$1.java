package com.survicate.surveys.infrastructure.storage;

import android.content.SharedPreferences;
import com.survicate.surveys.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Migrations.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0014R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/infrastructure/storage/MigrationsKt$MIGRATION_2_3$1", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "legacyDateFormat", "Ljava/text/SimpleDateFormat;", "getLegacyDateFormat", "()Ljava/text/SimpleDateFormat;", "legacyDateFormat$delegate", "Lkotlin/Lazy;", "migrate", "", "sharedPrefs", "Landroid/content/SharedPreferences;", "migratePresentationTimesToMillis", "prefsKey", "", "tryParseDateFor", "", "surveyId", "timesJson", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/Long;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MigrationsKt$MIGRATION_2_3$1 extends SurvicateStoreMigration {

    /* JADX INFO: renamed from: legacyDateFormat$delegate, reason: from kotlin metadata */
    private final Lazy legacyDateFormat;

    MigrationsKt$MIGRATION_2_3$1() {
        super(3);
        this.legacyDateFormat = LazyKt.lazy(new Function0() { // from class: com.survicate.surveys.infrastructure.storage.MigrationsKt$MIGRATION_2_3$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MigrationsKt$MIGRATION_2_3$1.legacyDateFormat_delegate$lambda$0();
            }
        });
    }

    private final SimpleDateFormat getLegacyDateFormat() {
        return (SimpleDateFormat) this.legacyDateFormat.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleDateFormat legacyDateFormat_delegate$lambda$0() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateStoreMigration
    public void migrate(SharedPreferences sharedPrefs) {
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        migratePresentationTimesToMillis("firstPresentationTimesKey", sharedPrefs);
        migratePresentationTimesToMillis("lastPresentationTimesKey", sharedPrefs);
    }

    private final void migratePresentationTimesToMillis(String prefsKey, SharedPreferences sharedPrefs) {
        String string = null;
        try {
            string = sharedPrefs.getString(prefsKey, null);
        } catch (ClassCastException unused) {
            sharedPrefs.edit().remove(prefsKey).apply();
        }
        if (string == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                Long lTryParseDateFor = tryParseDateFor(next, jSONObject);
                if (lTryParseDateFor != null) {
                    linkedHashMap.put(next, lTryParseDateFor);
                }
            }
            sharedPrefs.edit().putString(prefsKey, new JSONObject(linkedHashMap).toString()).apply();
        } catch (JSONException unused2) {
            sharedPrefs.edit().remove(prefsKey).apply();
        }
    }

    private final Long tryParseDateFor(String surveyId, JSONObject timesJson) {
        if (timesJson.isNull(surveyId)) {
            return null;
        }
        try {
            String string = timesJson.getString(surveyId);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return DateUtils.INSTANCE.tryParseToMillis(getLegacyDateFormat(), string);
        } catch (JSONException unused) {
            return null;
        }
    }
}
