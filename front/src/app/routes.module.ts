import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FollowersComponent} from './followers/followers.component';
export const routes: Routes = [
  { path: 'followers', component: FollowersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutesModule { }
