package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LinkAudienceDisallowedReason {
    DELETE_AND_RECREATE,
    RESTRICTED_BY_SHARED_FOLDER,
    RESTRICTED_BY_TEAM,
    USER_NOT_ON_TEAM,
    USER_ACCOUNT_TYPE,
    PERMISSION_DENIED,
    OTHER;

    static class Serializer extends UnionSerializer<LinkAudienceDisallowedReason> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkAudienceDisallowedReason linkAudienceDisallowedReason, JsonGenerator jsonGenerator) throws IOException {
            switch (C42701.f721xd874edd2[linkAudienceDisallowedReason.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("delete_and_recreate");
                    return;
                case 2:
                    jsonGenerator.writeString("restricted_by_shared_folder");
                    return;
                case 3:
                    jsonGenerator.writeString("restricted_by_team");
                    return;
                case 4:
                    jsonGenerator.writeString("user_not_on_team");
                    return;
                case 5:
                    jsonGenerator.writeString("user_account_type");
                    return;
                case 6:
                    jsonGenerator.writeString("permission_denied");
                    return;
                case 7:
                    jsonGenerator.writeString("other");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + linkAudienceDisallowedReason);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkAudienceDisallowedReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkAudienceDisallowedReason linkAudienceDisallowedReason;
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
            if ("delete_and_recreate".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.DELETE_AND_RECREATE;
            } else if ("restricted_by_shared_folder".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.RESTRICTED_BY_SHARED_FOLDER;
            } else if ("restricted_by_team".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.RESTRICTED_BY_TEAM;
            } else if ("user_not_on_team".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.USER_NOT_ON_TEAM;
            } else if ("user_account_type".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.USER_ACCOUNT_TYPE;
            } else if ("permission_denied".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.PERMISSION_DENIED;
            } else if ("other".equals(tag)) {
                linkAudienceDisallowedReason = LinkAudienceDisallowedReason.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return linkAudienceDisallowedReason;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkAudienceDisallowedReason$1 */
    static /* synthetic */ class C42701 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$LinkAudienceDisallowedReason */
        static final /* synthetic */ int[] f721xd874edd2;

        static {
            int[] iArr = new int[LinkAudienceDisallowedReason.values().length];
            f721xd874edd2 = iArr;
            try {
                iArr[LinkAudienceDisallowedReason.DELETE_AND_RECREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.RESTRICTED_BY_SHARED_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.RESTRICTED_BY_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.USER_NOT_ON_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.USER_ACCOUNT_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.PERMISSION_DENIED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f721xd874edd2[LinkAudienceDisallowedReason.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
