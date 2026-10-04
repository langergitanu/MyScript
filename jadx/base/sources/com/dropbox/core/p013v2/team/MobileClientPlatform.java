package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.events.BackendEvent;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MobileClientPlatform {
    IPHONE,
    IPAD,
    ANDROID,
    WINDOWS_PHONE,
    BLACKBERRY,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MobileClientPlatform$1 */
    static /* synthetic */ class C43871 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform;

        static {
            int[] iArr = new int[MobileClientPlatform.values().length];
            $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform = iArr;
            try {
                iArr[MobileClientPlatform.IPHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform[MobileClientPlatform.IPAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform[MobileClientPlatform.ANDROID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform[MobileClientPlatform.WINDOWS_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform[MobileClientPlatform.BLACKBERRY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<MobileClientPlatform> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MobileClientPlatform mobileClientPlatform, JsonGenerator jsonGenerator) throws IOException {
            int i = C43871.$SwitchMap$com$dropbox$core$v2$team$MobileClientPlatform[mobileClientPlatform.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("iphone");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("ipad");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString(BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM);
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("windows_phone");
            } else if (i == 5) {
                jsonGenerator.writeString("blackberry");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MobileClientPlatform deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MobileClientPlatform mobileClientPlatform;
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
            if ("iphone".equals(tag)) {
                mobileClientPlatform = MobileClientPlatform.IPHONE;
            } else if ("ipad".equals(tag)) {
                mobileClientPlatform = MobileClientPlatform.IPAD;
            } else if (BackendEvent.Workflows.Context.WORKFLOW_CONTEXT_PLATFORM.equals(tag)) {
                mobileClientPlatform = MobileClientPlatform.ANDROID;
            } else if ("windows_phone".equals(tag)) {
                mobileClientPlatform = MobileClientPlatform.WINDOWS_PHONE;
            } else if ("blackberry".equals(tag)) {
                mobileClientPlatform = MobileClientPlatform.BLACKBERRY;
            } else {
                mobileClientPlatform = MobileClientPlatform.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return mobileClientPlatform;
        }
    }
}
