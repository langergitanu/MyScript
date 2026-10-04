package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamNamespacesListError {
    INVALID_ARG,
    OTHER;

    static class Serializer extends UnionSerializer<TeamNamespacesListError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamNamespacesListError teamNamespacesListError, JsonGenerator jsonGenerator) throws IOException {
            if (C44171.$SwitchMap$com$dropbox$core$v2$team$TeamNamespacesListError[teamNamespacesListError.ordinal()] == 1) {
                jsonGenerator.writeString("invalid_arg");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamNamespacesListError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamNamespacesListError teamNamespacesListError;
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
            if ("invalid_arg".equals(tag)) {
                teamNamespacesListError = TeamNamespacesListError.INVALID_ARG;
            } else {
                teamNamespacesListError = TeamNamespacesListError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamNamespacesListError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamNamespacesListError$1 */
    static /* synthetic */ class C44171 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamNamespacesListError;

        static {
            int[] iArr = new int[TeamNamespacesListError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamNamespacesListError = iArr;
            try {
                iArr[TeamNamespacesListError.INVALID_ARG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
