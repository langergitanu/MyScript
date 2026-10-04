package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MemberRemoveActionType {
    DELETE,
    LEAVE,
    OFFBOARD,
    OFFBOARD_AND_RETAIN_TEAM_FOLDERS,
    OTHER;

    static class Serializer extends UnionSerializer<MemberRemoveActionType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberRemoveActionType memberRemoveActionType, JsonGenerator jsonGenerator) throws IOException {
            int i = C44931.$SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType[memberRemoveActionType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("delete");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("leave");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("offboard");
            } else if (i == 4) {
                jsonGenerator.writeString("offboard_and_retain_team_folders");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberRemoveActionType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberRemoveActionType memberRemoveActionType;
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
            if ("delete".equals(tag)) {
                memberRemoveActionType = MemberRemoveActionType.DELETE;
            } else if ("leave".equals(tag)) {
                memberRemoveActionType = MemberRemoveActionType.LEAVE;
            } else if ("offboard".equals(tag)) {
                memberRemoveActionType = MemberRemoveActionType.OFFBOARD;
            } else if ("offboard_and_retain_team_folders".equals(tag)) {
                memberRemoveActionType = MemberRemoveActionType.OFFBOARD_AND_RETAIN_TEAM_FOLDERS;
            } else {
                memberRemoveActionType = MemberRemoveActionType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberRemoveActionType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.MemberRemoveActionType$1 */
    static /* synthetic */ class C44931 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType;

        static {
            int[] iArr = new int[MemberRemoveActionType.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType = iArr;
            try {
                iArr[MemberRemoveActionType.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType[MemberRemoveActionType.LEAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType[MemberRemoveActionType.OFFBOARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$MemberRemoveActionType[MemberRemoveActionType.OFFBOARD_AND_RETAIN_TEAM_FOLDERS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
