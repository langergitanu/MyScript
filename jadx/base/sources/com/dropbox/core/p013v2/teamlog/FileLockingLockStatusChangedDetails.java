package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.LockStatus;
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
public class FileLockingLockStatusChangedDetails {

    @Nonnull
    protected final LockStatus newValue;

    @Nonnull
    protected final LockStatus previousValue;

    public FileLockingLockStatusChangedDetails(@Nonnull LockStatus lockStatus, @Nonnull LockStatus lockStatus2) {
        if (lockStatus == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = lockStatus;
        if (lockStatus2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = lockStatus2;
    }

    @Nonnull
    public LockStatus getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public LockStatus getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        LockStatus lockStatus;
        LockStatus lockStatus2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLockingLockStatusChangedDetails fileLockingLockStatusChangedDetails = (FileLockingLockStatusChangedDetails) obj;
        LockStatus lockStatus3 = this.previousValue;
        LockStatus lockStatus4 = fileLockingLockStatusChangedDetails.previousValue;
        return (lockStatus3 == lockStatus4 || lockStatus3.equals(lockStatus4)) && ((lockStatus = this.newValue) == (lockStatus2 = fileLockingLockStatusChangedDetails.newValue) || lockStatus.equals(lockStatus2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLockingLockStatusChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLockingLockStatusChangedDetails fileLockingLockStatusChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            LockStatus.Serializer.INSTANCE.serialize(fileLockingLockStatusChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            LockStatus.Serializer.INSTANCE.serialize(fileLockingLockStatusChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileLockingLockStatusChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LockStatus lockStatusDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                LockStatus lockStatusDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        lockStatusDeserialize = LockStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        lockStatusDeserialize2 = LockStatus.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lockStatusDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (lockStatusDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                FileLockingLockStatusChangedDetails fileLockingLockStatusChangedDetails = new FileLockingLockStatusChangedDetails(lockStatusDeserialize, lockStatusDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLockingLockStatusChangedDetails, fileLockingLockStatusChangedDetails.toStringMultiline());
                return fileLockingLockStatusChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
