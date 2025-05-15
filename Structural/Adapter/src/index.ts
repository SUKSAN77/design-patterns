import {
  PaymentClient,
  PaypalAdapter,
  PayPalService,
  StripeAdapter,
  StripeService,
} from "./Class";

function main() {
  const client = (client: PaymentClient, amount: number): void => {
    console.log("Client ทำการชำระเงิน....");
    client.clientPayment(amount);
  };

  const paypal = new PayPalService();
  const stripe = new StripeService();

  const paypalProcessor = new PaypalAdapter(paypal);
  const stripeProcessor = new StripeAdapter(stripe);

  const client1 = new PaymentClient(paypalProcessor);
  const client2 = new PaymentClient(stripeProcessor);

  console.log("Client 1 : จ่ายเงินผ่าน Paypal ด้วยจำนวนเงิน 3300 บาท");
  client(client1, 3300);

  console.log("Client 2 : จ่ายเงินผ่าน Stripe ด้วยจำนวนเงิน 5000 บาท");
  client(client2, 5000);
}

main();
