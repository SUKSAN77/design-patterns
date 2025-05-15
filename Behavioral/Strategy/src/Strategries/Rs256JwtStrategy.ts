import { JwtStrategy } from "./JwtStrategy";
import fs from "fs";
import jwt, { JwtPayload ,Algorithm} from "jsonwebtoken";

// RS256 Strategy Implementation
export class Rs256JwtStrategy implements JwtStrategy {
    private privateKey: string;
    private publicKey: string;
    private algorithm: Algorithm = "RS256";
  
    constructor() {
      try {
        this.privateKey = fs.readFileSync("src/private.pem", "utf8");
        this.publicKey = fs.readFileSync("src/public.pem", "utf8");
      } catch (error) {
        console.error("Error loading RSA keys:", error);
        this.privateKey = "";
        this.publicKey = "";
      }
    }
  
    getConfig() {
      return {
        privateKey: this.privateKey,
        publicKey: this.publicKey,
        algorithm: this.algorithm,
      };
    }
  
    signJwt(payload: object): string {
      const config = this.getConfig();
      return jwt.sign(payload, config.privateKey, {
        algorithm: config.algorithm,
      });
    }
  
    verify(token: string): JwtPayload | string | null {
      try {
        const config = this.getConfig();
        const decoded = jwt.verify(token, config.publicKey, {
          algorithms: [config.algorithm],
        });
        return decoded;
      } catch (error) {
        return null;
      }
    }
  }
  