package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminAlertingAlertStatePolicy {
    OFF,
    ON,
    OTHER;

    static class Serializer extends UnionSerializer<AdminAlertingAlertStatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44391.f781x969e1cd1[adminAlertingAlertStatePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i == 2) {
                jsonGenerator.writeString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminAlertingAlertStatePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminAlertingAlertStatePolicy adminAlertingAlertStatePolicy;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(tag)) {
                adminAlertingAlertStatePolicy = AdminAlertingAlertStatePolicy.OFF;
            } else if (DebugKt.DEBUG_PROPERTY_VALUE_ON.equals(tag)) {
                adminAlertingAlertStatePolicy = AdminAlertingAlertStatePolicy.ON;
            } else {
                adminAlertingAlertStatePolicy = AdminAlertingAlertStatePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminAlertingAlertStatePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminAlertingAlertStatePolicy$1 */
    static /* synthetic */ class C44391 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertingAlertStatePolicy */
        static final /* synthetic */ int[] f781x969e1cd1;

        static {
            int[] iArr = new int[AdminAlertingAlertStatePolicy.values().length];
            f781x969e1cd1 = iArr;
            try {
                iArr[AdminAlertingAlertStatePolicy.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f781x969e1cd1[AdminAlertingAlertStatePolicy.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
