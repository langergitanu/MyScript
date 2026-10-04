package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum PlacementRestriction {
    AUSTRALIA_ONLY,
    EUROPE_ONLY,
    JAPAN_ONLY,
    NONE,
    UK_ONLY,
    US_S3_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<PlacementRestriction> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PlacementRestriction placementRestriction, JsonGenerator jsonGenerator) throws IOException {
            switch (C45071.$SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[placementRestriction.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("australia_only");
                    break;
                case 2:
                    jsonGenerator.writeString("europe_only");
                    break;
                case 3:
                    jsonGenerator.writeString("japan_only");
                    break;
                case 4:
                    jsonGenerator.writeString("none");
                    break;
                case 5:
                    jsonGenerator.writeString("uk_only");
                    break;
                case 6:
                    jsonGenerator.writeString("us_s3_only");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PlacementRestriction deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PlacementRestriction placementRestriction;
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
            if ("australia_only".equals(tag)) {
                placementRestriction = PlacementRestriction.AUSTRALIA_ONLY;
            } else if ("europe_only".equals(tag)) {
                placementRestriction = PlacementRestriction.EUROPE_ONLY;
            } else if ("japan_only".equals(tag)) {
                placementRestriction = PlacementRestriction.JAPAN_ONLY;
            } else if ("none".equals(tag)) {
                placementRestriction = PlacementRestriction.NONE;
            } else if ("uk_only".equals(tag)) {
                placementRestriction = PlacementRestriction.UK_ONLY;
            } else if ("us_s3_only".equals(tag)) {
                placementRestriction = PlacementRestriction.US_S3_ONLY;
            } else {
                placementRestriction = PlacementRestriction.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return placementRestriction;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.PlacementRestriction$1 */
    static /* synthetic */ class C45071 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction;

        static {
            int[] iArr = new int[PlacementRestriction.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction = iArr;
            try {
                iArr[PlacementRestriction.AUSTRALIA_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[PlacementRestriction.EUROPE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[PlacementRestriction.JAPAN_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[PlacementRestriction.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[PlacementRestriction.UK_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$PlacementRestriction[PlacementRestriction.US_S3_ONLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
