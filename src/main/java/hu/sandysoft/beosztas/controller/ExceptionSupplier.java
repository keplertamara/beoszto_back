package hu.sandysoft.beosztas.controller;
@FunctionalInterface
public interface ExceptionSupplier<T> {
    T get() throws Exception;
}
