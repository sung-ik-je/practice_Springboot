import { Request, Response } from 'express';
import { AuthService } from './auth.service';
export declare class AuthController {
    private readonly authService;
    constructor(authService: AuthService);
    githubLogin(): Promise<void>;
    githubLoginCallback(req: Request, res: Response): Promise<any>;
    googleAuth(req: any): Promise<void>;
    googleAuthRedirect(req: any): Promise<any>;
    kakaoAuth(req: any): Promise<void>;
    kakaoAuthRedirect(req: any): Promise<any>;
    logout(req: Request, res: Response): void;
}
