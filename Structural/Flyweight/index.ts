enum MembershipType {
  SuperPremium = "SuperPremium",
  Premium = "Premium",
  Basic = "Basic",
}

// Factory สำหรับ Flyweight
class MembershipFactory {
  private static flyweights: { [key in MembershipType]?: MembershipFlyweight } =
    {};

  static getFlyweight(
    type: MembershipType,
    privileges: string[]
  ): MembershipFlyweight {
    const existingFlyweight = this.flyweights[type];

    if (existingFlyweight && existingFlyweight.getPrivileges() === privileges) {
      return existingFlyweight;
    }

    const newFlyweight = new MembershipFlyweight(type, privileges);
    return (this.flyweights[type] = newFlyweight);
  }

  static getInstanceFlyweight(): {
    [key in MembershipType]?: MembershipFlyweight;
  } {
    return this.flyweights;
  }
}

class MembershipFlyweight {
  constructor(private type: string, private privileges: string[]) {
    this.type = type;
    this.privileges = privileges;
  }

  getPrivileges(): string[] {
    return this.privileges;
  }

  getType(): string {
    return this.type;
  }

  displayInfo(name: string, balance: number) {
    console.log(
      `User: ${name}, Membership: ${this.getType()}, Balance: ${balance}, Privileges: [ ${this.getPrivileges().join(
        ", "
      )} ]`
    );
  }
}

// User ที่ใช้ Flyweight
class User {
  private flyweight: MembershipFlyweight;
  constructor(
    private name: string,
    membershipType: MembershipType,
    privileges: string[],
    private balance: number
  ) {
    this.name = name;
    this.balance = balance;
    this.flyweight = MembershipFactory.getFlyweight(membershipType, privileges);
  }

  displayInfo() {
    this.flyweight.displayInfo(this.name, this.balance);
  }
}

// ใช้งาน Flyweight

const user = new User(
  "MOOK",
  MembershipType.SuperPremium,
  ["No Ads", "4k Streaming"],
  100
);
const user1 = new User(
  "SUKSAN",
  MembershipType.Premium,
  ["No Ads", "HD Streaming"],
  50
);
const user2 = new User(
  "REW",
  MembershipType.Premium,
  ["No Ads", "HD Streaming"],
  30
);
const user3 = new User(
  "NUN",
  MembershipType.Basic,
  ["Ads", "SD Streaming"],
  10
);
const user4 = new User(
  "Toonz",
  MembershipType.Basic,
  ["Ads", "SD Streaming", "Download"],
  1000
);

const user5 = new User(
  "Doonz",
  MembershipType.Basic,
  ["Ads", "SD Streaming", "Download"],
  300
);

const user6 = new User(
  "Dear",
  MembershipType.Basic,
  ["Ads", "SD Streaming"],
  800
);
user1.displayInfo();
user2.displayInfo();
user3.displayInfo();
user4.displayInfo();
user5.displayInfo();
user6.displayInfo();
console.log(MembershipFactory.getInstanceFlyweight());
