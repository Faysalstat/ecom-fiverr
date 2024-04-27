export class UserRegistration {
  id!: number; // The "!" is a non-null assertion operator.
  firstName!: string;
  lastName!: string;
  phoneNumber!: string;
  address!: string;
  email!: string;
  gender!: string;
  userRole!: string;
  password!: string;
}


export class Product {
  id?: number;
  code?: string;
  name?: string;
  description?: string;
  price?: number;
  quantity?: number;
  category: string = "Book";
  image?: string;
}
export class Category{
  id!:number;
  categoryName!:number;
}
export class OrderItem{
  id?: number;
  productDTO?:Product;
  quantity:number = 0;
  price:number = 0;
  totalPrice:number = 0;
}
export class CartItem{
  id?: number;
  productId?:number;
  userId?:number;
}
export class Cart{
  id?: number;
  productList?:Product[];
}


export class OrderDetails{
  id?: number;
  orderItemDTOS?:OrderItem[];
  totalCost?:number;
  orderStatus?:string;
  userId?:string;
}

export class Customer{
  id!: number; 
  firstName!: string;
  lastName!: string;
  phoneNumber!: string;
  address!: string;
  email!: string;
  gender!: string;
}

