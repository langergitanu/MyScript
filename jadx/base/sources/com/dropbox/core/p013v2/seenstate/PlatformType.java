package com.dropbox.core.p013v2.seenstate;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum PlatformType {
    WEB,
    DESKTOP,
    MOBILE_IOS,
    MOBILE_ANDROID,
    API,
    UNKNOWN,
    MOBILE,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.seenstate.PlatformType$1 */
    static /* synthetic */ class C42451 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType;

        static {
            int[] iArr = new int[PlatformType.values().length];
            $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType = iArr;
            try {
                iArr[PlatformType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.DESKTOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.MOBILE_IOS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.MOBILE_ANDROID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.API.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[PlatformType.MOBILE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<PlatformType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PlatformType platformType, JsonGenerator jsonGenerator) throws IOException {
            switch (C42451.$SwitchMap$com$dropbox$core$v2$seenstate$PlatformType[platformType.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("web");
                    break;
                case 2:
                    jsonGenerator.writeString("desktop");
                    break;
                case 3:
                    jsonGenerator.writeString("mobile_ios");
                    break;
                case 4:
                    jsonGenerator.writeString("mobile_android");
                    break;
                case 5:
                    jsonGenerator.writeString("api");
                    break;
                case 6:
                    jsonGenerator.writeString("unknown");
                    break;
                case 7:
                    jsonGenerator.writeString(NetworkTargetingEvent.TYPE_MOBILE);
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PlatformType deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PlatformType platformType;
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
            if ("web".equals(tag)) {
                platformType = PlatformType.WEB;
            } else if ("desktop".equals(tag)) {
                platformType = PlatformType.DESKTOP;
            } else if ("mobile_ios".equals(tag)) {
                platformType = PlatformType.MOBILE_IOS;
            } else if ("mobile_android".equals(tag)) {
                platformType = PlatformType.MOBILE_ANDROID;
            } else if ("api".equals(tag)) {
                platformType = PlatformType.API;
            } else if ("unknown".equals(tag)) {
                platformType = PlatformType.UNKNOWN;
            } else if (NetworkTargetingEvent.TYPE_MOBILE.equals(tag)) {
                platformType = PlatformType.MOBILE;
            } else {
                platformType = PlatformType.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return platformType;
        }
    }
}
