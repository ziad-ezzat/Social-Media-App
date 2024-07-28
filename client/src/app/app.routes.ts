import { RouterModule, Routes } from '@angular/router';
import { MyComponentZiadComponent } from './my-component-ziad/my-component-ziad.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    {path: '', component: MyComponentZiadComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
