package aws.smithy.kotlin.runtime.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DslFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J)\u0010\b\u001a\u00028\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H¦\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/DslFactory;", "Builder", "Built", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DslFactory<Builder, Built> {
    Built invoke(Function1<? super Builder, Unit> block);
}
