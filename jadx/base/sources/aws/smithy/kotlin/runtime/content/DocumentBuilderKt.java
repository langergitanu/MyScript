package aws.smithy.kotlin.runtime.content;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/content/DocumentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Laws/smithy/kotlin/runtime/content/Document;", "buildDocument", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/content/Document;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DocumentBuilderKt {
    public static final Document buildDocument(Function1<? super DocumentBuilder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        DocumentBuilder documentBuilder = new DocumentBuilder();
        init.invoke(documentBuilder);
        return DocumentKt.Document(documentBuilder.getContent());
    }
}
