import { Memento } from "../Memento/Memento";

export interface Originator {
  saveMemento(): Memento;
}

