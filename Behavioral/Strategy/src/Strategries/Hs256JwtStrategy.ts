import { JwtStrategy } from "./JwtStrategy";
import jwt, { JwtPayload, Algorithm } from "jsonwebtoken";

// HS256 Strategy Implementation
export class Hs256JwtStrategy implements JwtStrategy {
  private secret: string = "WeEIyJc8BlNx0i9py";
  private algorithm: Algorithm = "HS256";

  getConfig() {
    return {
      secret: this.secret,
      algorithm: this.algorithm,
    };
  }

  signJwt(payload: object): string {
    const config = this.getConfig();
    return jwt.sign(payload, config.secret, {
      algorithm: config.algorithm,
    });
  }

  verify(token: string): JwtPayload | string | null {
    try {
      const config = this.getConfig();
      const decoded = jwt.verify(token, config.secret, {
        algorithms: [config.algorithm],
      });
      return decoded;
    } catch (error) {
      return null;
    }
  }
}
