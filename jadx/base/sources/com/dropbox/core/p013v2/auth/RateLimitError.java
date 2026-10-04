package com.dropbox.core.p013v2.auth;

import com.dropbox.core.p013v2.auth.RateLimitReason;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class RateLimitError {

    @Nonnull
    protected final RateLimitReason reason;
    protected final long retryAfter;

    public RateLimitError(@Nonnull RateLimitReason rateLimitReason, long j) {
        if (rateLimitReason == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = rateLimitReason;
        this.retryAfter = j;
    }

    public RateLimitError(@Nonnull RateLimitReason rateLimitReason) {
        this(rateLimitReason, 1L);
    }

    @Nonnull
    public RateLimitReason getReason() {
        return this.reason;
    }

    public long getRetryAfter() {
        return this.retryAfter;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.reason, Long.valueOf(this.retryAfter)});
    }

    public boolean equals(Object obj) {
        RateLimitError rateLimitError;
        RateLimitReason rateLimitReason;
        RateLimitReason rateLimitReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((rateLimitReason = this.reason) == (rateLimitReason2 = (rateLimitError = (RateLimitError) obj).reason) || rateLimitReason.equals(rateLimitReason2)) && this.retryAfter == rateLimitError.retryAfter;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<RateLimitError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RateLimitError rateLimitError, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("reason");
            RateLimitReason.Serializer.INSTANCE.serialize(rateLimitError.reason, jsonGenerator);
            jsonGenerator.writeFieldName("retry_after");
            StoneSerializers.uInt64().serialize(Long.valueOf(rateLimitError.retryAfter), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RateLimitError deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            RateLimitReason rateLimitReasonDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1L;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("reason".equals(currentName)) {
                        rateLimitReasonDeserialize = RateLimitReason.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("retry_after".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (rateLimitReasonDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"reason\" missing.");
                }
                RateLimitError rateLimitError = new RateLimitError(rateLimitReasonDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(rateLimitError, rateLimitError.toStringMultiline());
                return rateLimitError;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
