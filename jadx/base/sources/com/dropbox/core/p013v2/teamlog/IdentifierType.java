package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum IdentifierType {
    EMAIL,
    FACEBOOK_PROFILE_NAME,
    OTHER;

    static class Serializer extends UnionSerializer<IdentifierType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(IdentifierType identifierType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44851.$SwitchMap$com$dropbox$core$v2$teamlog$IdentifierType[identifierType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("email");
            } else if (i == 2) {
                jsonGenerator.writeString("facebook_profile_name");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public IdentifierType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            IdentifierType identifierType;
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
            if ("email".equals(tag)) {
                identifierType = IdentifierType.EMAIL;
            } else if ("facebook_profile_name".equals(tag)) {
                identifierType = IdentifierType.FACEBOOK_PROFILE_NAME;
            } else {
                identifierType = IdentifierType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return identifierType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.IdentifierType$1 */
    static /* synthetic */ class C44851 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$IdentifierType;

        static {
            int[] iArr = new int[IdentifierType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$IdentifierType = iArr;
            try {
                iArr[IdentifierType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$IdentifierType[IdentifierType.FACEBOOK_PROFILE_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
