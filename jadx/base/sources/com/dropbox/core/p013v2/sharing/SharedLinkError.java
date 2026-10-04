package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharedLinkError {
    SHARED_LINK_NOT_FOUND,
    SHARED_LINK_ACCESS_DENIED,
    UNSUPPORTED_LINK_TYPE,
    OTHER;

    static class Serializer extends UnionSerializer<SharedLinkError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkError sharedLinkError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43051.$SwitchMap$com$dropbox$core$v2$sharing$SharedLinkError[sharedLinkError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("shared_link_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("shared_link_access_denied");
            } else if (i == 3) {
                jsonGenerator.writeString("unsupported_link_type");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkError sharedLinkError;
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
            if ("shared_link_not_found".equals(tag)) {
                sharedLinkError = SharedLinkError.SHARED_LINK_NOT_FOUND;
            } else if ("shared_link_access_denied".equals(tag)) {
                sharedLinkError = SharedLinkError.SHARED_LINK_ACCESS_DENIED;
            } else if ("unsupported_link_type".equals(tag)) {
                sharedLinkError = SharedLinkError.UNSUPPORTED_LINK_TYPE;
            } else {
                sharedLinkError = SharedLinkError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedLinkError$1 */
    static /* synthetic */ class C43051 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkError;

        static {
            int[] iArr = new int[SharedLinkError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkError = iArr;
            try {
                iArr[SharedLinkError.SHARED_LINK_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkError[SharedLinkError.SHARED_LINK_ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkError[SharedLinkError.UNSUPPORTED_LINK_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
