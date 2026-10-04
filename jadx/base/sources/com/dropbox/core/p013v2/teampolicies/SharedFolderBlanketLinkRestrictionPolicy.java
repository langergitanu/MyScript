package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedFolderBlanketLinkRestrictionPolicy {
    MEMBERS,
    ANYONE,
    OTHER;

    static class Serializer extends UnionSerializer<SharedFolderBlanketLinkRestrictionPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45521.f809x7fbf045d[sharedFolderBlanketLinkRestrictionPolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("members");
            } else if (i == 2) {
                jsonGenerator.writeString("anyone");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderBlanketLinkRestrictionPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderBlanketLinkRestrictionPolicy sharedFolderBlanketLinkRestrictionPolicy;
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
            if ("members".equals(tag)) {
                sharedFolderBlanketLinkRestrictionPolicy = SharedFolderBlanketLinkRestrictionPolicy.MEMBERS;
            } else if ("anyone".equals(tag)) {
                sharedFolderBlanketLinkRestrictionPolicy = SharedFolderBlanketLinkRestrictionPolicy.ANYONE;
            } else {
                sharedFolderBlanketLinkRestrictionPolicy = SharedFolderBlanketLinkRestrictionPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderBlanketLinkRestrictionPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.SharedFolderBlanketLinkRestrictionPolicy$1 */
    static /* synthetic */ class C45521 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teampolicies$SharedFolderBlanketLinkRestrictionPolicy */
        static final /* synthetic */ int[] f809x7fbf045d;

        static {
            int[] iArr = new int[SharedFolderBlanketLinkRestrictionPolicy.values().length];
            f809x7fbf045d = iArr;
            try {
                iArr[SharedFolderBlanketLinkRestrictionPolicy.MEMBERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f809x7fbf045d[SharedFolderBlanketLinkRestrictionPolicy.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
