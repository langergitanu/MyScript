package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum NamespaceType {
    APP_FOLDER,
    SHARED_FOLDER,
    TEAM_FOLDER,
    TEAM_MEMBER_FOLDER,
    OTHER;

    static class Serializer extends UnionSerializer<NamespaceType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(NamespaceType namespaceType, JsonGenerator jsonGenerator) throws IOException {
            int i = C43881.$SwitchMap$com$dropbox$core$v2$team$NamespaceType[namespaceType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("app_folder");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("shared_folder");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("team_folder");
            } else if (i == 4) {
                jsonGenerator.writeString("team_member_folder");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public NamespaceType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            NamespaceType namespaceType;
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
            if ("app_folder".equals(tag)) {
                namespaceType = NamespaceType.APP_FOLDER;
            } else if ("shared_folder".equals(tag)) {
                namespaceType = NamespaceType.SHARED_FOLDER;
            } else if ("team_folder".equals(tag)) {
                namespaceType = NamespaceType.TEAM_FOLDER;
            } else if ("team_member_folder".equals(tag)) {
                namespaceType = NamespaceType.TEAM_MEMBER_FOLDER;
            } else {
                namespaceType = NamespaceType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return namespaceType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.NamespaceType$1 */
    static /* synthetic */ class C43881 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$NamespaceType;

        static {
            int[] iArr = new int[NamespaceType.values().length];
            $SwitchMap$com$dropbox$core$v2$team$NamespaceType = iArr;
            try {
                iArr[NamespaceType.APP_FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$NamespaceType[NamespaceType.SHARED_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$NamespaceType[NamespaceType.TEAM_FOLDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$NamespaceType[NamespaceType.TEAM_MEMBER_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
