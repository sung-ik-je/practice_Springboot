import { Controller, Get, Query, Req, Res, UseGuards } from '@nestjs/common';
import { AuthGuard } from '@nestjs/passport';
import { Request, Response } from 'express';
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // Github OAUTH

  // @Get('auth/github')
  @Get('github')
  @UseGuards(AuthGuard('github'))
  async githubLogin() { 
    console.log('redirection');
    /* GitHub 로그인 페이지로 리디렉션 */ 
  }

  @Get('github/callback')
  @UseGuards(AuthGuard('github'))
  async githubLoginCallback(@Req() req: Request, @Res() res: Response): Promise<any> {  
  // async githubLoginCallback(@Req() req: Request) {
    // 성공적인 인증 후 리디렉션
    // res의 의미를 잘 생각해야 된다, 현재 함수의 응답으로 redirect를 한다는거지 현재 함수의 요청을 redirect url의 request로 보낸다는 것이 아님
    
    // return req.user;   // 원하는대로 동작 X, 명시적으로 response가 정의되어 있기 때문에 해당 핸들러 명시적으로 응답 보내야 한다
    return res.send(req.user);  
  }

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // Google OAUTH
  // @Get('auth/google')
  @Get('google')
  @UseGuards(AuthGuard('google'))
  async googleAuth(@Req() req) { 
    /* Google 로그인 페이지로 리디렉션 */
    console.log('google redirection'); 
  }

  // @Get('auth/google/callback')
  @Get('google/callback')
  @UseGuards(AuthGuard('google'))
  async googleAuthRedirect(@Req() req) {
    console.log('google login success');
    return req.user;
  }

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // KAKAO OAUTH

  // @Get('auth/kakao')
  @Get('kakao')
  @UseGuards(AuthGuard('kakao'))
  async kakaoAuth(@Req() req) { 
    /* Google 로그인 페이지로 리디렉션 */ 
    console.log('kakao redirection');
  }

  // @Get('auth/kakao/callback')
  @Get('kakao/callback')
  @UseGuards(AuthGuard('kakao'))
  async kakaoAuthRedirect(@Req() req) {
    console.log('kakao oauth 적용');
    console.log(req);
    return req.user;
  }

  // logout시 어떤 플랫폼인지 구분을 logout 함수 내부에서 할건지 아님 플랫폼 별로 분리할 것인지?
  // 위에 2가지 요소 중 어쨋든 로그아웃을 구현하려면 DB에 저장을 해야됨
  // @Get('auth/logout')
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
