package com.revenuecat.purchases.common;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CustomVariableKeyValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\b¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/CustomVariableKeyValidator;", "", "()V", "isValidKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "validateAndFilter", "", ExifInterface.GPS_DIRECTION_TRUE, "variables", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CustomVariableKeyValidator {
    public static final CustomVariableKeyValidator INSTANCE = new CustomVariableKeyValidator();

    private CustomVariableKeyValidator() {
    }

    public final boolean isValidKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = key;
        if (str.length() > 0 && Character.isLetter(StringsKt.first(str))) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (Character.isLetter(cCharAt) || Character.isDigit(cCharAt) || cCharAt == '_') {
                }
            }
            return true;
        }
        return false;
    }

    public final <T> Map<String, T> validateAndFilter(Map<String, ? extends T> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends T> entry : variables.entrySet()) {
            String key = entry.getKey();
            boolean zIsValidKey = INSTANCE.isValidKey(key);
            if (!zIsValidKey) {
                LogLevel logLevel = LogLevel.WARN;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Custom variable key '" + key + "' is invalid and will be ignored. Keys must start with a letter and contain only letters, numbers, and underscores.");
                }
            }
            if (zIsValidKey) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
