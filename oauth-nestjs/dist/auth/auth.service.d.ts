import { HttpService } from '@nestjs/axios';
export declare class AuthService {
    private readonly httpService;
    private userProfile;
    constructor(httpService: HttpService);
    validateUser(profile: any): Promise<any>;
    getUserProfile(): any;
    logoutUserProfile(): void;
    getAccessToken(c: string): Promise<any>;
}
