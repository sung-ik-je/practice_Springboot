import { Module } from '@nestjs/common';
import { PassportModule } from '@nestjs/passport';
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { GithubStrategy } from './github.strategy';
import { HttpModule } from '@nestjs/axios';

@Module({
  imports: [
    PassportModule.register({ session: true }),
    HttpModule
  ],
  providers: [AuthService, GithubStrategy],
  controllers: [AuthController],
})
export class AuthModule {}
