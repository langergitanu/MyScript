package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TrustedTeamsRequestState {
    INVITED,
    LINKED,
    UNLINKED,
    OTHER;

    static class Serializer extends UnionSerializer<TrustedTeamsRequestState> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TrustedTeamsRequestState trustedTeamsRequestState, JsonGenerator jsonGenerator) throws IOException {
            int i = C45381.$SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestState[trustedTeamsRequestState.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("invited");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("linked");
            } else if (i == 3) {
                jsonGenerator.writeString("unlinked");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TrustedTeamsRequestState deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TrustedTeamsRequestState trustedTeamsRequestState;
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
            if ("invited".equals(tag)) {
                trustedTeamsRequestState = TrustedTeamsRequestState.INVITED;
            } else if ("linked".equals(tag)) {
                trustedTeamsRequestState = TrustedTeamsRequestState.LINKED;
            } else if ("unlinked".equals(tag)) {
                trustedTeamsRequestState = TrustedTeamsRequestState.UNLINKED;
            } else {
                trustedTeamsRequestState = TrustedTeamsRequestState.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return trustedTeamsRequestState;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TrustedTeamsRequestState$1 */
    static /* synthetic */ class C45381 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestState;

        static {
            int[] iArr = new int[TrustedTeamsRequestState.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestState = iArr;
            try {
                iArr[TrustedTeamsRequestState.INVITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestState[TrustedTeamsRequestState.LINKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestState[TrustedTeamsRequestState.UNLINKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
