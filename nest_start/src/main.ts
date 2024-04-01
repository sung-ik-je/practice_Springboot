import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  await app.listen(3000);
}

async function otherPort() {
  const app = await NestFactory.create(AppModule);
  await app.listen(2000);
}

bootstrap();

otherPort();
