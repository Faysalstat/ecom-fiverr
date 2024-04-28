import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserAuthGuard } from './auth/user-auth.guard';
import { AdminAuthGuard } from './auth/admin-auth.guard';

const routes: Routes = [
  {path: '',redirectTo:'auth',pathMatch:'full'},
  { path: 'auth',  loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: 'shop',canActivate:[UserAuthGuard], loadChildren: () => import('./shop/shop.module').then(m => m.ShopModule) },
  { path: 'admin',canActivate:[AdminAuthGuard], loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
