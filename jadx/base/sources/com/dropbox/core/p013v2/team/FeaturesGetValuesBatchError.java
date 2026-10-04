package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FeaturesGetValuesBatchError {
    EMPTY_FEATURES_LIST,
    OTHER;

    static class Serializer extends UnionSerializer<FeaturesGetValuesBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FeaturesGetValuesBatchError featuresGetValuesBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C43331.$SwitchMap$com$dropbox$core$v2$team$FeaturesGetValuesBatchError[featuresGetValuesBatchError.ordinal()] == 1) {
                jsonGenerator.writeString("empty_features_list");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FeaturesGetValuesBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FeaturesGetValuesBatchError featuresGetValuesBatchError;
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
            if ("empty_features_list".equals(tag)) {
                featuresGetValuesBatchError = FeaturesGetValuesBatchError.EMPTY_FEATURES_LIST;
            } else {
                featuresGetValuesBatchError = FeaturesGetValuesBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return featuresGetValuesBatchError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.FeaturesGetValuesBatchError$1 */
    static /* synthetic */ class C43331 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$FeaturesGetValuesBatchError;

        static {
            int[] iArr = new int[FeaturesGetValuesBatchError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$FeaturesGetValuesBatchError = iArr;
            try {
                iArr[FeaturesGetValuesBatchError.EMPTY_FEATURES_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
