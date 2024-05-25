import { Module } from '@nestjs/common';
import { PassportModule } from '@nestjs/passport';
import { ConfigModule } from '@nestjs/config';
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { GithubStrategy } from './strategies/github.strategy';
import { GoogleStrategy } from './strategies/google.strategy';
import { KakaoStrategy } from './strategies/kakao.strategy';

@Module({
  imports: [
    PassportModule.register({ session: true }),
    ConfigModule
  ],
  providers: [AuthService, GithubStrategy, GoogleStrategy, KakaoStrategy],
  controllers: [AuthController],
})
export class AuthModule {}
