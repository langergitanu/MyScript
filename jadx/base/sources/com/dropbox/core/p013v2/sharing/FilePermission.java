package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FileAction;
import com.dropbox.core.p013v2.sharing.PermissionDeniedReason;
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

/* JADX INFO: loaded from: classes4.dex */
public class FilePermission {

    @Nonnull
    protected final FileAction action;
    protected final boolean allow;

    @Nullable
    protected final PermissionDeniedReason reason;

    public FilePermission(@Nonnull FileAction fileAction, boolean z, @Nullable PermissionDeniedReason permissionDeniedReason) {
        if (fileAction == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = fileAction;
        this.allow = z;
        this.reason = permissionDeniedReason;
    }

    public FilePermission(@Nonnull FileAction fileAction, boolean z) {
        this(fileAction, z, null);
    }

    @Nonnull
    public FileAction getAction() {
        return this.action;
    }

    public boolean getAllow() {
        return this.allow;
    }

    @Nullable
    public PermissionDeniedReason getReason() {
        return this.reason;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.action, Boolean.valueOf(this.allow), this.reason});
    }

    public boolean equals(Object obj) {
        FilePermission filePermission;
        FileAction fileAction;
        FileAction fileAction2;
        PermissionDeniedReason permissionDeniedReason;
        PermissionDeniedReason permissionDeniedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((fileAction = this.action) == (fileAction2 = (filePermission = (FilePermission) obj).action) || fileAction.equals(fileAction2)) && this.allow == filePermission.allow && ((permissionDeniedReason = this.reason) == (permissionDeniedReason2 = filePermission.reason) || (permissionDeniedReason != null && permissionDeniedReason.equals(permissionDeniedReason2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FilePermission> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FilePermission filePermission, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("action");
            FileAction.Serializer.INSTANCE.serialize(filePermission.action, jsonGenerator);
            jsonGenerator.writeFieldName("allow");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(filePermission.allow), jsonGenerator);
            if (filePermission.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).serialize(filePermission.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FilePermission deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FileAction fileActionDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                PermissionDeniedReason permissionDeniedReason = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("action".equals(currentName)) {
                        fileActionDeserialize = FileAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allow".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("reason".equals(currentName)) {
                        permissionDeniedReason = (PermissionDeniedReason) StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fileActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow\" missing.");
                }
                FilePermission filePermission = new FilePermission(fileActionDeserialize, boolDeserialize.booleanValue(), permissionDeniedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(filePermission, filePermission.toStringMultiline());
                return filePermission;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
