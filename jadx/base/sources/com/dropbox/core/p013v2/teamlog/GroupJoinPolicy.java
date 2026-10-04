package com.dropbox.core.p013v2.teamlog;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupJoinPolicy {
    OPEN,
    REQUEST_TO_JOIN,
    OTHER;

    static class Serializer extends UnionSerializer<GroupJoinPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupJoinPolicy groupJoinPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44841.$SwitchMap$com$dropbox$core$v2$teamlog$GroupJoinPolicy[groupJoinPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
            } else if (i == 2) {
                jsonGenerator.writeString("request_to_join");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupJoinPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupJoinPolicy groupJoinPolicy;
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
            if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(tag)) {
                groupJoinPolicy = GroupJoinPolicy.OPEN;
            } else if ("request_to_join".equals(tag)) {
                groupJoinPolicy = GroupJoinPolicy.REQUEST_TO_JOIN;
            } else {
                groupJoinPolicy = GroupJoinPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupJoinPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.GroupJoinPolicy$1 */
    static /* synthetic */ class C44841 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$GroupJoinPolicy;

        static {
            int[] iArr = new int[GroupJoinPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$GroupJoinPolicy = iArr;
            try {
                iArr[GroupJoinPolicy.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$GroupJoinPolicy[GroupJoinPolicy.REQUEST_TO_JOIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
