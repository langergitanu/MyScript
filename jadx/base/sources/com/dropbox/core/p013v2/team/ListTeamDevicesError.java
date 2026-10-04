package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum ListTeamDevicesError {
    RESET,
    OTHER;

    static class Serializer extends UnionSerializer<ListTeamDevicesError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListTeamDevicesError listTeamDevicesError, JsonGenerator jsonGenerator) throws IOException {
            if (C43641.$SwitchMap$com$dropbox$core$v2$team$ListTeamDevicesError[listTeamDevicesError.ordinal()] == 1) {
                jsonGenerator.writeString("reset");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListTeamDevicesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListTeamDevicesError listTeamDevicesError;
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
                listTeamDevicesError = ListTeamDevicesError.RESET;
            } else {
                listTeamDevicesError = ListTeamDevicesError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listTeamDevicesError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.ListTeamDevicesError$1 */
    static /* synthetic */ class C43641 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$ListTeamDevicesError;

        static {
            int[] iArr = new int[ListTeamDevicesError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$ListTeamDevicesError = iArr;
            try {
                iArr[ListTeamDevicesError.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
