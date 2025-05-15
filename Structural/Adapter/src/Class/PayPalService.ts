export class PayPalService {
  makePayment(amount: number): void {
    amount /= 33.24;
    console.log(
      `Paypal: Making payment of ${amount.toLocaleString("th-TH")} USD`
    );
  }
}
