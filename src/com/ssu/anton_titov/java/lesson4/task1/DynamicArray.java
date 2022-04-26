package com.ssu.anton_titov.java.lesson4.task1;

import java.util.Arrays;
import java.util.Iterator;



public class DynamicArray<T> implements Iterable<T> {

    private T[] innerArray;
    private int curIdx = 0;


    DynamicArray(int size){ this.innerArray = (T[])new Object[size]; }


    void add(T newElement){

        if (this.iterator().hasNext()) {
            innerArray[curIdx++] = newElement;
        } else {
            float expansionCoefficient = (innerArray.length < 100)? 2f : 1.5f;
            T[] tmp = this.innerArray;
            this.innerArray = (T[])new Object[
                    Float.valueOf(
                            innerArray.length * expansionCoefficient)
                            .intValue()
                    ];
            System.arraycopy(tmp, 0, this.innerArray, 0, tmp.length);
            innerArray[curIdx++] = newElement;
        }
    }


    public T get(int i) {return innerArray[i];}

    void set(T newElem, int idx) {
        this.innerArray[idx - 1] = newElem;
    }

    void remove(int idx){
        if (this.innerArray.length - 1 - idx >= 0)
            System.arraycopy(this.innerArray, idx + 1, this.innerArray, idx, this.innerArray.length - 1 - idx);
        this.innerArray[this.innerArray.length - 1] = null;
    }

    @Override
    public String toString() {return "DynamicArray = " + Arrays.toString(innerArray);}


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return curIdx < innerArray.length;
            }

            @Override
            public T next() {
                return innerArray[curIdx++];
            }
        };
    }

}
