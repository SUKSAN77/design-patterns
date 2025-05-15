import express, { Express, Request, Response, NextFunction } from "express";
import jwt, { JwtPayload, Algorithm } from "jsonwebtoken";
import cookieParser from "cookie-parser";
import bodyParser from "body-parser";
import { Hs256JwtStrategy } from "./Strategries/Hs256JwtStrategy";
import { Rs256JwtStrategy } from "./Strategries/Rs256JwtStrategy";
import { JwtAuthService } from "./Service/JwtAuthService";

const app: Express = express();
const port: number = 3000;

// Middleware
app.use(bodyParser.json());
app.use(cookieParser());

// Extend Request type to include user property
declare global {
  namespace Express {
    interface Request {
      user?: JwtPayload | string;
    }
  }
}

const hs256Strategy = new Hs256JwtStrategy();
const rs256Strategy = new Rs256JwtStrategy();

const jwtService = JwtAuthService.getInstance(hs256Strategy);

const authenticate = (
  req: Request,
  res: Response,
  next: NextFunction
): void => {
  const authHeader = req.headers.authorization;
  const token: string | undefined = authHeader
    ? authHeader.split(" ")[1]
    : req.cookies.auth;

  if (!token) {
    res.status(401).json({ error: "Authentication required" });
    return;
  }

  const user = jwtService.verify(token);
  if (!user) {
    res.status(401).json({ error: "Invalid token" });
    return;
  }

  req.user = user;
  next();
};

app.get("/", (req: Request, res: Response) => {
  res.json({ message: "Hello World" });
});

app.post("/switch", (req: Request, res: Response) => {
  const { algorithm } = req.body;
  if (algorithm === "HS256") {
    jwtService.setStrategy(hs256Strategy);
    res.json({ message: "Switched to HS256" });
  } else if (algorithm === "RS256") {
    jwtService.setStrategy(rs256Strategy);
    res.json({ message: "Switched to RS256" });
  } else {
    res.status(400).json({ message: "Invalid algorithm name" });
  }
});

app.post("/login", (req: Request, res: Response) => {
  const { username, password, firstName, lastName, email } = req.body;

  const hashedPassword = Buffer.from(password).toString("base64");

  const payload = {
    user: {
      username,
      hashedPassword,
      firstName,
      lastName,
    },
    sub: email,
    exp: Math.floor(Date.now() / 1000) + 60 * 60, // 1 hour
  };
  const token = jwtService.signJwt(payload);

  res.cookie("auth", token, {
    httpOnly: true,
    maxAge: 30 * 24 * 60 * 60 * 1000, // 30 days
    sameSite: "strict",
    path: "/",
  });

  res.json({
    token,
    algorithm: jwtService.getCurrentAlgorithm(),
  });
});

app.get("/profile", authenticate, (req: Request, res: Response) => {
  res.json({
    data: req.user,
    algorithm: jwtService.getCurrentAlgorithm(),
  });
});

// Start server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
