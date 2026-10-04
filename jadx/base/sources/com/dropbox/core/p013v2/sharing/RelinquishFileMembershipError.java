package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class RelinquishFileMembershipError {
    public static final RelinquishFileMembershipError GROUP_ACCESS = new RelinquishFileMembershipError().withTag(Tag.GROUP_ACCESS);
    public static final RelinquishFileMembershipError NO_PERMISSION = new RelinquishFileMembershipError().withTag(Tag.NO_PERMISSION);
    public static final RelinquishFileMembershipError OTHER = new RelinquishFileMembershipError().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;

    public enum Tag {
        ACCESS_ERROR,
        GROUP_ACCESS,
        NO_PERMISSION,
        OTHER
    }

    private RelinquishFileMembershipError() {
    }

    private RelinquishFileMembershipError withTag(Tag tag) {
        RelinquishFileMembershipError relinquishFileMembershipError = new RelinquishFileMembershipError();
        relinquishFileMembershipError._tag = tag;
        return relinquishFileMembershipError;
    }

    private RelinquishFileMembershipError withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        RelinquishFileMembershipError relinquishFileMembershipError = new RelinquishFileMembershipError();
        relinquishFileMembershipError._tag = tag;
        relinquishFileMembershipError.accessErrorValue = sharingFileAccessError;
        return relinquishFileMembershipError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static RelinquishFileMembershipError accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelinquishFileMembershipError().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isGroupAccess() {
        return this._tag == Tag.GROUP_ACCESS;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RelinquishFileMembershipError)) {
            return false;
        }
        RelinquishFileMembershipError relinquishFileMembershipError = (RelinquishFileMembershipError) obj;
        if (this._tag != relinquishFileMembershipError._tag) {
            return false;
        }
        int i = C42871.f728xa7c3523a[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = relinquishFileMembershipError.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.RelinquishFileMembershipError$1 */
    static /* synthetic */ class C42871 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$RelinquishFileMembershipError$Tag */
        static final /* synthetic */ int[] f728xa7c3523a;

        static {
            int[] iArr = new int[Tag.values().length];
            f728xa7c3523a = iArr;
            try {
                iArr[Tag.ACCESS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f728xa7c3523a[Tag.GROUP_ACCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f728xa7c3523a[Tag.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f728xa7c3523a[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<RelinquishFileMembershipError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RelinquishFileMembershipError relinquishFileMembershipError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42871.f728xa7c3523a[relinquishFileMembershipError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(relinquishFileMembershipError.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("group_access");
            } else if (i == 3) {
                jsonGenerator.writeString("no_permission");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RelinquishFileMembershipError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RelinquishFileMembershipError relinquishFileMembershipErrorAccessError;
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
                relinquishFileMembershipErrorAccessError = RelinquishFileMembershipError.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("group_access".equals(tag)) {
                relinquishFileMembershipErrorAccessError = RelinquishFileMembershipError.GROUP_ACCESS;
            } else if ("no_permission".equals(tag)) {
                relinquishFileMembershipErrorAccessError = RelinquishFileMembershipError.NO_PERMISSION;
            } else {
                relinquishFileMembershipErrorAccessError = RelinquishFileMembershipError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return relinquishFileMembershipErrorAccessError;
        }
    }
}
