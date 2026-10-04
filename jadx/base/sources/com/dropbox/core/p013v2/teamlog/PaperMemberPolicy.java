package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PaperMemberPolicy {
    ANYONE_WITH_LINK,
    ONLY_TEAM,
    TEAM_AND_EXPLICITLY_SHARED,
    OTHER;

    static class Serializer extends UnionSerializer<PaperMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperMemberPolicy paperMemberPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45041.$SwitchMap$com$dropbox$core$v2$teamlog$PaperMemberPolicy[paperMemberPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("anyone_with_link");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("only_team");
            } else if (i == 3) {
                jsonGenerator.writeString("team_and_explicitly_shared");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperMemberPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperMemberPolicy paperMemberPolicy;
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
            if ("anyone_with_link".equals(tag)) {
                paperMemberPolicy = PaperMemberPolicy.ANYONE_WITH_LINK;
            } else if ("only_team".equals(tag)) {
                paperMemberPolicy = PaperMemberPolicy.ONLY_TEAM;
            } else if ("team_and_explicitly_shared".equals(tag)) {
                paperMemberPolicy = PaperMemberPolicy.TEAM_AND_EXPLICITLY_SHARED;
            } else {
                paperMemberPolicy = PaperMemberPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperMemberPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PaperMemberPolicy$1 */
    static /* synthetic */ class C45041 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PaperMemberPolicy;

        static {
            int[] iArr = new int[PaperMemberPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PaperMemberPolicy = iArr;
            try {
                iArr[PaperMemberPolicy.ANYONE_WITH_LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperMemberPolicy[PaperMemberPolicy.ONLY_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PaperMemberPolicy[PaperMemberPolicy.TEAM_AND_EXPLICITLY_SHARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
