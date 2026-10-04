package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum FolderSharingPolicyType {
    TEAM,
    INVITE_ONLY;

    static class Serializer extends UnionSerializer<FolderSharingPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FolderSharingPolicyType folderSharingPolicyType, JsonGenerator jsonGenerator) throws IOException {
            int i = C42291.$SwitchMap$com$dropbox$core$v2$paper$FolderSharingPolicyType[folderSharingPolicyType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("team");
            } else {
                if (i == 2) {
                    jsonGenerator.writeString("invite_only");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + folderSharingPolicyType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FolderSharingPolicyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FolderSharingPolicyType folderSharingPolicyType;
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
            if ("team".equals(tag)) {
                folderSharingPolicyType = FolderSharingPolicyType.TEAM;
            } else if ("invite_only".equals(tag)) {
                folderSharingPolicyType = FolderSharingPolicyType.INVITE_ONLY;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return folderSharingPolicyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.FolderSharingPolicyType$1 */
    static /* synthetic */ class C42291 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$FolderSharingPolicyType;

        static {
            int[] iArr = new int[FolderSharingPolicyType.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$FolderSharingPolicyType = iArr;
            try {
                iArr[FolderSharingPolicyType.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$FolderSharingPolicyType[FolderSharingPolicyType.INVITE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
