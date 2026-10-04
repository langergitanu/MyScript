package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.ListFileMembersCountResult;
import com.dropbox.core.p013v2.sharing.SharingFileAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ListFileMembersIndividualResult {
    public static final ListFileMembersIndividualResult OTHER = new ListFileMembersIndividualResult().withTag(Tag.OTHER);
    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private ListFileMembersCountResult resultValue;

    public enum Tag {
        RESULT,
        ACCESS_ERROR,
        OTHER
    }

    private ListFileMembersIndividualResult() {
    }

    private ListFileMembersIndividualResult withTag(Tag tag) {
        ListFileMembersIndividualResult listFileMembersIndividualResult = new ListFileMembersIndividualResult();
        listFileMembersIndividualResult._tag = tag;
        return listFileMembersIndividualResult;
    }

    private ListFileMembersIndividualResult withTagAndResult(Tag tag, ListFileMembersCountResult listFileMembersCountResult) {
        ListFileMembersIndividualResult listFileMembersIndividualResult = new ListFileMembersIndividualResult();
        listFileMembersIndividualResult._tag = tag;
        listFileMembersIndividualResult.resultValue = listFileMembersCountResult;
        return listFileMembersIndividualResult;
    }

    private ListFileMembersIndividualResult withTagAndAccessError(Tag tag, SharingFileAccessError sharingFileAccessError) {
        ListFileMembersIndividualResult listFileMembersIndividualResult = new ListFileMembersIndividualResult();
        listFileMembersIndividualResult._tag = tag;
        listFileMembersIndividualResult.accessErrorValue = sharingFileAccessError;
        return listFileMembersIndividualResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isResult() {
        return this._tag == Tag.RESULT;
    }

    public static ListFileMembersIndividualResult result(ListFileMembersCountResult listFileMembersCountResult) {
        if (listFileMembersCountResult == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersIndividualResult().withTagAndResult(Tag.RESULT, listFileMembersCountResult);
    }

    public ListFileMembersCountResult getResultValue() {
        if (this._tag != Tag.RESULT) {
            throw new IllegalStateException("Invalid tag: required Tag.RESULT, but was Tag." + this._tag.name());
        }
        return this.resultValue;
    }

    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    public static ListFileMembersIndividualResult accessError(SharingFileAccessError sharingFileAccessError) {
        if (sharingFileAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersIndividualResult().withTagAndAccessError(Tag.ACCESS_ERROR, sharingFileAccessError);
    }

    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return this.accessErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.resultValue, this.accessErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ListFileMembersIndividualResult)) {
            return false;
        }
        ListFileMembersIndividualResult listFileMembersIndividualResult = (ListFileMembersIndividualResult) obj;
        if (this._tag != listFileMembersIndividualResult._tag) {
            return false;
        }
        int i = C42751.f723x514a1ef5[this._tag.ordinal()];
        if (i == 1) {
            ListFileMembersCountResult listFileMembersCountResult = this.resultValue;
            ListFileMembersCountResult listFileMembersCountResult2 = listFileMembersIndividualResult.resultValue;
            return listFileMembersCountResult == listFileMembersCountResult2 || listFileMembersCountResult.equals(listFileMembersCountResult2);
        }
        if (i != 2) {
            return i == 3;
        }
        SharingFileAccessError sharingFileAccessError = this.accessErrorValue;
        SharingFileAccessError sharingFileAccessError2 = listFileMembersIndividualResult.accessErrorValue;
        return sharingFileAccessError == sharingFileAccessError2 || sharingFileAccessError.equals(sharingFileAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ListFileMembersIndividualResult$1 */
    static /* synthetic */ class C42751 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$ListFileMembersIndividualResult$Tag */
        static final /* synthetic */ int[] f723x514a1ef5;

        static {
            int[] iArr = new int[Tag.values().length];
            f723x514a1ef5 = iArr;
            try {
                iArr[Tag.RESULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f723x514a1ef5[Tag.ACCESS_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f723x514a1ef5[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<ListFileMembersIndividualResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ListFileMembersIndividualResult listFileMembersIndividualResult, JsonGenerator jsonGenerator) throws IOException {
            int i = C42751.f723x514a1ef5[listFileMembersIndividualResult.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("result", jsonGenerator);
                ListFileMembersCountResult.Serializer.INSTANCE.serialize(listFileMembersIndividualResult.resultValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("access_error", jsonGenerator);
                jsonGenerator.writeFieldName("access_error");
                SharingFileAccessError.Serializer.INSTANCE.serialize(listFileMembersIndividualResult.accessErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ListFileMembersIndividualResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ListFileMembersIndividualResult listFileMembersIndividualResultAccessError;
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
            if ("result".equals(tag)) {
                listFileMembersIndividualResultAccessError = ListFileMembersIndividualResult.result(ListFileMembersCountResult.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("access_error".equals(tag)) {
                expectField("access_error", jsonParser);
                listFileMembersIndividualResultAccessError = ListFileMembersIndividualResult.accessError(SharingFileAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                listFileMembersIndividualResultAccessError = ListFileMembersIndividualResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return listFileMembersIndividualResultAccessError;
        }
    }
}
