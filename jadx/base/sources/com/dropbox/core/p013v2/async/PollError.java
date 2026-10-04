package com.dropbox.core.p013v2.async;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PollError {
    INVALID_ASYNC_JOB_ID,
    INTERNAL_ERROR,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.async.PollError$1 */
    static /* synthetic */ class C41061 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$async$PollError;

        static {
            int[] iArr = new int[PollError.values().length];
            $SwitchMap$com$dropbox$core$v2$async$PollError = iArr;
            try {
                iArr[PollError.INVALID_ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$async$PollError[PollError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PollError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PollError pollError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41061.$SwitchMap$com$dropbox$core$v2$async$PollError[pollError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_async_job_id");
            } else if (i == 2) {
                jsonGenerator.writeString("internal_error");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PollError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PollError pollError;
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
            if ("invalid_async_job_id".equals(tag)) {
                pollError = PollError.INVALID_ASYNC_JOB_ID;
            } else if ("internal_error".equals(tag)) {
                pollError = PollError.INTERNAL_ERROR;
            } else {
                pollError = PollError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pollError;
        }
    }
}
