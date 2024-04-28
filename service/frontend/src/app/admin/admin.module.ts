import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from 'src/material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { PrimeNgModule } from 'src/primeng.module';

const routes: Routes = [
  {path: '',component: AdminComponent,children:[
    {path:'',component:OrderListComponent},
    {path:'product-list',component:ProductListComponent},
    {path:'add-product',component:AddProductComponent},

  ]},
];

@NgModule({
  declarations: [
    AdminComponent,
    AddProductComponent,
    ProductListComponent,
    OrderListComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    PrimeNgModule,
    RouterModule.forChild(routes)
  ]
})
export class AdminModule { }