package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum GetSharedLinkFileError {
    SHARED_LINK_NOT_FOUND,
    SHARED_LINK_ACCESS_DENIED,
    UNSUPPORTED_LINK_TYPE,
    OTHER,
    SHARED_LINK_IS_DIRECTORY;

    static class Serializer extends UnionSerializer<GetSharedLinkFileError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetSharedLinkFileError getSharedLinkFileError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42621.$SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError[getSharedLinkFileError.ordinal()];
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
                    jsonGenerator.writeString("shared_link_is_directory");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + getSharedLinkFileError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetSharedLinkFileError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetSharedLinkFileError getSharedLinkFileError;
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
                getSharedLinkFileError = GetSharedLinkFileError.SHARED_LINK_NOT_FOUND;
            } else if ("shared_link_access_denied".equals(tag)) {
                getSharedLinkFileError = GetSharedLinkFileError.SHARED_LINK_ACCESS_DENIED;
            } else if ("unsupported_link_type".equals(tag)) {
                getSharedLinkFileError = GetSharedLinkFileError.UNSUPPORTED_LINK_TYPE;
            } else if ("other".equals(tag)) {
                getSharedLinkFileError = GetSharedLinkFileError.OTHER;
            } else if ("shared_link_is_directory".equals(tag)) {
                getSharedLinkFileError = GetSharedLinkFileError.SHARED_LINK_IS_DIRECTORY;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getSharedLinkFileError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.GetSharedLinkFileError$1 */
    static /* synthetic */ class C42621 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError;

        static {
            int[] iArr = new int[GetSharedLinkFileError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError = iArr;
            try {
                iArr[GetSharedLinkFileError.SHARED_LINK_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError[GetSharedLinkFileError.SHARED_LINK_ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError[GetSharedLinkFileError.UNSUPPORTED_LINK_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError[GetSharedLinkFileError.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$GetSharedLinkFileError[GetSharedLinkFileError.SHARED_LINK_IS_DIRECTORY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
