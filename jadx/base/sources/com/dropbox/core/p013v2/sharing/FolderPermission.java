package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.FolderAction;
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
public class FolderPermission {

    @Nonnull
    protected final FolderAction action;
    protected final boolean allow;

    @Nullable
    protected final PermissionDeniedReason reason;

    public FolderPermission(@Nonnull FolderAction folderAction, boolean z, @Nullable PermissionDeniedReason permissionDeniedReason) {
        if (folderAction == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = folderAction;
        this.allow = z;
        this.reason = permissionDeniedReason;
    }

    public FolderPermission(@Nonnull FolderAction folderAction, boolean z) {
        this(folderAction, z, null);
    }

    @Nonnull
    public FolderAction getAction() {
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
        FolderPermission folderPermission;
        FolderAction folderAction;
        FolderAction folderAction2;
        PermissionDeniedReason permissionDeniedReason;
        PermissionDeniedReason permissionDeniedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((folderAction = this.action) == (folderAction2 = (folderPermission = (FolderPermission) obj).action) || folderAction.equals(folderAction2)) && this.allow == folderPermission.allow && ((permissionDeniedReason = this.reason) == (permissionDeniedReason2 = folderPermission.reason) || (permissionDeniedReason != null && permissionDeniedReason.equals(permissionDeniedReason2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderPermission> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderPermission folderPermission, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("action");
            FolderAction.Serializer.INSTANCE.serialize(folderPermission.action, jsonGenerator);
            jsonGenerator.writeFieldName("allow");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(folderPermission.allow), jsonGenerator);
            if (folderPermission.reason != null) {
                jsonGenerator.writeFieldName("reason");
                StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).serialize(folderPermission.reason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderPermission deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FolderAction folderActionDeserialize = null;
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
                        folderActionDeserialize = FolderAction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allow".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("reason".equals(currentName)) {
                        permissionDeniedReason = (PermissionDeniedReason) StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (folderActionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"action\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allow\" missing.");
                }
                FolderPermission folderPermission = new FolderPermission(folderActionDeserialize, boolDeserialize.booleanValue(), permissionDeniedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderPermission, folderPermission.toStringMultiline());
                return folderPermission;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
