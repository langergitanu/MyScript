package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminRole {
    BILLING_ADMIN,
    COMPLIANCE_ADMIN,
    CONTENT_ADMIN,
    LIMITED_ADMIN,
    MEMBER_ONLY,
    REPORTING_ADMIN,
    SECURITY_ADMIN,
    SUPPORT_ADMIN,
    TEAM_ADMIN,
    USER_MANAGEMENT_ADMIN,
    OTHER;

    static class Serializer extends UnionSerializer<AdminRole> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminRole adminRole, JsonGenerator jsonGenerator) throws IOException {
            switch (C44431.$SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[adminRole.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("billing_admin");
                    break;
                case 2:
                    jsonGenerator.writeString("compliance_admin");
                    break;
                case 3:
                    jsonGenerator.writeString("content_admin");
                    break;
                case 4:
                    jsonGenerator.writeString("limited_admin");
                    break;
                case 5:
                    jsonGenerator.writeString("member_only");
                    break;
                case 6:
                    jsonGenerator.writeString("reporting_admin");
                    break;
                case 7:
                    jsonGenerator.writeString("security_admin");
                    break;
                case 8:
                    jsonGenerator.writeString("support_admin");
                    break;
                case 9:
                    jsonGenerator.writeString("team_admin");
                    break;
                case 10:
                    jsonGenerator.writeString("user_management_admin");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminRole deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminRole adminRole;
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
            if ("billing_admin".equals(tag)) {
                adminRole = AdminRole.BILLING_ADMIN;
            } else if ("compliance_admin".equals(tag)) {
                adminRole = AdminRole.COMPLIANCE_ADMIN;
            } else if ("content_admin".equals(tag)) {
                adminRole = AdminRole.CONTENT_ADMIN;
            } else if ("limited_admin".equals(tag)) {
                adminRole = AdminRole.LIMITED_ADMIN;
            } else if ("member_only".equals(tag)) {
                adminRole = AdminRole.MEMBER_ONLY;
            } else if ("reporting_admin".equals(tag)) {
                adminRole = AdminRole.REPORTING_ADMIN;
            } else if ("security_admin".equals(tag)) {
                adminRole = AdminRole.SECURITY_ADMIN;
            } else if ("support_admin".equals(tag)) {
                adminRole = AdminRole.SUPPORT_ADMIN;
            } else if ("team_admin".equals(tag)) {
                adminRole = AdminRole.TEAM_ADMIN;
            } else if ("user_management_admin".equals(tag)) {
                adminRole = AdminRole.USER_MANAGEMENT_ADMIN;
            } else {
                adminRole = AdminRole.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminRole;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AdminRole$1 */
    static /* synthetic */ class C44431 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole;

        static {
            int[] iArr = new int[AdminRole.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole = iArr;
            try {
                iArr[AdminRole.BILLING_ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.COMPLIANCE_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.CONTENT_ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.LIMITED_ADMIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.MEMBER_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.REPORTING_ADMIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.SECURITY_ADMIN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.SUPPORT_ADMIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.TEAM_ADMIN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AdminRole[AdminRole.USER_MANAGEMENT_ADMIN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
