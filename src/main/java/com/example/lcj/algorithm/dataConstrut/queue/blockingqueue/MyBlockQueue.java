package com.example.lcj.algorithm.dataConstrut.queue.blockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/28 22:34
 */
public class MyBlockQueue<E> implements BlockingQueue<E> {
    private int capacity;
    private List<E> list;

    public MyBlockQueue(int capacity){
        this.capacity = capacity;
        this.list = new ArrayList<>(capacity);
    }

    @Override
    public E take() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                this.wait();
            }
            E value = list.remove(0);
            this.notifyAll();
            return value;
        }
    }

    @Override
    public void put(E e) throws InterruptedException {
        synchronized (this) {
            if (list.size() == capacity) {
                this.wait();
            }
            list.add(e);
            this.notifyAll();
        }
    }


    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }



    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }
}
