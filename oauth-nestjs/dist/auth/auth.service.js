"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.AuthService = void 0;
const common_1 = require("@nestjs/common");
const axios_1 = require("@nestjs/axios");
const axios_2 = require("axios");
let AuthService = class AuthService {
    constructor(httpService) {
        this.httpService = httpService;
    }
    async validateUser(profile) {
        this.userProfile = profile;
        return profile;
    }
    getUserProfile() {
        return this.userProfile;
    }
    logoutUserProfile() {
        this.userProfile = undefined;
    }
    async getAccessToken(c) {
        const url = 'https://github.com/login/oauth/access_token';
        const headers = {
            'Content-Type': 'application/json',
            Accept: 'application/json',
        };
        const body = {
            client_id: process.env.GITHUB_CLIENT_ID,
            client_secret: process.env.GITHUB_CLIENT_SECRET,
            code: c
        };
        console.log('code :::: ', c);
        try {
            const response = await axios_2.default.post(url, body, { headers });
            console.log(response.data);
            return response.data;
        }
        catch (error) {
            console.error('Error fetching access token:', error);
            throw new Error('Failed to fetch access token');
        }
    }
};
exports.AuthService = AuthService;
exports.AuthService = AuthService = __decorate([
    (0, common_1.Injectable)(),
    __metadata("design:paramtypes", [axios_1.HttpService])
], AuthService);
//# sourceMappingURL=auth.service.js.map