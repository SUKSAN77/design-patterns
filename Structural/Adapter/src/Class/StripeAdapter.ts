import { IPlayment } from "../Interface";
import { StripeService } from "./StripeService";

export class StripeAdapter implements IPlayment {
  private adaptee: StripeService;

  constructor(stripe: StripeService) {
    this.adaptee = stripe;
  }

  pay(amount: number): void {
    this.adaptee.processCharge(amount);
  }
}
