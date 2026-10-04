package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum MemberPolicy {
    TEAM,
    ANYONE,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.MemberPolicy$1 */
    static /* synthetic */ class C42811 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$MemberPolicy;

        static {
            int[] iArr = new int[MemberPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$MemberPolicy = iArr;
            try {
                iArr[MemberPolicy.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberPolicy[MemberPolicy.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<MemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberPolicy memberPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C42811.$SwitchMap$com$dropbox$core$v2$sharing$MemberPolicy[memberPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("team");
            } else if (i == 2) {
                jsonGenerator.writeString("anyone");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberPolicy memberPolicy;
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
            if ("team".equals(tag)) {
                memberPolicy = MemberPolicy.TEAM;
            } else if ("anyone".equals(tag)) {
                memberPolicy = MemberPolicy.ANYONE;
            } else {
                memberPolicy = MemberPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberPolicy;
        }
    }
}
