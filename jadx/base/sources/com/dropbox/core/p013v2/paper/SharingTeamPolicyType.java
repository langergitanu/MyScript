package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharingTeamPolicyType {
    PEOPLE_WITH_LINK_CAN_EDIT,
    PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT,
    INVITE_ONLY;

    static class Serializer extends UnionSerializer<SharingTeamPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingTeamPolicyType sharingTeamPolicyType, JsonGenerator jsonGenerator) throws IOException {
            int i = C42431.$SwitchMap$com$dropbox$core$v2$paper$SharingTeamPolicyType[sharingTeamPolicyType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("people_with_link_can_edit");
            } else if (i == 2) {
                jsonGenerator.writeString("people_with_link_can_view_and_comment");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("invite_only");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + sharingTeamPolicyType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingTeamPolicyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingTeamPolicyType sharingTeamPolicyType;
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
            if ("people_with_link_can_edit".equals(tag)) {
                sharingTeamPolicyType = SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_EDIT;
            } else if ("people_with_link_can_view_and_comment".equals(tag)) {
                sharingTeamPolicyType = SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT;
            } else if ("invite_only".equals(tag)) {
                sharingTeamPolicyType = SharingTeamPolicyType.INVITE_ONLY;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingTeamPolicyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.SharingTeamPolicyType$1 */
    static /* synthetic */ class C42431 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$SharingTeamPolicyType;

        static {
            int[] iArr = new int[SharingTeamPolicyType.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$SharingTeamPolicyType = iArr;
            try {
                iArr[SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$SharingTeamPolicyType[SharingTeamPolicyType.PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$SharingTeamPolicyType[SharingTeamPolicyType.INVITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
