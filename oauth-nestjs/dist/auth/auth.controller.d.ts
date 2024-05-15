import { Request, Response } from 'express';
export declare class AuthController {
    githubLogin(): Promise<void>;
    githubLoginCallback(req: Request, res: Response): Promise<void>;
    getProfile(req: Request, res: Response): void;
    logout(req: Request, res: Response): void;
}
