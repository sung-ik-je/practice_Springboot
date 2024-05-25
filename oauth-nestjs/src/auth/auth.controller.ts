// lib
import { Controller, Get, Query, Req, Res, UseGuards } from '@nestjs/common';
import { AuthGuard } from '@nestjs/passport';
import { Request, Response } from 'express';
import { ParsedQs } from 'qs';

// code
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  // Github OAUTH

  @Get('github')
  @UseGuards(AuthGuard('github'))
  async githubLogin() { /* GitHub 로그인 페이지로 리디렉션 */ }

  @Get('github/callback')
  @UseGuards(AuthGuard('github'))
  async githubLoginCallback(@Req() req: Request, @Res() res: Response, @Query('code') code: string): Promise<any> {
    // 성공적인 인증 후 리디렉션
    // res의 의미를 잘 생각해야 된다, 현재 함수의 응답으로 redirect를 한다는거지 현재 함수의 요청을 redirect url의 request로 보낸다는 것이 아님
    console.log(req);
  }

  @Get('github/profile')
  getProfile(@Req() req: Request, @Res() res: Response) {
    const userProfile = this.authService.getUserProfile(); // 저장된 사용자 프로필을 가져옴
    if (!userProfile) {
      console.log('not login yet');
      return res.redirect('/');
    }
    // res.send(`<h1>Hello ${JSON.stringify(userProfile.displayName)}</h1><a href="/auth/logout">Logout</a>`);
    res.send(`<h1>Hello v2 ${userProfile.displayName}</h1><a href="/auth/logout">Logout</a>`);
  }

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // Google OAUTH
  @Get('google')
  @UseGuards(AuthGuard('google'))
  async googleAuth(@Req() req) { /* Google 로그인 페이지로 리디렉션 */ }

  @Get('google/callback')
  @UseGuards(AuthGuard('google'))
  async googleAuthRedirect(@Req() req) {
    return req.user;
  }

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // KAKAO OAUTH

  @Get('kakao')
  @UseGuards(AuthGuard('kakao'))
  async kakaoAuth(@Req() req) { /* Google 로그인 페이지로 리디렉션 */ }

  @Get('kakao/callback')
  @UseGuards(AuthGuard('kakao'))
  async kakaoAuthRedirect(@Req() req) {
    console.log('kakao oauth 적용');
    console.log(req);
    return req.user;
  }

  // logout시 어떤 플랫폼인지 구분을 logout 함수 내부에서 할건지 아님 플랫폼 별로 분리할 것인지?
  // 위에 2가지 요소 중 어쨋든 로그아웃을 구현하려면 DB에 저장을 해야됨
  @Get('logout')
  logout(@Req() req: Request, @Res() res: Response) {
    req.logout((err) => {
      if (err) {
        console.error('Error logging out:', err);
      } else {
        // 로그아웃 후 수행할 작업을 여기에 추가할 수 있습니다.
        this.authService.logoutUserProfile();
        console.log('Logged out successfully.');
      }
    });
    res.redirect('/');
  }
}
