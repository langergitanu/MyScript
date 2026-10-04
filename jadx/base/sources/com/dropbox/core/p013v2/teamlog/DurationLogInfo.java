package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TimeUnit;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class DurationLogInfo {
    protected final long amount;

    @Nonnull
    protected final TimeUnit unit;

    public DurationLogInfo(@Nonnull TimeUnit timeUnit, long j) {
        if (timeUnit == null) {
            throw new IllegalArgumentException("Required value for 'unit' is null");
        }
        this.unit = timeUnit;
        this.amount = j;
    }

    @Nonnull
    public TimeUnit getUnit() {
        return this.unit;
    }

    public long getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.unit, Long.valueOf(this.amount)});
    }

    public boolean equals(Object obj) {
        DurationLogInfo durationLogInfo;
        TimeUnit timeUnit;
        TimeUnit timeUnit2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((timeUnit = this.unit) == (timeUnit2 = (durationLogInfo = (DurationLogInfo) obj).unit) || timeUnit.equals(timeUnit2)) && this.amount == durationLogInfo.amount;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DurationLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DurationLogInfo durationLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("unit");
            TimeUnit.Serializer.INSTANCE.serialize(durationLogInfo.unit, jsonGenerator);
            jsonGenerator.writeFieldName(Keys.AMOUNT);
            StoneSerializers.uInt64().serialize(Long.valueOf(durationLogInfo.amount), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DurationLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            TimeUnit timeUnitDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("unit".equals(currentName)) {
                        timeUnitDeserialize = TimeUnit.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (Keys.AMOUNT.equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (timeUnitDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"unit\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"amount\" missing.");
                }
                DurationLogInfo durationLogInfo = new DurationLogInfo(timeUnitDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(durationLogInfo, durationLogInfo.toStringMultiline());
                return durationLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
