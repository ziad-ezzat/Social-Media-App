import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { MyComponentZiadComponent } from './app/my-component-ziad/my-component-ziad.component';

bootstrapApplication(MyComponentZiadComponent, appConfig)
  .catch((err) => console.error(err));
