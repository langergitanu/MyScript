package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AddFolderMemberError;
import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.p013v2.sharing.SharedFolderMemberError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateFolderMemberError {
    public static final UpdateFolderMemberError INSUFFICIENT_PLAN = new UpdateFolderMemberError().withTag(Tag.INSUFFICIENT_PLAN);
    public static final UpdateFolderMemberError NO_PERMISSION = new UpdateFolderMemberError().withTag(Tag.NO_PERMISSION);
    public static final UpdateFolderMemberError OTHER = new UpdateFolderMemberError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private SharedFolderMemberError memberErrorValue;
    private AddFolderMemberError noExplicitAccessValue;

    public enum Tag {
        ACCESS_ERROR,
        MEMBER_ERROR,
        NO_EXPLICIT_ACCESS,
        INSUFFICIENT_PLAN,
        NO_PERMISSION,
        OTHER
    }

    private UpdateFolderMemberError() {
    }

    private UpdateFolderMemberError withTag(Tag tag) {
        UpdateFolderMemberError updateFolderMemberError = new UpdateFolderMemberError();
        updateFolderMemberError._tag = tag;
        return updateFolderMemberError;
    }

    private UpdateFolderMemberError withTagAndAccessError(Tag tag, SharedFolderAccessError sharedFolderAccessError) {
        UpdateFolderMemberError updateFolderMemberError = new UpdateFolderMemberError();
        updateFolderMemberError._tag = tag;
        updateFolderMemberError.accessErrorValue = sharedFolderAccessError;
        return updateFolderMemberError;
    }

    private UpdateFolderMemberError withTagAndMemberError(Tag tag, SharedFolderMemberError sharedFolderMemberError) {
        UpdateFolderMemberError updateFolderMemberError = new UpdateFolderMemberError();
        updateFolderMemberError._tag = tag;
        updateFolderMemberError.memberErrorValue = sharedFolderMemberError;
        return updateFolderMemberError;
    }

    private UpdateFolderMemberError withTagAndNoExplicitAccess(Tag tag, AddFolderMemberError addFolderMemberError) {
        UpdateFolderMemberError updateFolderMemberError = new UpdateFolderMemberError();
        updateFolderMemberError._tag = tag;
        updateFolderMemberError.noExplicitAccessValue = addFolderMemberError;
        return updateFolderMemberError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static UpdateFolderMemberError accessError(SharedFolderAccessError sharedFolderAccessError) {
        if (sharedFolderAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, sharedFolderAccessError);
    }

    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isMemberError() {
        return this._tag == Tag.MEMBER_ERROR;
    }

    public static UpdateFolderMemberError memberError(SharedFolderMemberError sharedFolderMemberError) {
        if (sharedFolderMemberError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderMemberError().withTagAndMemberError(Tag.MEMBER_ERROR, sharedFolderMemberError);
    }

    public SharedFolderMemberError getMemberErrorValue() {
        if (this._tag != Tag.MEMBER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_ERROR, but was Tag." + this._tag.name());
        }
        return this.memberErrorValue;
    }

    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
    }

    public static UpdateFolderMemberError noExplicitAccess(AddFolderMemberError addFolderMemberError) {
        if (addFolderMemberError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderMemberError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, addFolderMemberError);
    }

    public AddFolderMemberError getNoExplicitAccessValue() {
        if (this._tag != Tag.NO_EXPLICIT_ACCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.NO_EXPLICIT_ACCESS, but was Tag." + this._tag.name());
        }
        return this.noExplicitAccessValue;
    }

    public boolean isInsufficientPlan() {
        return this._tag == Tag.INSUFFICIENT_PLAN;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue, this.memberErrorValue, this.noExplicitAccessValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateFolderMemberError)) {
            return false;
        }
        UpdateFolderMemberError updateFolderMemberError = (UpdateFolderMemberError) obj;
        if (this._tag != updateFolderMemberError._tag) {
            return false;
        }
        switch (C43141.f739xbd0655b7[this._tag.ordinal()]) {
            case 1:
                SharedFolderAccessError sharedFolderAccessError = this.accessErrorValue;
                SharedFolderAccessError sharedFolderAccessError2 = updateFolderMemberError.accessErrorValue;
                return sharedFolderAccessError == sharedFolderAccessError2 || sharedFolderAccessError.equals(sharedFolderAccessError2);
            case 2:
                SharedFolderMemberError sharedFolderMemberError = this.memberErrorValue;
                SharedFolderMemberError sharedFolderMemberError2 = updateFolderMemberError.memberErrorValue;
                return sharedFolderMemberError == sharedFolderMemberError2 || sharedFolderMemberError.equals(sharedFolderMemberError2);
            case 3:
                AddFolderMemberError addFolderMemberError = this.noExplicitAccessValue;
                AddFolderMemberError addFolderMemberError2 = updateFolderMemberError.noExplicitAccessValue;
                return addFolderMemberError == addFolderMemberError2 || addFolderMemberError.equals(addFolderMemberError2);
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.UpdateFolderMemberError$1 */
    static /* synthetic */ class C43141 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$UpdateFolderMemberError$Tag */
        static final /* synthetic */ int[] f739xbd0655b7;

        static {
            int[] iArr = new int[Tag.values().length];
            f739xbd0655b7 = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f739xbd0655b7[Tag.MEMBER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f739xbd0655b7[Tag.NO_EXPLICIT_ACCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f739xbd0655b7[Tag.INSUFFICIENT_PLAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f739xbd0655b7[Tag.NO_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f739xbd0655b7[Tag.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UpdateFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UpdateFolderMemberError updateFolderMemberError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43141.f739xbd0655b7[updateFolderMemberError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharedFolderAccessError.Serializer.INSTANCE.serialize(updateFolderMemberError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("member_error", jsonGenerator);
                jsonGenerator.writeFieldName("member_error");
                SharedFolderMemberError.Serializer.INSTANCE.serialize(updateFolderMemberError.memberErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("no_explicit_access", jsonGenerator);
                jsonGenerator.writeFieldName("no_explicit_access");
                AddFolderMemberError.Serializer.INSTANCE.serialize(updateFolderMemberError.noExplicitAccessValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("insufficient_plan");
            } else if (i == 5) {
                jsonGenerator.writeString("no_permission");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UpdateFolderMemberError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UpdateFolderMemberError updateFolderMemberErrorNoExplicitAccess;
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
            if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.accessError(SharedFolderAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("member_error".equals(tag)) {
                expectField("member_error", jsonParser);
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.memberError(SharedFolderMemberError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_explicit_access".equals(tag)) {
                expectField("no_explicit_access", jsonParser);
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.noExplicitAccess(AddFolderMemberError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("insufficient_plan".equals(tag)) {
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.INSUFFICIENT_PLAN;
            } else if ("no_permission".equals(tag)) {
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.NO_PERMISSION;
            } else {
                updateFolderMemberErrorNoExplicitAccess = UpdateFolderMemberError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return updateFolderMemberErrorNoExplicitAccess;
        }
    }
}
