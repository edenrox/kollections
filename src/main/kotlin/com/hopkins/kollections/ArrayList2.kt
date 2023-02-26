package com.hopkins.kollections

import kotlin.math.max

/**
 * Represents an indexed list of items stored in an array.  The array is resized as needed.
 */
class ArrayList2<T> : Collection2<T> {
    private var buffer: Array<Any?>
    private var size = 0
    
    constructor() {
        buffer = emptyArray()
    }
    
    constructor(capacity: Int) {
        buffer = Array<Any?>(capacity) { null }
    }
    
    constructor(vararg items: T) {
        buffer = (items as Array<Any?>).copyOf()
        size = items.size
    }
    
    override fun add(item: T) {
        ensureCapacity(size + 1)
        buffer[size++] = item
    }

    override fun addAll(items: Collection2<T>) {
        ensureCapacity(size + items.size())
        for (item in items) {
            buffer[size++] = item
        }
    }
    
    override fun clear() {
        for (i in 0..size) {
            buffer[i] = null
        }
        size = 0
    }

    override fun contains(item: Any?): Boolean {
        for (i in 0..size - 1) {
            if (item == buffer[i]) {
                return true
            }
        }
        return false
    }
    
    private fun ensureCapacity(capacity: Int) {
        if (buffer.size >= capacity) {
            return
        }
        val newCapacity = max(max(8, capacity), buffer.size * 2)
        buffer = buffer.copyOf(newCapacity)
    }
    
    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<T> = ArrayList2Iterator(this)
    
    override fun size(): Int = size

    override fun toArray(): Array<Any?> = buffer.copyOf(size)
    
    operator fun get(index: Int): T {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        return buffer[index]!! as T
    }
    
    operator fun set(index: Int, value: T): T? {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException()
        }
        if (index == size) {
          ensureCapacity(index)
          size++
        }
        val oldValue = buffer[index] as T?
        buffer[index] = value
        return oldValue
    }
}

private class ArrayList2Iterator<T>(val list: ArrayList2<T>) : Iterator<T> {
    var next = 0

    override fun hasNext(): Boolean = next < list.size()

    override fun next(): T = list[next++]
}