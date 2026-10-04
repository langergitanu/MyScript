package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum RevokeLinkedAppError {
    APP_NOT_FOUND,
    MEMBER_NOT_FOUND,
    APP_FOLDER_REMOVAL_NOT_SUPPORTED,
    OTHER;

    static class Serializer extends UnionSerializer<RevokeLinkedAppError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeLinkedAppError revokeLinkedAppError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43951.$SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppError[revokeLinkedAppError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("app_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("member_not_found");
            } else if (i == 3) {
                jsonGenerator.writeString("app_folder_removal_not_supported");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeLinkedAppError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RevokeLinkedAppError revokeLinkedAppError;
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
            if ("app_not_found".equals(tag)) {
                revokeLinkedAppError = RevokeLinkedAppError.APP_NOT_FOUND;
            } else if ("member_not_found".equals(tag)) {
                revokeLinkedAppError = RevokeLinkedAppError.MEMBER_NOT_FOUND;
            } else if ("app_folder_removal_not_supported".equals(tag)) {
                revokeLinkedAppError = RevokeLinkedAppError.APP_FOLDER_REMOVAL_NOT_SUPPORTED;
            } else {
                revokeLinkedAppError = RevokeLinkedAppError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeLinkedAppError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.RevokeLinkedAppError$1 */
    static /* synthetic */ class C43951 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppError;

        static {
            int[] iArr = new int[RevokeLinkedAppError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppError = iArr;
            try {
                iArr[RevokeLinkedAppError.APP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppError[RevokeLinkedAppError.MEMBER_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$RevokeLinkedAppError[RevokeLinkedAppError.APP_FOLDER_REMOVAL_NOT_SUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
