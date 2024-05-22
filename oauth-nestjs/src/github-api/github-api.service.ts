import { Injectable, HttpService } from '@nestjs/common';
import { AxiosResponse } from 'axios';

@Injectable()
export class GitHubApiService {
  constructor(private readonly httpService: HttpService) {}

  async getUserInfo(accessToken: string): Promise<AxiosResponse<any>> {
    const headers = {
      Authorization: `Bearer ${accessToken}`,
    };
    return this.httpService.get('https://api.github.com/user', { headers }).toPromise();
  }
}