package com.dropbox.core.p013v2.teamlog;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class ShowcaseEditCommentDetails {

    @Nullable
    protected final String commentText;

    @Nonnull
    protected final String eventUuid;

    public ShowcaseEditCommentDetails(@Nonnull String str, @Nullable String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        this.commentText = str2;
    }

    public ShowcaseEditCommentDetails(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nullable
    public String getCommentText() {
        return this.commentText;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.commentText});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ShowcaseEditCommentDetails showcaseEditCommentDetails = (ShowcaseEditCommentDetails) obj;
        String str3 = this.eventUuid;
        String str4 = showcaseEditCommentDetails.eventUuid;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.commentText) == (str2 = showcaseEditCommentDetails.commentText) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ShowcaseEditCommentDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ShowcaseEditCommentDetails showcaseEditCommentDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(showcaseEditCommentDetails.eventUuid, jsonGenerator);
            if (showcaseEditCommentDetails.commentText != null) {
                jsonGenerator.writeFieldName("comment_text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(showcaseEditCommentDetails.commentText, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ShowcaseEditCommentDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("comment_text".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                ShowcaseEditCommentDetails showcaseEditCommentDetails = new ShowcaseEditCommentDetails(strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(showcaseEditCommentDetails, showcaseEditCommentDetails.toStringMultiline());
                return showcaseEditCommentDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
