package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LinkAudience {
    PUBLIC,
    TEAM,
    NO_ONE,
    PASSWORD,
    MEMBERS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkAudience$1 */
    static /* synthetic */ class C42691 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience;

        static {
            int[] iArr = new int[LinkAudience.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience = iArr;
            try {
                iArr[LinkAudience.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience[LinkAudience.TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience[LinkAudience.NO_ONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience[LinkAudience.PASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAudience[LinkAudience.MEMBERS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<LinkAudience> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkAudience linkAudience, JsonGenerator jsonGenerator) throws IOException {
            int i = C42691.$SwitchMap$com$dropbox$core$v2$sharing$LinkAudience[linkAudience.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("public");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("team");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("no_one");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
            } else if (i == 5) {
                jsonGenerator.writeString("members");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkAudience deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkAudience linkAudience;
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
            if ("public".equals(tag)) {
                linkAudience = LinkAudience.PUBLIC;
            } else if ("team".equals(tag)) {
                linkAudience = LinkAudience.TEAM;
            } else if ("no_one".equals(tag)) {
                linkAudience = LinkAudience.NO_ONE;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                linkAudience = LinkAudience.PASSWORD;
            } else if ("members".equals(tag)) {
                linkAudience = LinkAudience.MEMBERS;
            } else {
                linkAudience = LinkAudience.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return linkAudience;
        }
    }
}
