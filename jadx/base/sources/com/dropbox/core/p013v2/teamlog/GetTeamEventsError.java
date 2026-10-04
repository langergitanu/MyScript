package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GetTeamEventsError {
    ACCOUNT_ID_NOT_FOUND,
    INVALID_TIME_RANGE,
    INVALID_FILTERS,
    OTHER;

    static class Serializer extends UnionSerializer<GetTeamEventsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetTeamEventsError getTeamEventsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44821.$SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsError[getTeamEventsError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("account_id_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("invalid_time_range");
            } else if (i == 3) {
                jsonGenerator.writeString("invalid_filters");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetTeamEventsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetTeamEventsError getTeamEventsError;
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
            if ("account_id_not_found".equals(tag)) {
                getTeamEventsError = GetTeamEventsError.ACCOUNT_ID_NOT_FOUND;
            } else if ("invalid_time_range".equals(tag)) {
                getTeamEventsError = GetTeamEventsError.INVALID_TIME_RANGE;
            } else if ("invalid_filters".equals(tag)) {
                getTeamEventsError = GetTeamEventsError.INVALID_FILTERS;
            } else {
                getTeamEventsError = GetTeamEventsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getTeamEventsError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.GetTeamEventsError$1 */
    static /* synthetic */ class C44821 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsError;

        static {
            int[] iArr = new int[GetTeamEventsError.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsError = iArr;
            try {
                iArr[GetTeamEventsError.ACCOUNT_ID_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsError[GetTeamEventsError.INVALID_TIME_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsError[GetTeamEventsError.INVALID_FILTERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
