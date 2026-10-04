package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TrustedNonTeamMemberType {
    ENTERPRISE_ADMIN,
    MULTI_INSTANCE_ADMIN,
    OTHER;

    static class Serializer extends UnionSerializer<TrustedNonTeamMemberType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TrustedNonTeamMemberType trustedNonTeamMemberType, JsonGenerator jsonGenerator) throws IOException {
            int i = C45361.$SwitchMap$com$dropbox$core$v2$teamlog$TrustedNonTeamMemberType[trustedNonTeamMemberType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("enterprise_admin");
            } else if (i == 2) {
                jsonGenerator.writeString("multi_instance_admin");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TrustedNonTeamMemberType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TrustedNonTeamMemberType trustedNonTeamMemberType;
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
            if ("enterprise_admin".equals(tag)) {
                trustedNonTeamMemberType = TrustedNonTeamMemberType.ENTERPRISE_ADMIN;
            } else if ("multi_instance_admin".equals(tag)) {
                trustedNonTeamMemberType = TrustedNonTeamMemberType.MULTI_INSTANCE_ADMIN;
            } else {
                trustedNonTeamMemberType = TrustedNonTeamMemberType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return trustedNonTeamMemberType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TrustedNonTeamMemberType$1 */
    static /* synthetic */ class C45361 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TrustedNonTeamMemberType;

        static {
            int[] iArr = new int[TrustedNonTeamMemberType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TrustedNonTeamMemberType = iArr;
            try {
                iArr[TrustedNonTeamMemberType.ENTERPRISE_ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TrustedNonTeamMemberType[TrustedNonTeamMemberType.MULTI_INSTANCE_ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
