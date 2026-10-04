package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class DeleteSecondaryEmailResult {
    public static final DeleteSecondaryEmailResult OTHER = new DeleteSecondaryEmailResult().withTag(Tag.OTHER);
    private Tag _tag;
    private String cannotRemovePrimaryValue;
    private String notFoundValue;
    private String successValue;

    public enum Tag {
        SUCCESS,
        NOT_FOUND,
        CANNOT_REMOVE_PRIMARY,
        OTHER
    }

    private DeleteSecondaryEmailResult() {
    }

    private DeleteSecondaryEmailResult withTag(Tag tag) {
        DeleteSecondaryEmailResult deleteSecondaryEmailResult = new DeleteSecondaryEmailResult();
        deleteSecondaryEmailResult._tag = tag;
        return deleteSecondaryEmailResult;
    }

    private DeleteSecondaryEmailResult withTagAndSuccess(Tag tag, String str) {
        DeleteSecondaryEmailResult deleteSecondaryEmailResult = new DeleteSecondaryEmailResult();
        deleteSecondaryEmailResult._tag = tag;
        deleteSecondaryEmailResult.successValue = str;
        return deleteSecondaryEmailResult;
    }

    private DeleteSecondaryEmailResult withTagAndNotFound(Tag tag, String str) {
        DeleteSecondaryEmailResult deleteSecondaryEmailResult = new DeleteSecondaryEmailResult();
        deleteSecondaryEmailResult._tag = tag;
        deleteSecondaryEmailResult.notFoundValue = str;
        return deleteSecondaryEmailResult;
    }

    private DeleteSecondaryEmailResult withTagAndCannotRemovePrimary(Tag tag, String str) {
        DeleteSecondaryEmailResult deleteSecondaryEmailResult = new DeleteSecondaryEmailResult();
        deleteSecondaryEmailResult._tag = tag;
        deleteSecondaryEmailResult.cannotRemovePrimaryValue = str;
        return deleteSecondaryEmailResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static DeleteSecondaryEmailResult success(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, str);
    }

    public String getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public static DeleteSecondaryEmailResult notFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndNotFound(Tag.NOT_FOUND, str);
    }

    public String getNotFoundValue() {
        if (this._tag != Tag.NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.notFoundValue;
    }

    public boolean isCannotRemovePrimary() {
        return this._tag == Tag.CANNOT_REMOVE_PRIMARY;
    }

    public static DeleteSecondaryEmailResult cannotRemovePrimary(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new DeleteSecondaryEmailResult().withTagAndCannotRemovePrimary(Tag.CANNOT_REMOVE_PRIMARY, str);
    }

    public String getCannotRemovePrimaryValue() {
        if (this._tag != Tag.CANNOT_REMOVE_PRIMARY) {
            throw new IllegalStateException("Invalid tag: required Tag.CANNOT_REMOVE_PRIMARY, but was Tag." + this._tag.name());
        }
        return this.cannotRemovePrimaryValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.notFoundValue, this.cannotRemovePrimaryValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteSecondaryEmailResult)) {
            return false;
        }
        DeleteSecondaryEmailResult deleteSecondaryEmailResult = (DeleteSecondaryEmailResult) obj;
        if (this._tag != deleteSecondaryEmailResult._tag) {
            return false;
        }
        int i = C43251.f744x5fb28aff[this._tag.ordinal()];
        if (i == 1) {
            String str = this.successValue;
            String str2 = deleteSecondaryEmailResult.successValue;
            return str == str2 || str.equals(str2);
        }
        if (i == 2) {
            String str3 = this.notFoundValue;
            String str4 = deleteSecondaryEmailResult.notFoundValue;
            return str3 == str4 || str3.equals(str4);
        }
        if (i != 3) {
            return i == 4;
        }
        String str5 = this.cannotRemovePrimaryValue;
        String str6 = deleteSecondaryEmailResult.cannotRemovePrimaryValue;
        return str5 == str6 || str5.equals(str6);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.DeleteSecondaryEmailResult$1 */
    static /* synthetic */ class C43251 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$DeleteSecondaryEmailResult$Tag */
        static final /* synthetic */ int[] f744x5fb28aff;

        static {
            int[] iArr = new int[Tag.values().length];
            f744x5fb28aff = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f744x5fb28aff[Tag.NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f744x5fb28aff[Tag.CANNOT_REMOVE_PRIMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f744x5fb28aff[Tag.OTHER.ordinal()] = 4;
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

    static class Serializer extends UnionSerializer<DeleteSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteSecondaryEmailResult deleteSecondaryEmailResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C43251.f744x5fb28aff[deleteSecondaryEmailResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.SUCCESS);
                StoneSerializers.string().serialize(deleteSecondaryEmailResult.successValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("not_found", jsonGenerator);
                jsonGenerator.writeFieldName("not_found");
                StoneSerializers.string().serialize(deleteSecondaryEmailResult.notFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("cannot_remove_primary", jsonGenerator);
                jsonGenerator.writeFieldName("cannot_remove_primary");
                StoneSerializers.string().serialize(deleteSecondaryEmailResult.cannotRemovePrimaryValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteSecondaryEmailResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteSecondaryEmailResult deleteSecondaryEmailResultCannotRemovePrimary;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                expectField(FirebaseAnalytics.Param.SUCCESS, jsonParser);
                deleteSecondaryEmailResultCannotRemovePrimary = DeleteSecondaryEmailResult.success(StoneSerializers.string().deserialize(jsonParser));
            } else if ("not_found".equals(tag)) {
                expectField("not_found", jsonParser);
                deleteSecondaryEmailResultCannotRemovePrimary = DeleteSecondaryEmailResult.notFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("cannot_remove_primary".equals(tag)) {
                expectField("cannot_remove_primary", jsonParser);
                deleteSecondaryEmailResultCannotRemovePrimary = DeleteSecondaryEmailResult.cannotRemovePrimary(StoneSerializers.string().deserialize(jsonParser));
            } else {
                deleteSecondaryEmailResultCannotRemovePrimary = DeleteSecondaryEmailResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteSecondaryEmailResultCannotRemovePrimary;
        }
    }
}
