package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupsPollError {
    INVALID_ASYNC_JOB_ID,
    INTERNAL_ERROR,
    OTHER,
    ACCESS_DENIED;

    static class Serializer extends UnionSerializer<GroupsPollError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupsPollError groupsPollError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43471.$SwitchMap$com$dropbox$core$v2$team$GroupsPollError[groupsPollError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invalid_async_job_id");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("internal_error");
            } else if (i == 3) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("access_denied");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + groupsPollError);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupsPollError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupsPollError groupsPollError;
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
                groupsPollError = GroupsPollError.INVALID_ASYNC_JOB_ID;
            } else if ("internal_error".equals(tag)) {
                groupsPollError = GroupsPollError.INTERNAL_ERROR;
            } else if ("other".equals(tag)) {
                groupsPollError = GroupsPollError.OTHER;
            } else if ("access_denied".equals(tag)) {
                groupsPollError = GroupsPollError.ACCESS_DENIED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupsPollError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.GroupsPollError$1 */
    static /* synthetic */ class C43471 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$GroupsPollError;

        static {
            int[] iArr = new int[GroupsPollError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$GroupsPollError = iArr;
            try {
                iArr[GroupsPollError.INVALID_ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupsPollError[GroupsPollError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupsPollError[GroupsPollError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$GroupsPollError[GroupsPollError.ACCESS_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
