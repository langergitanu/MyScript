package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersListError {
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersListError$1 */
    static /* synthetic */ class C43761 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MembersListError = new int[MembersListError.values().length];
    }

    static class Serializer extends UnionSerializer<MembersListError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersListError membersListError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43761.$SwitchMap$com$dropbox$core$v2$team$MembersListError[membersListError.ordinal()];
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersListError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
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
            MembersListError membersListError = MembersListError.OTHER;
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersListError;
        }
    }
}
