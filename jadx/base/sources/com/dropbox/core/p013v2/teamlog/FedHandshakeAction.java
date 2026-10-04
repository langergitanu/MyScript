package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum FedHandshakeAction {
    ACCEPTED_INVITE,
    CANCELED_INVITE,
    INVITE_EXPIRED,
    INVITED,
    REJECTED_INVITE,
    REMOVED_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<FedHandshakeAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FedHandshakeAction fedHandshakeAction, JsonGenerator jsonGenerator) throws IOException {
            switch (C44741.$SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[fedHandshakeAction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("accepted_invite");
                    break;
                case 2:
                    jsonGenerator.writeString("canceled_invite");
                    break;
                case 3:
                    jsonGenerator.writeString("invite_expired");
                    break;
                case 4:
                    jsonGenerator.writeString("invited");
                    break;
                case 5:
                    jsonGenerator.writeString("rejected_invite");
                    break;
                case 6:
                    jsonGenerator.writeString("removed_team");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FedHandshakeAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FedHandshakeAction fedHandshakeAction;
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
            if ("accepted_invite".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.ACCEPTED_INVITE;
            } else if ("canceled_invite".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.CANCELED_INVITE;
            } else if ("invite_expired".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.INVITE_EXPIRED;
            } else if ("invited".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.INVITED;
            } else if ("rejected_invite".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.REJECTED_INVITE;
            } else if ("removed_team".equals(tag)) {
                fedHandshakeAction = FedHandshakeAction.REMOVED_TEAM;
            } else {
                fedHandshakeAction = FedHandshakeAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fedHandshakeAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.FedHandshakeAction$1 */
    static /* synthetic */ class C44741 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction;

        static {
            int[] iArr = new int[FedHandshakeAction.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction = iArr;
            try {
                iArr[FedHandshakeAction.ACCEPTED_INVITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[FedHandshakeAction.CANCELED_INVITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[FedHandshakeAction.INVITE_EXPIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[FedHandshakeAction.INVITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[FedHandshakeAction.REJECTED_INVITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$FedHandshakeAction[FedHandshakeAction.REMOVED_TEAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
