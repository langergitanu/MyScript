package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum FileAction {
    DISABLE_VIEWER_INFO,
    EDIT_CONTENTS,
    ENABLE_VIEWER_INFO,
    INVITE_VIEWER,
    INVITE_VIEWER_NO_COMMENT,
    INVITE_EDITOR,
    UNSHARE,
    RELINQUISH_MEMBERSHIP,
    SHARE_LINK,
    CREATE_LINK,
    CREATE_VIEW_LINK,
    CREATE_EDIT_LINK,
    OTHER;

    static class Serializer extends UnionSerializer<FileAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileAction fileAction, JsonGenerator jsonGenerator) throws IOException {
            switch (C42551.$SwitchMap$com$dropbox$core$v2$sharing$FileAction[fileAction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("disable_viewer_info");
                    break;
                case 2:
                    jsonGenerator.writeString("edit_contents");
                    break;
                case 3:
                    jsonGenerator.writeString("enable_viewer_info");
                    break;
                case 4:
                    jsonGenerator.writeString("invite_viewer");
                    break;
                case 5:
                    jsonGenerator.writeString("invite_viewer_no_comment");
                    break;
                case 6:
                    jsonGenerator.writeString("invite_editor");
                    break;
                case 7:
                    jsonGenerator.writeString("unshare");
                    break;
                case 8:
                    jsonGenerator.writeString("relinquish_membership");
                    break;
                case 9:
                    jsonGenerator.writeString("share_link");
                    break;
                case 10:
                    jsonGenerator.writeString("create_link");
                    break;
                case 11:
                    jsonGenerator.writeString("create_view_link");
                    break;
                case 12:
                    jsonGenerator.writeString("create_edit_link");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileAction fileAction;
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
            if ("disable_viewer_info".equals(tag)) {
                fileAction = FileAction.DISABLE_VIEWER_INFO;
            } else if ("edit_contents".equals(tag)) {
                fileAction = FileAction.EDIT_CONTENTS;
            } else if ("enable_viewer_info".equals(tag)) {
                fileAction = FileAction.ENABLE_VIEWER_INFO;
            } else if ("invite_viewer".equals(tag)) {
                fileAction = FileAction.INVITE_VIEWER;
            } else if ("invite_viewer_no_comment".equals(tag)) {
                fileAction = FileAction.INVITE_VIEWER_NO_COMMENT;
            } else if ("invite_editor".equals(tag)) {
                fileAction = FileAction.INVITE_EDITOR;
            } else if ("unshare".equals(tag)) {
                fileAction = FileAction.UNSHARE;
            } else if ("relinquish_membership".equals(tag)) {
                fileAction = FileAction.RELINQUISH_MEMBERSHIP;
            } else if ("share_link".equals(tag)) {
                fileAction = FileAction.SHARE_LINK;
            } else if ("create_link".equals(tag)) {
                fileAction = FileAction.CREATE_LINK;
            } else if ("create_view_link".equals(tag)) {
                fileAction = FileAction.CREATE_VIEW_LINK;
            } else if ("create_edit_link".equals(tag)) {
                fileAction = FileAction.CREATE_EDIT_LINK;
            } else {
                fileAction = FileAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.FileAction$1 */
    static /* synthetic */ class C42551 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$FileAction;

        static {
            int[] iArr = new int[FileAction.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$FileAction = iArr;
            try {
                iArr[FileAction.DISABLE_VIEWER_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.EDIT_CONTENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.ENABLE_VIEWER_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.INVITE_VIEWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.INVITE_VIEWER_NO_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.INVITE_EDITOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.UNSHARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.RELINQUISH_MEMBERSHIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.SHARE_LINK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.CREATE_LINK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.CREATE_VIEW_LINK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FileAction[FileAction.CREATE_EDIT_LINK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }
}
