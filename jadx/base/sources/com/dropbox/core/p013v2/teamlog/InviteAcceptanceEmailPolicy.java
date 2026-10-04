package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum InviteAcceptanceEmailPolicy {
    DISABLED,
    ENABLED,
    OTHER;

    static class Serializer extends UnionSerializer<InviteAcceptanceEmailPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C44871.f793x9c7819e3[inviteAcceptanceEmailPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("disabled");
            } else if (i == 2) {
                jsonGenerator.writeString("enabled");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public InviteAcceptanceEmailPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy;
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
            if ("disabled".equals(tag)) {
                inviteAcceptanceEmailPolicy = InviteAcceptanceEmailPolicy.DISABLED;
            } else if ("enabled".equals(tag)) {
                inviteAcceptanceEmailPolicy = InviteAcceptanceEmailPolicy.ENABLED;
            } else {
                inviteAcceptanceEmailPolicy = InviteAcceptanceEmailPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return inviteAcceptanceEmailPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.InviteAcceptanceEmailPolicy$1 */
    static /* synthetic */ class C44871 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$InviteAcceptanceEmailPolicy */
        static final /* synthetic */ int[] f793x9c7819e3;

        static {
            int[] iArr = new int[InviteAcceptanceEmailPolicy.values().length];
            f793x9c7819e3 = iArr;
            try {
                iArr[InviteAcceptanceEmailPolicy.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f793x9c7819e3[InviteAcceptanceEmailPolicy.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
