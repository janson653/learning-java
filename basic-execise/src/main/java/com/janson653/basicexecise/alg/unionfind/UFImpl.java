package com.janson653.basicexecise.alg.unionfind;

public class UFImpl extends UF {
    public UFImpl(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        if(id[q] == q) {
            id[p] = q;
        }
        else {
            id[p] = id[find(q)];
        }
    }


}
