package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum FolderAction {
    CHANGE_OPTIONS,
    DISABLE_VIEWER_INFO,
    EDIT_CONTENTS,
    ENABLE_VIEWER_INFO,
    INVITE_EDITOR,
    INVITE_VIEWER,
    INVITE_VIEWER_NO_COMMENT,
    RELINQUISH_MEMBERSHIP,
    UNMOUNT,
    UNSHARE,
    LEAVE_A_COPY,
    SHARE_LINK,
    CREATE_LINK,
    SET_ACCESS_INHERITANCE,
    OTHER;

    static class Serializer extends UnionSerializer<FolderAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FolderAction folderAction, JsonGenerator jsonGenerator) throws IOException {
            switch (C42591.$SwitchMap$com$dropbox$core$v2$sharing$FolderAction[folderAction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("change_options");
                    break;
                case 2:
                    jsonGenerator.writeString("disable_viewer_info");
                    break;
                case 3:
                    jsonGenerator.writeString("edit_contents");
                    break;
                case 4:
                    jsonGenerator.writeString("enable_viewer_info");
                    break;
                case 5:
                    jsonGenerator.writeString("invite_editor");
                    break;
                case 6:
                    jsonGenerator.writeString("invite_viewer");
                    break;
                case 7:
                    jsonGenerator.writeString("invite_viewer_no_comment");
                    break;
                case 8:
                    jsonGenerator.writeString("relinquish_membership");
                    break;
                case 9:
                    jsonGenerator.writeString("unmount");
                    break;
                case 10:
                    jsonGenerator.writeString("unshare");
                    break;
                case 11:
                    jsonGenerator.writeString("leave_a_copy");
                    break;
                case 12:
                    jsonGenerator.writeString("share_link");
                    break;
                case 13:
                    jsonGenerator.writeString("create_link");
                    break;
                case 14:
                    jsonGenerator.writeString("set_access_inheritance");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FolderAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FolderAction folderAction;
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
            if ("change_options".equals(tag)) {
                folderAction = FolderAction.CHANGE_OPTIONS;
            } else if ("disable_viewer_info".equals(tag)) {
                folderAction = FolderAction.DISABLE_VIEWER_INFO;
            } else if ("edit_contents".equals(tag)) {
                folderAction = FolderAction.EDIT_CONTENTS;
            } else if ("enable_viewer_info".equals(tag)) {
                folderAction = FolderAction.ENABLE_VIEWER_INFO;
            } else if ("invite_editor".equals(tag)) {
                folderAction = FolderAction.INVITE_EDITOR;
            } else if ("invite_viewer".equals(tag)) {
                folderAction = FolderAction.INVITE_VIEWER;
            } else if ("invite_viewer_no_comment".equals(tag)) {
                folderAction = FolderAction.INVITE_VIEWER_NO_COMMENT;
            } else if ("relinquish_membership".equals(tag)) {
                folderAction = FolderAction.RELINQUISH_MEMBERSHIP;
            } else if ("unmount".equals(tag)) {
                folderAction = FolderAction.UNMOUNT;
            } else if ("unshare".equals(tag)) {
                folderAction = FolderAction.UNSHARE;
            } else if ("leave_a_copy".equals(tag)) {
                folderAction = FolderAction.LEAVE_A_COPY;
            } else if ("share_link".equals(tag)) {
                folderAction = FolderAction.SHARE_LINK;
            } else if ("create_link".equals(tag)) {
                folderAction = FolderAction.CREATE_LINK;
            } else if ("set_access_inheritance".equals(tag)) {
                folderAction = FolderAction.SET_ACCESS_INHERITANCE;
            } else {
                folderAction = FolderAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return folderAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.FolderAction$1 */
    static /* synthetic */ class C42591 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$FolderAction;

        static {
            int[] iArr = new int[FolderAction.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$FolderAction = iArr;
            try {
                iArr[FolderAction.CHANGE_OPTIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.DISABLE_VIEWER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.EDIT_CONTENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.ENABLE_VIEWER_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.INVITE_EDITOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.INVITE_VIEWER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.INVITE_VIEWER_NO_COMMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.RELINQUISH_MEMBERSHIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.UNMOUNT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.UNSHARE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.LEAVE_A_COPY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.SHARE_LINK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.CREATE_LINK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$FolderAction[FolderAction.SET_ACCESS_INHERITANCE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }
}
