package com.dropbox.core.p013v2.fileproperties;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PropertyType {
    STRING,
    OTHER;

    static class Serializer extends UnionSerializer<PropertyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PropertyType propertyType, JsonGenerator jsonGenerator) throws IOException {
            if (C41251.$SwitchMap$com$dropbox$core$v2$fileproperties$PropertyType[propertyType.ordinal()] == 1) {
                jsonGenerator.writeString(TypedValues.Custom.S_STRING);
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PropertyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PropertyType propertyType;
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
            if (TypedValues.Custom.S_STRING.equals(tag)) {
                propertyType = PropertyType.STRING;
            } else {
                propertyType = PropertyType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return propertyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.PropertyType$1 */
    static /* synthetic */ class C41251 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$fileproperties$PropertyType;

        static {
            int[] iArr = new int[PropertyType.values().length];
            $SwitchMap$com$dropbox$core$v2$fileproperties$PropertyType = iArr;
            try {
                iArr[PropertyType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
