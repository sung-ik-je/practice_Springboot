export declare class AuthService {
    private userProfile;
    private accessToken;
    validateUser(accessToken: any, profile: any): Promise<any>;
    getUserProfile(): any;
    logoutUserProfile(): void;
}
