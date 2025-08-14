import { Memento } from "../Memento/Memento";

export interface Originator<T> {
  saveMemento(): Memento<T>;
  restoreMemento(memento: Memento<T>): void;
}

