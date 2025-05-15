export class LineProfileService {
    private static PROFILE_URL = 'https://api.line.me/v2/profile';
  
    async getProfile(accessToken: string) {
      const response = await fetch(LineProfileService.PROFILE_URL, {
        headers: { Authorization: `Bearer ${accessToken}` },
      });
  
      if (!response.ok) {
        throw new Error(`Failed to fetch user profile: ${response.statusText}`);
      }
  
      return response.json();
    }
  }