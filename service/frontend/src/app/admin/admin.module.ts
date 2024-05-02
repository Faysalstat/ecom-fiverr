import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { MaterialModule } from '../../material.module';
import { UpdateProductComponent } from './update-product/update-product.component';

const routes: Routes = [
  {path: '',component: AdminComponent,children:[
    {path:'',component:OrderListComponent},
    {path:'product-list',component:ProductListComponent},
    {path:'add-product',component:AddProductComponent},
    {path:'update-product/:id',component:UpdateProductComponent},

  ]},
];

@NgModule({
  declarations: [
    AdminComponent,
    AddProductComponent,
    ProductListComponent,
    OrderListComponent,
    UpdateProductComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ]
})
export class AdminModule { }
