// lib
import { Controller, Get, Req, Res, UseGuards } from '@nestjs/common';
import { AuthGuard } from '@nestjs/passport';
import { Request, Response } from 'express';

// code
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  @Get('github')
  @UseGuards(AuthGuard('github'))
  async githubLogin() {
    // GitHub 로그인 페이지로 리디렉션
  }

  @Get('github/callback')
  @UseGuards(AuthGuard('github'))
  async githubLoginCallback(@Req() req: Request, @Res() res: Response) {
    // 성공적인 인증 후 리디렉션
    console.log("인증 성공");
    // console.log(req);
    // console.log("==================================================");
    // console.log(res);
    console.log("auth check : ", req.isAuthenticated());
    await this.authService.validateUser(req.user); // 사용자 프로필을 저장
    res.redirect('/auth/github/profile');
  }

  @Get('github/profile')
  getProfile(@Req() req: Request, @Res() res: Response) {
    const userProfile = this.authService.getUserProfile(); // 저장된 사용자 프로필을 가져옴
    if (!userProfile) {
      console.log('come in')
      return res.redirect('/');
    }
    // res.send(`<h1>Hello ${JSON.stringify(userProfile.displayName)}</h1><a href="/auth/logout">Logout</a>`);
    res.send(`<h1>Hello ${userProfile.displayName}</h1><a href="/auth/logout">Logout</a>`);
    res.send('<h1>보소 18<h1>');
    console.log(userProfile);
  }

  @Get('logout')
  logout(@Req() req: Request, @Res() res: Response) {
    req.logout((err) => {
      if (err) {
        console.error('Error logging out:', err);
      } else {
        console.log('Logged out successfully.');
        // 로그아웃 후 수행할 작업을 여기에 추가할 수 있습니다.
      }
    });
    res.redirect('/');
  }
}
