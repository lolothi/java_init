package org.example.exEntrainement;

public final class SingletonMemoryAddress {

    private static SingletonMemoryAddress instance;

    private SingletonMemoryAddress() {
    }

    //synchronized pour gérer le multi-thread
    public static synchronized SingletonMemoryAddress getlnstance() {
        if (instance == null) {
            instance = new SingletonMemoryAddress();
        }
        return instance;
    }

    public void memoryAddress() {
        Object obj = new Object();
        int hashCode = obj.hashCode();
        System.out.println("Memory Address of Object: " + Integer.toHexString(hashCode));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
