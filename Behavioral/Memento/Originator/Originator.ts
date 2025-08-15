import { Memento } from "../Memento/Memento";

export interface Originator {
  saveMemento(): Memento;
  restoreMemento(memento: Memento): void;
}

