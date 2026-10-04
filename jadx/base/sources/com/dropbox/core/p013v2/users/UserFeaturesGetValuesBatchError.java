package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum UserFeaturesGetValuesBatchError {
    EMPTY_FEATURES_LIST,
    OTHER;

    static class Serializer extends UnionSerializer<UserFeaturesGetValuesBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserFeaturesGetValuesBatchError userFeaturesGetValuesBatchError, JsonGenerator jsonGenerator) throws IOException {
            if (C45681.f816x6106ef74[userFeaturesGetValuesBatchError.ordinal()] == 1) {
                jsonGenerator.writeString("empty_features_list");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserFeaturesGetValuesBatchError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserFeaturesGetValuesBatchError userFeaturesGetValuesBatchError;
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
                userFeaturesGetValuesBatchError = UserFeaturesGetValuesBatchError.EMPTY_FEATURES_LIST;
            } else {
                userFeaturesGetValuesBatchError = UserFeaturesGetValuesBatchError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userFeaturesGetValuesBatchError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.UserFeaturesGetValuesBatchError$1 */
    static /* synthetic */ class C45681 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$users$UserFeaturesGetValuesBatchError */
        static final /* synthetic */ int[] f816x6106ef74;

        static {
            int[] iArr = new int[UserFeaturesGetValuesBatchError.values().length];
            f816x6106ef74 = iArr;
            try {
                iArr[UserFeaturesGetValuesBatchError.EMPTY_FEATURES_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
