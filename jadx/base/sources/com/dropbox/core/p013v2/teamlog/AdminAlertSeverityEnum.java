package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminAlertSeverityEnum {
    HIGH,
    INFO,
    LOW,
    MEDIUM,
    NA,
    OTHER;

    static class Serializer extends UnionSerializer<AdminAlertSeverityEnum> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminAlertSeverityEnum adminAlertSeverityEnum, JsonGenerator jsonGenerator) throws IOException {
            int i = C44371.$SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum[adminAlertSeverityEnum.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("high");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("info");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("low");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString(FirebaseAnalytics.Param.MEDIUM);
            } else if (i == 5) {
                jsonGenerator.writeString("na");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminAlertSeverityEnum deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminAlertSeverityEnum adminAlertSeverityEnum;
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
                adminAlertSeverityEnum = AdminAlertSeverityEnum.HIGH;
            } else if ("info".equals(tag)) {
                adminAlertSeverityEnum = AdminAlertSeverityEnum.INFO;
            } else if ("low".equals(tag)) {
                adminAlertSeverityEnum = AdminAlertSeverityEnum.LOW;
            } else if (FirebaseAnalytics.Param.MEDIUM.equals(tag)) {
                adminAlertSeverityEnum = AdminAlertSeverityEnum.MEDIUM;
            } else if ("na".equals(tag)) {
                adminAlertSeverityEnum = AdminAlertSeverityEnum.NA;
            } else {
                adminAlertSeverityEnum = AdminAlertSeverityEnum.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminAlertSeverityEnum;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminAlertSeverityEnum$1 */
    static /* synthetic */ class C44371 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum;

        static {
            int[] iArr = new int[AdminAlertSeverityEnum.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum = iArr;
            try {
                iArr[AdminAlertSeverityEnum.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum[AdminAlertSeverityEnum.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum[AdminAlertSeverityEnum.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum[AdminAlertSeverityEnum.MEDIUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertSeverityEnum[AdminAlertSeverityEnum.NA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
