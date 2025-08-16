import { Caretaker } from "./Caretaker/Caretaker";
import { ItemOriginator } from "./Originator/ItemOriginator";
import { Sword } from "./Originator/Sword";

class UpgradeClient {
  private item: ItemOriginator;
  private caretaker: Caretaker;

  constructor(item: ItemOriginator, caretaker: Caretaker) {
    this.item = item;
    this.caretaker = caretaker;
  }

  private calculateSuccessRate(level: number): number {
    return Math.max(0.1, 1 - level * 0.1); //successRate = 1−(level×0.1) // 0.1 คือค่าที่น้อยที่สุด 10%
  }

  upgrade() {
    const currentLevel = this.item.getLevel();
    const successRate = this.calculateSuccessRate(currentLevel);
    const roll = Math.random(); // สร้างเลขทศนิยมแบบสุ่มในช่วง 0 ถึง 1

    console.log(`🎲 Success Rate: ${(successRate * 100).toFixed(1)}%`); //ปัดเศษ

    if (roll < successRate) {
      this.item.setLevel(currentLevel + 1);
      this.caretaker.addHistory();
      console.log(
        `✅ Success! New Level: ${this.item.getLevel()} | New Value: ${this.item.getValue()} | Attack: ${this.item.getAttackPower()}`
      );
    } else {
      this.caretaker.undo();
      console.log(
        `❌ Fail! Reverting to Level ${this.item.getLevel()} | Value: ${this.item.getValue()} | Attack: ${this.item.getAttackPower()}`
      );
    }
  }

  enhancement(attempts: number) {
    console.log("\n======== Enhancement Start ========");
    for (let i = 0; i < attempts; i++) {
      console.log(`\n🔨 Attempt ${i + 1}`);
      this.upgrade();
    }
    console.log("\n======== Final Item Info ========");
    this.item.showInfo();
    console.log("=================================");
  }
}

const main = () => {
  const myItem = new Sword("Sword of the King", "Legendary", 100);
  const caretaker = new Caretaker(myItem);
  const upgradeClient = new UpgradeClient(myItem, caretaker);

  upgradeClient.enhancement(15); // Increasing attempts to see higher levels

  myItem.showInfo(); // Show final item info


  caretaker.showHistoryData(); // Show history of upgrades
};

main();
