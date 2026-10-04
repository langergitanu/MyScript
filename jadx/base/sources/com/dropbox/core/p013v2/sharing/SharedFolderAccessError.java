package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharedFolderAccessError {
    INVALID_ID,
    NOT_A_MEMBER,
    INVALID_MEMBER,
    EMAIL_UNVERIFIED,
    UNMOUNTED,
    OTHER;

    static class Serializer extends UnionSerializer<SharedFolderAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderAccessError sharedFolderAccessError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43011.$SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError[sharedFolderAccessError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_id");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("not_a_member");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("invalid_member");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("email_unverified");
            } else if (i == 5) {
                jsonGenerator.writeString("unmounted");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderAccessError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderAccessError sharedFolderAccessError;
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
            if ("invalid_id".equals(tag)) {
                sharedFolderAccessError = SharedFolderAccessError.INVALID_ID;
            } else if ("not_a_member".equals(tag)) {
                sharedFolderAccessError = SharedFolderAccessError.NOT_A_MEMBER;
            } else if ("invalid_member".equals(tag)) {
                sharedFolderAccessError = SharedFolderAccessError.INVALID_MEMBER;
            } else if ("email_unverified".equals(tag)) {
                sharedFolderAccessError = SharedFolderAccessError.EMAIL_UNVERIFIED;
            } else if ("unmounted".equals(tag)) {
                sharedFolderAccessError = SharedFolderAccessError.UNMOUNTED;
            } else {
                sharedFolderAccessError = SharedFolderAccessError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderAccessError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedFolderAccessError$1 */
    static /* synthetic */ class C43011 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError;

        static {
            int[] iArr = new int[SharedFolderAccessError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError = iArr;
            try {
                iArr[SharedFolderAccessError.INVALID_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError[SharedFolderAccessError.NOT_A_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError[SharedFolderAccessError.INVALID_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError[SharedFolderAccessError.EMAIL_UNVERIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedFolderAccessError[SharedFolderAccessError.UNMOUNTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
