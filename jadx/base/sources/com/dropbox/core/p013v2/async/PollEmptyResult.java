package com.dropbox.core.p013v2.async;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PollEmptyResult {
    IN_PROGRESS,
    COMPLETE;

    /* JADX INFO: renamed from: com.dropbox.core.v2.async.PollEmptyResult$1 */
    static /* synthetic */ class C41051 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$async$PollEmptyResult;

        static {
            int[] iArr = new int[PollEmptyResult.values().length];
            $SwitchMap$com$dropbox$core$v2$async$PollEmptyResult = iArr;
            try {
                iArr[PollEmptyResult.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$async$PollEmptyResult[PollEmptyResult.COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PollEmptyResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PollEmptyResult pollEmptyResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C41051.$SwitchMap$com$dropbox$core$v2$async$PollEmptyResult[pollEmptyResult.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("in_progress");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("complete");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + pollEmptyResult);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PollEmptyResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PollEmptyResult pollEmptyResult;
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
            if ("in_progress".equals(tag)) {
                pollEmptyResult = PollEmptyResult.IN_PROGRESS;
            } else if ("complete".equals(tag)) {
                pollEmptyResult = PollEmptyResult.COMPLETE;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pollEmptyResult;
        }
    }
}
