package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamMembershipType {
    FREE,
    FULL,
    GUEST,
    OTHER;

    static class Serializer extends UnionSerializer<TeamMembershipType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamMembershipType teamMembershipType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45281.$SwitchMap$com$dropbox$core$v2$teamlog$TeamMembershipType[teamMembershipType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(NeboUserProfileManager.BACKEND_PAID_STATUS_FREE);
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("full");
            } else if (i == 3) {
                jsonGenerator.writeString("guest");
            } else {
                jsonGenerator.writeString("other");
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
            if (NeboUserProfileManager.BACKEND_PAID_STATUS_FREE.equals(tag)) {
                teamMembershipType = TeamMembershipType.FREE;
            } else if ("full".equals(tag)) {
                teamMembershipType = TeamMembershipType.FULL;
            } else if ("guest".equals(tag)) {
                teamMembershipType = TeamMembershipType.GUEST;
            } else {
                teamMembershipType = TeamMembershipType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamMembershipType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TeamMembershipType$1 */
    static /* synthetic */ class C45281 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TeamMembershipType;

        static {
            int[] iArr = new int[TeamMembershipType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TeamMembershipType = iArr;
            try {
                iArr[TeamMembershipType.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TeamMembershipType[TeamMembershipType.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TeamMembershipType[TeamMembershipType.GUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
