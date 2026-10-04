package com.dropbox.core.p013v2.team;

import androidx.core.app.NotificationCompat;
import com.dropbox.core.p013v2.team.ExcludedUsersUpdateStatus;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class ExcludedUsersUpdateResult {

    @Nonnull
    protected final ExcludedUsersUpdateStatus status;

    public ExcludedUsersUpdateResult(@Nonnull ExcludedUsersUpdateStatus excludedUsersUpdateStatus) {
        if (excludedUsersUpdateStatus == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = excludedUsersUpdateStatus;
    }

    @Nonnull
    public ExcludedUsersUpdateStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.status});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ExcludedUsersUpdateStatus excludedUsersUpdateStatus = this.status;
        ExcludedUsersUpdateStatus excludedUsersUpdateStatus2 = ((ExcludedUsersUpdateResult) obj).status;
        return excludedUsersUpdateStatus == excludedUsersUpdateStatus2 || excludedUsersUpdateStatus.equals(excludedUsersUpdateStatus2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExcludedUsersUpdateResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExcludedUsersUpdateResult excludedUsersUpdateResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            ExcludedUsersUpdateStatus.Serializer.INSTANCE.serialize(excludedUsersUpdateResult.status, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExcludedUsersUpdateResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            ExcludedUsersUpdateStatus excludedUsersUpdateStatusDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        excludedUsersUpdateStatusDeserialize = ExcludedUsersUpdateStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (excludedUsersUpdateStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                ExcludedUsersUpdateResult excludedUsersUpdateResult = new ExcludedUsersUpdateResult(excludedUsersUpdateStatusDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(excludedUsersUpdateResult, excludedUsersUpdateResult.toStringMultiline());
                return excludedUsersUpdateResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
