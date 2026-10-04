package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum UserOnPaperDocFilter {
    VISITED,
    SHARED,
    OTHER;

    static class Serializer extends UnionSerializer<UserOnPaperDocFilter> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserOnPaperDocFilter userOnPaperDocFilter, JsonGenerator jsonGenerator) throws IOException {
            int i = C42441.$SwitchMap$com$dropbox$core$v2$paper$UserOnPaperDocFilter[userOnPaperDocFilter.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("visited");
            } else if (i == 2) {
                jsonGenerator.writeString("shared");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserOnPaperDocFilter deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserOnPaperDocFilter userOnPaperDocFilter;
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
            if ("visited".equals(tag)) {
                userOnPaperDocFilter = UserOnPaperDocFilter.VISITED;
            } else if ("shared".equals(tag)) {
                userOnPaperDocFilter = UserOnPaperDocFilter.SHARED;
            } else {
                userOnPaperDocFilter = UserOnPaperDocFilter.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userOnPaperDocFilter;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.UserOnPaperDocFilter$1 */
    static /* synthetic */ class C42441 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$UserOnPaperDocFilter;

        static {
            int[] iArr = new int[UserOnPaperDocFilter.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$UserOnPaperDocFilter = iArr;
            try {
                iArr[UserOnPaperDocFilter.VISITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$UserOnPaperDocFilter[UserOnPaperDocFilter.SHARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
