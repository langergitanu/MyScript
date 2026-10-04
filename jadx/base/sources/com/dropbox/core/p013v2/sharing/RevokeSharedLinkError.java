package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum RevokeSharedLinkError {
    SHARED_LINK_NOT_FOUND,
    SHARED_LINK_ACCESS_DENIED,
    UNSUPPORTED_LINK_TYPE,
    OTHER,
    SHARED_LINK_MALFORMED;

    static class Serializer extends UnionSerializer<RevokeSharedLinkError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RevokeSharedLinkError revokeSharedLinkError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42951.$SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError[revokeSharedLinkError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("shared_link_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("shared_link_access_denied");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("unsupported_link_type");
            } else if (i == 4) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 5) {
                    jsonGenerator.writeString("shared_link_malformed");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + revokeSharedLinkError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RevokeSharedLinkError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RevokeSharedLinkError revokeSharedLinkError;
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
                revokeSharedLinkError = RevokeSharedLinkError.SHARED_LINK_NOT_FOUND;
            } else if ("shared_link_access_denied".equals(tag)) {
                revokeSharedLinkError = RevokeSharedLinkError.SHARED_LINK_ACCESS_DENIED;
            } else if ("unsupported_link_type".equals(tag)) {
                revokeSharedLinkError = RevokeSharedLinkError.UNSUPPORTED_LINK_TYPE;
            } else if ("other".equals(tag)) {
                revokeSharedLinkError = RevokeSharedLinkError.OTHER;
            } else if ("shared_link_malformed".equals(tag)) {
                revokeSharedLinkError = RevokeSharedLinkError.SHARED_LINK_MALFORMED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return revokeSharedLinkError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RevokeSharedLinkError$1 */
    static /* synthetic */ class C42951 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError;

        static {
            int[] iArr = new int[RevokeSharedLinkError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError = iArr;
            try {
                iArr[RevokeSharedLinkError.SHARED_LINK_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError[RevokeSharedLinkError.SHARED_LINK_ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError[RevokeSharedLinkError.UNSUPPORTED_LINK_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError[RevokeSharedLinkError.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$RevokeSharedLinkError[RevokeSharedLinkError.SHARED_LINK_MALFORMED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
