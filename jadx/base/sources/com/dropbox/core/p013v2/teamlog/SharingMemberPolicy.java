package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharingMemberPolicy {
    ALLOW,
    FORBID,
    FORBID_WITH_EXCLUSIONS,
    OTHER;

    static class Serializer extends UnionSerializer<SharingMemberPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingMemberPolicy sharingMemberPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45191.$SwitchMap$com$dropbox$core$v2$teamlog$SharingMemberPolicy[sharingMemberPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("allow");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("forbid");
            } else if (i == 3) {
                jsonGenerator.writeString("forbid_with_exclusions");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingMemberPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingMemberPolicy sharingMemberPolicy;
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
            if ("allow".equals(tag)) {
                sharingMemberPolicy = SharingMemberPolicy.ALLOW;
            } else if ("forbid".equals(tag)) {
                sharingMemberPolicy = SharingMemberPolicy.FORBID;
            } else if ("forbid_with_exclusions".equals(tag)) {
                sharingMemberPolicy = SharingMemberPolicy.FORBID_WITH_EXCLUSIONS;
            } else {
                sharingMemberPolicy = SharingMemberPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingMemberPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharingMemberPolicy$1 */
    static /* synthetic */ class C45191 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$SharingMemberPolicy;

        static {
            int[] iArr = new int[SharingMemberPolicy.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$SharingMemberPolicy = iArr;
            try {
                iArr[SharingMemberPolicy.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingMemberPolicy[SharingMemberPolicy.FORBID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$SharingMemberPolicy[SharingMemberPolicy.FORBID_WITH_EXCLUSIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
