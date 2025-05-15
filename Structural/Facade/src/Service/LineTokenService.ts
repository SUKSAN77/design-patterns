export class LineTokenService {
  private static VERIFYTOKEN_URL = "https://api.line.me/oauth2/v2.1/verify";

  async verifyToken(accessToken: string) {
    const params = new URLSearchParams({ access_token: accessToken });

    const response = await fetch(
      `${LineTokenService.VERIFYTOKEN_URL}?${params}`,
      {
        method: "GET",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
      }
    );

    if (!response.ok) {
      throw new Error(`Failed to verify token: ${response.statusText}`);
    }

    return { ok: response.ok, data: await response.json() };
  }
}
