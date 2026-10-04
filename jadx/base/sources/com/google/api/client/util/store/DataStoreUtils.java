package com.google.api.client.util.store;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.survicate.surveys.TextRecallingManager;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class DataStoreUtils {
    public static String toString(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            boolean z = true;
            for (String str : dataStore.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(TextRecallingManager.ANSWER_SEPARATOR);
                }
                sb.append(str).append(Literals.PROPERTY_SPLITTER).append(dataStore.get(str));
            }
            return sb.append(AbstractJsonLexerKt.END_OBJ).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DataStoreUtils() {
    }
}
