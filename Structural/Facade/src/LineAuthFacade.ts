import { LineProfileService } from "./Service/LineProfileService";
import { LineTokenService } from "./Service/LineTokenService";
import { LineUserService } from "./Service/LineUserService";

export class LineAuthFacade {
  private profileService: LineProfileService;
  private tokenService: LineTokenService;

  constructor() {
    this.profileService = new LineProfileService();
    this.tokenService = new LineTokenService();
  }

  async authenticateUser(accessToken: string) {
    const verifyResult = await this.tokenService.verifyToken(accessToken);
    if (!verifyResult.ok) {
      throw new Error("Invalid token");
    }

    const profile = await this.profileService.getProfile(accessToken);

    return LineUserService.register({
      uuid: profile.userId,
      nickName: profile.displayName,
      imageUrl: profile.pictureUrl,
    });
  }

  async getUserByAccessToken(accessToken: string) {
    const verifyResult = await this.tokenService.verifyToken(accessToken);
    if (!verifyResult.ok) {
      throw new Error("Invalid token");
    }

    const profile = await this.profileService.getProfile(accessToken);

    return LineUserService.getUserByUuid(profile.userId);
  }
}