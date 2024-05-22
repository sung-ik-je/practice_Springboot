import { Module, HttpModule} from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AuthModule } from './auth/auth.module';
import { PassportModule } from '@nestjs/passport';
import { ProfileController } from './profile/profile.controller';
import { GitHubApiService } from './github-api/github-api.service';

@Module({
  imports: [
    AuthModule,
    PassportModule.register({ defaultStrategy: 'github' }),
  ],
  controllers: [
    AppController,
    ProfileController
  ],
  providers: [
    AppService,
    GitHubApiService
  ],
})
export class AppModule {}
