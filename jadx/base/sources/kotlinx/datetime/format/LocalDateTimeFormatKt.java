package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;

/* JADX INFO: compiled from: LocalDateTimeFormat.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"ISO_DATETIME", "Lkotlinx/datetime/format/LocalDateTimeFormat;", "getISO_DATETIME", "()Lkotlinx/datetime/format/LocalDateTimeFormat;", "ISO_DATETIME$delegate", "Lkotlin/Lazy;", "emptyIncompleteLocalDateTime", "Lkotlinx/datetime/format/IncompleteLocalDateTime;", "kotlinx-datetime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LocalDateTimeFormatKt {
    private static final Lazy ISO_DATETIME$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3();
        }
    });
    private static final IncompleteLocalDateTime emptyIncompleteLocalDateTime = new IncompleteLocalDateTime(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    public static final LocalDateTimeFormat getISO_DATETIME() {
        return (LocalDateTimeFormat) ISO_DATETIME$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDateTimeFormat ISO_DATETIME_delegate$lambda$3() {
        return LocalDateTimeFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2((DateTimeFormatBuilder.WithDateTime) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2(DateTimeFormatBuilder.WithDateTime build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        build.date(LocalDateFormatKt.getISO_DATE());
        DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1((DateTimeFormatBuilder.WithDateTime) obj);
            }
        });
        build.time(LocalTimeFormatKt.getISO_TIME());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0(DateTimeFormatBuilder.WithDateTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.m16123char(alternativeParsing, 't');
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1(DateTimeFormatBuilder.WithDateTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.m16123char(alternativeParsing, 'T');
        return Unit.INSTANCE;
    }
}
