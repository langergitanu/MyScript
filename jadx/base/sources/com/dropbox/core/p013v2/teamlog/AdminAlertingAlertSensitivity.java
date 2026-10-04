package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminAlertingAlertSensitivity {
    HIGH,
    HIGHEST,
    INVALID,
    LOW,
    LOWEST,
    MEDIUM,
    OTHER;

    static class Serializer extends UnionSerializer<AdminAlertingAlertSensitivity> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminAlertingAlertSensitivity adminAlertingAlertSensitivity, JsonGenerator jsonGenerator) throws IOException {
            switch (C44381.f779x76a0564d[adminAlertingAlertSensitivity.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("high");
                    break;
                case 2:
                    jsonGenerator.writeString("highest");
                    break;
                case 3:
                    jsonGenerator.writeString("invalid");
                    break;
                case 4:
                    jsonGenerator.writeString("low");
                    break;
                case 5:
                    jsonGenerator.writeString("lowest");
                    break;
                case 6:
                    jsonGenerator.writeString(FirebaseAnalytics.Param.MEDIUM);
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminAlertingAlertSensitivity deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminAlertingAlertSensitivity adminAlertingAlertSensitivity;
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
            if ("high".equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.HIGH;
            } else if ("highest".equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.HIGHEST;
            } else if ("invalid".equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.INVALID;
            } else if ("low".equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.LOW;
            } else if ("lowest".equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.LOWEST;
            } else if (FirebaseAnalytics.Param.MEDIUM.equals(tag)) {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.MEDIUM;
            } else {
                adminAlertingAlertSensitivity = AdminAlertingAlertSensitivity.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminAlertingAlertSensitivity;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminAlertingAlertSensitivity$1 */
    static /* synthetic */ class C44381 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertingAlertSensitivity */
        static final /* synthetic */ int[] f779x76a0564d;

        static {
            int[] iArr = new int[AdminAlertingAlertSensitivity.values().length];
            f779x76a0564d = iArr;
            try {
                iArr[AdminAlertingAlertSensitivity.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f779x76a0564d[AdminAlertingAlertSensitivity.HIGHEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f779x76a0564d[AdminAlertingAlertSensitivity.INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f779x76a0564d[AdminAlertingAlertSensitivity.LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f779x76a0564d[AdminAlertingAlertSensitivity.LOWEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f779x76a0564d[AdminAlertingAlertSensitivity.MEDIUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
