import { Injectable } from '@nestjs/common';

@Injectable()
export class AuthService {
  private userProfile: any;

  async validateUser(profile: any): Promise<any> {
    // 여기서 사용자 프로필을 데이터베이스에 저장하거나 다른 처리를 합니다.
    // 예를 들어, 사용자를 데이터베이스에서 찾거나 생성합니다.
    this.userProfile = profile;
    return profile;
  }

  getUserProfile(): any {
    // 전역 변수에 저장된 사용자 프로필 반환
    return this.userProfile;
  }

  logoutUserProfile() {
    this.userProfile = undefined;
  }
}