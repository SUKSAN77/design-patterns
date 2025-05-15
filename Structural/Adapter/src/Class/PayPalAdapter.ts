import { IPlayment } from "../Interface";
import { PayPalService } from "./PayPalService";

export class PaypalAdapter implements IPlayment {
  private adaptee: PayPalService;

  constructor(adaptee: PayPalService) {
    this.adaptee = adaptee;
  }

  pay(amount: number): void {
    this.adaptee.makePayment(amount);
  }
}
