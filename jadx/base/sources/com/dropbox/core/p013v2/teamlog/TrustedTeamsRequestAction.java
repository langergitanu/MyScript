package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TrustedTeamsRequestAction {
    ACCEPTED,
    DECLINED,
    EXPIRED,
    INVITED,
    REVOKED,
    OTHER;

    static class Serializer extends UnionSerializer<TrustedTeamsRequestAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TrustedTeamsRequestAction trustedTeamsRequestAction, JsonGenerator jsonGenerator) throws IOException {
            int i = C45371.$SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction[trustedTeamsRequestAction.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("accepted");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("declined");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("expired");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("invited");
            } else if (i == 5) {
                jsonGenerator.writeString("revoked");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TrustedTeamsRequestAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TrustedTeamsRequestAction trustedTeamsRequestAction;
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
            if ("accepted".equals(tag)) {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.ACCEPTED;
            } else if ("declined".equals(tag)) {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.DECLINED;
            } else if ("expired".equals(tag)) {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.EXPIRED;
            } else if ("invited".equals(tag)) {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.INVITED;
            } else if ("revoked".equals(tag)) {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.REVOKED;
            } else {
                trustedTeamsRequestAction = TrustedTeamsRequestAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return trustedTeamsRequestAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TrustedTeamsRequestAction$1 */
    static /* synthetic */ class C45371 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction;

        static {
            int[] iArr = new int[TrustedTeamsRequestAction.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction = iArr;
            try {
                iArr[TrustedTeamsRequestAction.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction[TrustedTeamsRequestAction.DECLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction[TrustedTeamsRequestAction.EXPIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction[TrustedTeamsRequestAction.INVITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedTeamsRequestAction[TrustedTeamsRequestAction.REVOKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
