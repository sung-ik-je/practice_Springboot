import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import axios from 'axios';

@Injectable()
export class AuthService {
  private userProfile: any;
  constructor(private readonly httpService: HttpService) {}

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

  async getAccessToken(c: string): Promise<any> {
    const url = 'https://github.com/login/oauth/access_token';
    const headers = {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    };
    const body = {
      client_id: process.env.GITHUB_CLIENT_ID,
      client_secret: process.env.GITHUB_CLIENT_SECRET,
      code: c
    };

    console.log('code :::: ', c);
    try {
      const response = await axios.post(url, body, { headers });
      console.log(response.data);
      return response.data;
    } catch (error) {
      console.error('Error fetching access token:', error);
      throw new Error('Failed to fetch access token');
    }
  }
}