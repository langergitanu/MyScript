package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.secondaryemails.SecondaryEmail;
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
public final class AddSecondaryEmailResult {
    public static final AddSecondaryEmailResult OTHER = new AddSecondaryEmailResult().withTag(Tag.OTHER);
    private Tag _tag;
    private String alreadyOwnedByUserValue;
    private String alreadyPendingValue;
    private String rateLimitedValue;
    private String reachedLimitValue;
    private SecondaryEmail successValue;
    private String tooManyUpdatesValue;
    private String transientErrorValue;
    private String unavailableValue;
    private String unknownErrorValue;

    public enum Tag {
        SUCCESS,
        UNAVAILABLE,
        ALREADY_PENDING,
        ALREADY_OWNED_BY_USER,
        REACHED_LIMIT,
        TRANSIENT_ERROR,
        TOO_MANY_UPDATES,
        UNKNOWN_ERROR,
        RATE_LIMITED,
        OTHER
    }

    private AddSecondaryEmailResult() {
    }

    private AddSecondaryEmailResult withTag(Tag tag) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndSuccess(Tag tag, SecondaryEmail secondaryEmail) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.successValue = secondaryEmail;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndUnavailable(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.unavailableValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndAlreadyPending(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.alreadyPendingValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndAlreadyOwnedByUser(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.alreadyOwnedByUserValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndReachedLimit(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.reachedLimitValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndTransientError(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.transientErrorValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndTooManyUpdates(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.tooManyUpdatesValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndUnknownError(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.unknownErrorValue = str;
        return addSecondaryEmailResult;
    }

    private AddSecondaryEmailResult withTagAndRateLimited(Tag tag, String str) {
        AddSecondaryEmailResult addSecondaryEmailResult = new AddSecondaryEmailResult();
        addSecondaryEmailResult._tag = tag;
        addSecondaryEmailResult.rateLimitedValue = str;
        return addSecondaryEmailResult;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static AddSecondaryEmailResult success(SecondaryEmail secondaryEmail) {
        if (secondaryEmail == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddSecondaryEmailResult().withTagAndSuccess(Tag.SUCCESS, secondaryEmail);
    }

    public SecondaryEmail getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isUnavailable() {
        return this._tag == Tag.UNAVAILABLE;
    }

    public static AddSecondaryEmailResult unavailable(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndUnavailable(Tag.UNAVAILABLE, str);
    }

    public String getUnavailableValue() {
        if (this._tag != Tag.UNAVAILABLE) {
            throw new IllegalStateException("Invalid tag: required Tag.UNAVAILABLE, but was Tag." + this._tag.name());
        }
        return this.unavailableValue;
    }

    public boolean isAlreadyPending() {
        return this._tag == Tag.ALREADY_PENDING;
    }

    public static AddSecondaryEmailResult alreadyPending(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndAlreadyPending(Tag.ALREADY_PENDING, str);
    }

    public String getAlreadyPendingValue() {
        if (this._tag != Tag.ALREADY_PENDING) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_PENDING, but was Tag." + this._tag.name());
        }
        return this.alreadyPendingValue;
    }

    public boolean isAlreadyOwnedByUser() {
        return this._tag == Tag.ALREADY_OWNED_BY_USER;
    }

    public static AddSecondaryEmailResult alreadyOwnedByUser(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndAlreadyOwnedByUser(Tag.ALREADY_OWNED_BY_USER, str);
    }

    public String getAlreadyOwnedByUserValue() {
        if (this._tag != Tag.ALREADY_OWNED_BY_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_OWNED_BY_USER, but was Tag." + this._tag.name());
        }
        return this.alreadyOwnedByUserValue;
    }

    public boolean isReachedLimit() {
        return this._tag == Tag.REACHED_LIMIT;
    }

    public static AddSecondaryEmailResult reachedLimit(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndReachedLimit(Tag.REACHED_LIMIT, str);
    }

    public String getReachedLimitValue() {
        if (this._tag != Tag.REACHED_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.REACHED_LIMIT, but was Tag." + this._tag.name());
        }
        return this.reachedLimitValue;
    }

    public boolean isTransientError() {
        return this._tag == Tag.TRANSIENT_ERROR;
    }

    public static AddSecondaryEmailResult transientError(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndTransientError(Tag.TRANSIENT_ERROR, str);
    }

    public String getTransientErrorValue() {
        if (this._tag != Tag.TRANSIENT_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.TRANSIENT_ERROR, but was Tag." + this._tag.name());
        }
        return this.transientErrorValue;
    }

    public boolean isTooManyUpdates() {
        return this._tag == Tag.TOO_MANY_UPDATES;
    }

    public static AddSecondaryEmailResult tooManyUpdates(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndTooManyUpdates(Tag.TOO_MANY_UPDATES, str);
    }

    public String getTooManyUpdatesValue() {
        if (this._tag != Tag.TOO_MANY_UPDATES) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_UPDATES, but was Tag." + this._tag.name());
        }
        return this.tooManyUpdatesValue;
    }

    public boolean isUnknownError() {
        return this._tag == Tag.UNKNOWN_ERROR;
    }

    public static AddSecondaryEmailResult unknownError(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndUnknownError(Tag.UNKNOWN_ERROR, str);
    }

    public String getUnknownErrorValue() {
        if (this._tag != Tag.UNKNOWN_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.UNKNOWN_ERROR, but was Tag." + this._tag.name());
        }
        return this.unknownErrorValue;
    }

    public boolean isRateLimited() {
        return this._tag == Tag.RATE_LIMITED;
    }

    public static AddSecondaryEmailResult rateLimited(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddSecondaryEmailResult().withTagAndRateLimited(Tag.RATE_LIMITED, str);
    }

    public String getRateLimitedValue() {
        if (this._tag != Tag.RATE_LIMITED) {
            throw new IllegalStateException("Invalid tag: required Tag.RATE_LIMITED, but was Tag." + this._tag.name());
        }
        return this.rateLimitedValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.unavailableValue, this.alreadyPendingValue, this.alreadyOwnedByUserValue, this.reachedLimitValue, this.transientErrorValue, this.tooManyUpdatesValue, this.unknownErrorValue, this.rateLimitedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AddSecondaryEmailResult)) {
            return false;
        }
        AddSecondaryEmailResult addSecondaryEmailResult = (AddSecondaryEmailResult) obj;
        if (this._tag != addSecondaryEmailResult._tag) {
            return false;
        }
        switch (C43191.$SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[this._tag.ordinal()]) {
            case 1:
                SecondaryEmail secondaryEmail = this.successValue;
                SecondaryEmail secondaryEmail2 = addSecondaryEmailResult.successValue;
                return secondaryEmail == secondaryEmail2 || secondaryEmail.equals(secondaryEmail2);
            case 2:
                String str = this.unavailableValue;
                String str2 = addSecondaryEmailResult.unavailableValue;
                return str == str2 || str.equals(str2);
            case 3:
                String str3 = this.alreadyPendingValue;
                String str4 = addSecondaryEmailResult.alreadyPendingValue;
                return str3 == str4 || str3.equals(str4);
            case 4:
                String str5 = this.alreadyOwnedByUserValue;
                String str6 = addSecondaryEmailResult.alreadyOwnedByUserValue;
                return str5 == str6 || str5.equals(str6);
            case 5:
                String str7 = this.reachedLimitValue;
                String str8 = addSecondaryEmailResult.reachedLimitValue;
                return str7 == str8 || str7.equals(str8);
            case 6:
                String str9 = this.transientErrorValue;
                String str10 = addSecondaryEmailResult.transientErrorValue;
                return str9 == str10 || str9.equals(str10);
            case 7:
                String str11 = this.tooManyUpdatesValue;
                String str12 = addSecondaryEmailResult.tooManyUpdatesValue;
                return str11 == str12 || str11.equals(str12);
            case 8:
                String str13 = this.unknownErrorValue;
                String str14 = addSecondaryEmailResult.unknownErrorValue;
                return str13 == str14 || str13.equals(str14);
            case 9:
                String str15 = this.rateLimitedValue;
                String str16 = addSecondaryEmailResult.rateLimitedValue;
                return str15 == str16 || str15.equals(str16);
            case 10:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.AddSecondaryEmailResult$1 */
    static /* synthetic */ class C43191 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.ALREADY_PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.ALREADY_OWNED_BY_USER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.REACHED_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.TRANSIENT_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.TOO_MANY_UPDATES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.UNKNOWN_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.RATE_LIMITED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[Tag.OTHER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<AddSecondaryEmailResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddSecondaryEmailResult addSecondaryEmailResult, JsonGenerator jsonGenerator) throws IOException {
            switch (C43191.$SwitchMap$com$dropbox$core$v2$team$AddSecondaryEmailResult$Tag[addSecondaryEmailResult.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                    SecondaryEmail.Serializer.INSTANCE.serialize(addSecondaryEmailResult.successValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("unavailable", jsonGenerator);
                    jsonGenerator.writeFieldName("unavailable");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.unavailableValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("already_pending", jsonGenerator);
                    jsonGenerator.writeFieldName("already_pending");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.alreadyPendingValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("already_owned_by_user", jsonGenerator);
                    jsonGenerator.writeFieldName("already_owned_by_user");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.alreadyOwnedByUserValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("reached_limit", jsonGenerator);
                    jsonGenerator.writeFieldName("reached_limit");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.reachedLimitValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("transient_error", jsonGenerator);
                    jsonGenerator.writeFieldName("transient_error");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.transientErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 7:
                    jsonGenerator.writeStartObject();
                    writeTag("too_many_updates", jsonGenerator);
                    jsonGenerator.writeFieldName("too_many_updates");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.tooManyUpdatesValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 8:
                    jsonGenerator.writeStartObject();
                    writeTag("unknown_error", jsonGenerator);
                    jsonGenerator.writeFieldName("unknown_error");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.unknownErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 9:
                    jsonGenerator.writeStartObject();
                    writeTag("rate_limited", jsonGenerator);
                    jsonGenerator.writeFieldName("rate_limited");
                    StoneSerializers.string().serialize(addSecondaryEmailResult.rateLimitedValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddSecondaryEmailResult deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddSecondaryEmailResult addSecondaryEmailResultRateLimited;
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
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.success(SecondaryEmail.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("unavailable".equals(tag)) {
                expectField("unavailable", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.unavailable(StoneSerializers.string().deserialize(jsonParser));
            } else if ("already_pending".equals(tag)) {
                expectField("already_pending", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.alreadyPending(StoneSerializers.string().deserialize(jsonParser));
            } else if ("already_owned_by_user".equals(tag)) {
                expectField("already_owned_by_user", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.alreadyOwnedByUser(StoneSerializers.string().deserialize(jsonParser));
            } else if ("reached_limit".equals(tag)) {
                expectField("reached_limit", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.reachedLimit(StoneSerializers.string().deserialize(jsonParser));
            } else if ("transient_error".equals(tag)) {
                expectField("transient_error", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.transientError(StoneSerializers.string().deserialize(jsonParser));
            } else if ("too_many_updates".equals(tag)) {
                expectField("too_many_updates", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.tooManyUpdates(StoneSerializers.string().deserialize(jsonParser));
            } else if ("unknown_error".equals(tag)) {
                expectField("unknown_error", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.unknownError(StoneSerializers.string().deserialize(jsonParser));
            } else if ("rate_limited".equals(tag)) {
                expectField("rate_limited", jsonParser);
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.rateLimited(StoneSerializers.string().deserialize(jsonParser));
            } else {
                addSecondaryEmailResultRateLimited = AddSecondaryEmailResult.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addSecondaryEmailResultRateLimited;
        }
    }
}
