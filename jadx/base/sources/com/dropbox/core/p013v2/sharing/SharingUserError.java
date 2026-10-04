package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharingUserError {
    EMAIL_UNVERIFIED,
    OTHER;

    static class Serializer extends UnionSerializer<SharingUserError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingUserError sharingUserError, JsonGenerator jsonGenerator) throws IOException {
            if (C43091.$SwitchMap$com$dropbox$core$v2$sharing$SharingUserError[sharingUserError.ordinal()] == 1) {
                jsonGenerator.writeString("email_unverified");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingUserError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingUserError sharingUserError;
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
            if ("email_unverified".equals(tag)) {
                sharingUserError = SharingUserError.EMAIL_UNVERIFIED;
            } else {
                sharingUserError = SharingUserError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingUserError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.SharingUserError$1 */
    static /* synthetic */ class C43091 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$SharingUserError;

        static {
            int[] iArr = new int[SharingUserError.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$SharingUserError = iArr;
            try {
                iArr[SharingUserError.EMAIL_UNVERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
