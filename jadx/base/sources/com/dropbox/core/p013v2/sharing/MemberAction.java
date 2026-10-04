package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum MemberAction {
    LEAVE_A_COPY,
    MAKE_EDITOR,
    MAKE_OWNER,
    MAKE_VIEWER,
    MAKE_VIEWER_NO_COMMENT,
    REMOVE,
    OTHER;

    static class Serializer extends UnionSerializer<MemberAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MemberAction memberAction, JsonGenerator jsonGenerator) throws IOException {
            switch (C42801.$SwitchMap$com$dropbox$core$v2$sharing$MemberAction[memberAction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("leave_a_copy");
                    break;
                case 2:
                    jsonGenerator.writeString("make_editor");
                    break;
                case 3:
                    jsonGenerator.writeString("make_owner");
                    break;
                case 4:
                    jsonGenerator.writeString("make_viewer");
                    break;
                case 5:
                    jsonGenerator.writeString("make_viewer_no_comment");
                    break;
                case 6:
                    jsonGenerator.writeString("remove");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MemberAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MemberAction memberAction;
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
            if ("leave_a_copy".equals(tag)) {
                memberAction = MemberAction.LEAVE_A_COPY;
            } else if ("make_editor".equals(tag)) {
                memberAction = MemberAction.MAKE_EDITOR;
            } else if ("make_owner".equals(tag)) {
                memberAction = MemberAction.MAKE_OWNER;
            } else if ("make_viewer".equals(tag)) {
                memberAction = MemberAction.MAKE_VIEWER;
            } else if ("make_viewer_no_comment".equals(tag)) {
                memberAction = MemberAction.MAKE_VIEWER_NO_COMMENT;
            } else if ("remove".equals(tag)) {
                memberAction = MemberAction.REMOVE;
            } else {
                memberAction = MemberAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return memberAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.MemberAction$1 */
    static /* synthetic */ class C42801 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$MemberAction;

        static {
            int[] iArr = new int[MemberAction.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$MemberAction = iArr;
            try {
                iArr[MemberAction.LEAVE_A_COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberAction[MemberAction.MAKE_EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberAction[MemberAction.MAKE_OWNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberAction[MemberAction.MAKE_VIEWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberAction[MemberAction.MAKE_VIEWER_NO_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$MemberAction[MemberAction.REMOVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
