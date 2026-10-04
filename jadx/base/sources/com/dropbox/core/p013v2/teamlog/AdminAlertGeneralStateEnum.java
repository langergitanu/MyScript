package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminAlertGeneralStateEnum {
    ACTIVE,
    DISMISSED,
    IN_PROGRESS,
    NA,
    RESOLVED,
    OTHER;

    static class Serializer extends UnionSerializer<AdminAlertGeneralStateEnum> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminAlertGeneralStateEnum adminAlertGeneralStateEnum, JsonGenerator jsonGenerator) throws IOException {
            int i = C44361.f777xd430cba2[adminAlertGeneralStateEnum.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("dismissed");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("in_progress");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("na");
            } else if (i == 5) {
                jsonGenerator.writeString("resolved");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminAlertGeneralStateEnum deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminAlertGeneralStateEnum adminAlertGeneralStateEnum;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.ACTIVE;
            } else if ("dismissed".equals(tag)) {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.DISMISSED;
            } else if ("in_progress".equals(tag)) {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.IN_PROGRESS;
            } else if ("na".equals(tag)) {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.NA;
            } else if ("resolved".equals(tag)) {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.RESOLVED;
            } else {
                adminAlertGeneralStateEnum = AdminAlertGeneralStateEnum.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminAlertGeneralStateEnum;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminAlertGeneralStateEnum$1 */
    static /* synthetic */ class C44361 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertGeneralStateEnum */
        static final /* synthetic */ int[] f777xd430cba2;

        static {
            int[] iArr = new int[AdminAlertGeneralStateEnum.values().length];
            f777xd430cba2 = iArr;
            try {
                iArr[AdminAlertGeneralStateEnum.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f777xd430cba2[AdminAlertGeneralStateEnum.DISMISSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f777xd430cba2[AdminAlertGeneralStateEnum.IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f777xd430cba2[AdminAlertGeneralStateEnum.NA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f777xd430cba2[AdminAlertGeneralStateEnum.RESOLVED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
