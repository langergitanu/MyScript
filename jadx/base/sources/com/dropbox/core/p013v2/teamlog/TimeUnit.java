package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TimeUnit {
    DAYS,
    HOURS,
    MILLISECONDS,
    MINUTES,
    MONTHS,
    SECONDS,
    WEEKS,
    YEARS,
    OTHER;

    static class Serializer extends UnionSerializer<TimeUnit> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TimeUnit timeUnit, JsonGenerator jsonGenerator) throws IOException {
            switch (C45351.$SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[timeUnit.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("days");
                    break;
                case 2:
                    jsonGenerator.writeString("hours");
                    break;
                case 3:
                    jsonGenerator.writeString("milliseconds");
                    break;
                case 4:
                    jsonGenerator.writeString("minutes");
                    break;
                case 5:
                    jsonGenerator.writeString("months");
                    break;
                case 6:
                    jsonGenerator.writeString("seconds");
                    break;
                case 7:
                    jsonGenerator.writeString("weeks");
                    break;
                case 8:
                    jsonGenerator.writeString("years");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TimeUnit deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TimeUnit timeUnit;
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
            if ("days".equals(tag)) {
                timeUnit = TimeUnit.DAYS;
            } else if ("hours".equals(tag)) {
                timeUnit = TimeUnit.HOURS;
            } else if ("milliseconds".equals(tag)) {
                timeUnit = TimeUnit.MILLISECONDS;
            } else if ("minutes".equals(tag)) {
                timeUnit = TimeUnit.MINUTES;
            } else if ("months".equals(tag)) {
                timeUnit = TimeUnit.MONTHS;
            } else if ("seconds".equals(tag)) {
                timeUnit = TimeUnit.SECONDS;
            } else if ("weeks".equals(tag)) {
                timeUnit = TimeUnit.WEEKS;
            } else if ("years".equals(tag)) {
                timeUnit = TimeUnit.YEARS;
            } else {
                timeUnit = TimeUnit.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return timeUnit;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.TimeUnit$1 */
    static /* synthetic */ class C45351 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit = iArr;
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.MINUTES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.MONTHS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.SECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.WEEKS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$TimeUnit[TimeUnit.YEARS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
