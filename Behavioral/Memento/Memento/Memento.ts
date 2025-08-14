export interface Memento<T> {
    getState(): T;
    setState(state: T): void;
}