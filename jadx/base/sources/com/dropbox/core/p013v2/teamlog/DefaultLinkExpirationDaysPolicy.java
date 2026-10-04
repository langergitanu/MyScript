package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum DefaultLinkExpirationDaysPolicy {
    DAY_1,
    DAY_180,
    DAY_3,
    DAY_30,
    DAY_7,
    DAY_90,
    NONE,
    YEAR_1,
    OTHER;

    static class Serializer extends UnionSerializer<DefaultLinkExpirationDaysPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy, JsonGenerator jsonGenerator) throws IOException {
            switch (C44551.f786xfd6f5cc8[defaultLinkExpirationDaysPolicy.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("day_1");
                    break;
                case 2:
                    jsonGenerator.writeString("day_180");
                    break;
                case 3:
                    jsonGenerator.writeString("day_3");
                    break;
                case 4:
                    jsonGenerator.writeString("day_30");
                    break;
                case 5:
                    jsonGenerator.writeString("day_7");
                    break;
                case 6:
                    jsonGenerator.writeString("day_90");
                    break;
                case 7:
                    jsonGenerator.writeString("none");
                    break;
                case 8:
                    jsonGenerator.writeString("year_1");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DefaultLinkExpirationDaysPolicy deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DefaultLinkExpirationDaysPolicy defaultLinkExpirationDaysPolicy;
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
            if ("day_1".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_1;
            } else if ("day_180".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_180;
            } else if ("day_3".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_3;
            } else if ("day_30".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_30;
            } else if ("day_7".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_7;
            } else if ("day_90".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.DAY_90;
            } else if ("none".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.NONE;
            } else if ("year_1".equals(tag)) {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.YEAR_1;
            } else {
                defaultLinkExpirationDaysPolicy = DefaultLinkExpirationDaysPolicy.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return defaultLinkExpirationDaysPolicy;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.DefaultLinkExpirationDaysPolicy$1 */
    static /* synthetic */ class C44551 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$DefaultLinkExpirationDaysPolicy */
        static final /* synthetic */ int[] f786xfd6f5cc8;

        static {
            int[] iArr = new int[DefaultLinkExpirationDaysPolicy.values().length];
            f786xfd6f5cc8 = iArr;
            try {
                iArr[DefaultLinkExpirationDaysPolicy.DAY_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.DAY_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.DAY_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.DAY_30.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.DAY_7.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.DAY_90.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f786xfd6f5cc8[DefaultLinkExpirationDaysPolicy.YEAR_1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
