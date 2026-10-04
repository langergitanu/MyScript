package com.dropbox.core.p013v2.teampolicies;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum GroupCreation {
    ADMINS_AND_MEMBERS,
    ADMINS_ONLY;

    /* JADX INFO: renamed from: com.dropbox.core.v2.teampolicies.GroupCreation$1 */
    static /* synthetic */ class C45461 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teampolicies$GroupCreation;

        static {
            int[] iArr = new int[GroupCreation.values().length];
            $SwitchMap$com$dropbox$core$v2$teampolicies$GroupCreation = iArr;
            try {
                iArr[GroupCreation.ADMINS_AND_MEMBERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teampolicies$GroupCreation[GroupCreation.ADMINS_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<GroupCreation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GroupCreation groupCreation, JsonGenerator jsonGenerator) throws IOException {
            int i = C45461.$SwitchMap$com$dropbox$core$v2$teampolicies$GroupCreation[groupCreation.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("admins_and_members");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("admins_only");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + groupCreation);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GroupCreation deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GroupCreation groupCreation;
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
            if ("admins_and_members".equals(tag)) {
                groupCreation = GroupCreation.ADMINS_AND_MEMBERS;
            } else if ("admins_only".equals(tag)) {
                groupCreation = GroupCreation.ADMINS_ONLY;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return groupCreation;
        }
    }
}
