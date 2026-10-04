package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum SharedFolderMembersInheritancePolicy {
    DONT_INHERIT_MEMBERS,
    INHERIT_MEMBERS,
    OTHER;

    static class Serializer extends UnionSerializer<SharedFolderMembersInheritancePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy, JsonGenerator jsonGenerator) throws IOException {
            int i = C45141.f795x7791221[sharedFolderMembersInheritancePolicy.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("dont_inherit_members");
            } else if (i == 2) {
                jsonGenerator.writeString("inherit_members");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharedFolderMembersInheritancePolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharedFolderMembersInheritancePolicy sharedFolderMembersInheritancePolicy;
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
            if ("dont_inherit_members".equals(tag)) {
                sharedFolderMembersInheritancePolicy = SharedFolderMembersInheritancePolicy.DONT_INHERIT_MEMBERS;
            } else if ("inherit_members".equals(tag)) {
                sharedFolderMembersInheritancePolicy = SharedFolderMembersInheritancePolicy.INHERIT_MEMBERS;
            } else {
                sharedFolderMembersInheritancePolicy = SharedFolderMembersInheritancePolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharedFolderMembersInheritancePolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.SharedFolderMembersInheritancePolicy$1 */
    static /* synthetic */ class C45141 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$SharedFolderMembersInheritancePolicy */
        static final /* synthetic */ int[] f795x7791221;

        static {
            int[] iArr = new int[SharedFolderMembersInheritancePolicy.values().length];
            f795x7791221 = iArr;
            try {
                iArr[SharedFolderMembersInheritancePolicy.DONT_INHERIT_MEMBERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f795x7791221[SharedFolderMembersInheritancePolicy.INHERIT_MEMBERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
