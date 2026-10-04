package org.ejml.equation;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Sequence {
    List<Operation> operations = new ArrayList();

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public void perform() {
        for (int i = 0; i < this.operations.size(); i++) {
            this.operations.get(i).process();
        }
    }
}
