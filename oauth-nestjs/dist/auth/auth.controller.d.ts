import { Request, Response } from 'express';
import { AuthService } from './auth.service';
export declare class AuthController {
    private readonly authService;
    constructor(authService: AuthService);
    githubLogin(): Promise<void>;
    githubLoginCallback(req: Request, res: Response, code: string): Promise<any>;
    getProfile(req: Request, res: Response): void;
    logout(req: Request, res: Response): void;
}
