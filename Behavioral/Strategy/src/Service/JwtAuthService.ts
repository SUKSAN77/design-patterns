import { JwtPayload } from "jsonwebtoken";
import { JwtStrategy } from "../Strategries/JwtStrategy";

// JWT Service with Strategy Pattern (Singleton)
export class JwtAuthService {
  private static instance: JwtAuthService;
  private strategy: JwtStrategy;

  private constructor(strategy: JwtStrategy) {
    this.strategy = strategy;
  }

  static getInstance(strategy?: JwtStrategy): JwtAuthService {
    if (!JwtAuthService.instance && strategy) {
      JwtAuthService.instance = new JwtAuthService(strategy);
    }
    return JwtAuthService.instance;
  }

  setStrategy(strategy: JwtStrategy) {
    this.strategy = strategy;
  }

  signJwt(payload: object): string {
    return this.strategy.signJwt(payload);
  }

  verify(token: string): JwtPayload | string | null {
    return this.strategy.verify(token);
  }

  getCurrentAlgorithm(): string {
    return this.strategy.getConfig().algorithm;
  }
}
