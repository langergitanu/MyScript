package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminAlertCategoryEnum {
    ACCOUNT_TAKEOVER,
    DATA_LOSS_PROTECTION,
    INFORMATION_GOVERNANCE,
    MALWARE_SHARING,
    MASSIVE_FILE_OPERATION,
    NA,
    THREAT_MANAGEMENT,
    OTHER;

    static class Serializer extends UnionSerializer<AdminAlertCategoryEnum> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminAlertCategoryEnum adminAlertCategoryEnum, JsonGenerator jsonGenerator) throws IOException {
            switch (C44351.$SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[adminAlertCategoryEnum.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("account_takeover");
                    break;
                case 2:
                    jsonGenerator.writeString("data_loss_protection");
                    break;
                case 3:
                    jsonGenerator.writeString("information_governance");
                    break;
                case 4:
                    jsonGenerator.writeString("malware_sharing");
                    break;
                case 5:
                    jsonGenerator.writeString("massive_file_operation");
                    break;
                case 6:
                    jsonGenerator.writeString("na");
                    break;
                case 7:
                    jsonGenerator.writeString("threat_management");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminAlertCategoryEnum deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminAlertCategoryEnum adminAlertCategoryEnum;
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
            if ("account_takeover".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.ACCOUNT_TAKEOVER;
            } else if ("data_loss_protection".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.DATA_LOSS_PROTECTION;
            } else if ("information_governance".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.INFORMATION_GOVERNANCE;
            } else if ("malware_sharing".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.MALWARE_SHARING;
            } else if ("massive_file_operation".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.MASSIVE_FILE_OPERATION;
            } else if ("na".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.NA;
            } else if ("threat_management".equals(tag)) {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.THREAT_MANAGEMENT;
            } else {
                adminAlertCategoryEnum = AdminAlertCategoryEnum.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminAlertCategoryEnum;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminAlertCategoryEnum$1 */
    static /* synthetic */ class C44351 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum;

        static {
            int[] iArr = new int[AdminAlertCategoryEnum.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum = iArr;
            try {
                iArr[AdminAlertCategoryEnum.ACCOUNT_TAKEOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.DATA_LOSS_PROTECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.INFORMATION_GOVERNANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.MALWARE_SHARING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.MASSIVE_FILE_OPERATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.NA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminAlertCategoryEnum[AdminAlertCategoryEnum.THREAT_MANAGEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
