import { IPlayment } from "../Interface/IPayment";

export class PaymentClient {
  private processor: IPlayment;

  constructor(payment: IPlayment) {
    this.processor = payment;
  }

  clientPayment(amount: number): void {
    this.processor.pay(amount);
  }
}
