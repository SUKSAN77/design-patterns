import { JwtPayload } from "jsonwebtoken";

// JWT Strategy Interface
export interface JwtStrategy {
  getConfig(): Record<string, any>;
  signJwt(payload: object): string;
  verify(token: string): JwtPayload | string | null;
}
