package richard;

import java.lang.Iterable;
import java.util.Iterator;
import java.lang.Exception;

public class VetorDinamico<T> implements Iterator<T>, Iterable<T> {

    public VetorDinamico(int capacity){
        allocate(capacity);
    }

    public VetorDinamico(){
        allocate(0);
    }

    public VetorDinamico allocate(int allocation){
        //
        int memoryToAllocate = base;

        while (memoryToAllocate <= allocation)
            memoryToAllocate += base;

        T copy[] = arrayBase;
        arrayBase = (T[]) new Object[memoryToAllocate];

        for(int i=0; i < copy.length; i++)
            arrayBase[i] = copy[i];

        return this;
    }

    public int getLength(){
        return length;
    }

    public int getCapacity(){
        return arrayBase.length;
    }

    public T get(int position) throws RuntimeException{
            return arrayBase[position];
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return (iterationCount < length);
    }

    @Override
    public T next() {
        return arrayBase[iterationCount++];
    }

    protected T arrayBase[] = (T[]) new Object[0];
    protected int length = 0;
    private int iterationCount = 0;

    public static void setAllocateBase(int baseIn){
        base = baseIn;
    }

    protected static int base = 14;
}