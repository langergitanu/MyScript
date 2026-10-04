package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListTeamAppsError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<ListTeamAppsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListTeamAppsError listTeamAppsError, JsonGenerator jsonGenerator) throws IOException {
            if (C43631.$SwitchMap$com$dropbox$core$v2$team$ListTeamAppsError[listTeamAppsError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListTeamAppsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListTeamAppsError listTeamAppsError;
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
            if ("reset".equals(tag)) {
                listTeamAppsError = ListTeamAppsError.RESET;
            } else {
                listTeamAppsError = ListTeamAppsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listTeamAppsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListTeamAppsError$1 */
    static /* synthetic */ class C43631 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListTeamAppsError;

        static {
            int[] iArr = new int[ListTeamAppsError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListTeamAppsError = iArr;
            try {
                iArr[ListTeamAppsError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
