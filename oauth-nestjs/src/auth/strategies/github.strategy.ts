import { PassportStrategy } from '@nestjs/passport';
import { Strategy } from 'passport-github2';
import { Injectable } from '@nestjs/common';
import { AuthService } from '../auth.service';

// 'github' end-point에 사용되는 알고리즘으로 Get() 정의되어 있는 함수 전에 먼저 실행되는 guard
@Injectable()
export class GithubStrategy extends PassportStrategy(Strategy, 'github') {
  constructor(private authService: AuthService) {
    super({
      clientID: process.env.GITHUB_CLIENT_ID,
      clientSecret: process.env.GITHUB_CLIENT_SECRET,
      callbackURL: 'http://localhost:3000/auth/github/callback',
      scope: ['user'],
    });
  }

  async validate(accessToken: string, refreshToken: string, profile: any) {
    console.log('what the');
    return this.authService.validateUser(accessToken, profile);
  }
}
