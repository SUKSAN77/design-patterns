import { Elysia } from "elysia";
import { LineAuthFacade } from "./LineAuthFacade";
import cors from "@elysiajs/cors";
import { LineUserService } from "./Service/LineUserService";

new Elysia()
  .use(
    cors({
      origin: "http://localhost:3000",
      credentials: true,
      methods: ["GET", "POST", "PUT", "DELETE", "OPTIONS"],
      allowedHeaders: ["Content-Type", "Authorization","x-line-access-token"],
    })
  )
  .post("/auth/line", async ({ body }) => {
    const { accessToken } = body as { accessToken: string };
    if (!accessToken) {
      return { error: "Missing accessToken" };
    }
    try {
      const facade = new LineAuthFacade();
      const user = await facade.authenticateUser(accessToken);
      return user
    } catch (error) {
      return { error: error instanceof Error ? error.message : "Unknown error" };
    }
  })
  .post("/delete", async ({ body }) => {
    const { uuid } = body as { uuid: string };
    if (!uuid) {
      return { error: "Missing uuid" };
    }
    try {
      await LineUserService.deleteUserByUuid(uuid);
      return {  message: "User deleted" };
    } catch (error) {
      return { error: error instanceof Error ? error.message : "Unknown error" };
    }
  })
  .get("/profile", async ({ headers }) => {
    const accessToken = headers["x-line-access-token"];
    if (!accessToken) {
      return { error: "Missing access token" };
    }

    try {
      const facade = new LineAuthFacade();
      const user = await facade.getUserByAccessToken(accessToken);
      return { success: true, user };
    } catch (error) {
      return { error: error instanceof Error ? error.message : "Unknown error" };
    }
  })
  .listen(8080);

console.log(`🦊 Elysia is running at http://localhost:8080`);
