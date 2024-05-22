import { Controller, Get, Req, Res, UseGuards } from '@nestjs/common';
import { AuthGuard } from '@nestjs/passport';
import { Request, Response } from 'express';
import { GitHubApiService } from '../github-api/github-api.service';

@Controller('profile')
export class ProfileController {
  constructor(private readonly githubApiService: GitHubApiService) {}

  @Get('github')
  @UseGuards(AuthGuard('github'))
  async getGitHubProfile(@Req() req: Request, @Res() res: Response) {
    const accessToken = req.user.accessToken; // GitHub 액세스 토큰
    try {
      const response = await this.githubApiService.getUserInfo(accessToken);
      const userInfo = response.data;
      res.send(userInfo);
    } catch (error) {
      console.error('Error fetching GitHub profile:', error);
      res.status(500).send('Error fetching GitHub profile');
    }
  }
}