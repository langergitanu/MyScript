package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum AdminTier {
    TEAM_ADMIN,
    USER_MANAGEMENT_ADMIN,
    SUPPORT_ADMIN,
    MEMBER_ONLY;

    static class Serializer extends UnionSerializer<AdminTier> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AdminTier adminTier, JsonGenerator jsonGenerator) throws IOException {
            int i = C43211.$SwitchMap$com$dropbox$core$v2$team$AdminTier[adminTier.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("team_admin");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("user_management_admin");
            } else if (i == 3) {
                jsonGenerator.writeString("support_admin");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("member_only");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + adminTier);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AdminTier deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AdminTier adminTier;
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
            if ("team_admin".equals(tag)) {
                adminTier = AdminTier.TEAM_ADMIN;
            } else if ("user_management_admin".equals(tag)) {
                adminTier = AdminTier.USER_MANAGEMENT_ADMIN;
            } else if ("support_admin".equals(tag)) {
                adminTier = AdminTier.SUPPORT_ADMIN;
            } else if ("member_only".equals(tag)) {
                adminTier = AdminTier.MEMBER_ONLY;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return adminTier;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.AdminTier$1 */
    static /* synthetic */ class C43211 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$AdminTier;

        static {
            int[] iArr = new int[AdminTier.values().length];
            $SwitchMap$com$dropbox$core$v2$team$AdminTier = iArr;
            try {
                iArr[AdminTier.TEAM_ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AdminTier[AdminTier.USER_MANAGEMENT_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AdminTier[AdminTier.SUPPORT_ADMIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AdminTier[AdminTier.MEMBER_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
