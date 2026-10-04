package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamMembershipType {
    FULL,
    LIMITED;

    static class Serializer extends UnionSerializer<TeamMembershipType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMembershipType teamMembershipType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44151.$SwitchMap$com$dropbox$core$v2$team$TeamMembershipType[teamMembershipType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("full");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("limited");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + teamMembershipType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamMembershipType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamMembershipType teamMembershipType;
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
            if ("full".equals(tag)) {
                teamMembershipType = TeamMembershipType.FULL;
            } else if ("limited".equals(tag)) {
                teamMembershipType = TeamMembershipType.LIMITED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMembershipType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamMembershipType$1 */
    static /* synthetic */ class C44151 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamMembershipType;

        static {
            int[] iArr = new int[TeamMembershipType.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamMembershipType = iArr;
            try {
                iArr[TeamMembershipType.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamMembershipType[TeamMembershipType.LIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
