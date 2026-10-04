package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum VisibilityPolicyDisallowedReason {
    DELETE_AND_RECREATE,
    RESTRICTED_BY_SHARED_FOLDER,
    RESTRICTED_BY_TEAM,
    USER_NOT_ON_TEAM,
    USER_ACCOUNT_TYPE,
    PERMISSION_DENIED,
    OTHER;

    static class Serializer extends UnionSerializer<VisibilityPolicyDisallowedReason> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason, JsonGenerator jsonGenerator) throws IOException {
            switch (C43181.f741xf6e98198[visibilityPolicyDisallowedReason.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("delete_and_recreate");
                    break;
                case 2:
                    jsonGenerator.writeString("restricted_by_shared_folder");
                    break;
                case 3:
                    jsonGenerator.writeString("restricted_by_team");
                    break;
                case 4:
                    jsonGenerator.writeString("user_not_on_team");
                    break;
                case 5:
                    jsonGenerator.writeString("user_account_type");
                    break;
                case 6:
                    jsonGenerator.writeString("permission_denied");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public VisibilityPolicyDisallowedReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            VisibilityPolicyDisallowedReason visibilityPolicyDisallowedReason;
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
            if ("delete_and_recreate".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.DELETE_AND_RECREATE;
            } else if ("restricted_by_shared_folder".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.RESTRICTED_BY_SHARED_FOLDER;
            } else if ("restricted_by_team".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.RESTRICTED_BY_TEAM;
            } else if ("user_not_on_team".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.USER_NOT_ON_TEAM;
            } else if ("user_account_type".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.USER_ACCOUNT_TYPE;
            } else if ("permission_denied".equals(tag)) {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.PERMISSION_DENIED;
            } else {
                visibilityPolicyDisallowedReason = VisibilityPolicyDisallowedReason.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return visibilityPolicyDisallowedReason;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.VisibilityPolicyDisallowedReason$1 */
    static /* synthetic */ class C43181 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$VisibilityPolicyDisallowedReason */
        static final /* synthetic */ int[] f741xf6e98198;

        static {
            int[] iArr = new int[VisibilityPolicyDisallowedReason.values().length];
            f741xf6e98198 = iArr;
            try {
                iArr[VisibilityPolicyDisallowedReason.DELETE_AND_RECREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f741xf6e98198[VisibilityPolicyDisallowedReason.RESTRICTED_BY_SHARED_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f741xf6e98198[VisibilityPolicyDisallowedReason.RESTRICTED_BY_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f741xf6e98198[VisibilityPolicyDisallowedReason.USER_NOT_ON_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f741xf6e98198[VisibilityPolicyDisallowedReason.USER_ACCOUNT_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f741xf6e98198[VisibilityPolicyDisallowedReason.PERMISSION_DENIED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
