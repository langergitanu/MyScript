package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ExcludedUsersListError {
    LIST_ERROR,
    OTHER;

    static class Serializer extends UnionSerializer<ExcludedUsersListError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ExcludedUsersListError excludedUsersListError, JsonGenerator jsonGenerator) throws IOException {
            if (C43281.$SwitchMap$com$dropbox$core$v2$team$ExcludedUsersListError[excludedUsersListError.ordinal()] == 1) {
                jsonGenerator.writeString("list_error");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ExcludedUsersListError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ExcludedUsersListError excludedUsersListError;
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
            if ("list_error".equals(tag)) {
                excludedUsersListError = ExcludedUsersListError.LIST_ERROR;
            } else {
                excludedUsersListError = ExcludedUsersListError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return excludedUsersListError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ExcludedUsersListError$1 */
    static /* synthetic */ class C43281 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersListError;

        static {
            int[] iArr = new int[ExcludedUsersListError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ExcludedUsersListError = iArr;
            try {
                iArr[ExcludedUsersListError.LIST_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
