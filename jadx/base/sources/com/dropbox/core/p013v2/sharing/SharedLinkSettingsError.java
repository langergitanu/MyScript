package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharedLinkSettingsError {
    INVALID_SETTINGS,
    NOT_AUTHORIZED;

    static class Serializer extends UnionSerializer<SharedLinkSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedLinkSettingsError sharedLinkSettingsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43071.$SwitchMap$com$dropbox$core$v2$sharing$SharedLinkSettingsError[sharedLinkSettingsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_settings");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("not_authorized");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + sharedLinkSettingsError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedLinkSettingsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedLinkSettingsError sharedLinkSettingsError;
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
            if ("invalid_settings".equals(tag)) {
                sharedLinkSettingsError = SharedLinkSettingsError.INVALID_SETTINGS;
            } else if ("not_authorized".equals(tag)) {
                sharedLinkSettingsError = SharedLinkSettingsError.NOT_AUTHORIZED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedLinkSettingsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharedLinkSettingsError$1 */
    static /* synthetic */ class C43071 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkSettingsError;

        static {
            int[] iArr = new int[SharedLinkSettingsError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkSettingsError = iArr;
            try {
                iArr[SharedLinkSettingsError.INVALID_SETTINGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$SharedLinkSettingsError[SharedLinkSettingsError.NOT_AUTHORIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
