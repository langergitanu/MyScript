package com.myscript.nebo.userdict.p035ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus;", "", "<init>", "()V", "Valid", "Invalid", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Valid;", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class InputStatus {
    public /* synthetic */ InputStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Valid;", "Lcom/myscript/nebo/userdict/ui/InputStatus;", "<init>", "()V", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Valid extends InputStatus {
        public static final Valid INSTANCE = new Valid();

        private Valid() {
            super(null);
        }
    }

    private InputStatus() {
    }

    /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "Lcom/myscript/nebo/userdict/ui/InputStatus;", "<init>", "()V", "IsEmpty", "Exists", "ContainsWhiteSpace", "ForbiddenChar", "TooLong", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$ContainsWhiteSpace;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$Exists;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$ForbiddenChar;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$IsEmpty;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$TooLong;", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Invalid extends InputStatus {
        public /* synthetic */ Invalid(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$IsEmpty;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "<init>", "()V", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class IsEmpty extends Invalid {
            public static final IsEmpty INSTANCE = new IsEmpty();

            private IsEmpty() {
                super(null);
            }
        }

        private Invalid() {
            super(null);
        }

        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$Exists;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "word", "", "<init>", "(Ljava/lang/CharSequence;)V", "getWord", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Exists extends Invalid {
            private final CharSequence word;

            public static /* synthetic */ Exists copy$default(Exists exists, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = exists.word;
                }
                return exists.copy(charSequence);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CharSequence getWord() {
                return this.word;
            }

            public final Exists copy(CharSequence word) {
                Intrinsics.checkNotNullParameter(word, "word");
                return new Exists(word);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Exists) && Intrinsics.areEqual(this.word, ((Exists) other).word);
            }

            public int hashCode() {
                return this.word.hashCode();
            }

            public String toString() {
                return "Exists(word=" + ((Object) this.word) + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Exists(CharSequence word) {
                super(null);
                Intrinsics.checkNotNullParameter(word, "word");
                this.word = word;
            }

            public final CharSequence getWord() {
                return this.word;
            }
        }

        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$ContainsWhiteSpace;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "word", "", "<init>", "(Ljava/lang/CharSequence;)V", "getWord", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class ContainsWhiteSpace extends Invalid {
            private final CharSequence word;

            public static /* synthetic */ ContainsWhiteSpace copy$default(ContainsWhiteSpace containsWhiteSpace, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = containsWhiteSpace.word;
                }
                return containsWhiteSpace.copy(charSequence);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CharSequence getWord() {
                return this.word;
            }

            public final ContainsWhiteSpace copy(CharSequence word) {
                Intrinsics.checkNotNullParameter(word, "word");
                return new ContainsWhiteSpace(word);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ContainsWhiteSpace) && Intrinsics.areEqual(this.word, ((ContainsWhiteSpace) other).word);
            }

            public int hashCode() {
                return this.word.hashCode();
            }

            public String toString() {
                return "ContainsWhiteSpace(word=" + ((Object) this.word) + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContainsWhiteSpace(CharSequence word) {
                super(null);
                Intrinsics.checkNotNullParameter(word, "word");
                this.word = word;
            }

            public final CharSequence getWord() {
                return this.word;
            }
        }

        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$ForbiddenChar;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "invalidCharsCount", "", "invalidChars", "", "<init>", "(ILjava/lang/CharSequence;)V", "getInvalidCharsCount", "()I", "getInvalidChars", "()Ljava/lang/CharSequence;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class ForbiddenChar extends Invalid {
            private final CharSequence invalidChars;
            private final int invalidCharsCount;

            public static /* synthetic */ ForbiddenChar copy$default(ForbiddenChar forbiddenChar, int i, CharSequence charSequence, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = forbiddenChar.invalidCharsCount;
                }
                if ((i2 & 2) != 0) {
                    charSequence = forbiddenChar.invalidChars;
                }
                return forbiddenChar.copy(i, charSequence);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getInvalidCharsCount() {
                return this.invalidCharsCount;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final CharSequence getInvalidChars() {
                return this.invalidChars;
            }

            public final ForbiddenChar copy(int invalidCharsCount, CharSequence invalidChars) {
                Intrinsics.checkNotNullParameter(invalidChars, "invalidChars");
                return new ForbiddenChar(invalidCharsCount, invalidChars);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ForbiddenChar)) {
                    return false;
                }
                ForbiddenChar forbiddenChar = (ForbiddenChar) other;
                return this.invalidCharsCount == forbiddenChar.invalidCharsCount && Intrinsics.areEqual(this.invalidChars, forbiddenChar.invalidChars);
            }

            public int hashCode() {
                return (Integer.hashCode(this.invalidCharsCount) * 31) + this.invalidChars.hashCode();
            }

            public String toString() {
                return "ForbiddenChar(invalidCharsCount=" + this.invalidCharsCount + ", invalidChars=" + ((Object) this.invalidChars) + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ForbiddenChar(int i, CharSequence invalidChars) {
                super(null);
                Intrinsics.checkNotNullParameter(invalidChars, "invalidChars");
                this.invalidCharsCount = i;
                this.invalidChars = invalidChars;
            }

            public final CharSequence getInvalidChars() {
                return this.invalidChars;
            }

            public final int getInvalidCharsCount() {
                return this.invalidCharsCount;
            }
        }

        /* JADX INFO: compiled from: UserDictionaryViewModel.kt */
        @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid$TooLong;", "Lcom/myscript/nebo/userdict/ui/InputStatus$Invalid;", "word", "", "<init>", "(Ljava/lang/CharSequence;)V", "getWord", "()Ljava/lang/CharSequence;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class TooLong extends Invalid {
            private final CharSequence word;

            public static /* synthetic */ TooLong copy$default(TooLong tooLong, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = tooLong.word;
                }
                return tooLong.copy(charSequence);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CharSequence getWord() {
                return this.word;
            }

            public final TooLong copy(CharSequence word) {
                Intrinsics.checkNotNullParameter(word, "word");
                return new TooLong(word);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TooLong) && Intrinsics.areEqual(this.word, ((TooLong) other).word);
            }

            public int hashCode() {
                return this.word.hashCode();
            }

            public String toString() {
                return "TooLong(word=" + ((Object) this.word) + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TooLong(CharSequence word) {
                super(null);
                Intrinsics.checkNotNullParameter(word, "word");
                this.word = word;
            }

            public final CharSequence getWord() {
                return this.word;
            }
        }
    }
}
