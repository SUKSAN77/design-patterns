import { PrismaClient } from "@prisma/client";

interface PrismaUser {
  getUsers(): Promise<User[]>;
  getUserByEmail(email: string): Promise<User | null>;
  addUser(name: string, email: string): void;
  deleteUserByEmail(email: string): void;
  close(): void;
}

type User = {
  id: number;
  name: string;
  email: string;
};

class PrismaUserProxy implements PrismaUser {
  private static instance: PrismaUserProxy;
  private prisma: PrismaClient;

  private constructor() {
    this.prisma = new PrismaClient();
  }

  static getInstance(): PrismaUserProxy {
    if (!PrismaUserProxy.instance) {
      PrismaUserProxy.instance = new PrismaUserProxy();
    }
    return PrismaUserProxy.instance;
  }

  async getUsers(): Promise<User[]> {
    console.log("Fetching from Database: Users");
    try {
      const users = await this.prisma.user.findMany();

      if (users.length === 0) {
        console.log("No users found.");
        return [];
      }

      return users;
    } catch (error) {
      console.error("Error: ", error instanceof Error ? error.message : error);
      return [];
    }
  }

  async getUserByEmail(email: string): Promise<User | null> {
    console.log(`Fetching from Database: User with email ${email}`);
    try {
      const user = await this.prisma.user.findUnique({ where: { email } });

      if (!user) {
        console.log("No user found.");
        return null;
      }

      return user;
    } catch (error) {
      console.error("Error: ", error instanceof Error ? error.message : error);
      return null;
    }
  }

  async addUser(name: string, email: string) {
    console.log(`Inserting User: ${name}`);

    if (await this.prisma.user.findUnique({ where: { email } })) {
      console.log(`User ${name} already exists.`);
      return;
    }

    await this.prisma.user.create({
      data: { name, email },
    });
  }

  async deleteUserByEmail(email: string) {
    console.log(`Deleting User with email ${email}`);
    await this.prisma.user.delete({ where: { email } });
  }

  async close() {
    await this.prisma.$disconnect();
    console.log("🚪 Prisma Disconnected.");
  }
}

export default PrismaUserProxy;
