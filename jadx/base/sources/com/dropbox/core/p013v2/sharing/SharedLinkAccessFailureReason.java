package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharedLinkAccessFailureReason {
    LOGIN_REQUIRED,
    EMAIL_VERIFY_REQUIRED,
    PASSWORD_REQUIRED,
    TEAM_ONLY,
    OWNER_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<SharedLinkAccessFailureReason> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkAccessFailureReason sharedLinkAccessFailureReason, JsonGenerator jsonGenerator) throws IOException {
            int i = C43031.f735x77d63655[sharedLinkAccessFailureReason.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("login_required");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("email_verify_required");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("password_required");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("team_only");
            } else if (i == 5) {
                jsonGenerator.writeString("owner_only");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkAccessFailureReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkAccessFailureReason sharedLinkAccessFailureReason;
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
            if ("login_required".equals(tag)) {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.LOGIN_REQUIRED;
            } else if ("email_verify_required".equals(tag)) {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.EMAIL_VERIFY_REQUIRED;
            } else if ("password_required".equals(tag)) {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.PASSWORD_REQUIRED;
            } else if ("team_only".equals(tag)) {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.TEAM_ONLY;
            } else if ("owner_only".equals(tag)) {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.OWNER_ONLY;
            } else {
                sharedLinkAccessFailureReason = SharedLinkAccessFailureReason.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkAccessFailureReason;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedLinkAccessFailureReason$1 */
    static /* synthetic */ class C43031 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkAccessFailureReason */
        static final /* synthetic */ int[] f735x77d63655;

        static {
            int[] iArr = new int[SharedLinkAccessFailureReason.values().length];
            f735x77d63655 = iArr;
            try {
                iArr[SharedLinkAccessFailureReason.LOGIN_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f735x77d63655[SharedLinkAccessFailureReason.EMAIL_VERIFY_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f735x77d63655[SharedLinkAccessFailureReason.PASSWORD_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f735x77d63655[SharedLinkAccessFailureReason.TEAM_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f735x77d63655[SharedLinkAccessFailureReason.OWNER_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
