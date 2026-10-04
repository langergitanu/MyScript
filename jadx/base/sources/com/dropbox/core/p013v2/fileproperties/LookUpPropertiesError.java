package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LookUpPropertiesError {
    PROPERTY_GROUP_NOT_FOUND,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.LookUpPropertiesError$1 */
    static /* synthetic */ class C41191 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$LookUpPropertiesError */
        static final /* synthetic */ int[] f669x96137ab4;

        static {
            int[] iArr = new int[LookUpPropertiesError.values().length];
            f669x96137ab4 = iArr;
            try {
                iArr[LookUpPropertiesError.PROPERTY_GROUP_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<LookUpPropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LookUpPropertiesError lookUpPropertiesError, JsonGenerator jsonGenerator) throws IOException {
            if (C41191.f669x96137ab4[lookUpPropertiesError.ordinal()] == 1) {
                jsonGenerator.writeString("property_group_not_found");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LookUpPropertiesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LookUpPropertiesError lookUpPropertiesError;
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
            if ("property_group_not_found".equals(tag)) {
                lookUpPropertiesError = LookUpPropertiesError.PROPERTY_GROUP_NOT_FOUND;
            } else {
                lookUpPropertiesError = LookUpPropertiesError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return lookUpPropertiesError;
        }
    }
}
