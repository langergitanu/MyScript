package com.dropbox.core.p013v2.paper;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum SharingPublicPolicyType {
    PEOPLE_WITH_LINK_CAN_EDIT,
    PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT,
    INVITE_ONLY,
    DISABLED;

    static class Serializer extends UnionSerializer<SharingPublicPolicyType> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingPublicPolicyType sharingPublicPolicyType, JsonGenerator jsonGenerator) throws IOException {
            int i = C42421.$SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType[sharingPublicPolicyType.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("people_with_link_can_edit");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("people_with_link_can_view_and_comment");
            } else if (i == 3) {
                jsonGenerator.writeString("invite_only");
            } else {
                if (i == 4) {
                    jsonGenerator.writeString("disabled");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + sharingPublicPolicyType);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingPublicPolicyType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingPublicPolicyType sharingPublicPolicyType;
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
                sharingPublicPolicyType = SharingPublicPolicyType.PEOPLE_WITH_LINK_CAN_EDIT;
            } else if ("people_with_link_can_view_and_comment".equals(tag)) {
                sharingPublicPolicyType = SharingPublicPolicyType.PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT;
            } else if ("invite_only".equals(tag)) {
                sharingPublicPolicyType = SharingPublicPolicyType.INVITE_ONLY;
            } else if ("disabled".equals(tag)) {
                sharingPublicPolicyType = SharingPublicPolicyType.DISABLED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingPublicPolicyType;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.paper.SharingPublicPolicyType$1 */
    static /* synthetic */ class C42421 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType;

        static {
            int[] iArr = new int[SharingPublicPolicyType.values().length];
            $SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType = iArr;
            try {
                iArr[SharingPublicPolicyType.PEOPLE_WITH_LINK_CAN_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType[SharingPublicPolicyType.PEOPLE_WITH_LINK_CAN_VIEW_AND_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType[SharingPublicPolicyType.INVITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$paper$SharingPublicPolicyType[SharingPublicPolicyType.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
