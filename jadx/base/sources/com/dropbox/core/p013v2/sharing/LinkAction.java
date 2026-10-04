package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum LinkAction {
    CHANGE_ACCESS_LEVEL,
    CHANGE_AUDIENCE,
    REMOVE_EXPIRY,
    REMOVE_PASSWORD,
    SET_EXPIRY,
    SET_PASSWORD,
    OTHER;

    static class Serializer extends UnionSerializer<LinkAction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LinkAction linkAction, JsonGenerator jsonGenerator) throws IOException {
            switch (C42681.$SwitchMap$com$dropbox$core$v2$sharing$LinkAction[linkAction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("change_access_level");
                    break;
                case 2:
                    jsonGenerator.writeString("change_audience");
                    break;
                case 3:
                    jsonGenerator.writeString("remove_expiry");
                    break;
                case 4:
                    jsonGenerator.writeString("remove_password");
                    break;
                case 5:
                    jsonGenerator.writeString("set_expiry");
                    break;
                case 6:
                    jsonGenerator.writeString("set_password");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LinkAction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LinkAction linkAction;
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
            if ("change_access_level".equals(tag)) {
                linkAction = LinkAction.CHANGE_ACCESS_LEVEL;
            } else if ("change_audience".equals(tag)) {
                linkAction = LinkAction.CHANGE_AUDIENCE;
            } else if ("remove_expiry".equals(tag)) {
                linkAction = LinkAction.REMOVE_EXPIRY;
            } else if ("remove_password".equals(tag)) {
                linkAction = LinkAction.REMOVE_PASSWORD;
            } else if ("set_expiry".equals(tag)) {
                linkAction = LinkAction.SET_EXPIRY;
            } else if ("set_password".equals(tag)) {
                linkAction = LinkAction.SET_PASSWORD;
            } else {
                linkAction = LinkAction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return linkAction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.LinkAction$1 */
    static /* synthetic */ class C42681 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$LinkAction;

        static {
            int[] iArr = new int[LinkAction.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$LinkAction = iArr;
            try {
                iArr[LinkAction.CHANGE_ACCESS_LEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAction[LinkAction.CHANGE_AUDIENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAction[LinkAction.REMOVE_EXPIRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAction[LinkAction.REMOVE_PASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAction[LinkAction.SET_EXPIRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$LinkAction[LinkAction.SET_PASSWORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
