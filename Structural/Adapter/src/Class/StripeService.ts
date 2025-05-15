export class StripeService {
  processCharge(amount: number): void {
    amount /= 33.24;
    console.log(
      `Stripe: Processing charge of ${amount.toLocaleString("th-TH")} USD`
    );
  }
}
