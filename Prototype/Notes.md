# Prototype Design Pattern Notes

The core purpose of the **Prototype Pattern** is to allow an object to create an exact copy of itself without making the calling code dependent on its concrete class. 

## 🛠️ How to Implement It (Step-by-Step)

1. **Define a Generic Interface:** Use a generic type parameter (`<T>`) in your cloning interface. This ensures **type safety**, meaning the `copy()` method returns the exact class type you need, avoiding the need for manual type-casting later.
2. **Create a Copy Constructor:** Write a constructor in your concrete class that accepts an instance of the same class as a parameter and copies its fields.
3. **Implement the Copy Method:** Have the `copy()` method simply instantiate a new object by passing `this` into the copy constructor.

---

## 💻 Code Blueprint

### 1. The Interface
```java
package Prototype;

public interface CloneablePrototype<T> {
    T copy();
}