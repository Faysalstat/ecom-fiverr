import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ShopComponent } from './shop.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { MaterialModule } from '../../material.module';
const routes: Routes = [
  {
    path: '',
    component: ShopComponent,
    children: [
      { path: '', component: ProductListComponent },
      { path: 'order-list', component: OrderListComponent },
      { path: 'order-details/:id', component: OrderDetailsComponent },
      { path: 'cart-list', component: CartListComponent },
      {
        path: 'product-details/:productId',
        component: ProductDetailsComponent,
      },
    ],
  },
];

@NgModule({
  declarations: [
    ShopComponent,
    ProductListComponent,
    CartListComponent,
    ProductDetailsComponent,
    OrderListComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

    RouterModule.forChild(routes),
  ],
})
export class ShopModule {}
